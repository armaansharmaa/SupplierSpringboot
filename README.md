Here is the updated README file reflecting the updated output structure of the POST API:

---

# Makersharks Manufacturer Search API (Proof of Concept)

## Overview

This project is a proof of concept (POC) for Makersharks' search API. The API allows buyers to search for manufacturers based on customized requirements such as location, nature of business, and manufacturing processes.

## Features

- **Supplier Search:** Fetch a list of manufacturers based on specific criteria like location, nature of business, and manufacturing processes.
- **Pagination Support:** Supports pagination when the number of results exceeds a certain limit.
- **Input Validation:** Ensures only valid data is processed by the API.
- **Exception Handling:** Handles exceptions gracefully. (More security features are documented as TODOs)
- **API Documentation:** Includes Swagger documentation for easy interaction and testing of the API.

## Technologies Used

- **Backend:** Spring Boot (Java)
- **Database:** H2 (In-Memory Database for POC)
- **Validation:** Hibernate Validator
- **Testing:** JUnit and Mockito
- **Documentation:** Swagger (enabled)

## Running the Application

### Prerequisites

- **Java 17** or higher
- **Maven 3.6+**

### Steps

1. **Clone the Repository:**
   ```bash
   git clone https://github.com/armaansharmaa/SupplierSpringboot.git
   cd SupplierSpringboot
   ```

2. **Build the Project:**
   ```bash
   mvn clean install
   ```

3. **Run the Application:**
   Once the build is successful, run the application using:
   ```bash
   mvn spring-boot:run
   ```

4. **Access the API:**
   The API will be accessible at:
   ```
   http://localhost:8080
   ```

5. **Access Swagger UI (Enabled):**
   If Swagger is enabled, the API documentation and testing UI will be available at:
   ```
   http://localhost:8080/swagger-ui.html
   ```

   **Swagger can also be accessed using the OpenAPI JSON format at:**
   ```
   http://localhost:8080/v3/api-docs
   ```

### Database

The application uses an in-memory H2 database for the POC. On startup, it will auto-generate the necessary tables and populate them with sample data from `data.sql`.

To access the H2 console, go to:
```
http://localhost:8080/h2-console
```

Use the following credentials:
- **JDBC URL:** `jdbc:h2:mem:testdb`
- **Username:** `root`
- **Password:** '0000'

## API Endpoints

### `/api/supplier/query` [POST]

**Description:** Retrieves a list of manufacturers matching the given criteria. The search is based on location, nature of business, and the capability to perform specific manufacturing processes. Supports pagination.

**Request Body Example:**
```json
{
  "location": "India",
  "natureOfBusiness": "small_scale",
  "manufacturingProcess": "3d_printing",
  "page": 0,
  "size": 10
}
```

**Response Example:**
```json
{
  "totalPages": 1,
  "totalElements": 1,
  "size": 10,
  "content": [
    {
      "supplierId": 1,
      "companyName": "ABC Manufacturing",
      "website": "https://abcmanufacturing.com",
      "location": "India",
      "natureOfBusiness": "small_scale",
      "manufacturingProcesses": "3d_printing"
    }
  ],
  "number": 0,
  "sort": {
    "empty": true,
    "sorted": true,
    "unsorted": true
  },
  "first": true,
  "last": true,
  "numberOfElements": 1,
  "pageable": {
    "offset": 0,
    "sort": {
      "empty": true,
      "sorted": true,
      "unsorted": true
    },
    "paged": true,
    "pageSize": 10,
    "pageNumber": 0,
    "unpaged": false
  },
  "empty": false
}
```

### Example cURL Requests

To test the API, you can use the following cURL commands:

#### Example 1: Fetch Small-Scale 3D Printing Manufacturers in India
```bash
curl -X POST http://localhost:8080/api/supplier/query \
-H "Content-Type: application/json" \
-d '{
  "location": "India",
  "natureOfBusiness": "small_scale",
  "manufacturingProcess": "3d_printing",
  "page": 0,
  "size": 10
}'
```

#### Example 2: Fetch Medium-Scale Moulding Manufacturers in USA
```bash
curl -X POST http://localhost:8080/api/supplier/query \
-H "Content-Type: application/json" \
-d '{
  "location": "USA",
  "natureOfBusiness": "medium_scale",
  "manufacturingProcess": "moulding",
  "page": 0,
  "size": 10
}'
```

### Response

The API returns a structured response with pagination, containing the total number of pages, total elements, and the list of suppliers matching the criteria.

**Response Fields:**
- `totalPages`: The total number of pages available.
- `totalElements`: The total number of manufacturers found.
- `size`: The number of results per page.
- `content`: A list of suppliers matching the criteria, including:
  - `supplierId`: The unique identifier for the supplier.
  - `companyName`: The name of the company.
  - `website`: The website URL of the company.
  - `location`: The location of the manufacturer.
  - `natureOfBusiness`: The nature of business (e.g., small_scale, medium_scale, etc.).
  - `manufacturingProcesses`: The manufacturing process (e.g., 3d_printing, moulding, etc.).
- `number`: The current page number.
- `sort`: Sorting information.
- `first`: Boolean indicating if this is the first page.
- `last`: Boolean indicating if this is the last page.
- `numberOfElements`: The number of elements on the current page.
- `pageable`: Additional pagination information, such as the offset, page size, page number, etc.
- `empty`: Boolean indicating if the content is empty.

## Testing

Run the unit tests using:
```bash
mvn test
```

Unit tests cover:
- Validation of API inputs.
- Correct response structure.
- Handling of invalid or missing parameters.

## Security Considerations

- **Input Validation:** All inputs are validated to ensure only proper data is processed by the API.
- **TODOs:** Detailed security features such as authentication, authorization, and rate-limiting are planned but not yet implemented in the POC.
- **Protection Against Attacks:** SQL Injection is prevented by using parameterized queries and sanitized inputs.

## Future Improvements (TODOs)

- **Security Enhancements:** Implement OAuth2 for authentication and authorization.
- **Rate Limiting:** Prevent excessive querying from users.
- **Caching:** Add caching for frequent search queries to improve performance.
- **Improved Exception Handling:** Provide more granular error responses and handle specific error cases gracefully.

## License

This project is licensed under the MIT License.

## Contact

For any questions or issues, please contact [Armaan Sharma](mailto:armaan.sh03@gmail.com).

---