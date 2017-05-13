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

UNIT TESTS

To launch tests, run without disable test execution

1. mvn clean install 

To disable test execution launch

1. mvn -Dmaven.test.skip=true clean install 

14/05/2017 IMPROVEMENTS

Changed GitHub API to Github API v3. The URL and the response were changed in this new version, however response still have 'language' property.
REST request with RestTemplate to automatically fill Repo[] entity rather than using a HashMap to set all repository fields.
Configured GitHub URL in application.properties file.
WireMock is used to simulate GitHub API responses. There are few sample responses in '/github-users-web/src/test/resources/__files/responses' folder for each case.
Streams are used to calculate favourite language of the user.