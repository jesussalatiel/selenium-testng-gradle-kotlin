# Selenium-TestNG-Gradle-Kotlin

Selenium-TestNG-Gradle-Kotlin provides robust web UI test automation. It uses Selenium WebDriver for browser interaction, TestNG for structured and parallel testing, and Gradle for build automation, all developed in concise and type-safe Kotlin for easy integration into CI.

## Features

- **Browser Automation:** Interacts with web browsers using Selenium WebDriver.
- **Structured Testing:** Organizes tests with TestNG with support for parameterization and parallel execution.
- **Build and Dependency Management:** Automates builds and manages dependencies with Gradle.
- **Kotlin:** Enjoys concise syntax and greater type safety.
- **CI/CD Ready:** Easily integrates with continuous integration pipelines.

## Prerequisites

- Java JDK (recommended 21 or higher)
- Gradle (or use the Gradle Wrapper: `./gradlew`)
- Compatible browser and driver (e.g., Chrome and ChromeDriver)
- Basic knowledge of Kotlin

## Getting Started

1. **Clone the Repository:**

   ```bash
   git clone <repository-url>
   cd selenium-testng-gradle-kotlin
   ```

2. **Run in headless mode**

   ```bash
   ./gradlew clean test -Dheadless=true
   ```

3. **Prettier and Code Linter**
   ```bash
   ./gradlew :app:spotlessApply
   ```

## 🧪 Design and Best Practices Applied in Testing

This project applies several modern automation techniques and testing architecture:

- ✅ **Separation of concerns**: Classes like `EnvironmentBuilder` handle environment configuration, while `LoginBuilder` encapsulates authentication flows.
- 🧱 **Centralized constants**: The base URL is stored in a dedicated class (e.g., `PracticePages`), facilitating changes between environments (dev, staging, prod).
- ♻️ **Reusable logic**: An Indirect Page pattern is used through builder classes, reducing code duplication in test cases.
- 🧪 **Atomic and independent tests**: Each test runs in isolation, allowing for safe parallel execution without shared state.
- 🧵 **Support for parallel testing**: Using `ThreadLocal` and TestNG's `@Parameters`, tests can run simultaneously on different browser instances.
- 📖 **Clear and expressive assertions**: Assertions include descriptive messages, improving readability and debugging when a test fails.

These practices ensure that tests are **scalable, maintainable, and fast**, making them ideal for modern CI/CD pipelines.
