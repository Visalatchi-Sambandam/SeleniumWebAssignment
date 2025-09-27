## 📘 Project Overview

This repository showcases a comprehensive **Selenium WebDriver** automation framework designed for end-to-end testing of web applications. Developed using **Java**, the framework emphasizes modularity, scalability, and maintainability, making it suitable for both small-scale projects and enterprise-level applications.

## 🔧 Technologies & Tools

* **Programming Language**: Java
* **Automation Tool**: Selenium WebDriver
* **Testing Framework**: TestNG
* **Build Tool**: Maven
* **Browser Drivers**: ChromeDriver, GeckoDriver
* **CI/CD Integration**: Jenkins (optional)
* **Version Control**: Git

## 🛠️ Features

* **Cross-Browser Testing**: Supports Chrome and Firefox browsers.
* **Data-Driven Testing**: Integrates with Excel and CSV files for parameterized tests.
* **Page Object Model (POM)**: Implements POM design pattern for better code organization.
* **Parallel Test Execution**: Configured for parallel test execution to reduce test suite runtime.
* **Screenshots on Failure**: Captures screenshots upon test failure for better debugging.
* **Test Reports**: Generates detailed HTML reports using TestNG listeners.

## 📦 Installation & Setup

### Prerequisites

Ensure the following are installed:

* Java JDK 11 or higher
* Maven
* ChromeDriver / GeckoDriver (compatible with your browser version)

### Steps

1. Clone the repository: git clone https://github.com/Visalatchi-Sambandam/SeleniumWebAssignment.git
                         cd SeleniumWebAssignment

2. Install dependencies: mvn clean install

3. Run tests:  mvn test

4. For parallel test execution, modify the `testng.xml` suite file to specify the desired number of threads.

