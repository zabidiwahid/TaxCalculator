# Tax Calculator Service

This project provides a tax calculation service based on the Malaysian tax system. It calculates the tax amount, identifies the applicable tax slab, and lists the available tax claim options based on the annual income provided.

## Table of Contents

- [Getting Started](#getting-started)
- [Building and Running the Application](#building-and-running-the-application)
- [API Endpoint](#api-endpoint)
- [Sample Request and Response](#sample-request-and-response)
- [Unit Tests](#unit-tests)

## Getting Started

These instructions will help you set up and run the Tax Calculator service on your local machine.

### Prerequisites

- Java 17 or higher
- Maven

### Installation

1. Clone the repository:
   ```sh
   git clone https://github.com/zabidiwahid/TaxCalculator
   
2. Navigate to the project directory:
   ```sh
   cd TaxCalculator
   
## Building and Running the Application

### Building

- To build the application, run the following Maven command:
   ```sh
   mvn clean install
   
### Running
- To run the application, use the following command:
   ```sh
   mvn spring-boot:run

The application will start on http://localhost:8080.

## API Endpoint

The service exposes a REST API endpoint to calculate tax.

### Endpoint

**GET** `/tax`

### Request Parameter

- `annualIncome` (double): The annual income for which the tax needs to be calculated.

### Response

The response is a JSON object containing:

- `taxAmount` (double): The calculated tax amount.
- `taxSlab` (string): The tax slab category.
- `taxClaimOptions` (List<String>): List of applicable tax claim options.

## Sample Request and Response

### Sample Request

    GET /tax?annualIncome=55000

### Sample Response

    ```json
        {
          "taxAmount": 1650.0,
          "taxSlab": "Category D: 1% on income up to RM35,000, 6% on income above RM35,000",
          "taxClaimOptions": [
            "Education fees (Self): Other than a degree at masters or doctorate level",
            "Medical treatment, special needs and carer expenses for parents",
            "Purchase of basic supporting equipment for disabled self, spouse, child or parent"
          ]
        }

## Unit Tests

Unit tests have been written to ensure the correctness of the tax calculation logic. To run the tests, use the following Maven command:

        mvn test
        
## Running Tests by Tag

You can run specific groups of tests using tags. For example, to run tests tagged with group-a, use the following command:
    
        mvn -Dgroups="group-a" test
        
Similarly, you can run tests for other groups by replacing group-a with the appropriate tag (e.g., group-b, group-c, etc.).