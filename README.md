# Spring Boot Modular Web Application

A production-oriented Spring Boot application demonstrating a **modular architecture** using Java and Spring Boot best practices.

The project is organized into independent modules with clear responsibilities, making it easier to maintain, test, and extend over time.

---

## 🚀 Features

- Modular Architecture
- Spring Boot
- Spring Data JPA
- RESTful APIs
- Validation
- Exception Handling
- Layered Architecture
- DTO Pattern
- Dependency Injection
- Maven Multi-Module Structure
- Clean Code Principles

---

## 🏗 Architecture

The application follows a modular design where each module is responsible for a specific business capability.

```
spring-boot-modular-webapp
│
├── common
│   ├── configuration
│   ├── exceptions
│   └── utilities
│
├── modules
│   ├── module-a
│   ├── module-b
│   └── module-c
│
└── application
```

Each module contains its own:

- Controller
- Service
- Repository
- Domain
- DTOs

This approach minimizes coupling and improves maintainability.

---

## 🛠 Tech Stack

| Technology | Version |
|------------|---------|
| Java | 21 |
| Spring Boot | Latest |
| Spring Data JPA | ✔ |
| Maven | ✔ |
| Hibernate | ✔ |
| Lombok | ✔ |
| PostgreSQL | ✔ |
| Validation | Jakarta Validation |

---

## 📦 Getting Started

### Clone

```bash
git clone https://github.com/farzan6118/spring-boot-modular-webapp.git

cd spring-boot-modular-webapp
```

### Build

```bash
mvn clean install
```

### Run

```bash
mvn spring-boot:run
```

---

## 📁 Project Structure

```
src
 ├── main
 │   ├── java
 │   └── resources
 └── test
```

The project follows the standard Spring Boot project layout with additional modular separation.

---

## 🎯 Goals

This project demonstrates:

- Building maintainable Spring Boot applications
- Applying modular design principles
- Separation of concerns
- Scalable package organization
- Clean architecture concepts

---

## 🔮 Future Improvements

- Spring Modulith
- Docker Support
- Testcontainers
- OpenAPI / Swagger
- Flyway
- Integration Tests
- GitHub Actions CI/CD
- Observability (Micrometer + Prometheus)

---

## 👨‍💻 Author

**Farzan Saketi**

Senior Java Backend Developer

GitHub:
https://github.com/farzan6118

---

## 📄 License

This project is available under the MIT License.
