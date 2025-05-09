EventBuddyAPI - Event Management REST API
EventBuddyAPI is a backend service for managing events. It provides a set of RESTful APIs that allow users to create, update, retrieve, and delete event information.

🚀 Features
Event Management: CRUD operations for managing events.

PostgreSQL Database: Uses PostgreSQL to store event data.

Validation: Ensures correct data entry with Spring Boot Validation.

Exception Handling: Custom exception handling with clear error messages.

Unit and Integration Tests: Fully tested API with JUnit and MockMvc.

💻 Technologies Used
Spring Boot: Framework for building the API.

PostgreSQL: Database to store event data.

JUnit: Testing framework for unit and integration tests.

MockMvc: Simulates HTTP requests for testing controllers.

Maven: Build and dependency management tool.

🏗️ Project Setup
Clone the repository:

bash
Copy
Edit
git clone https://github.com/your-username/EventBuddyAPI.git
Navigate to the project directory:

bash
Copy
Edit
cd EventBuddyAPI
Run the application locally:

Make sure you have Java 17 or above installed.

Use Maven to build and run the application:

bash
Copy
Edit
mvn spring-boot:run
Database Configuration:

Update the application.properties file with your PostgreSQL database credentials.

properties
Copy
Edit
spring.datasource.url=jdbc:postgresql://localhost:5432/eventbuddydb
spring.datasource.username=your-db-username
spring.datasource.password=your-db-password
📱 API Endpoints
1. Get All Events
GET /api/events

Description: Fetch all events.

Response: A list of all events in the database.

2. Get Event by ID
GET /api/events/{id}

Description: Get event details by event ID.

Response: Event details.

3. Create New Event
POST /api/events

Request Body:

json
Copy
Edit
{
    "name": "New Event",
    "description": "Event description",
    "startDate": "2025-06-01",
    "endDate": "2025-06-02",
    "location": "Event Location"
}
Response: Created event details.

4. Update Event
PUT /api/events/{id}

Request Body:

json
Copy
Edit
{
    "name": "Updated Event",
    "description": "Updated description",
    "startDate": "2025-06-01",
    "endDate": "2025-06-02",
    "location": "Updated Location"
}
Response: Updated event details.

5. Delete Event
DELETE /api/events/{id}

Description: Delete an event by ID.

Response: Confirmation of event deletion.

🧪 Running Tests
Unit Tests: To run all the unit tests in the project:

bash
Copy
Edit
mvn test
Integration Tests: To run integration tests:

bash
Copy
Edit
mvn verify
🌱 Contributing
Feel free to fork the repository and submit pull requests. You can contribute by fixing bugs, adding new features, or improving documentation.

Fork the repository

Create a new branch (git checkout -b feature-name)

Make your changes

Commit your changes (git commit -am 'Add feature')

Push to the branch (git push origin feature-name)

Create a new Pull Request


📞 Contact
Akhil Somisetty - akhilsomisetty2004@gmail.com

