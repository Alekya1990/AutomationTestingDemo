# Selenium Automation Testing Demo

This project is a Java-based automation testing suite using **Selenium WebDriver** to demonstrate various web interaction techniques on the [Test Automation Practice](https://testautomationpractice.blogspot.com/) website.

## Features

The automation script covers a wide range of web elements and scenarios:
- **Form Filling**: Input fields, text areas, and radio buttons.
- **Dropdowns**: Selection by visible text.
- **Alert Handling**: Simple alerts, confirmation boxes, and prompt boxes.
- **Checkboxes**: Batch selection and deselection.
- **Scrolling**: Using `JavaScriptExecutor` for window and element-specific scrolling.
- **Mouse Actions**: Hover effects and element interactions using the `Actions` class.
- **Keyboard Actions**: Text manipulation and copying.
- **Advanced Interactions**: Drag and drop, SVG element handling.
- **Screenshots**: Capturing the state of the web page.

## Prerequisites

- **Java JDK**: 1.7 or higher (configured for 1.7 in `pom.xml`).
- **Maven**: For dependency management and execution.
- **Google Chrome**: The script uses `ChromeDriver`.

## Dependencies

Key libraries used in this project:
- **Selenium Java**: Core automation framework.
- **WebDriverManager**: Automatic management of browser drivers.
- **MySQL Connector**: For database-related testing capabilities.
- **JUnit**: For unit testing support.

## How to Run

1. **Clone the repository** (if applicable).
2. **Navigate to the project root**:
   ```cmd
   cd /d "d:\DatabaseTesting\demo"
   ```
3. **Compile and Execute**:
   ```cmd
   mvn compile exec:java -Dexec.mainClass="src.com.example.AutomationTestingDemo"
   ```

## Project Structure

- `src/main/java/com/example/AutomationTestingDemo.java`: Main automation script.
- `pom.xml`: Maven configuration and dependencies.
