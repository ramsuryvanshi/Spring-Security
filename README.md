# 🔐 Spring Boot Security Project

## 📖 Overview
This is a **Spring Boot Security Project** that demonstrates how to implement **user authentication and authorization** using **Spring Security**, `UserDetailsService`, and `AuthenticationManager`.

It follows best practices for secure login management, password encryption, and role-based access control (RBAC).

---

## 🚀 Features
- ✅ User Registration & Login
- 🧩 Role-Based Authorization (`ADMIN`, `USER`)
- 💾 MySQL Database Integration with JPA/Hibernate
- 🧱 Layered Architecture (Controller → Service → Repository)
- 🔐 Password Encryption using `BCryptPasswordEncoder`
- ⚙️ Custom Implementation of `UserDetailsService`
- 🧰 Authentication managed using `AuthenticationManager`
- 🧾 Exception Handling for invalid credentials and unauthorized access

---

---

## 🧩 Key Components

### 🔹 1. `UserDetailsService`
- Custom implementation (`CustomUserDetailsService`) loads user details from the database.
- Used by Spring Security for authentication.
- Returns `UserDetails` object containing username, password, and roles.

### 🔹 2. `AuthenticationManager`
- Used in the login flow to authenticate user credentials.
- Validates the username and password from `UserDetailsService`.

### 🔹 3. `SecurityConfig`
Defines:
- HTTP security rules (`/login`, `/register`, etc.)
- Password encoder (`BCryptPasswordEncoder`)
- Authentication provider and manager beans

---

## ⚙️ Technologies Used
- **Java 17+**
- **Spring Boot 3+**
- **Spring Security**
- **Spring Data JPA (Hibernate)**
- **MySQL Database**
- **Maven**
- **Postman** (for API testing)

---

## 🗃️ Database Configuration
`application.properties`
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/my_db
spring.datasource.username=root
spring.datasource.password=yourpassword

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect

