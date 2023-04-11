# saksoft_assignment
This repo is only to for assignment purpose.


Spring Boot Rest CRUD API example with Maven that use Spring Data JPA to interact with H2 database

**Technology:**
Java 
Spring Boot 
H2 Database 
Maven 


**Api's**

Get all Users(GET)
localhost:9090/users/users

Creates the User(POST)
localhost:9090/users/create

Edit the user by userId(PUT)
localhost:9090/users/edit/{userId}

Deltes the user by userId(DELETE)
localhost:9090/users/delete/{userId}

Fetch the user by email
localhost:9090/users/getByEmail/{email}

Note : This api's can be performed from postman locally.

**The appliaction is based on 3 tire architecture.**

Controller layer
Service layer
Persitance layer
