# Student Management REST API

A backend REST API built using **Java and Spring Boot** that provides basic CRUD operations for managing student records.

This project was created as part of my learning journey into **backend development and REST API design**.

---

## Features

- Create student records
- Retrieve student information
- Update student details
- Delete student records
- RESTful API structure following standard HTTP methods

---

## Tech Stack

- **Java**
- **Spring Boot**
- **Spring Web**
- **Maven**
- REST API architecture

---

## API Endpoints

| Method | Endpoint | Description |
|------|------|-------------|
| GET | /students | Get all students |
| GET | /students/{id} | Get student by ID |
| POST | /students | Create a new student |
| PUT | /students/{id} | Update student details |
| DELETE | /students/{id} | Delete a student |

---

## Example Request

POST `/students`

``json
 {
   "name": "John Doe",
   "email": "john@example.com",
   "course": "Computer Science"
 }

---

## Running the Project

Clone the repository: 
  git clone https://github.com/peeyush-pareek-in-tallinn/REST-APIs--Student-Management.git

Navigate to the project directory: 
  cd REST-APIs--Student-Management

Run the application: 
  mvn spring-boot:run

The API will start at: 
  http://localhost:8080

---


## Learning Goals

This project helped me practice:

- REST API development using Spring Boot
- Structuring backend services
- Implementing CRUD operations
- Understanding controller-service architecture

---


Author

Peeyush Pareek
Aspiring Backend Developer focusing on Rust and Java
