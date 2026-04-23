# 🛒 Product Management API (Spring Boot + JPA + MySQL)

## 📌 Overview
A backend RESTful API built using Spring Boot to manage products with full CRUD operations.  
This project follows clean architecture principles and uses JPA for database interaction, DTOs for data transfer, and validation for robust input handling.

---

## 🚀 Features

- ➕ Add Product (POST)
- 📄 Get All Products (GET)
- 🔍 Get Product by ID (GET)
- ✏️ Update Product (PUT)
- ❌ Delete Product (DELETE)
- ⚠️ Global Exception Handling
- ✅ Input Validation (@NotBlank, @Positive)
- 🔄 DTO-based Architecture (separating API & Entity)
- 📦 Structured API Responses (ApiResponse)

---

## 🧠 Concepts Used

- Spring Boot
- REST APIs
- JPA (Hibernate)
- DTO (Data Transfer Object)
- Validation (@Valid, constraints)
- Exception Handling (@RestControllerAdvice)
- Layered Architecture (Controller → Service → Repository)
- ResponseEntity
- JSON Processing

---

## 🛠️ Tech Stack

- Java
- Spring Boot
- Spring Data JPA
- MySQL
- Maven
- Postman (API testing)

---

## 📂 Project Structure
com.trisha.productapp
├── controller
│ └── ProductController
├── service
│ └── ProductService
├── repository
│ └── ProductRepository
├── entity
│ └── Product
├── dto
│ └── ProductDTO
├── exception
│ └── GlobalExceptionHandler
├── response
│ └── ApiResponse
└── ProductAppApplication


---

## 🔗 API Endpoints

| Method | Endpoint            | Description              |
|--------|--------------------|--------------------------|
| POST   | /products          | Create a new product     |
| GET    | /products          | Get all products         |
| GET    | /products/{id}     | Get product by ID        |
| PUT    | /products/{id}     | Update product           |
| DELETE | /products/{id}     | Delete product           |

---

## 📥 Sample Request

### ➕ Add Product

```json
{
  "name": "Laptop",
  "price": 50000
}

## 📥 Sample Response
{
  "status": 201,
  "message": "Product created successfully",
  "data": {
    "id": 1,
    "name": "Laptop",
    "price": 50000
  },
  "timestamp": "2026-04-23T16:30:00"
}

⚙️ How to Run
1.Clone the repository:
    git clone https://github.com/your-username/product-management-system-java.git
2.Open in IntelliJ / any IDE
3.Configure MySQL in application.properties
4.Run:
   mvn spring-boot:run

#### 🎯 Learning Outcomes
Built a real-world backend application using Spring Boot
Implemented clean layered architecture
Used JPA for database persistence (no manual SQL)
Applied DTO pattern for secure and flexible API design
Added validation for reliable input handling
Designed structured and consistent API responses
Handled exceptions globally for better error management

🚀 Future Improvements
Add Swagger for API documentation
Implement pagination and filtering
Add authentication (Spring Security + JWT)
Deploy application (Render / AWS)


👩‍💻 Author

Trisha Kammati
