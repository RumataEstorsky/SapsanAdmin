###############################################################################
# Системные сообщения
###############################################################################

# --- Constraints
constraint.required=Обязательное
constraint.min=Минимальное значение: {0}
constraint.max=Максимальное значение: {0}
constraint.minLength=Минималная длина: {0}
constraint.maxLength=Максимальная длина: {0}
constraint.email=Email
constraints.unique=Такое значение уже есть

# --- Formats
format.date=Дата (''{0}'')
format.numeric=Число
format.real=Вещ. число

# --- Errors
error.invalid=Некорректное значение
error.required=Это поле необходимо заполнить
error.number=Ожидается числовое значение
error.real=Ожидается вещественное число
error.min=Должно быть больше или равно {0}
error.max=Должно быть меньше или равно {0}
error.minLength=Миним. длина должна быть {0}
error.maxLength=Максим. длина должна быть {0}
error.email=Введите верный E-mail
error.pattern=Должно удовлетворять {0}

error.alluppercase=Все буквы этого поля должны быть заглавными
constraint.alluppercase=Ожидались заглавные буквы

###############################################################################
# Общий интерфейс
###############################################################################
interface.yes=Да
interface.no=Нет
interface.save=Сохранить
interface.cancel=Отмена
interface.add=Добавить
interface.edit=Редактировать
interface.delete=Удалить
interface.chooseValue=-- Выберите значение --
interface.choose=Выберите
interface.search=Поиск

interface.notFound=Запись номер {0} не найдена!
interface.successEdited=Запись "{0}" была успешно отредактирована!
interface.successAdded=Запись "{0}" была успешно добавлена!
interface.successDeleted=Запись c номером {0} была успешно удалена!

interface.list.previous=Предыдущая
interface.list.next=Следующая
interface.list.displaying=Показано от
interface.list.to= до
interface.list.of= из
interface.list.noRecords=Нет записей для отображения

interface.upload.max_size=Максимальный размер файла для загрузки составляет {0} Кб, а размер Вашего файла {1} Кб!
interface.upload.extensions=Неподдерживаемый формат файла "{0}", допустимы файлы форматов: {1}
interface.upload.image_tag=<img src="{0}">
#interface.upload.doc_tag=<a href="{0}">{1}</a>
interface.upload.doc_tag=<a href="javascript:void(null);" rel="{0}" class="redactor_file_link redactor_file_ico_{2}">{1}</a>';
interface.upload.error=Ошибка загрузки файла!

###############################################################################
# Пользователи
###############################################################################
user.registration.title=Регистрация пользователя
user.registration.name=Ваше имя:
user.registration.name.help=Ваше имя, от 3 до 64 символов.
user.registration.email=Ваш адрес E-mail:
user.registration.email.help=Здесь нужно указазать адрес электронной почты
user.registration.letterTitle=Вы зарегистрированы!
user.registration.notUniqueEmail=На адрес почты {0} уже был зарегистрирован пользователь!

user.forgot.title=Восстановление Вашего пароля
user.forgot.letterTitle=Ваш новый пароль!
user.forgot.badEmail=Адрес электронной почты {0} не найден в базе, проверьте, не отпечатались ли Вы

user.login.title=Вход в систему
user.login.login=Логин
user.login.password=Пароль
user.login.inlet=Вход
user.login.forgot=Забыли пароль?
user.login.needRegistration=Еще не зарегистрированы?
user.login.invalidLogin=Проверьте, верно ли Вы ввели логин и пароль, не нажата ли клавиша Caps Lock, и установлена ли верная раскладка клавиатуры.
user.login.blocked=Ваша учётная запись сейчас заблокирована, обратитесь к ответственному в Вашей организации для разрешения этой проблемы.

user.changePassword.badOldPassword="Вы указали неверный старый пароль"
user.changePassword.passwordsMismatch="Новый пароль и его повторение не совпадают"
user.cabinet.title=Личный кабинет: {0}

###############################################################################
# Опрос
###############################################################################
template.notFound="Шаблон тестирования с кодом {0} не найден"




###############################################################################
# Администрирование Сапсан-Админ
###############################################################################

#
#
admin.skeleton.dashboard=Панель управления
admin.skeleton.goHome=Домой
admin.skeleton.logout=Выход
admin.skeleton.navigation=Обзор моделей
admin.skeleton.admin=Сапсан-Андмин™
admin.skeleton.loading=Загрузка...



#
#
admin.list.list=Список
admin.list.addNew=Добавить
admin.list.export=Экспорт
admin.list.history=История
admin.list.delete=Удалить
admin.list.edit=Правка
admin.list.selectedItems=Выбранные записи
admin.list.addFilter=Добавить фильтр
admin.list.filter=Фильтр
admin.list.refresh=Обновить
admin.list.show=Просмотр
admin.list.exportB=Экспорт найденных
admin.list.deleteB=Удалить выделенные

#
#
#
#
admin.export.selectFields=Выбор полей для экспорта
admin.export.selectFieldsModel=Поля из "{0}"
admin.export.optionsCSV=Настройки для CSV
admin.export.codepage=Кодировка
admin.export.codepageHelp=Выбор выходной кодировки для файла CSV. По-умолчанию используется UTF-8
admin.export.noHeader=Опустить заголовок
admin.export.noHeaderHelp=Не выводить заголовки полей в файл
admin.export.separator=Разделитель полей
admin.export.separatorHelp=Выбор разделителя для отделения данных одного поля от данных другого, используется запятая по-умолчаию. В русской локали рекомендуется использовать табуляцию, т.к. с помощью запятых отделяется дробная часть числа от целой.
admin.export.sep1=<запятая> ","
admin.export.sep2=<точка с запятой> ";"
admin.export.sep3=<табуляция>
admin.export.buttonCSV=Экспорт в CSV
admin.export.buttonJSON=Экспорт в JSON
admin.export.buttonXML=Экспорт в XML

#
#
admin.edit.save=Сохранить
admin.edit.saveAndAdd=Сохранить и добавить ещё
admin.edit.saveAndEdit=Сохранить и редактировать

admin.delete.yes=Да, я уверен
admin.delete.confirm=Вы уверены, что хотите удалить объект "{0}"? Вместе с этим объектом будут удалены или оставлены без связей следующие объекты:

admin.show.title=Основная информация