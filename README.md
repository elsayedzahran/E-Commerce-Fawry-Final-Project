# E-Commerce System - Fawry Final Project

## 📜 Overview

This **E-Commerce System** is a microservices-based project that simulates a complete online shopping platform. It includes core functionalities like order management, notifications, cart operations, coupon validation, and service discovery for seamless interaction between components.

---

## ✨ Features

### Microservices
- **Order API**:  
  Handles the creation, update, and management of customer orders.
  
- **Notification API**:  
  Sends real-time notifications for order updates and shipping details.

- **Cart Items Service**:  
  Manages items added to the shopping cart, including quantity updates and cart clearing.

- **Store Service**:  
  Handles product listing and inventory updates.

- **Coupon Service**:  
  Validates and applies discount codes during checkout.

- **User Service**:  
  Manages user profiles, authentication, and preferences.

- **Discovery Service**:  
  Facilitates service registration and discovery for microservices communication.

- **Gateway Service**:  
  Acts as a single entry point for all microservice APIs, ensuring security and load balancing.

---

## 🛠️ Installation

1. **Clone the repository**:
   ```bash
   git clone https://github.com/elsayedzahran/E-Commerce-Fawry-Final-Project.git


## 🚀 Usage

1. **Start all services**, ensuring that the Discovery Service and Gateway Service are active.
   - The Gateway Service will provide the routing for API requests, and the Discovery Service ensures that the microservices can register and discover each other.

2. **Access the system via the gateway endpoints**:
   - **Order API**: `/api/orders` - Use this endpoint to place, update, and retrieve orders.
   - **Notification API**: `/api/notifications` - Access this API to send and receive notifications for order updates.
   - **Cart Items Service**: `/api/cart` - Add, remove, or update items in the shopping cart.
   - **Store Service**: `/api/store` - Retrieve product listings and manage product data.
   - **Coupon Service**: `/api/coupons` - Apply and validate discount codes.
   - **User Service**: `/api/users` - Manage user profiles, authentication, and preferences.

3. **Interact with the APIs** using tools like Postman, a frontend application, or any HTTP client that supports RESTful API calls.
   - You can perform POST, GET, PUT, DELETE operations as needed.

## 📦 Technologies

- **Backend**: 
  - **Java**: The core backend language for the microservices.
  - **Spring Boot**: A framework to simplify Java-based application development.
  
- **Microservices Framework**:
  - **Spring Cloud**: A framework for building distributed systems and microservices architectures.
  
- **Database**:
  - **MySQL**: Used to store and manage data for each service (such as user data, order details, and product inventory).

- **Tools**:
  - **Service Discovery**: **Eureka** (Spring Cloud) for service registration and discovery.
  - **API Gateway**: **Spring Gateway** serves as the entry point for all API requests, managing routing and security.
  - **Build Tool**: **Maven** to manage project dependencies and build lifecycle.
  - **API Testing**: **Postman** for testing the APIs in the development and staging environments.
  
- **Version Control**: 
  - **Git** for source code management, collaboration, and version tracking.
 
## 👥 Contributors

- **Elsayed Zahran**: Lead developer responsible for the **Order API** and **Notification API**.  


## 📞 Contact

For questions or support, you can reach out to:
- **Elsayed Zahran**: [elsayedzahran789@g,ail.com](mailto:your-email@example.com)
- Or connect with me via [GitHub](https://github.com/elsayedzahran).

