# Furry Friends API

## Overview

The Furry Friends API is a Spring Boot application designed to manage pets, specifically cats and dogs. It provides endpoints to create, read, update, and delete pet records.

## Getting Started

### Prerequisites

- Java 11 or higher
- Maven 3.6.3 or higher
- MySQL or any other relational database

### Installation

`empty`

## API Endpoints

### Common Endpoints for All Pets

- **Get All Pets**
    ```http
    GET /pets
    ```

- **Get** a Pet by ID
    ```http
    GET /pets/{id}
    ```


- **Create** a Pet
    ```http
    POST /{type}
    ```
    - Request Body:
        ```json
        {
          "name": "PetName", // string
          "age": PetAge, // integer
          "type": ("DOG", "CAT", "BIRD", "HAMSTER") // enum string
          "specificAttribute": "SpecificValue"  // varies by pet type
        }
        ```
    - `type` Pet Type.
    - `specificAttribute` varies by pet type:
        - **Cat**: indoor (boolean), color (string)
        - **Dog**: trained (boolean), breed (string)
        - **Hamster**: isCute (boolean), color (string)
        - **Bird**: canFly (boolean), color (string)

- **UPDATE** a Pet
    ```http
    PATCH /{type}/{id}
    ```
    - Request Body:
        ```json
        {
          "specificAttribute": "UpdatedSpecificValue"
        }
        ```
    - `type` Pet Type.
    - `specificAttribute` varies by pet type:
        - **Cat**: indoor (boolean), color (string)
        - **Dog**: trained (boolean), breed (string)
        - **Hamster**: isCute (boolean), color (string)
        - **Bird**: canFly (boolean), color (string)


- **Delete** a pet
    ```http
    DELETE /pets/{id}
    ```
