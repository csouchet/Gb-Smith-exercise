# Gb-Smith-exercise
=============

What it does?
-------------
This repository contains the exercise that I had to do for my interview at Gb &amp; Smith.

Requirements
-------------
>     Java JDK 1.7 or higher
>     Maven 3.x or higher

Building the project.
----------------- 
Just run the following Maven command:
>     mvn clean install

Tomcat
------------------
You can find a Tomcat bundle already configured (Datasource, War, Log) in the /tomcat/target directory.
Need to unzip the Tomcat-8.0.28.zip file.
To start Tomcat, use the startup.bat or startup.sh script in <TOMCAT_HOME>/bin.

Rest API
------------------
Create a user : PUT http://localhost:8280/gbsmith-application/user?id=1&firstname=toto&lastname=titi
Return a user : GET http://localhost:8280/gbsmith-application/user/1
Delete a user : DELETE http://localhost:8280/gbsmith-application/user/1


Specification :
----------------- 
A web application with 3 features :
- Add user. Parameters(lastname, firstname, id). Return(OK/KO)
- Get user. Parameter(id). Return(lastname, firstname)
- Delete user. Parameter(id). Return(OK/KO)

Technical constraints :
-----------------
- REST web service through Spring annotations for the use of these 3 actions.
- Using Maven to build the project/modules.
- Embedded Database using JPA / Hibernate
