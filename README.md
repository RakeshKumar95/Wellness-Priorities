# Wellness-Priorities

An application in Spring Boot called "Priority"

**Description:** 

There are 4 areas that a user can allot different priorities to. 

1. Connection
2. Relationships
3. Career
4. Wealth

Along with priority, he/she needs to rate the satisfaction for all the above areas on a scale of 1 to 5.

Company admin/creator should have the ability to add more areas in the backend later if needed. 

**Task:**

Create REST APIs that 

- Returns a list of all the priority areas from the database
- Accepts the order of priority along with the satisfaction rating for each area for a user and stores it in the database

Technology Used:
  - Java 11
  - Spring Boot
  - JPA/Hibernate
  - MySQL 8.0
  - For testing api - Postman

API's 
GET http://localhost:8080/priorities/categories/all-default
  - Gets all the categories in the database with default order
GET http://localhost:8080/priorities/categories/{userId}
  Ex - http://localhost:8080/priorities/categories/1000
  - Gets all the categories for the user with the given user id in the order provided by user

POST http://localhost:8080/priorities/rating-order
  - Add/Update the category with the order and rating provided by user. Same api is used for adding and updating both. 
  If the category is not customized by user and he does some modification for the categories it will be added against his user id and the next time he modifies the same
  with some different rating or order, same will be updated
  
POST http://localhost:8080/admin/categories/add
  - For the admin to add more categories

Download and run in mysql [init.zip](https://github.com/RakeshKumar95/Wellness-Priorities/files/7086356/init.zip)

  
There is no security implemented for this api as of now.
