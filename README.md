# Interview Memory Bank

A Spring Boot backend application where users can register, log in, and share interview experiences to help other job seekers prepare for interviews.

## Tech Stack

- Java 21
- Spring Boot
- Spring Data JPA
- Spring Security
- MySQL
- Maven
- Postman

## Features Completed

### Day 1
- Project setup
- MySQL integration
- User registration API
- JPA entities and repositories
- Security configuration
- Postman testing

## API Endpoints

### Register User

POST `/api/auth/register`

Request:

```json
{
  "name": "Nitika",
  "email": "nitika@gmail.com",
  "password": "123456"
}
