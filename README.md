BRIEF DESCRIPTION 
Web application built in Java which needs Maven to build it. 

This application was developed with Spring Boot to use an embedded Tomcat to run it. This application uses Spring MVC + Thymeleaf (presentation tier). 

It has a MVC controller (UserController) to get the two possible requests, one for start the application and other one to process the request.  

To query the user repositories, there is a Service (UserService) to do a HTTPS request, and process its response as ObjectMapper (JSON Object). With the result of the service, the controller update the model to show the result in the web page. 
 
TASKS TO RUN IT 
There is a folder with the application called github-users-web. 

To run the application, you need Java JDK 8 + Maven 3, and follow next steps 

1. mvn clean install 
2. mvn spring-boot:run 
3. The web application will start on port 8080. To try it you should use next URL: http://localhost:8080 