# Supermarket Management System

## Overview

The Supermarket Management System is a Java-based application designed to manage the operations of a supermarket. It includes features such as database connectivity, logging, and a modular structure.

## Project Structure

```
Supermarket Management System/
├── src/
│   ├── com/
│   │   └── supermarket/
│   │       └── management/
│   │           ├── Main.java
│   │           ├── LoggerConfig.java
│   │           └── DatabaseConnection.java
│   └── module-info.java
├── logs/
│   └── application.log
├── log4j.properties
└── .classpath
```

## Prerequisites

- Java SE 17
- MySQL
- Log4j 1.2.17

## Setup

1. **Clone the repository:**
    ```sh
    git clone https://github.com/yourusername/supermarket-management-system.git
    cd supermarket-management-system
    ```

2. **Configure the database:**
    - Ensure MySQL is installed and running.
    - Create a database named `supermarket`.
    - Update the `DatabaseConnection.java` file with your MySQL username and password.

3. **Add dependencies:**
    - Download the MySQL Connector/J and Log4j libraries and place them in the specified paths:
        - `C:/Users/koceila/Downloads/mysql-connector-java-8.0.28.jar`
        - `C:/Users/koceila/Downloads/log4j-1.2.17.jar`

4. **Configure Log4j:**
    - Ensure the `log4j.properties` file is correctly set up.

## Running the Application

1. **Compile the project:**
    ```sh
    javac -d bin -sourcepath src src/module-info.java src/com/supermarket/management/*.java
    ```

2. **Run the application:**
    ```sh
    java -p bin -m com.supermarket.management/com.supermarket.management.Main
    ```

## Adding the Project to GitHub

1. **Initialize a Git repository:**
    ```sh
    cd /d:/My\ stuff/Projects/Supermarket\ Management\ System
    git init
    ```

2. **Add all files to the repository:**
    ```sh
    git add .
    ```

3. **Commit the files:**
    ```sh
    git commit -m "Initial commit"
    ```

4. **Create a new repository on GitHub:**
    - Go to [GitHub](https://github.com) and log in.
    - Click on the "+" icon in the top right corner and select "New repository".
    - Name your repository (e.g., `supermarket-management-system`).
    - Click "Create repository".

5. **Add the remote repository:**
    ```sh
    git remote add origin https://github.com/yourusername/supermarket-management-system.git
    ```

6. **Push the files to GitHub:**
    ```sh
    git push -u origin master
    ```

Replace `yourusername` with your actual GitHub username.

## Files

### `src/module-info.java`

Defines the module and its dependencies.

```java
// filepath: /d:/My stuff/Projects/Supermarket Management System/src/module-info.java
module com.supermarket.management {
    requires java.sql;
    requires log4j;
}
```

### `src/com/supermarket/management/Main.java`

The main class to start the application.

```java
// filepath: /d:/My stuff/Projects/Supermarket Management System/src/Main.java
package com.supermarket.management;

public class Main {
    
    public static void main(String[] args) {
        // Initialize the application
        // ...existing code...
    }
}
```

### `src/com/supermarket/management/LoggerConfig.java`

Configures the logger.

```java
// filepath: /d:/My stuff/Projects/Supermarket Management System/src/LoggerConfig.java
package com.supermarket.management;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LoggerConfig {
    static {
        PropertyConfigurator.configure("log4j.properties");
    }

    public static Logger getLogger(Class<?> clazz) {
        return Logger.getLogger(clazz);
    }
}
```

### `src/com/supermarket/management/DatabaseConnection.java`

Manages the database connection.

```java
// filepath: /d:/My stuff/Projects/Supermarket Management System/src/DatabaseConnection.java
package com.supermarket.management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/supermarket";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
```

### `log4j.properties`

Configures Log4j.

```java-properties
// filepath: /d:/My stuff/Projects/Supermarket Management System/log4j.properties
log4j.rootLogger=DEBUG, stdout, file

log4j.appender.stdout=org.apache.log4j.ConsoleAppender
log4j.appender.stdout.Target=System.out
log4j.appender.stdout.layout=org.apache.log4j.PatternLayout
log4j.appender.stdout.layout.ConversionPattern=%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m%n

log4j.appender.file=org.apache.log4j.RollingFileAppender
log4j.appender.file.File=logs/application.log
log4j.appender.file.MaxFileSize=5MB
log4j.appender.file.MaxBackupIndex=10
log4j.appender.file.layout=org.apache.log4j.PatternLayout
log4j.appender.file.layout.ConversionPattern=%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m%n
```

### `.classpath`

Defines the classpath for the project.

```xml
<!-- filepath: /D:/My stuff/Projects/Supermarket Management System/.classpath -->
<?xml version="1.0" encoding="UTF-8"?>
<classpath>
    <classpathentry kind="con" path="org.eclipse.jdt.launching.JRE_CONTAINER/org.eclipse.jdt.internal.debug.ui.launcher.StandardVMType/JavaSE-17">
        <attributes>
            <attribute name="module" value="true"/>
        </attributes>
    </classpathentry>
    <classpathentry kind="src" path="src"/>
    <classpathentry kind="lib" path="C:/Users/koceila/Downloads/mysql-connector-java-8.0.28.jar"/>
    <classpathentry kind="lib" path="C:/Users/koceila/Downloads/log4j-1.2.17.jar"/>
    <classpathentry kind="output" path="bin"/>
</classpath>
```
`
