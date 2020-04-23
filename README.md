![](logo.jpg)

# Covid-19 Medical Information Application

### Synopsis
The intention of this program is to allow users to connect, via the web, to information about locations in the world that 
are especially of interest to them (i.e. their home, siblings location, birth place etc). 

These locations will be listed with an information overview of the Coronavirus disease activity: critical 
patients, daily deltas as well as the deaths caused by the disease in the recent period.

### Technical Details
This program was written as a Java 1.8 Spring Boot microservice which applies the Reactive webflux technology and uses Jetty as its web container. Disease information is provided via Restful web services, through [Rapid API](https://rapidapi.com).  

The front end of the application was written using **React JS** (using [React Hooks](https://reactjs.org/docs/hooks-intro.html)).

 The application itself has been hosted on AWS, running as an EC2 service off of a `t2.micro`, which is deployed into the default VPC. Information on the connecting users is persisting using a DynamoDb NoSQL database, as this provides the best possible performance, scalability, resilience and cost.
 
 ### How to run the Application Locally
 You must have the following to run this application:
 - Java 1.8 compiler 
 - Apache maven 3 
 
 Then perform the following:
 ```
 1. mvn clean install
 2. mvn spring-boot:run
 ```

### About the Developer

**Colin Schofield**   
e: colin_sch@yahoo.com  
p: 0448 644 233  
l: https://www.linkedin.com/in/colins/
