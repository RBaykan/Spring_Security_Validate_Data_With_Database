## Spring Security Validate Data With Database

This project demonstrates a basic implementation of a user management system using **Spring Boot** and **JPA**. It includes features such as creating user accounts and fetching user data. Additionally, we validate account creation by checking the database to ensure that usernames and email addresses are unique.

# Features
- **User Entity:** Represents user accounts with fields such as `firstname`, `lastname`, `username`, `password`, and `email`.
- **Validation:** 
  - Ensures that email and username are unique during account registration.
  - Uses `@Valid` annotations for input validation
  - It is a continuation of the previous project and was developed using H2 Database.
  - Previous project: https://github.com/RBaykan/Spring_Security_Validating_Data
- **Endpoints:**
  - `GET /api/user`: Retrieve a list of all registered users.
  - `POST /api/user`: Register a new user if the username and email are not already in use.
# Technologies Used 
Spring Boot
Spring Security
Spring Validation
Hibernate Validator
Java 21+

## Project Structure

### Model
The `User` entity represents the user table in the database.
- **File:** `com.nontius.proje.model.User`

### Repository
The `UserRepository` provides database operations and custom methods (JPA will be convert to SQL/HQL queries) to find users by `username` and `email`.
- **File:** `com.nontius.proje.repository.UserRepository`

### Service
The `UserService` interface defines methods for user-related operations such as registration and fetching all users.
- **File:** `com.nontius.proje.service.UserService`

### Controller
The `UserController` handles API requests for user operations.
- **File:** `com.nontius.proje.controller.UserController`

# How to Run
Clone the repository: `https://github.com/RBaykan/Spring_Security_Validate_Data_With_Database.git`
Configure the database connection in `application.yaml` (Configured for H2 Database).
Run the application using your IDE or via the command line:
```bash
./mvnw spring-boot:run
```
Access the API at http://localhost:8080/api/user.

## API Endpoints

### Get All Users
**Endpoint:** `GET /api/user`  
**Description:** Returns a list of all registered users. You can create a new DTO. I am using the userDTO that I created for registration. 
It will also show the "mathcing password" information but it will be assigned null from the mappe
**Response:**  
like:
```json
[
  {
    "id": 1,
    "firstname": "Ali",
    "lastname": "Veli",
    "username": "ali_veli",
    "password": "1234",
    "matchinPassword": "null"
    "email": "aliveli@example.com"
  },
  {
    "id": 2,
    "firstname": "Veli",
    "lastname": "Ali",
    "username": "veli_ali",
     "password": "1234",
    "matchinPassword": "null"
    "email": "veli_ali@example.com"
  }
]
```
or if no value:
```json
[]
```

Register a New User
Endpoint: POST /api/user
Description: Registers a new user. Fails if the email or username is already in use.
Request Body:

```json
{
  "firstname": "Ali",
  "lastname": "Veli",
  "username": "ali_veli",
  "password": "1234",
  "password": "1234",
  "email": "ali_veli@example.com"
}
```
Response:
```json
{
  "firstname": "Ali",
  "lastname": "Veli",
  "username": "ali_veli",
  "password": "1234",
  "matchinPassword": "1234",
  "email": "ali_veli@example.com"
}
```
Validation Error: If username or email already exists:
```json
{
  "error": "Username already exit"
}
```
or
```json
{
  "error": "Email already exit"
}
```




