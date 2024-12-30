# Library Management System

A Spring Boot application for managing books in a library, including features like adding, removing, searching, and displaying all books. 

## Features

1. **Add a Book**: Add a new book to the library inventory.
2. **Remove a Book**: Remove a book by ID or Title.
3. **Search for a Book**: Search books by Title, Author, or Publication Year.
4. **Display All Books**: Display all books in the inventory.
5. **Exception Handling**: Handles errors like duplicate book entries or book not found.
6. **Design Patterns**: Implements Singleton  
7. **Exit Application**: Safely terminates the Spring Boot application.

## Technologies Used

- Spring Boot (REST Controllers, Dependency Injection, Exception Handling)
- Java 8+ Features (Streams, Functional Programming)
- In-Memory Storage (List)

## Running the Application

1. Clone the repository:
    ```bash
    git clone https://github.com/yourusername/library-management.git
    ```
2. Navigate to the project directory:
    ```bash
    cd library-management
    ```
3. Run the Spring Boot application:
    ```bash
    ./mvnw spring-boot:run
    ```
4. The application will run on `http://localhost:8080`.

## API Endpoints

1. **POST /add**: Add a new book.
2. **DELETE /{bookId}**: Remove a book by ID or Title.
3. **GET /{key}: Search books by Title, Author, or Publication Year.
4. **GET / : Display all books.
5. **POST /update/{bookId}**: Exit the application.
