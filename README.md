# WeatherApp

## Task:

> Please implement Spring boot application with one REST service - update weather - /weather/<location>/<temp>, e.g. /weather/SOF/15.2, /weather/VAR/18.3
The API should calculate the average temp for the location and store it in db. (You should use the information in DB to calculate the average and there should be only one record per location). You should make sure to protect data in case of parallel requests for one and same location.
The API should return the current average as response.

>Add Spring Cloud (Eureka) and register the weather spring boot service with it. 

>Add zuul (https://www.baeldung.com/zuul-load-balancing).
Start two instances of the weather spring boot app on different ports and register them in Eureka together with Zuul.

>At the end you should have 4 running applications - eureka, zuul and 2 instances of weather spring boot app.
The incoming requests should go through zuul and be proxied to one of the two spring boot weather apps. Add logging to verify that it works.