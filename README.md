# User Management API

This project demonstrates a basic implementation of a user management system using **Spring Boot** and **JPA**. It includes features such as creating user accounts and fetching user data. Additionally, we validate account creation by checking the database to ensure that usernames and email addresses are unique.

## Features
- **User Entity:** Represents user accounts with fields such as `firstname`, `lastname`, `username`, `password`, and `email`.
- **Validation:** 
  - Ensures that email and username are unique during account registration.
  - Uses `@Valid` annotations for input validation.
- **Endpoints:**
  - `GET /api/user`: Retrieve a list of all registered users.
  - `POST /api/user`: Register a new user if the username and email are not already in use.

## Project Structure

### Model
The `User` entity represents the user table in the database.
- **File:** `com.nontius.proje.model.User`

### Repository
The `UserRepository` provides database operations and custom methods to find users by `username` and `email`.
- **File:** `com.nontius.proje.repository.UserRepository`

### Service
The `UserService` interface defines methods for user-related operations such as registration and fetching all users.
- **File:** `com.nontius.proje.service.UserService`

### Controller
The `UserController` handles API requests for user operations.
- **File:** `com.nontius.proje.controller.UserController`

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
  "error": "Username is already exit"
}
```
or
```json
{
  "error": "Username is already exit"
}
```

