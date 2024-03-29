# Курсовой проект по модулю «Автоматизация тестирования» для профессии «Инженер по тестированию»

## Описание проекта

В рамках данного проекта необходимо автоматизировать тестирование комплексного сервиса покупки тура, взаимодействующего с СУБД и API Банка.

![service](/reports/pics/service.png)


Покупка тура возможна с помощью банковской карты и в кредит. Данные по картам обрабатываются отдельными сервисами (Payment Gate, Credit Gate). Разработчики сделали один сервис, симулирующий и Payment Gate, и Credit Gate.

Сервис обрабатывает только специальные номера карт, которые предоставлены для тестирования:

- APPROVED карта - 4444 4444 4444 4441

- DECLINED карта - 4444 4444 4444 4442.

Приложение должно в собственной СУБД сохранять информацию о том, каким способом был совершён платёж, и успешно ли он был совершён (при этом данные карт сохранять не допускается).

## Документация

* [План автоматизации](/reports/Plan.md)
* [Отчёт по итогам тестирования](/reports/Report.md)
* [Отчёт по итогам автоматизации](/reports/Summary.md)

## Запуск приложения

### Предусловия

1. Требуется изучить пречень используемых инструментов, описаных в [плане автоматизации тестирования](/reports/Plan.md). Обеспечить их дальнейшее использование в проекте;
2. Клонировать [репозиторий](https://github.com/Watsupkin/Diploma_aqa) командой
> git clone
3. Запустить Docker Desktop;
4. Открыть проект в IntelliJ IDEA.

### Запуск

1. Запустить базу данных MySQL. Параметры для запуска хранятся в файле [docker-compose.yml](https://github.com/Watsupkin/Diploma_aqa/blob/main/docker-compose.yml). Для запуска необходимо ввести в терминале команду:
> docker-compose up
2. Для запуска приложения ввести в терминале команду
> java -jar artifacts/aqa-shop.jar -port=8080
3. Приложение должно запуститься и работать по адресу [http://localhost:8080/](http://localhost:8080/).

### Запуск тестов

1. В терминале IntelliJ IDEA ввести команду;
> ./gradlew clean test
2. Подождать пока пройдут все тесты и посмотреть результат.

### Формирование отчета AllureReport по результатам тестирования

1. Для генерации отчета и автоматического открытия его в браузере следует ввести в терминале IntelliJ IDEA команду:
> ./gradlew allureServe
2. Подождать генерации отчета и посмотреть его в открывшемся браузере.