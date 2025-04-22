# 📝 API Documentation & Features Guide

## ⚙️ Actuator
Access Spring Boot Actuator Monitoring endpoints:  
🔗 [http://localhost:8080/actuator](http://localhost:8080/actuator)

---

## 💾 H2 Database Console
Access the in-memory H2 database console:  
🔗 [http://localhost:8080/h2-console](http://localhost:8080/h2-console)

---

## 📚 Swagger/OpenAPI Documentation
**UI Interface:**  
🔗 [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

**Raw API Docs (JSON):**  
🔗 [http://localhost:8080/v3/api-docs](http://localhost:8080/v3/api-docs)

---

## ❗ Exception Handling
- @ControllerAdvice is used to mark the class as a REST controller advice
- @ExceptionHandler is used to handle exceptions globally inside the application
```java
@ControllerAdvice  // Global exception handler
public class GlobalExceptionHandler {
  
  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorResponse> handleException(Exception ex) {
    // Custom logic
  }
}
```

---

## ✅ Validation
- Annotate the class with @Validated (at controller level).
- Annotate the request body with @Valid (for field validation).
```java
@RestController
@Validated
public class AccountController {

  @PostMapping("/accounts")
  public Account createAccount(@Valid @RequestBody AccountRequest request) {
  // ...
  }
}
```

---

## 📅 Auditing (Auto-track Create/Modify Timestamps)
Required setup:
1. AuditAwareImpl.java
```java
@Component
public class AuditAwareImpl implements AuditorAware<String> {
  @Override
  public Optional<String> getCurrentAuditor() {
  return Optional.of("SYSTEM"); // Or fetch logged-in user
  }
}
```
2. BaseEntity.java
```java
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {
  @CreatedDate
  private LocalDateTime createdAt;

  @CreatedBy
  private String createdBy;
  
  @LastModifiedDate
  private LocalDateTime updatedAt;

  @LastModifiedBy
  rivate String updatedBy;
}
```
3. Enable in main application
```java
@SpringBootApplication
@EnableJpaAuditing
public class AccountsApplication { ... }
```

---

## 📜 OpenAPI/Swagger Annotations
| Annotation          | Usage Example                          | Purpose                          |
|---------------------|---------------------------------------|----------------------------------|
| `@OpenAPIDefinition`| On main class                         | Global API metadata (title, version) |
| `@Tag`              | `@Tag(name = "Account API")`          | Groups related endpoints         |
| `@Operation`        | `@Operation(summary = "Create account")` | Describes an endpoint           |
| `@ApiResponses`     | `@ApiResponse(responseCode = "400")`   | Documents error responses       |
| `@Schema`           | `@Schema(description = "User email")`  | Describes model fields          |
