# HomeBanking Lite

A personal banking web application developed with Java and Spring Boot.

HomeBanking Lite is a web-based application that simulates a personal banking environment, allowing users to securely log in, view their bank accounts, check their balances, and consult their transaction history.

[🇮🇹 Read the Italian version](README.it.md)

## Features

- Secure login with username and password.
- Personal dashboard displaying customer information and total balance.
- Bank account overview with individual account balances and IBANs.
- Recent transactions displayed on the dashboard.
- Complete transaction history.
- Transaction filtering by bank account.
- Secure logout.

## Technologies Used

- Java 21
- Spring Boot
- Spring Security
- Spring Data JPA
- Hibernate
- MySQL
- Thymeleaf
- HTML5
- CSS3
- Maven

## Architecture

The application follows a layered architecture to separate responsibilities:

- **Controller:** handles HTTP requests and manages application navigation.
- **Service:** contains the application logic.
- **Repository:** manages data access through Spring Data JPA.
- **Model:** represents the application's data entities.
- **View:** displays the user interface using Thymeleaf templates.

## Security

- Authentication managed by Spring Security.
- Passwords stored as BCrypt hashes.
- Local database credentials kept outside the public repository.

## Database Configuration

The application uses MySQL as its relational database.

To configure the local database:

1. Create a MySQL database named `homebanking_lite`.
2. Configure the connection properties in `application-local.properties`.
3. Use the provided `application-local.example.properties` file as a configuration template.

The local configuration file is excluded from Git to prevent database credentials from being published.

## Running the Application

### Prerequisites

- Java 21
- MySQL
- Maven (or the included Maven Wrapper)

### Steps

1. Clone the repository:

   ```bash
   git clone https://github.com/DavideMantuano/homebanking-lite.git
2. Open the project in your preferred Java IDE.
3. Create and configure the local database.
4. Configure application-local.properties.
5. Run the Spring Boot application.
6. Open your browser and navigate to:   http://localhost:8080

##Project Status
This project was developed as a personal portfolio project to practice Java backend development and the Spring ecosystem.

It simulates a personal banking environment using fictional customer and transaction data. It is not connected to real banking services.

## Author

**Davide Mantuano**

- GitHub: [DavideMantuano](https://github.com/DavideMantuano)

