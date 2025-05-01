# The Verdict - Backend API

## 📚 Overview
The Verdict is a Java Spring Boot-based backend system designed for a movie review platform. It demonstrates object-oriented design principles, secure JWT-based authentication, usage of multiple design patterns, PostgreSQL database integration, and a modular service-repository-controller architecture.

## ⚙️ Tech Stack
- Java 17
- Spring Boot 3.x
- Spring Security (JWT Authentication)
- PostgreSQL
- Maven
- Render.com (for deployment)

## 🏗️ Design Patterns Used
- **Factory Pattern** - Creating users based on roles (AdminUser, NormalUser)
- **Strategy Pattern** - Dynamic review sorting (by rating, by date)
- **Observer Pattern** - Notifying users of new reviews
- **Singleton Pattern** - Managing authentication and security configs

## 📁 Project Structure
```
the-verdict/
├── src/main/java/com/theverdict/
│   ├── config/ (JWT, Security)
│   ├── controller/ (Auth, User, Movie, Review APIs)
│   ├── model/ (User, Movie, Review entities)
│   ├── observer/ (Observer pattern classes)
│   ├── repository/ (UserRepository, MovieRepository, ReviewRepository)
│   ├── service/ (UserService, MovieService, ReviewService, Factory, Strategy)
│   └── util/ (optional utilities)
└── resources/
    └── application.properties
```

## 🚀 Main Features
- User Registration and Login (JWT Token Authentication)
- Add, View, Update, Delete Movies
- Add, View, Update, Delete Reviews
- Search Movies by Title
- Get Reviews by Movie or by User
- Role-based user system (AdminUser and NormalUser)

## 🛡️ Security
- JWT Tokens for authentication
- Secure password hashing (BCrypt)
- Stateless session management

## 🔗 API Endpoints (Examples)
- `POST /api/auth/register` - Register new user
- `POST /api/auth/login` - Authenticate user and receive JWT
- `POST /api/movies` - Create a new movie
- `GET /api/movies` - List all movies
- `PUT /api/movies/{id}` - Update a movie
- `DELETE /api/movies/{id}` - Delete a movie
- `POST /api/reviews` - Create a review
- `GET /api/reviews/movie/{movieId}` - Get reviews for a movie
- `GET /api/reviews/user/{userId}` - Get reviews by user

## 🗄️ Database (PostgreSQL)
- Tables: `users`, `movies`, `reviews`
- Relationships:
    - One User can write many Reviews
    - One Movie can have many Reviews

## 📝 How to Run Locally
1. Clone the repository
2. Configure `application.properties`
3. Run with Maven: `mvn spring-boot:run`
4. Use Postman to test endpoints

## 📄 License
This project is developed for academic purposes under open academic standards.

---

🎯 **Built with passion for SWE7302 Advanced Software Development (2024-25).**
