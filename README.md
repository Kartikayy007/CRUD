# Product Service API

A Spring Boot REST API application that provides CRUD operations for Product management.

## Technologies Used

- Java 17
- Spring Boot 3.2.3
- Spring Data JPA
- PostgreSQL
- Swagger/OpenAPI for API documentation
- Lombok
- Maven

## Project Structure

The application follows a layered architecture:

```
src/main/java/com/example/productservice/
├── ProductServiceApplication.java       # Main application class
├── controller                          # REST Controllers
│   └── ProductController.java
├── dto                                 # Data Transfer Objects
│   └── ProductDto.java
├── exception                           # Exception handling
│   ├── ErrorDetails.java
│   ├── GlobalExceptionHandler.java
│   ├── ResourceNotFoundException.java
│   └── ValidationErrorResponse.java
├── model                               # Entity models
│   └── Product.java
├── repository                          # Data access layer
│   └── ProductRepository.java
└── service                             # Business logic
    ├── ProductService.java             # Service interface
    └── impl
        └── ProductServiceImpl.java     # Service implementation
```

## Database Setup

### Option 1: Using Docker (Recommended)

A Docker Compose file is included to quickly set up PostgreSQL:

```bash
docker-compose up -d
```

This will create a PostgreSQL instance with:
- Database: `productdb`
- Username: `postgres`
- Password: `postgres`

### Option 2: Manual Setup

1. Ensure PostgreSQL is installed and running on your machine
2. Create a database named `productdb`:
   ```sql
   CREATE DATABASE productdb;
   ```
3. The application will automatically create the necessary tables when it starts

## Sample Data

The application includes sample product data that will be automatically loaded when the application starts. This includes products like smartphones, laptops, headphones, etc.

## Running the Application

### Option 1: Using the provided script (Recommended)

A convenience script is included to start PostgreSQL and run the application:

```bash
./run.sh
```

This script will:
1. Start the PostgreSQL container using Docker Compose
2. Wait for PostgreSQL to initialize
3. Build and run the Spring Boot application

### Option 2: Manual execution

1. Start PostgreSQL (either using Docker Compose or your local installation)
2. Navigate to the project directory
3. Run the application:
   ```bash
   ./mvnw spring-boot:run
   ```
   Or build and run:
   ```bash
   ./mvnw clean package
   java -jar target/product-service-0.0.1-SNAPSHOT.jar
   ```

## API Documentation

Swagger UI is available at: http://localhost:8080/swagger-ui.html

API endpoints:

- `POST /api/products` - Create a new product
- `GET /api/products` - Get all products
- `GET /api/products/{id}` - Get a product by ID
- `PUT /api/products/{id}` - Update a product
- `DELETE /api/products/{id}` - Delete a product (soft delete)
- `GET /api/products/search?name={name}` - Search products by name
- `GET /api/products/active` - Get all active products

## Configuration

Configuration properties are defined in `src/main/resources/application.properties`.
