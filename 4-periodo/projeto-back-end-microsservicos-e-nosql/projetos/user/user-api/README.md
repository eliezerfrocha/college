# User API

A Spring Boot REST API for user management with MongoDB integration.

## Features

- **User Management**: Create, read, update, and delete users
- **Data Validation**: Input validation with Jakarta Bean Validation
- **MongoDB Integration**: Uses Spring Data MongoDB for data persistence
- **RESTful API**: Clean REST endpoints following best practices
- **Error Handling**: Proper HTTP status codes and error responses

## API Endpoints

### Users
- `POST /api/users` - Create a new user
- `GET /api/users` - Get all users
- `GET /api/users/{id}` - Get user by ID
- `GET /api/users/cpf/{cpf}` - Get user by CPF
- `PUT /api/users/{id}` - Update user
- `DELETE /api/users/{id}` - Delete user

## Data Model

### User Entity
- `id`: String (MongoDB ObjectId)
- `nome`: String (required)
- `cpf`: String (required, 11 digits)
- `endereco`: String (required)
- `email`: String (required, valid email format)
- `telefone`: String (required, 10-11 digits)
- `dataCadastro`: LocalDateTime (auto-generated)

### UserDTO
- `nome`: String (required)
- `cpf`: String (required, 11 digits)
- `endereco`: String (required)
- `email`: String (required, valid email format)
- `telefone`: String (required, 10-11 digits)

## Configuration

The application is configured to use:
- **Port**: 8080
- **Database**: MongoDB (localhost:27017/user_api)
- **Java Version**: 17
- **Spring Boot**: 3.5.6

## Running the Application

1. **Prerequisites**:
   - Java 17+
   - MongoDB running on localhost:27017
   - Maven 3.6+

2. **Start MongoDB**:
   ```bash
   # Using Docker
   docker run -d -p 27017:27017 --name mongodb mongo:latest
   
   # Or install MongoDB locally and start the service
   ```

3. **Run the Application**:
   ```bash
   ./mvnw spring-boot:run
   ```

4. **Run Tests**:
   ```bash
   ./mvnw test
   ```

## Example Usage

### Create a User
```bash
curl -X POST http://localhost:8080/api/users \
  -H "Content-Type: application/json" \
  -d '{
    "nome": "João Silva",
    "cpf": "12345678901",
    "endereco": "Rua das Flores, 123",
    "email": "joao@email.com",
    "telefone": "11999999999"
  }'
```

### Get All Users
```bash
curl http://localhost:8080/api/users
```

### Get User by ID
```bash
curl http://localhost:8080/api/users/{id}
```

### Update User
```bash
curl -X PUT http://localhost:8080/api/users/{id} \
  -H "Content-Type: application/json" \
  -d '{
    "nome": "João Silva Santos",
    "cpf": "12345678901",
    "endereco": "Rua das Flores, 456",
    "email": "joao.santos@email.com",
    "telefone": "11888888888"
  }'
```

### Delete User
```bash
curl -X DELETE http://localhost:8080/api/users/{id}
```

## Technologies Used

- **Spring Boot 3.5.6**
- **Spring Data MongoDB**
- **Spring Web**
- **Jakarta Bean Validation**
- **Lombok**
- **MongoDB**
- **Maven**
- **JUnit 5** (for testing)

## Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com/eliezer/api/user/user_api/
│   │       ├── UserApiApplication.java
│   │       ├── controller/
│   │       │   └── UserController.java
│   │       ├── models/
│   │       │   ├── User.java
│   │       │   └── dto/
│   │       │       └── UserDTO.java
│   │       ├── repositories/
│   │       │   └── UserRepository.java
│   │       └── services/
│   │           └── UserService.java
│   └── resources/
│       └── application.yml
└── test/
    └── java/
        └── com/eliezer/api/user/user_api/
            └── UserApiApplicationTests.java
```
