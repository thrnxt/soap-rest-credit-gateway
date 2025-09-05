# soap-rest-credit-gateway
 мини-шлюз: SOAP-сервис принимает XML-запрос проверки клиента, валидирует его по XSD, дергает внешний REST-скоринг и возвращает SOAP-ответ

wsdl доступен по адресу http://localhost:8080/ws/credit.wsdl
![wsdl](wsdl.jpg)

SOAP запрос с положительным ответом, использую SOAP UI:
![soap](soap-request.jpg)

А также REST запрос с decision - reject, использую Postman
![rest](rest-request.jpg)
