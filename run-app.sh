#!/bin/bash

# Compile and run the application directly with Java
echo "Compiling and running the application..."

# Ensure the target directory exists
mkdir -p target/classes

# Compile the Java files
find src/main/java -name "*.java" -print | xargs javac -d target/classes -cp "target/classes"

# Run the application
java -cp target/classes com.example.productservice.ProductServiceApplication
