# Normal Ecommerce Backend

A backend application for an e-commerce website built with **Java and Spring Boot**. This project provides REST APIs for managing products, customers, and basic e-commerce operations.

## 🚀 Technologies Used

* Java
* Spring Boot
* Spring Data JPA
* H2 DB
* REST API
* Maven
* Git & GitHub

## 📌 Features

* Product management
* CRUD operations
* RESTful APIs
* H2 database integration
* Layered architecture using Controller, Service, and Repository



The application follows a basic layered architecture:

**Controller → Service → Repository → Database**

## ⚙️ How to Run

### 1. Clone the repository

```bash
git clone https://github.com/shreejeshpanta/Normal-Ecommerce-backend.git
```

### 2. Open the project

Open the project in IntelliJ IDEA, Eclipse, or another Java IDE.

### 3. Configure MySQL

Create a H2 database and update the database configuration in `application.properties`.

Example:

```properties
spring.application.name=ecom-project
spring.datasource.url=jdbc:h2:mem:ecomdb
spring.datasource.driverClassName=org.h2.Driver
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update
spring.jpa.defer-datasource-initialization=true
spring.application

```

### 4. Run the application

Run the Spring Boot application from your IDE or using Maven:

```bash
mvn spring-boot:run
```

## 🔗 API

The application provides REST APIs for performing CRUD operations.

You can test the APIs using **Postman**.

## 🔐 Authentication

Authentication and authorization are **not implemented yet**. This project currently focuses on the core backend functionality and REST API development.

## 📚 Purpose

This project was created as a learning project to practice:

* Java backend development
* Spring Boot
* REST API development
* Database integration
* JPA and Hibernate
* Backend project structure

## 👨‍💻 Author

**Shreejesh Panta**

GitHub: [shreejeshpanta](https://github.com/shreejeshpanta)
