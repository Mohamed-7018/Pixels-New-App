# Pixels App

![Pixels App Icon](https://user-images.githubusercontent.com/80456446/124113684-00392400-da6c-11eb-8779-cea0193eefb6.jpg)

**Pixels Egypt** mobile app is an essential platform designed to keep users connected and engaged with educational resources. The app is structured to provide courses, news, and knowledge sharing, making it easier for users to access a variety of learning materials.

## Features

- **Browse Courses**: Access courses, videos, and resources in different fields like Computer, Communication, Power, and Mechanical Engineering.
- **Stay Updated**: Follow the latest news and announcements.
- **Knowledge Sharing**: Join a community dedicated to spreading knowledge.

---

## Repository Structure

### Backend (Java Spring Boot)

```bash
├── controller      # Contains all RESTful endpoints and controllers
├── exceptions      # Exception handling logic for custom exceptions
├── repository      # Data access layer, responsible for interacting with the database
├── model           # Defines entity classes and data models
├── service         # Business logic and service layer
├── utils           # Utility classes and methods for common functions

### Mobile (Flutter)

The mobile app is built using Clean Code Architecture, ensuring separation of concerns between different layers:

Presentation Layer: Handles the UI and user interaction.
Domain Layer: Contains the business logic and interacts with the data layer.
Data Layer: Responsible for data handling (local and remote data source)

