# Gb-Smith-exercise
=============

What it does?
-------------
This repository contains the exercise that I had to do for my interview at Gb &amp; Smith.

Requirements
-------------
>     Java JDK 1.8 or higher
>     Maven 3.x or higher

Building the project.
----------------- 
Just run the following Maven command:
>     mvn clean install



Specification :
----------------- 
A web application with 3 features :
- Add user. Parameters(lastname, firstname, id). Return(OK/KO)
- Get user. Parameter(id). Return(lastname, firstname)
- Delete user. Parameter(id). Return(OK/KO)

Technical constraints :
- REST web service through Spring annotations for the use of these 3 actions.
- Using Maven to build the project/modules.
- Embedded Database using JPA / Hibernate
