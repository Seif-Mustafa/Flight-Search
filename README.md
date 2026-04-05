# Flight Search - Spring Modulith Example

This project is a Spring Boot 3.x application that demonstrates the implementation of a modular monolith architecture using **Spring Modulith**. The core functionality revolves around providing flight search capabilities by integrating with the **Amadeus Java SDK**, while strictly adhering to module encapsulation.

## Overview

The application is structured into clearly defined modules to maintain loose coupling and high cohesion:

- **`search`**: Responsible for handling incoming flight search requests via REST endpoints.
- **`integration.amadeus`**: Encapsulates the configuration and communication with the external Amadeus API.

Crucially, the `search` module only interacts with the public, exposed interface of the `integration.amadeus` module, ensuring architectural integrity.

## Features

- **Modular Architecture**: Built with Spring Modulith to enforce module boundaries and verify architectural rules.
- **Flight Searching**: Exposes REST endpoints to query for available flights.
- **Amadeus Integration**: Seamlessly integrates with the Amadeus flight search APIs using the `amadeus-java` SDK.
- **Architectural Testing**: Includes Spring Modulith tests to automatically verify that there are no invalid dependencies between modules.

## Technologies Used

- Java 17
- Spring Boot 3.2.x
- Spring Modulith 1.1.x
- Amadeus Java SDK
- Maven
- Lombok

## Getting Started

### Prerequisites

To run this application, you need:
- Java 17 or higher
- Maven
- An Amadeus Developer Account (to obtain API credentials)

### Configuration

Before running the application, you need to configure your Amadeus API credentials. You can typically add these to your `application.properties` or `application.yml` file (depending on your configuration setup) or pass them as environment variables:

```properties
amadeus.api.key=YOUR_API_KEY
amadeus.api.secret=YOUR_API_SECRET
```
*(Note: Update the property names if they differ in your implementation, and replace the values with your actual credentials)*

### Running the Application

You can run the application using Maven:

```bash
mvn spring-boot:run
```

### Running Tests

To verify the underlying module structure using Spring Modulith's test capabilities, run:

```bash
mvn test
```
