package sapsan.schema

import sapsan.annotation.Label
import scala.collection.mutable.LinkedHashMap
import sapsan.common.Notation
import com.avaje.ebean.Ebean
import java.util.Date

class Model(val clazz: Class[_]) extends Ordered[Model] {

    /** Название класса */
    val name = clazz.getSimpleName

    /** Название для пользователей */
    lazy val label = if(clazz.getAnnotation(classOf[Label]) == null) "" else clazz.getAnnotation(classOf[Label]).value

    /** JPA-аннотация модели @Table (описывает свойства таблицы) */
    private [this] lazy val tableAnn = clazz.getAnnotation(classOf[javax.persistence.Table])

    /** Название таблицы в базе данных */
    lazy val table = if(tableAnn == null) Notation.camelToC(name) else tableAnn.name()

    /** Название схемы в базе данных */
    lazy val schema = if(tableAnn == null) "" else tableAnn.schema()

    /** Ключи уникальности для данной модели */
    lazy val uniqueConstraints = if(tableAnn == null) List() else tableAnn.uniqueConstraints()

    /**  Является ли наследником класса play.db.ebean.Model */
    val isModel = clazz.getSuperclass() == classOf[play.db.ebean.Model] &&
        clazz.getAnnotation(classOf[sapsan.annotation.Label]) != null

    /** Поля моделей */
    val fields = new LinkedHashMap[String, Field]

    /** Название в Си-нотации (для применения в виде идентификаторов на сайте) */
    val toCNotation = Notation.camelToC(name)

    /** Экспериментальный экземпляр объекта для данной модели (для получения значений по-умолчанию и других операций) */
    def experiment = clazz.getConstructor().newInstance()

    init

    /** Инициализация класса */
    def init = {
        clazz.getDeclaredFields.foreach { f =>
            // Берём только поля, помеченные аннотацией Label
            if(f.getAnnotation(classOf[Label]) != null) {
                val field = new Field(this, f)
                fields.put(field.toCNotation, field)
            }
        }

    }

    /** Ассоциативный массив из названий полей в кач. ключей и пустых строк - как значений. Магия 7 уровня, объяснения в книгах по алхимии. */
    val emptyForm = fields.map { case (_, f) => (f.toCNotation, "") }

    //    def fieldsWithoutKeys = fields.filter(f => !(f._2.isId || f._2.isKeyField))

    /** Только простые поля для формы редактирования, без первичных и внешних ключей, авто-поставляемых */
    def fieldsForEdit = fields.filter(f => !(f._2.isPrimary /* || f._2.isKeyField || f._2.isDefaultExists */ || f._2.isOneToMany ))
    def fieldsForEdit2 = fieldsForEdit.filter(f => !(f._2.isDefaultExists))
    def fieldsForEdit3 = fieldsForEdit.filter(f => !(Field.dateFields.contains(f._2.name)))

    /** Поля для вывода в списке записей */
    def fieldsForGrid = fields.filter(f => !(f._2.isManyToMany || f._2.isOneToMany))

    /** Возвращает первую колонку, которая является первичным ключом */
    def primaryField = fields.find(_._2.isPrimary).head._2

    /** Возвращает "именной ключ", или же первый столбец, если именной ключ не будет найден */
    def nameField = {
        val col = fields.find(f => f._2.name == "name" || f._2.dataType == DataTypeGroup.String)
        if(col.nonEmpty) col.head._2 else fields.head._2
    }

    /** Извлечение кода записи из переданного объекта */
    def extractId(obj: Any) = primaryField.extract(obj).toString.toLong

    /** Формирование ассоциативного массива: (код записи -> именное поле) */
    def biList = {
        val result = new LinkedHashMap[Any, Any]
        val items = Ebean.find(clazz)
            .orderBy(nameField.name)
            .findList()

        import collection.JavaConversions._
        for(item <- items) {
            result.put(primaryField.extract(item), nameField.extract(item))
        }
        result
    }

    /** Загрузка экземпляра объекта данной модели по его коду */
    def recordById(id: Any) = Ebean.find(clazz).where.eq(primaryField.name, id).findUnique()

    /** Добавление новой записи в БД по карте,
      * где ключом выступает имя поля в модели, а значением - некоторая строка
      */
    def createRecord(data : Map[String, String] ) {
        val obj = clazz.getConstructor().newInstance()

        // Установка полям модели значений из формы
        data.foreach { case (key, value) =>
                val f = clazz.getDeclaredField(key)
                val mf = fields(key)
                f.set(obj, mf.fromString(value))
//                println(s"$key = ${value}")
        }

        saveRecord(obj)
    }

    /** Создание записи в БД, заполненной случайными данными */
    def createRandomRecord {
        val obj = clazz.getConstructor().newInstance()

        // Установка полям модели значений из формы
        fieldsForEdit2.foreach { case (name, field) =>
            val f = clazz.getDeclaredField(field.name)
            f.set(obj, field.random)
        }

        saveRecord(obj)
    }

    /** Сохранение новой записи  в БД */
    def saveRecord(bean: Any) {
        // Проставляем дату добавления записи (если есть такое поле)
        val f = clazz.getDeclaredField(Field.createdAt)
        if(f != null) {
            f.set(bean, new Date())
        }
        // Сохраняем запись
        try {
            val method = clazz.getMethod("save")
            method.invoke(bean)
        } catch {
            case _: Throwable => Ebean.save(bean)
        }
    }

    /** Обновление записи  в БД */
    def updateRecord(bean: Any, id: Long) {
        // Проставляем дату добавления записи (если есть такое поле)
        val f = clazz.getDeclaredField(Field.updatedAt)
        if(f != null) {
            f.set(bean, new Date())
        }
        // Обновляем запись
        try {
            val method = clazz.getMethod("update", classOf[Object])
            val nativeId = primaryField.fromLong(id)
            method.invoke(bean, nativeId.asInstanceOf[Object])  //TODO !!! id.toString.toInt.asInstanceOf[Object]
        } catch {
            case e: Throwable =>
                e.printStackTrace()
                // => Ebean.update(bean)
            throw e
        }
    }

//    def appendHistoryEvent(de) = {
//
//    }

    /** Абсолютно статическая, то есть связи M-1 и 1-1 отсутствуют, но цикличные связи возможны
      * т.е. ищем первую связанную, но не цикличную связь */
    lazy val isStatic = fields.find(f => (f._2.isManyToOne  && !f._2.isCyclicRel)).isEmpty

    /** Является ли данная модель связанной с переданной связью 1-М со стороны "M"  **/
    def isSlave(that: Model) = fields.find(f => f._2.isManyToOne && f._2.foreignModel == that).nonEmpty

    /** Сравнение модели по степени статичности */
    def compare(that: Model) =
        if(isSlave(that)) -1
        else if(that.isSlave(this)) 1
        else 0

    /** Количество записей в таблице */
    def recordCount = Ebean.find(clazz).findRowCount()

    override def toString: String = name
}