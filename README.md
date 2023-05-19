# RestAPI_SpringJPA
# Spring Boot REST API with Spring Data JPA

This is a sample project that demonstrates how to build a RESTful API using Spring Boot and Spring Data JPA. The project aims to provide a basic structure and implementation for creating and managing resources through RESTful endpoints.

## Features

- Create, Read, Update, and Delete (CRUD) operations for a resource.
- Integration with a relational database using Spring Data JPA.
- Validation of input data using Hibernate Validator.
- Exception handling and error responses.
- Unit and integration testing using JUnit and Spring Test.

## Prerequisites

To run this project, you need to have the following installed:

- Java Development Kit (JDK) 8 or higher
- Maven
- An IDE (e.g., IntelliJ IDEA, Eclipse)

## Getting Started

Follow these steps to set up and run the project locally:

1. Clone the repository:

```bash
git clone https://github.com/rawalcodes7/RestAPI_SpringJPA.git
```

2. Open the project in your preferred IDE.

3. Configure the database connection properties in the `application.properties` file. By default, it uses an in-memory H2 database.

4. Build the project using Maven:

```bash
mvn clean install
```

5. Run the application:

```bash
mvn spring-boot:run
```

The API will be accessible at `http://localhost:8080/api`.

## API Endpoints

The following endpoints are available for interacting with the API:

| Endpoint                   | HTTP Method | Description                      |
|----------------------------|-------------|----------------------------------|
| `/jpa/users`            | POST        | Create a new resource             |
| `/jpa/users/{id}`       | GET         | Get a resource by ID              |
| `/jpa/users`            | GET         | Get all resources                 |
| `/jpa/users/{id}`       | PUT         | Update a resource by ID           |
| `/jpa/users/{id}`       | DELETE      | Delete a resource by ID           |

## Request and Response Examples

### Create a Resource

**Request:**

```bash
POST /api/resource
Content-Type: application/json

{
  "name": "Example Resource",
  "description": "This is an example resource."
}
```

**Response:**

```bash
HTTP/1.1 201 Created
Content-Type: application/json

{
  "id": 1,
  "name": "Example Resource",
  "description": "This is an example resource."
}
```

### Get a Resource

**Request:**

```bash
GET /api/resource/1
```

**Response:**

```bash
HTTP/1.1 200 OK
Content-Type: application/json

{
  "id": 1,
  "name": "Example Resource",
  "description": "This is an example resource."
}
```

### Update a Resource

**Request:**

```bash
PUT /api/resource/1
Content-Type: application/json

{
  "name": "Updated Resource",
  "description": "This is the updated resource."
}
```



