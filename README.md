# CRUD Notes App

A simple **CRUD (Create, Read, Update, Delete)** application built with **Spring Boot, MySQL, and Vanilla JavaScript/HTML/CSS**.
Users can add, view, update, and delete notes in real time.

---

## Features

* Create a new note
* Read all notes or a specific note
* Update an existing note
* Delete a note
* Frontend served as static files (`index.html`, `style.css`, `script.js`)
* Backend REST API built with Spring Boot
* MySQL database for persistent storage

---

## Project Structure

```
CRUD_Notes_App/
├── pom.xml
├── README.md
├── src/
│   ├── main/
│   │   ├── java/com/example/notesapp/
│   │   │   ├── controller/NoteController.java
│   │   │   ├── model/Note.java
│   │   │   ├── repository/NoteRepository.java
│   │   │   └── service/NoteService.java
│   │   └── resources/
│   │       ├── static/
│   │       │   ├── index.html
│   │       │   ├── style.css
│   │       │   └── script.js
│   │       └── application.properties
└── target/ (generated after build)
```

---

## Prerequisites

* Java 21 (OpenJDK or Oracle JDK)
* Maven
* MySQL

---

## Setup Instructions

1. **Clone or download the project**
2. **Create the database schema in MySQL**:

```sql
CREATE DATABASE crud_app;
```

3. **Update MySQL credentials** in `src/main/resources/application.properties` if needed:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/crud_app?useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=your_password
```

4. **Build the project**:

```bash
mvn clean install
```

5. **Run the backend**:

```bash
mvn spring-boot:run
```

6. **Open the frontend**:

Open in a browser:

```
http://localhost:8080/index.html
```

---

## Notes

* Tables are auto-created by JPA (`hibernate.ddl-auto=update`)
* API endpoints are available under `/api/notes`
* CORS is enabled (`@CrossOrigin(origins="*")`) so frontend JS can call backend

---

## API Endpoints

| Method | Endpoint        | Description         |
| ------ | --------------- | ------------------- |
| POST   | /api/notes      | Create a new note   |
| GET    | /api/notes      | Get all notes       |
| GET    | /api/notes/{id} | Get a note by ID    |
| PUT    | /api/notes/{id} | Update a note by ID |
| DELETE | /api/notes/{id} | Delete a note by ID |

---

## Tech Stack

* Java 21
* Spring Boot 3.x
* MySQL
* HTML, CSS, JavaScript

---

## Testing Quickly

1. Open `index.html` in a browser after backend is running.
2. Add a note → should appear instantly in the list.
3. Update a note → click edit, save → changes reflect.
4. Delete a note → click delete → removed immediately.

---
