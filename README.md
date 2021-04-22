# bgbilling-webservice-1c

## Что это?

Пример обращения к веб-сервису АСР BGBilling из 1С:Предприятие 8.3 (управляемые формы)

## Как этим пользоваться?

1) Прочитать доку биллинга
   https://docs.bitel.ru/pages/viewpage.action?pageId=135888906
2) `dynservice:ru.test.bgbilling.bill.Bill1CService=ru.test.bgbilling.service.bill.server.service.Bill1CServiceImpl`
3) Указать верные логин и пароль для пользователя в обработке
   ```
    ЗаписьJSON.ЗаписатьЗначение("admin"); //Логин пользователя биллинга
    ЗаписьJSON.ЗаписатьЗначение("admin"); //Пароль пользователя биллинга
   ```
   Ну и желательно URL в строке
   ```
   Соединение = Новый HTTPСоединение("billing.bitel.ru", 443,,,,, Новый ЗащищенноеСоединениеOpenSSL());
   ```
   Можно использовать http если поменять строку на 
   ```
   Соединение = Новый HTTPСоединение("billing.bitel.ru", 80);
   ```
4) Подключить обработку в 1С как внешнюю.
5) Пользоваться.
6) ...
7) Если не получится - штош...