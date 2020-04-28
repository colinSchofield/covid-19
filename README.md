![](logo.jpg)

# Covid-19 Medical Information Site

### Synopsis
The intention of this program is to allow users to connect via the web and retrieve daily statistical information on the 
**Covid-19** pandemic. 

A summary is presented of the disease activity, based on world wide location. The information includes critical patients, 
daily deltas as well as the deaths caused by the disease in the recent period.

Users may also sign-up for a newsletter which they will be sent via email, or they may opt to receive SMS notifications. 

### Technical Details
This program was written as a Java 1.8 Spring Boot microservice which applies the Reactive webflux technology and uses 
Jetty as its web container. Disease information is provided via Restful web services, through [Rapid API](https://rapidapi.com).  

The front end of the application was written using **React JS** (using [React Hooks](https://reactjs.org/docs/hooks-intro.html))
together with front end HTML/CSS styling via [Bootstrap](https://getbootstrap.com).

The application itself has been hosted on AWS, running as an EC2 service off of a `t2.micro`, which is deployed into the 
default VPC. Information on users who have signed up to receive the newsletter, is persisting using a 
DynamoDb NoSQL database, as this provides the best possible performance, scalability, resilience and cost.

You may view the application by following the link below:
 
>
> [Medical Information Site](http://ec2-3-8-131-4.eu-west-2.compute.amazonaws.com)
>
 
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
