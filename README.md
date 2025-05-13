# Store Backend

The **store_backend** project is a backend application built with Spring Boot, integrated with Elasticsearch to manage product and user data.

## Table of Contents

- [Overview](#overview)
- [Technologies Used](#technologies-used)
- [Project Structure](#project-structure)
- [Setup and Run](#setup-and-run)
  - [Requirements](#requirements)
  - [Elasticsearch and Kibana Setup](#elasticsearch-and-kibana-setup)
  - [Spring Boot Configuration](#spring-boot-configuration)
  - [Build and Run](#build-and-run)
- [API Endpoints](#api-endpoints)
- [Models](#models)

## Overview

The **store_backend** project provides RESTful APIs for managing products and users, with Elasticsearch as the primary database.

## Technologies Used

- Spring Boot
- Spring Data Elasticsearch
- Apache Maven
- Elasticsearch
- Kibana
- Docker
- Java 17

## Project Structure

The project follows the standard Maven structure with the following main packages:

- `com.example.elasticsearch`: Contains the main Application class.
- `com.example.elasticsearch.controller`: Contains REST controllers for Product and User.
- `com.example.elasticsearch.model`: Contains model classes for Product and User.
- `com.example.elasticsearch.repository`: Contains Spring Data Elasticsearch repositories for Product and User.
- `com.example.elasticsearch.service`: Contains service classes for Product and User, handling business logic and repository interactions.

## Setup and Run

### Requirements

- Java Development Kit (JDK) 17
- Apache Maven
- Docker and Docker Compose

### Elasticsearch and Kibana Setup

The project uses Docker Compose to set up Elasticsearch and Kibana.

1. Navigate to the `Kafka/elasticsearch` directory in the project.
2. Run the following command to start Elasticsearch and Kibana:
   ```bash
   docker-compose up -d
   ```
   - Elasticsearch will run on `localhost:9200`.
   - Kibana will run on `localhost:5601`.

### Spring Boot Configuration

The `application.properties` file contains the configuration for the Spring Boot application and Elasticsearch connection. Ensure the configuration matches your Elasticsearch setup:

```properties
spring.application.name=elasticsearch
spring.elasticsearch.uris=localhost:9200
spring.elasticsearch.username=elastic
spring.elasticsearch.password=hieunt04lm
```

### Build and Run

1. Navigate to the root directory of the Elasticsearch module (`Elasticsearch/elasticsearch`).
2. Build the application using Maven:
   ```bash
   mvn clean package
   ```
3. Run the application:
   ```bash
   java -jar target/elasticsearch-0.0.1-SNAPSHOT.jar
   ```
   _(Note: The JAR file name may vary depending on the project version.)_

## API Endpoints

### Products (`/api/products`)

- **POST** `/products/create`: Create a new product.
- **GET** `/products/getAll`: Retrieve all products.
- **GET** `/products/{id}`: Retrieve a product by ID.
- **GET** `/products/search?name={name}`: Search for products by name.
- **DELETE** `/products/delete/{id}`: Delete a product by ID.

### Users (`/api/users`)

- **POST** `/users/create`: Create a new user.
- **GET** `/users/getAll`: Retrieve all users.
- **GET** `/users/{id}`: Retrieve a user by ID.
- **GET** `/users/search?name={name}`: Search for users by name.
- **DELETE** `/users/delete/{id}`: Delete a user by ID.

## Models

### Product

- `id` (Long)
- `name` (String)

### User

- `id` (Long)
- `name` (String)
- `dob` (String)
- `role` (String)
