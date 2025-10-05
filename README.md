# Calculator API

A simple REST API built with Spring Boot for performing basic mathematical operations. This is a learning project designed to understand the fundamentals of REST APIs, Spring Boot architecture, and modern Java development practices.

## Learning Objectives

This is my **first REST API project** - a foundational step in learning:
- Spring Boot framework fundamentals
- RESTful API design and implementation
- Service layer architecture and separation of concerns
- Unit and integration testing
- Dependency injection and IoC (Inversion of Control)
- HTTP request/response handling
- JSON serialization/deserialization

This simple calculator serves as a building block for more complex projects in the future, including microservices architecture, database integration, and advanced Spring features.

## Project Structure

```
calculator/
├── src/main/java/com/Kevin/calculator/
│   ├── CalculatorApplication.java          # Main Spring Boot application entry point
│   ├── Operation.java                      # Enum defining calculator operations
│   ├── CalculatorService.java              # Business logic layer
│   ├── CalculatorController.java           # REST API endpoints
│   ├── CalculationRequest.java             # Request DTO (Data Transfer Object)
│   └── CalculationResponse.java            # Response DTO
├── src/test/java/com/Kevin/calculator/
│   ├── CalculatorApplicationTests.java     # Basic application tests
│   ├── CalculatorServiceTest.java          # Unit tests for service layer
│   └── CalculatorControllerTest.java       # Integration tests for API endpoints
├── pom.xml                                 # Maven dependencies and build configuration
└── README.md                               # This file
```

## Technologies Used

- **Java 17+** - Programming language
- **Spring Boot 3.x** - Application framework
- **Spring Web** - REST API support
- **Maven** - Dependency management and build tool
- **JUnit 5** - Unit testing framework
- **Mockito** - Mocking framework for tests
- **MockMvc** - Spring MVC testing support

## Getting Started

### Prerequisites
- JDK 17 or higher
- Maven 3.6+
- IDE (IntelliJ IDEA, Eclipse, or VS Code recommended)

### Installation & Running

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd calculator
   ```

2. **Build the project**
   ```bash
   mvn clean install
   ```

3. **Run the application**
   ```bash
   mvn spring-boot:run
   ```
   
   Or run directly from your IDE by executing `CalculatorApplication.java`

4. **Application will start on:** `http://localhost:8080`

## API Endpoints

### Base URL
```
http://localhost:8080/api/calculator
```

### Available Operations

#### 1. Addition
```http
POST /api/calculator/add
Content-Type: application/json

{
  "a": 5,
  "b": 3
}

Response: { "result": 8.0 }
```

#### 2. Subtraction
```http
POST /api/calculator/subtract
Content-Type: application/json

{
  "a": 10,
  "b": 3
}

Response: { "result": 7.0 }
```

#### 3. Multiplication
```http
POST /api/calculator/multiply
Content-Type: application/json

{
  "a": 5,
  "b": 3
}

Response: { "result": 15.0 }
```

#### 4. Division
```http
POST /api/calculator/divide
Content-Type: application/json

{
  "a": 10,
  "b": 2
}

Response: { "result": 5.0 }
```

#### 5. Factorial
```http
POST /api/calculator/factorial?n=5

Response: { "result": 120.0 }
```

#### 6. Generic Calculate (Using Operation Enum)
```http
POST /api/calculator/calculate
Content-Type: application/json

{
  "operation": "ADDITION",
  "a": 5,
  "b": 3
}

Response: { "result": 8.0 }
```

## Architecture & Design Patterns

### Layered Architecture

This project follows a **3-tier architecture** pattern:

```
┌─────────────────────────┐
│   Controller Layer      │  <- Handles HTTP requests/responses
│  (REST API Endpoints)   │
└───────────┬─────────────┘
            │
            ↓
┌─────────────────────────┐
│    Service Layer        │  <- Contains business logic
│  (Calculator Logic)     │
└─────────────────────────┘
```

### Component Breakdown

#### 1. **Operation.java** (Enum)
Defines the types of mathematical operations supported:
- `ADDITION (+)`
- `SUBTRACTION (-)`
- `MULTIPLICATION (*)`
- `DIVISION (/)`
- `FACTORIAL (!)`

#### 2. **CalculatorService.java** (Service Layer)
Contains the core business logic:
- Individual methods for each operation (`add()`, `subtract()`, etc.)
- Generic `calculate()` method that accepts an `Operation` enum
- Validation logic (e.g., divide by zero protection)

**Key annotation:** `@Service` - Marks this as a Spring-managed service bean

#### 3. **CalculatorController.java** (Controller Layer)
Exposes REST endpoints:
- Maps HTTP requests to service methods
- Handles request/response JSON conversion
- Returns appropriate HTTP status codes

