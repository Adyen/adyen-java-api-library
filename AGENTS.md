## Overview

This is the Adyen Java API Library, providing Java developers with an easy way to interact with the Adyen API. The library is a wrapper around the Adyen API, generated from OpenAPI specifications.

## Code Generation

A significant portion of this library, particularly the API services and data models, is automatically generated

- **Engine**: We use [OpenAPI Generator](https://openapi-generator.tech/) with custom [Mustache](https://mustache.github.io/) templates to convert Adyen's OpenAPI specifications into Java code.
- **Templates**: The custom templates are located in the `/templates` directory. These templates are tailored to fit our custom HTTP client and model structure.
- **Automation**:
    - **Centralized**: The primary generation process is managed in a separate repository, [`adyen-sdk-automation`](https://github.com/Adyen/adyen-sdk-automation). Changes to the OpenAPI specs trigger a GitHub workflow in that repository, which generates the code and opens Pull Requests in this library.
    - **Local**: For development and testing, you must use the [`adyen-sdk-automation`](https://github.com/Adyen/adyen-sdk-automation) repository.

### Local Code Generation

To test new features or changes to the templates, you must run the generation process from a local clone of the `adyen-sdk-automation` repository.

1.  **Clone the automation repository**:
    ```bash
    git clone https://github.com/Adyen/adyen-sdk-automation.git
    ```

2.  **Link this library**: The automation project needs to target your local clone of `adyen-java-api-library`. From inside the `adyen-sdk-automation` directory, run the following commands. This will replace the `java/repo` directory with a symlink to your local project.
    ```bash
    rm -rf java/repo
    ln -s /path/to/your/adyen-java-api-library java/repo
    ```

3.  **Run the generator**: You can now run the Gradle commands to generate code.
    - **To generate all services for the Java library**:
      ```bash
      ./gradlew :java:services
      ```
    - **To generate a single service (e.g., Checkout)**:
      ```bash
      ./gradlew :java:checkout
      ```
    - **To clean the repository before generating**:
      ```bash
      ./gradlew :java:cleanRepo :java:checkout
      ```

## Core Components

- **`Client.java`**: The central class for configuring the library (API key, environment, etc.) and accessing API services.
- **`Service.java`**: The base class for all API services, containing the generic HTTP client logic.
- **`/service`**: This package contains the generated service classes (e.g., `Checkout`, `Management`) that expose methods for specific API endpoints.
- **`/model`**: This package contains the generated data models used for API requests and responses.

## Development Workflow

This is a standard Maven project.

### Building

To compile the source code, run the tests, and package the project into a JAR file, use:

```bash
mvn install
```

### Running Tests

To execute the unit tests:

```bash
mvn test
```

### Code Style & Formatting

We use Checkstyle for linting and Spotless for formatting.

- **Check for style violations**:
  ```bash
  mvn checkstyle:check
  ```
- **Apply formatting**:
  ```bash
  mvn spotless:apply
  ```

The build will fail if there are any Checkstyle violations. Run `spotless:apply` before committing.

## Release Process

The release process is automated via GitHub Actions. When a release is triggered:
1.  A script determines the next version number (major, minor, or patch).
2.  The `pom.xml` and other version files are updated.
3.  A pull request is created with the version bump.
4.  Once merged, a GitHub release is created, and the new version is published to Maven Central.
