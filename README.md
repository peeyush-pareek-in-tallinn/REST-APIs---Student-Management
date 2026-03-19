# Student Management REST API

![Repo Size](https://img.shields.io/github/repo-size/peeyush-pareek-in-tallinn/REST-APIs---Student-Management?style=flat-square)
![Contributors](https://img.shields.io/github/contributors/peeyush-pareek-in-tallinn/REST-APIs---Student-Management?style=flat-square)
![License](https://img.shields.io/github/license/peeyush-pareek-in-tallinn/REST-APIs---Student-Management?style=flat-square)
![Last Commit](https://img.shields.io/github/last-commit/peeyush-pareek-in-tallinn/REST-APIs---Student-Management?style=flat-square)

A Spring Boot REST API for managing student records. This project provides CRUD operations, demonstrates clean RESTful API design, and follows a layered architecture with controllers, services, and repositories. Ideal for learning backend development with Java.

## Table of Contents

- Features
- Tech Stack
- Getting Started
- API Endpoints
- Project Structure
- Contributing
- License
- Acknowledgements

## Features

- Student Management – Create, read, update, and delete student records  
- RESTful API – Structured endpoints for frontend or client applications  
- Layered Architecture – Clear separation between controllers, services, and repositories  
- Exception Handling – Robust error management for invalid requests  
- DTOs – Clean data transfer between layers  

## Tech Stack

| Layer       | Technology |
|------------|------------|
| Backend    | Java (Spring Boot) |
| Web        | Spring MVC / REST |
| Data       | JPA / Hibernate |
| Database   | MySQL / PostgreSQL |
| Build      | Maven |
| Testing    | JUnit / Mockito (optional) |
| Code Quality | Lombok (optional) |

## Getting Started

### Installation

``bash
git clone https://github.com/peeyush-pareek-in-tallinn/REST-APIs---Student-Management.git
cd REST-APIs---Student-Management

Open in your IDE (IntelliJ, Eclipse, VS Code) and ensure:

Java 17+ installed

Maven installed

A running SQL database (MySQL recommended)

Configuration

Update application.properties with your database credentials:

spring.datasource.url=jdbc:mysql://localhost:3306/student_db
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
Run the App
mvn clean install
mvn spring-boot:run

APIs will be available at: http://localhost:8080/api/

API Endpoints (Example)
Endpoint	Method	Description
/api/students	GET	List all students
/api/students/{id}	GET	Get student by ID
/api/students	POST	Create a new student
/api/students/{id}	PUT	Update student by ID
/api/students/{id}	DELETE	Delete student by ID
Project Structure
src/
├── main/
│   ├── java/
│   │   └── com.example.student/
│   │       ├── controller/
│   │       ├── service/
│   │       ├── dto/
│   │       ├── model/
│   │       ├── repository/
│   │       └── exception/
│   └── resources/
│       └── application.properties
Contributing

Star the repo

Fork it

Create a branch

Implement your feature

Open a Pull Request

License

MIT License. See LICENSE for details.

Acknowledgements

This project is designed as a learning resource for building RESTful APIs with Java and Spring Boot. You can extend it for real-world applications or use it to practice backend development.

---


## Author

Peeyush Pareek
Aspiring Backend Java Developer
