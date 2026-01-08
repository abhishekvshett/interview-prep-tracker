# Interview Prep Tracker (Spring Boot + MySQL)

A backend REST API to track interview preparation topics and job applications per user.

## 🚀 Features
- User registration with password hashing (BCrypt)
- Track preparation topics (Java, DSA, OS, etc.)
- Track job applications (company, role, status)
- User-specific data ownership
- Clean REST APIs with DTOs
- Global exception handling
- MySQL persistence using Spring Data JPA

---

## 🏗️ Tech Stack
- Java 17
- Spring Boot
- Spring Data JPA
- MySQL
- Hibernate
- Maven

---

## 📐 Architecture



- **Controller**: Handles HTTP requests
- **DTOs**: Protect API contract & sensitive data
- **Service**: Business logic & validation
- **Repository**: Data access
- **Entity**: Database mapping

---

## 🔐 Security
- Passwords are hashed using BCrypt
- Entities are never exposed directly in APIs
- Clean DTO-based responses

---

## 📌 API Endpoints

### Users
- `POST /api/users/register`

### Topics
- `POST /api/users/{userId}/topics`
- `GET /api/users/{userId}/topics`

### Applications
- `POST /api/users/{userId}/applications`
- `GET /api/users/{userId}/applications`

---

## ⚠️ Error Handling
- Custom exceptions (`UserNotFoundException`, `EmailAlreadyExistsException`)
- Global exception handler with proper HTTP status codes

---

## ✅ Future Improvements
- Authentication & JWT
- Pagination & sorting
- Frontend (React)
