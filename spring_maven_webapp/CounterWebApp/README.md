# Counter Web Application

This example Java Web Application is based on this article:
[How to create a Web Application Project with Maven](https://www.mkyong.com/maven/how-to-create-a-web-application-project-with-maven/)

It is developed in JDK 8 + Tomcat 9.0.10 (or 7.0.47)


Here are some developer notes.

1. Create the web application.

```
# create the "CounterWebApp" web application.
mvn archetype:generate -DgroupId=com.example -DartifactId=CounterWebApp -DarchetypeArtifactId=maven-archetype-webapp -DinteractiveMode=false

# navigate to "CounterWebApp" folder.
cd CounterWebApp

# generate Eclipse web project files.
mvn eclipse:eclipse -Dwtpversion=2.0
```

2. Add or update the source files according to the guide.


3. Run in eclipse, or under Maven as below.

```
# clean up and compile.
mvn clean compile.

# build to WAR file.
mvn package

# launch in Tomcat container.
mvn tomcat7:run
```

It is now ready to access the web application via link below:
http://localhost:8080/CounterWebApp/

