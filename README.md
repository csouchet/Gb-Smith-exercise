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

# Tomcat 
------------------
http://localhost:8280/gbsmith-application/

    http://localhost:8280/gbsmith-application/#/user/delete : liste des Todo
    http://localhost:8280/gbsmith-application/#/user/new : saisie d'un nouveau Todo
    http://localhost:8280/gbsmith-application/#/user/find/{id} : détail du Todo d'identifiant {id}



# Rest API
------------------
Return a user : GET http://localhost:8280/api/user/:id
Delete a user : DELETE http://localhost:8280/api/user/:id
Create a user : PUT http://localhost:8280/api/user/:user


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
