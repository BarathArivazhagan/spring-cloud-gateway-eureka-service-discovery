# spring-cloud-gateway-eureka-service-discovery

This project demonstrates the usage of API gateway between microservices using spring cloud gateway along with netflix eureka service discovery


## what is spring cloud gateway ?

<p>Spring Cloud Gateway is an intelligent and programmable router based on Project Reactor.</p>


![spring cloud gateway](images/spring_cloud_gateway.png)


<table>


 <tr>
    <th style="text-align:left">Name</th>
    <th style="text-align:left">Port</th> 
    <th style="text-align:left">Description</th>
  </tr>
  <tr>
    <td><a href="https://github.com/BarathArivazhagan/spring-cloud-gateway-eureka-service-discovery/tree/master/api-cloud-gateway">api-cloud-gateway</a></td>
    <td>8500</td>
    <td>spring cloud gateway router</td>
  </tr>
  <tr>
    <td><a href="https://github.com/BarathArivazhagan/spring-cloud-gateway-eureka-service-discovery/tree/master/eureka-server">eureka server</a></td>
    <td>8080</td>
    <td>service registration server</td>
  </tr>
  <tr>
    <td><a href="https://github.com/BarathArivazhagan/spring-cloud-gateway-eureka-service-discovery/tree/master/bank-microservice">bank microservice</a></td>
    <td>8081</td>
    <td>bank microservice</td>
  </tr>
  <tr>
    <td><a href="https://github.com/BarathArivazhagan/spring-cloud-gateway-eureka-service-discovery/tree/master/customer-microservice">customer microservice</a></td>
    <td>8082</td>
    <td>customer microservice</td>
  </tr>
  <tr>
    <td><a href="https://github.com/BarathArivazhagan/spring-cloud-gateway-routing/tree/master/config-server">config-server</a></td>
    <td>8888</td>
    <td>spring cloud config server </td>
  </tr>
  
</table>


## How to build and run ?

 * Download/Clone the repository : 
   
   ```
   $ git clone https://github.com/BarathArivazhagan/spring-cloud-gateway-eureka-service-discovery.git
   $ cd spring-cloud-gateway-routing
   $ ./mvnw clean install
   ```

 * To run the application :

	  ```
	 $ docker-compose up
	  ```

## How to test the application ? 

Use gateway routes to route to respective microservices. 

spring cloud gateway route definition : 

```
  
spring:
  cloud:
    gateway:
      routes:
        - id: bank-service
          uri: http://localhost:8081
          predicates:
          - Path= /bankms/*
          filters:
          - StripPrefix=1
        - id: customer-service
          uri: http://localhost:8082
          predicates:
          - Path= /customerms/*
          filters:
          - StripPrefix=1
```

```
$ curl http://localhost:8081/bankms/banks


$ curl http://localhost:8081/custms/customers

```


#### Header based routing strategy 

![spring cloud gateway](images/spring_cloud_gateway_header.png)

Enable <b>SPRING_PROFILES_ACTIVE=header</b> to test header based routing strategy


#### Query param based routing strategy

![spring cloud gateway](images/spring_cloud_gateway_param.png)

Enable <b>SPRING_PROFILES_ACTIVE=query</b> to test query param based routing strategy




#### How to rebuild the project after the changes? 

```
  docker-compose build
```




