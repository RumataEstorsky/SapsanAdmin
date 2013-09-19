package sapsan.schema

import scala.collection.mutable.{LinkedHashMap,HashMap}
import scala.collection.immutable.TreeMap
import play.Play
import play.libs.Classpath
import sapsan.annotation.Label


object Schema {
    /** Хеш по Си-псевдониму имени */
    val models = loadModels()


    def modelsByStatic = models.values.toList.sortWith(_ < _)

    /**
     * Загружает модели в память.
     * @param packageName название пакета. Модели будут загружены рекурсивно из него и всех подкаталогов
     */
    def loadModels(packageName: String = "models") = {
        val result = new HashMap[String, Model]
        import collection.JavaConversions._
        Classpath.getTypesAnnotatedWith(Play.application, "models", classOf[Label]).map { className =>
            val clazz = Class.forName(className, true, Play.application.classloader)
            val model = new Model(clazz)
            if (model.isModel) {
                result.put(model.toCNotation, model)
            }
        }
        // Отсортируем модели по ключам, по алфавиту
        TreeMap(result.toSeq:_*)
    }

}