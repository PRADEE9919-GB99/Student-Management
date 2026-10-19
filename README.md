# Student Management System

A RESTful Student Management System developed using **Java, Spring Boot, Spring Data JPA, and MySQL**. The application provides APIs to create, retrieve, update, and delete student records, with centralized exception handling and structured error responses.

## Features

* Create and register student records
* Retrieve a student by ID
* Search students by name
* Retrieve all students
* Update student details
* Delete student records
* Centralized exception handling using `@RestControllerAdvice`
* Structured error responses using `ErrorInfo`
* Request validation using Jakarta Bean Validation
* Application logging for debugging and troubleshooting

## Tech Stack

* **Language:** Java
* **Framework:** Spring Boot
* **Database:** MySQL
* **Persistence:** Spring Data JPA, Hibernate
* **API:** RESTful APIs
* **Build Tool:** Maven
* **Testing Tool:** Postman
* **Logging:** Spring Boot Logging / SLF4J

## Student Attributes

| Field         | Description               |
| ------------- | ------------------------- |
| `studentId`   | Unique student identifier |
| `studentName` | Student's name            |
| `email`       | Student's email address   |
| `age`         | Student's age             |
| `gender`      | Numeric gender value      |

## Project Structure

```text
Student-Management/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/pradeep/Student/Management/System/
│       │       ├── api/
│       │       │   └── StudentController.java
│       │       ├── dto/
│       │       │   └── StudentDTO.java
│       │       ├── entity/
│       │       │   └── Student.java
│       │       ├── exception/
│       │       │   ├── ErrorInfo.java
│       │       │   ├── GlobalExceptionHandler.java
│       │       │   └── StudentException.java
│       │       ├── repository/
│       │       │   └── StudentRepository.java
│       │       ├── service/
│       │       │   ├── StudentService.java
│       │       │   └── StudentServiceImpl.java
│       │       └── util/
│       │           └── StudentUtil.java
│       └── resources/
│           └── application.properties
├── pom.xml
└── README.md
```

*The structure above reflects the intended organization; adjust filenames if your actual project differs.*

## Prerequisites

Install the following before running the application:

* Java Development Kit (JDK)
* Apache Maven, or use the Maven wrapper if included
* MySQL Server
* Postman (for API testing)

## Database Setup

Create the MySQL database:

```sql
CREATE DATABASE StudentManagement;
```

Configure the database connection in `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/StudentManagement
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

server.port=8080
```

Set `DB_USERNAME` and `DB_PASSWORD` as environment variables before starting the application. Do not commit real database credentials to GitHub.

## Run the Application

1. Clone the repository:

   ```bash
   git clone <YOUR_GITHUB_REPOSITORY_URL>
   ```

2. Navigate into the project directory:

   ```bash
   cd Student-Management
   ```

3. Configure the MySQL database connection.

4. Run the application using Maven:

   ```bash
   mvn spring-boot:run
   ```

   Alternatively, run the main Spring Boot application class from Eclipse.

5. The application should be available at:

   `http://localhost:8080`

## REST API Endpoints

Base URL: `http://localhost:8080/students`

| Method | Endpoint                | Description              | Success Status |
| ------ | ----------------------- | ------------------------ | -------------- |
| POST   | `/students`             | Add a student            | 201 Created    |
| GET    | `/students`             | Retrieve all students    | 200 OK         |
| GET    | `/students/{studentId}` | Retrieve a student by ID | 200 OK         |
| GET    | `/students/name/{name}` | Search students by name  | 200 OK         |
| PUT    | `/students/{studentId}` | Update a student         | 204 No Content |
| DELETE | `/students/{studentId}` | Delete a student         | 204 No Content |

## Sample API Request

### Create a Student

**Request**

```http
POST /students
Content-Type: application/json
```

**Request Body**

```json
{
  "studentName": "Praveen",
  "email": "praveen@example.com",
  "age": 24,
  "gender": 1
}
```

The API returns the generated student ID when creation succeeds.

### Retrieve a Student

```http
GET /students/1
```

### Update a Student

```http
PUT /students/1
Content-Type: application/json
```

```json
{
  "studentName": "Praveen Biradar",
  "email": "praveen@example.com",
  "age": 24,
  "gender": 1
}
```

### Delete a Student

```http
DELETE /students/1
```

## Exception Handling

The application uses centralized exception handling through `GlobalExceptionHandler`.

* `StudentException` — handles student-related errors, such as a student ID not being found.
* Validation exceptions — handle invalid request data when validation is configured.
* General exceptions — handle unexpected application errors.

Error responses use the `ErrorInfo` structure, containing an error code and error information. HTTP status codes depend on the exception-handler mappings.

## Logging

Application logs can be configured in `application.properties`:

```properties
logging.file.name=logs/student-management.log
logging.level.com.pradeep.Student.Management.System=DEBUG
```

Logs help diagnose application issues during development and testing. Avoid logging passwords, tokens, or other sensitive information.

## Testing

Use Postman to test the REST endpoints, including:

* Successful student creation and retrieval
* Updating and deleting existing records
* Requests for nonexistent student IDs
* Invalid request bodies and validation errors
* Duplicate email addresses, if email uniqueness is enforced

## Future Enhancements

* Add pagination and sorting
* Implement Swagger/OpenAPI documentation
* Add automated unit and integration tests
* Introduce authentication and authorization
* Add Docker support

## Author

**Pradeep**

---

*This project was developed to practice Spring Boot REST API development, database integration, CRUD operations, and centralized exception handling.*
