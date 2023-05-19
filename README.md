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



# User Entity - RESTful API

This is a User entity class that represents a user in a RESTful API. It provides information about the user's id, name, birthdate, and their associated posts.

## Entity Structure

The User entity has the following attributes:

- `id`: Integer - The unique identifier for the user.
- `name`: String - The name of the user.
- `birthdate`: LocalDate - The birthdate of the user.
- `posts`: List of Post objects - The posts associated with the user.

## API Endpoints

The User entity can be managed through the following RESTful endpoints:

| Endpoint            | HTTP Method | Description                    |
|---------------------|-------------|--------------------------------|
| `/api/users`        | GET         | Get all users                  |
| `/api/users/{id}`   | GET         | Get a user by ID               |
| `/api/users`        | POST        | Create a new user              |
| `/api/users/{id}`   | PUT         | Update a user by ID            |
| `/api/users/{id}`   | DELETE      | Delete a user by ID            |

## JSON Representation

The User entity is represented in JSON format as follows:

```json
{
  "id": 1,
  "name": "John Doe",
  "birthdate": "1990-01-01",
  "posts": [
    {
      "id": 1,
      "title": "Post 1",
      "content": "This is the first post."
    },
    {
      "id": 2,
      "title": "Post 2",
      "content": "This is the second post."
    }
  ]
}
```

## Validations

The User entity includes the following validations:

- `name`: The name should have at least 2 characters.
- `birthdate`: The birthdate should be in the past.

## Usage

To use this User entity in your RESTful API project:

1. Include the User class in your project's source code.
2. Customize the entity according to your project's requirements (e.g., add additional attributes or relationships).
3. Implement the RESTful endpoints and business logic for managing users.
4. Configure the database connection and dependencies in your project's configuration files.
5. Build and run the project to test the API endpoints.

## Example

Here's an example of creating a new user using the API:

**Request:**

```bash
POST /api/users
Content-Type: application/json

{
  "name": "John Doe",
  "birthdate": "1990-01-01"
}
```

**Response:**

```bash
HTTP/1.1 201 Created
Content-Type: application/json

{
  "id": 1,
  "name": "John Doe",
  "birthdate": "1990-01-01"
}
```

You can refer to the API endpoints section for more details on how to interact with the User entity in your RESTful API.


