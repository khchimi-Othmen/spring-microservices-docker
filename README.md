# Spring Microservices Docker Project


A Spring Boot microservices application built with Spring Boot, JDK 17, Docker, and other popular open-source technologies. This project aims to simplify the deployment and management of microservices using containerization and modern DevOps practices.
![azerty drawio (1)](https://github.com/khchimi-Othmen/spring-microservices-docker/assets/80161433/d5639fc4-64ca-49a9-bd46-c7924bf6fa48)

## Features

- **Config Server**: Centralized configuration management to ensure consistency across microservices.
- **Eureka Discovery Server**: Service registration and discovery for dynamic and resilient communication between microservices.
- **Gateway**: API Gateway for routing, load balancing, and security across the microservices ecosystem.
- **Zipkin**: Distributed tracing system to monitor and troubleshoot microservices interactions.
- **RabbitMQ**: Messaging broker for efficient and reliable communication between microservices.
- **Docker Support**: Simplified deployment using Docker containers and a robust CI/CD pipeline.

## CI/CD Pipeline

We have implemented a robust CI/CD pipeline to automate the build and deployment of our microservices. Here's an overview of our CI/CD process:

- **Build**: On every push to the `main` branch, our CI workflow builds the application, runs unit tests, and packages it into a Docker image.

- **Docker Image**: The Docker image is tagged and pushed to our Docker registry for easy deployment.

- **Deployment**: We use [Deployment Tool/Platform] to manage our containers in production. Our deployment process is fully automated, ensuring consistent and reliable releases.

- **Testing**: Our CI/CD pipeline includes comprehensive testing to maintain code quality and prevent regressions.

- **Monitoring**: We have set up monitoring and alerting to ensure the health and performance of our microservices in production.

## Contributing

We welcome contributions to make the Spring Microservices Docker Project even better! If you find any issues, have suggestions, or want to contribute in any way, please open an issue or submit a pull request. We value your input and collaboration.

## License

This project is licensed under the [MIT License](LICENSE). Feel free to use, modify, and distribute it according to the terms of the license.

---

*Note: Replace `[Deployment Tool/Platform]` with the actual deployment tool/platform you use.*
