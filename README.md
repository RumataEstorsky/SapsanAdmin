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
  также добавьте в этот же файл ссылку на репозиторий Сапсана:
```
  val main = play.Project(appName, appVersion, appDependencies).settings(
	resolvers += Resolver.url("SapsanAdmin GitHub Repository", url("http://rumataestorsky.github.com/releases/"))(Resolver.ivyStylePatterns)
  )
```

* Далее добавьте маршруты Сапсана в начало файла `conf/routes`
 маршруты админки - https://github.com/RumataEstorsky/SapsanAdmin/wiki/Adminroutes
 и маршруты авторизации (не обязательны, если вы используете свой механизм авторизации) - https://github.com/RumataEstorsky/SapsanAdmin/wiki/Authroutes

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



## Пример работы

* Вы можете попробовать Сапсан без установки на этом демонстрационном приложении http://sapsan-demo.herokuapp.com/
  также доступен исходный код демонстрационного приложения - https://github.com/RumataEstorsky/SapsanDemo


## Документация

* Вы можете ознакомиться с принципами работы и управления SapsanAdmin в разделе [вики](./wiki/)