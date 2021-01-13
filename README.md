# wizpandaBackend
This application is built on Java, SpringBoot and rest web services. It uses the in memory H2 database to store the data with configuration provided in application.properties file 
It exposes 3 end points: Create Account, Login and Fetch students detail.

## Run the application:
To run the application import the project in STS or eclipse as a maven project. After importing the project run it as maven build and type command clean install.
Clean install command will install all the maven dependency in your local system that are required by the application.
After all the dependencies are installed, run the application as spring boot app. Application will be running on 8080 port which is default port.

## Endpoints:
1. /student/create : This endpoint will create a student account in H2 database. The method type is POST and required a Request Body for student data.
2. /login: This rest endpoint will validate whether the user is authenticated or not. The method type is POST and required a Request Body for the credentials.
3. /students: The rest endpoint will fetch all the students details for the database and returned the response as JSON response. The method type is GET as we are getting data from the server.
