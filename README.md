# Bon-Bonite Automation Framework

Professional QA automation framework for the Bon-Bonite e-commerce website, built as a technical challenge for QVision.

## Objective

This project implements a robust, maintainable, and scalable test automation framework using industry best practices and modern technologies. The framework follows the Screenplay Pattern and integrates Cucumber for behavior-driven testing.

## Technologies Used

- **Java 21+** - Programming language
- **Gradle** - Build automation tool
- **Serenity BDD 4.2.0** - Testing framework with Screenplay Pattern
- **Cucumber 7.18.0** - Behavior-Driven Development (BDD)
- **JUnit 5** - Test execution framework
- **Selenium WebDriver 4.23.1** - Browser automation
- **Google Chrome** - Target browser
- **WebDriverManager 5.8.0** - WebDriver management
- **AssertJ** - Fluent assertions

## Architecture

The framework follows the **Screenplay Pattern** as the primary design pattern, which promotes:

- **Actors** - Represent users performing actions in the system
- **Abilities** - Capabilities that actors possess (e.g., BrowseTheWeb)
- **Tasks** - High-level business actions performed by actors
- **Interactions** - Low-level UI interactions
- **Questions** - Queries to verify system state

### Cucumber Integration

Cucumber provides the behavior layer:
- **Feature files** - Define test scenarios in Gherkin language
- **Step Definitions** - Connect Gherkin steps to Screenplay implementation
- **Tags** - Organize and filter test scenarios

## Project Structure

```
src
└── test
    ├── java
    │   └── com.qvision.bonbonite
    │       ├── runners              # JUnit 5 test runners
    │       ├── stepdefinitions      # Cucumber step definitions
    │       ├── tasks                # Screenplay tasks
    │       ├── interactions         # Screenplay interactions
    │       ├── questions            # Screenplay questions
    │       ├── ui                   # Page objects (UI locators)
    │       ├── models               # Data models
    │       ├── abilities            # Custom abilities
    │       └── utils                # Utility classes
    └── resources
        ├── features
        │   └── smoke                # Feature files by category
        ├── serenity.conf            # Serenity configuration
        └── logback-test.xml         # Logging configuration
```

## Requirements

- Java 21 or higher
- Google Chrome browser
- Gradle (included via wrapper)

## Installation and Configuration

1. Clone the repository
2. Navigate to the project directory
3. The project uses the Gradle wrapper, no additional installation needed

## Running Tests

### Run all tests
```bash
./gradlew clean test
```

On Windows:
```bash
gradlew.bat clean test
```

### Run only smoke tests
```bash
./gradlew clean test --tests SmokeTestRunner
```

On Windows:
```bash
gradlew.bat clean test --tests SmokeTestRunner
```

## Serenity Report Location

After test execution, the Serenity BDD report is generated at:

```
build/serenity/index.html
```

Open this file in a browser to view the detailed test report with screenshots and execution logs.

## Example Feature (Gherkin)

```gherkin
@smoke
Feature: Smoke test Bon-Bonite

  Scenario: Validate that the Bon-Bonite home page loads correctly
    Given that the user is on the Bon-Bonite home page
    Then the user should see the home page loaded correctly
```

## Screenplay and Cucumber Integration

The framework integrates Cucumber with Screenplay Pattern as follows:

1. **Cucumber Feature** - Defines the behavior in business language
2. **Step Definitions** - Translate Gherkin steps into Screenplay actions
3. **Screenplay Tasks** - Implement business logic using actors
4. **Screenplay Questions** - Verify system state using actors
5. **UI Page Objects** - Define web element locators

This separation ensures:
- Test scenarios remain readable and maintainable
- Business logic is reusable across different scenarios
- UI changes are isolated to page objects
- Test code follows SOLID principles

## Future Scenarios

The framework is designed to support the following functional scenarios (to be implemented):

1. User registration
2. User data modification
3. Product purchase flow

## Best Practices Applied

- **SOLID principles** where applicable
- **Separation of concerns** - UI, business logic, and test definitions are separated
- **Screenplay Pattern** - Actor-based design for better test reusability
- **DRY (Don't Repeat Yourself)** - Reusable tasks and questions
- **Clean code** - Descriptive naming and clear structure
- **No Thread.sleep()** - Uses Serenity's built-in wait mechanisms
- **Robust selectors** - Prefers id, name, data-testid over fragile XPaths
- **Centralized configuration** - All settings in serenity.conf
