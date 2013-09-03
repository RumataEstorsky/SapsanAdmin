# SapsanAdmin


## Установка

* Для работы у вас должен быть установленный и настроенный Play Framework версии 2.1 или выше.
  (см. подробнее http://www.playframework.org/)

* Создайте новый проект `play new example`

* Отредактируйте в новом проекте файл `project/Build.scala` и добавьте туда строки:
  в массив зависимостей проекта
```
  val appDependencies = Seq(
      // ...
      "ru.myscala" % "sapsan_2.10" % "0.1"
    )
```
  а также добавте в этот же файл ссылку на репозиторий Сапсана:
```
  val main = play.Project(appName, appVersion, appDependencies).settings(
	resolvers += Resolver.url("My GitHub Play Repository", url("http://rumataestorsky.github.com/releases/"))(Resolver.ivyStylePatterns)
  )
```

## Настройка

* В конфигурационном файле вашего проекта `conf/application.conf` добавьте следующие строки:

```
sapsan {
    # Название приложения, будет отображаться в заголовке админки
    name = "Супер-пупер"
    # Вести ли историю редактирования записей
    history = yes
    # Сколько записей на страницу будет помещаться в списках
    pagination.items_per_page = 10
}
```

