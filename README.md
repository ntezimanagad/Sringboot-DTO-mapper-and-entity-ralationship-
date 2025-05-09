📘 Project Overview
This project is built using Spring Boot and demonstrates how to implement relationships between entities (tables) using JPA, along with DTOs and Mappers for clean data handling between layers (Entity ↔ DTO ↔ Controller).

🚀 Key Concepts Used
🧾 DTO (Data Transfer Object)

🔁 Entity-DTO Mapping using Mapper classes

🔗 One-to-Many and Many-to-One relationships

🗄️ Spring Data JPA repositories

🌐 RESTful APIs

🧱 Entities and Relationships
There are three main entities in this project:

👷 Employee — an employee who submits suggestions.

💡 Suggestion — a suggestion made by an employee.

🏷️ SuggestionType — the category/type of the suggestion.

🔗 Relationships:
👤 An Employee can have many Suggestions (One-to-Many).

📂 A SuggestionType can have many Suggestions (One-to-Many).

🧾 A Suggestion belongs to one Employee and one SuggestionType (Many-to-One).

📦 DTO Usage
DTOs are used to expose only the required data in API responses and requests. This:

🛡️ Improves security

🔓 Reduces data coupling

⚙️ Enables flexible communication with the frontend

Each entity has a matching DTO that includes only the necessary fields.
➡️ For relationships, only foreign key IDs like employee_id and suggestionType_id are used instead of full nested objects.

🔄 Mapper Classes
Mapper classes are used to convert between Entity and DTO:

🔁 toDto(Entity): Converts an entity to a DTO for responses.

🔁 toEntity(DTO): Converts a DTO into an entity for saving.

Mappers also handle nested mapping when necessary (e.g., mapping lists of related entities like posts or suggestions).

🧠 Service Layer Logic (💡 Suggestion Creation Example)
📥 Receives a SuggestionDTO from the controller

🛠 Converts it to a Suggestion entity using SuggestionMapper

🔍 Fetches the related Employee and SuggestionType by ID

🔗 Links them to the Suggestion

💾 Saves the Suggestion using the repository

📤 Converts the saved entity back to DTO to return as a response

🎯 Purpose of Relationships in DTO
Instead of sending full Employee or SuggestionType objects in SuggestionDTO,
we just send their IDs:

✅ employee_id
✅ suggestionType_id

This:

✂️ Keeps DTOs simple

📉 Reduces response payload

🧼 Improves frontend-backend separation

✅ Benefits of This Structure
📚 Clear separation between database logic and API logic

🛠 Easy to maintain and extend

🔄 Clean handling of relationships

🚀 Follows RESTful API best practices
