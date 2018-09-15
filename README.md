# trade-information
A trade information service

This is a trade-information service by Cemil Aydogdu. https://github.com/caydogdu/trade-information

These are the main ability of project

    Ability to validate trades

This project was developed with spring boot. Java 8 is required. No database was used.


There is a REST Service in this project.

    To validate trades POST localhost:8081/trades with body 
    [
      {
        "customer":"PLUTO1",
        "ccyPair":"EURUSD",
        "type":"Spot",
        "direction":"BUY",
        "tradeDate":"2016-0811",
        "amount1":1000000.00,
        "amount2":1120000.00,
        "rate":1.12,
        "valueDate":"2016-08-15",
        "legalEntity":"CS Zurich",
        "trader":"Johann Baumfiddler"
      }
    ]

Run options and deployment

This project is a microservice. So you can easily run it.

1- Running as a packaged application If you use the Spring Boot Maven or Gradle plugins first create an executable jar then you can run your application using java -jar. For example: $ java -jar target/trade-information-0.0.1-SNAPSHOT.jar It is also possible to run a packaged application with remote debugging support enabled. This allows you to attach a debugger to your packaged application:

You can also run it with executing the main class (com.bank.trade.Application)

2- Using the Maven plugin The Spring Boot Maven plugin includes a run goal which can be used to quickly compile and run your application. Applications run in an exploded form just like in your IDE.

$ mvn spring-boot:run
