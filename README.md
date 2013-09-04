# SapsanAdmin


## Установка

* Для работы у вас должен быть установленный и настроенный [Play Framework](http://www.playframework.org/) версии 2.1 или выше.

* Создайте новый проект `play new example`,консоль Play спросит какой проект Вы хотите создвать (Scala или Java).
  Сапсан может работать с обоими типами проектов, но если Вы выберите Scala то потребуется вручную подключить
  зависимости `javaCore`, `javaJdbc`, `javaEbean` в файле `project/Build.scala`, при этом зависимости
  `Anorm` и `jdbc` лучше отключить;
  а также добавить строку `ebean.default="models.*"` в файл `conf/application.conf`

* Отредактируйте в новом проекте файл `project/Build.scala` и добавьте туда строки:
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
  и не забудьте подключить `import Keys._` в этом файле (если он не подключён).

* Далее добавьте в файл `conf/routes` подключение маршрутов
    ```
    ->      /admin                              sa.Routes
    ```
 это лучше сделать сразу после основного маршрута "/".
 Естественно, `/admin` это необязательный адрес, вы можете задать более удобный для себя.


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

* Не забудьте настроить подключение к БД, `conf/application.conf` например, так:
    ```
    db.default {
        driver=org.postgresql.Driver
        url="postgres://user:secret@localhost/mydatabase"
    }
    ```
  и подключить соответствующую библиотеку в `project/Build.scala`, например
  `"postgresql" % "postgresql" % "9.1-901.jdbc4"`

## Описание моделей

* Далее Вам необходимо описать модели данных (для каждой таблицы БД - свою модель).
  Правила описания моделей смотрите в [вики Сапсана](./../../wiki/Shortinfoebeanmodels).
  Примеры моделей есть в демонстрационном приложении (ссылка дана ниже)

## Запуск

* После описания моделей запустите своё приложение, например выполнив `play run`
  и перейдите по адресу http://localhost:9000/admin (если вы вводили `admin` в файле `routes`)


## Пример работы

* Вы можете попробовать Сапсан без установки на [этом демонстрационном приложении](http://sapsan-demo.herokuapp.com/)
  также доступен [исходный код демонстрационного приложения](https://github.com/RumataEstorsky/SapsanDemo)


## Документация

* Вы можете ознакомиться с принципами работы и управления SapsanAdmin в разделе [вики](./../../wiki/)