**Key annotations:**
- `@RestController` - Combines `@Controller` and `@ResponseBody`
- `@RequestMapping` - Defines base path for all endpoints
- `@PostMapping` - Maps POST requests to handler methods
- `@RequestBody` - Converts JSON to Java objects
- `@Autowired` - Injects dependencies (CalculatorService)

#### 4. **DTOs (Data Transfer Objects)**
- **CalculationRequest.java** - Encapsulates input data
- **CalculationResponse.java** - Encapsulates output data

These provide a clean contract for API communication and separate external API structure from internal domain models.

## Testing

### Run All Tests
```bash
mvn test
```

### Test Coverage

#### Unit Tests (`CalculatorServiceTest.java`)
Tests the business logic in isolation:
- Addition with positive/negative numbers
- Subtraction edge cases
- Multiplication by zero
- Division by zero exception handling
- Factorial with boundary conditions

#### Integration Tests (`CalculatorControllerTest.java`)
Tests the API endpoints:
- HTTP request/response handling
- JSON serialization/deserialization
- Endpoint routing
- Error responses

**Testing frameworks used:**
- **JUnit 5** - Test execution
- **Mockito** - Mocking dependencies
- **MockMvc** - Simulating HTTP requests without server

## Testing the API

### Using cURL
```bash
# Addition
curl -X POST http://localhost:8080/api/calculator/add \
  -H "Content-Type: application/json" \
  -d '{"a": 5, "b": 3}'

# Factorial
curl -X POST http://localhost:8080/api/calculator/factorial?n=5
```

### Using Postman
1. Create a new POST request
2. URL: `http://localhost:8080/api/calculator/add`
3. Headers: `Content-Type: application/json`
4. Body (raw JSON):
   ```json
   {
     "a": 10,
     "b": 5
   }
   ```
5. Send and view response

### Using Browser Console (JavaScript)
```javascript
fetch('http://localhost:8080/api/calculator/add', {
  method: 'POST',
  headers: { 'Content-Type': 'application/json' },
  body: JSON.stringify({ a: 7, b: 3 })
})
.then(r => r.json())
.then(data => console.log(data));
```

## Key Concepts Learned

### 1. **Dependency Injection**
Spring automatically injects `CalculatorService` into `CalculatorController`:
```java
@Autowired
private CalculatorService calculatorService;
```

### 2. **RESTful Design**
- Uses appropriate HTTP methods (POST for operations)
- Returns JSON responses
- Follows REST conventions

### 3. **Separation of Concerns**
- Controller handles HTTP (not business logic)
- Service contains business logic (not HTTP concerns)
- DTOs separate API contract from domain models

### 4. **Error Handling**
- Arithmetic exceptions (divide by zero)
- Input validation
- Appropriate HTTP status codes

## Future Enhancements

This project is designed to be expanded with:

- [ ] **Database Integration** - Store calculation history with JPA/Hibernate
- [ ] **User Authentication** - Add Spring Security for user login
- [ ] **Advanced Operations** - Square root, power, trigonometric functions
- [ ] **Calculation History** - Retrieve past calculations
- [ ] **Exception Handling** - Global exception handler with `@ControllerAdvice`
- [ ] **API Documentation** - Add Swagger/OpenAPI documentation
- [ ] **Frontend Integration** - Build React/Angular UI
- [ ] **Caching** - Add Redis for frequently used calculations
- [ ] **Rate Limiting** - Prevent API abuse
- [ ] **Docker** - Containerize the application
- [ ] **CI/CD** - Automated testing and deployment pipeline
- [ ] **Microservices** - Split into multiple services with inter-service communication

## Known Limitations

- No persistent storage (calculations are not saved)
- Limited error messages
- No input validation beyond basic type checking
- No authentication or authorization
- No rate limiting
- Single-threaded operation handling

## Notes

This is a **learning project** and intentionally kept simple to understand core concepts. It's not production-ready but serves as a solid foundation for:
- Understanding Spring Boot fundamentals
- Learning REST API development
- Practicing TDD (Test-Driven Development)
- Exploring Spring ecosystem features

**This calculator API represents my first step in backend development and will be built upon as I learn more advanced concepts in Spring Boot, microservices architecture, and enterprise Java development.**

## Resources & References

- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
- [Testing the Web Layer](https://spring.io/guides/gs/testing-web/)
- [Spring Framework Reference](https://docs.spring.io/spring-framework/reference/)

## Author

**Kevin** - Aspiring Backend Developer

## License

This project is for educational purposes.

---

**Happy Coding!**

*This is just the beginning of my journey in building scalable, enterprise-grade applications.*
