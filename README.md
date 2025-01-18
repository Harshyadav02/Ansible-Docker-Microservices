#  Microservices Project

A  platform built with Spring Boot microservices architecture, enabling scalable and maintainable online ping functionality.

## Project Overview

This project implements a microservices-based  system with the following core services:
- Product Service: Manages product catalog and inventory
- Order Service: Handles order processing and management
- User Service: Manages user accounts and authentication
- Gateway Service: API Gateway for routing and load balancing
- Config Server: Centralized configuration management
- Service Registry: Service discovery using Eureka

## Architecture

The application follows a microservices architecture pattern with:
- Spring Cloud for service discovery and configuration
- API Gateway for request routing
- Inter-service communication through Feign client
- Containerization using Docker
- Infrastructure as code using Ansible

## Services Description

### Config Server
- Centralized configuration management for all microservices
- Enables dynamic configuration updates
- Located in `/configserver`

### Service Registry (Eureka Server)
- Service discovery and registration
- Health monitoring
- Located in `/serviceregistry`

### API Gateway
- Single entry point for all client requests
- Request routing to appropriate services
- Load balancing
- Located in `/gatway`

### Product Service
- Product catalog management
- Inventory tracking
- REST API for product operations
- Located in `/productservice`

### Order Service
- Order processing and management
- Integration with Product Service
- Order status tracking
- Located in `/orderservice`

### User Service
- User account management
- Authentication and authorization
- User profile operations
- Located in `/userservice`

## Technology Stack

- **Framework**: Spring Boot
- **Service Discovery**: Netflix Eureka
- **Configuration**: Spring Cloud Config
- **API Gateway**: Spring Cloud Gateway
- **Database**: JPA/Hibernate (specific database configurable)
- **Build Tool**: Maven
- **Containerization**: Docker
- **Infrastructure**: Ansible

## Project Structure

```
.
├── ansible_microservice_setup.yml    # Ansible playbook for deployment
├── docker-compose.yml                # Docker composition for all services
├── configserver                      # Centralized configuration service
├── serviceregistry                   # Eureka service registry
├── gatway                           # API Gateway service
├── productservice                   # Product management service
├── orderservice                     # Order management service
└── userservice                      # User management service
```

## Setup and Installation

1. **Prerequisites**
   - JDK 11 or later
   - Maven
   - Docker and Docker Compose
   - Ansible (for deployment)

2. **Build Services**
   ```bash
   # Build each service
   cd configserver && ./mvnw clean package
   cd ../serviceregistry && ./mvnw clean package
   cd ../gatway && ./mvnw clean package
   cd ../productservice && ./mvnw clean package
   cd ../orderservice && ./mvnw clean package
   cd ../userservice && ./mvnw clean package
   ```

3. **Run with Docker Compose**
   ```bash
   docker-compose up -d
   ```

4. **Deploy with Ansible**
   ```bash
   ansible-playbook ansible_microservice_setup.yml
   ```

## Service Dependencies

- Order Service depends on Product Service for product information
- All services depend on Config Server for configuration
- All services register with Service Registry
- All external requests go through the API Gateway

## Contributing

Feel free to fork the repository and submit a pull request with your changes. For major updates, please open an issue to discuss before implementing.
