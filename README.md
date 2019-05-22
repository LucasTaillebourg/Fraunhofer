# Fraunhofer

## Topic of the project : 
Nowadays web applications are a common approach in the industry. You have a frontend (which the user
will see and interact with) and a backend (in which the processing/evaluation logic is executed). 

To ease the process of developing web applications there are plenty of frameworks. One of them is Spring.


Please implement a basic REST service in Java with Spring. You should implement one method, which
handles server-sent events (SSE) via a REST GET request. The method/app should sent random in
EventModel in JSON format. The EventModel has the following fields:
Name of the event, id is unique, unix timestamp, description of the event, prediction
The id and the prediction can be random values (https://docs.spring.io/springboot/docs/current/reference/html/boot-features-external-config.html).


The method should check if the prediction is higher or lower than 30%. If the value is higher than 30% the EventModel should be send to
the frontend (you don’t have to implement this, just display the JSON as unformatted text). If the value is
lower than 30% nothing happens. 

Please apply best practices to comment and format your source code.

As a bonus you can write unit tests or maybe choose a TTD approach, but that’s up to you.

The main objective of this task is to get a better understanding about your approach to solve problems
and implement the solution in code.


## API Documentation :

You will find the API documentation on  http://localhost:8080/swagger-ui.html when the serveur is running.
The documentation is generated by swagger. (https://www.baeldung.com/swagger-2-documentation-for-spring-rest-api)

