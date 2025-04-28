🏦 Banking Spring Boot Application
-----------------------------------
This is a microservices-based banking application built with Spring Boot, using Eureka Server for service discovery, Docker for containerization, and Spring Security (optional).
It follows a clean architecture with user-service and account-service microservices.

🛠 Tech Stack
-------------
```
Java 21

Spring Boot 3.0+

Spring Cloud Netflix Eureka Server

Maven

Docker

GitHub
```

🏗 Project Structure
---------------------
```
Banking-Spring-Boot-Application/
│
├── eureka-server/           # Eureka service registry
│
├── user-service/            # Microservice to manage Users
│
├── account-service/         # Microservice to manage Accounts
│
└── README.md                 # You're reading it now 😄
```

📚 Description of Services
---------------------------
✅ Eureka Server

--> Acts as a service discovery server.

--> All microservices (user-service, account-service) will register themselves here.

✅ User Service

--> CRUD operations for users.

--> Registers itself with Eureka server.

✅ Account Service

--> CRUD operations for bank accounts.

--> Also registers itself with Eureka service

🚀 How to Run
--------------
1. Clone the repository:
```
git clone https://github.com/sagarsinha11/Banking-Spring-Boot-Application.git
cd Banking-Spring-Boot-Application
```

2. Build and run locally using Maven
   
   Build all services:
```
cd eureka-server
mvn clean package
cd ../user-service
mvn clean package
cd ../account-service
mvn clean package
```
   Run Eureka server:
```
cd ../eureka-server
mvn spring-boot:run
```
   Run User service:
```
cd ../user-service
mvn spring-boot:run
```
   Run Account service:
```
cd ../account-service
mvn spring-boot:run
```

3. Build and run using Docker
   
Build docker images:
```
docker build -t sagarsinha11/eureka-server:v1 ./eureka-server
docker build -t sagarsinha11/user-service:v1 ./user-service
docker build -t sagarsinha11/account-service:v1 ./account-service
```

Push images to Docker Hub:
```
docker push sagarsinha11/eureka-server:v1
docker push sagarsinha11/user-service:v1
docker push sagarsinha11/account-service:v1
```

Run containers:
```
docker run -p 8761:8761 sagarsinha11/eureka-server:v1
docker run -p 8081:8081 sagarsinha11/user-service:v1
docker run -p 8082:8082 sagarsinha11/account-service:v1
```

## 📜 API Endpoints

These will be accessible after running the services.

### 🧑‍💼 User Service APIs

| Method | Endpoint      | Description       |
|--------|---------------|-------------------|
| GET    | `/users`       | Get all users      |
| POST   | `/users`       | Create new user    |
| GET    | `/users/{id}`  | Get user by ID     |

### 🏦 Account Service APIs

| Method | Endpoint        | Description         |
|--------|-----------------|---------------------|
| GET    | `/accounts`      | Get all accounts     |
| POST   | `/accounts`      | Create new account   |
| GET    | `/accounts/{id}` | Get account by ID    |


## 🌐 Eureka Dashboard

Visit: [http://localhost:8761](http://localhost:8761)

You will see `user-service` and `account-service` registered.

---

## 👨‍💻 Author

**GitHub**: [Sagar Sinha](https://github.com/sagarsinha11)

---

## 📋 License

This project is licensed under the **MIT License**.

---

## 🚀 Happy Coding!
