# Interview Memory Bank

A Spring Boot backend application where users can share, manage, and explore real interview experiences from different companies.

The project provides REST APIs for user authentication and interview experience management, including search, pagination, password encryption, and JWT token generation.

---

## 🚀 Features

### 👤 User Authentication
- User Registration
- User Login
- Duplicate Email Validation
- BCrypt Password Encryption
- JWT Token Generation

### 📝 Interview Experience Management
- Add Interview Experience
- View All Interview Experiences
- View Interview Experience by ID
- Update Interview Experience
- Delete Interview Experience

### 🔍 Search Features
- Search Experiences by Company
- Search Experiences by Role
- View Experiences by User

### 📄 Pagination
- Paginated Interview Experience Results

### 🔗 Database Relationships
- One User can have multiple Interview Experiences
- One-to-Many relationship between User and InterviewExperience

---

## 🛠 Tech Stack

- Java 21
- Spring Boot
- Spring Data JPA
- Spring Security
- JWT (JSON Web Token)
- MySQL
- Maven
- Lombok
- Swagger / OpenAPI
- Postman

---

## 📂 Project Structure

```text
src/main/java/com/interviewbank/interview_memory_bank

├── config
├── controller
├── dto
├── entity
├── repository
├── security
└── service
