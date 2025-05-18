#!/bin/bash

# No need for PostgreSQL container since we're using H2 in-memory database
echo "Using H2 in-memory database..."

# Build and run the Spring Boot application
echo "Building and running the application..."
./mvnw spring-boot:run
