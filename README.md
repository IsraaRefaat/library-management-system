# 📚 Library Management System

A complete Spring Boot application to manage a digital library. This system supports CRUD operations on users, books, authors, publishers, categories, and borrowing transactions, with future plans for full security integration and logging.

---

## 🚀 Features

* **User Roles**: `ADMIN`, `LIBRARIAN`, `STAFF`, `MEMBER`
* **Authentication**: Basic Auth, JWT
* **Book Management** with multiple authors and hierarchical categories
* **Borrowing System** with return tracking
* **CRUD Operations**:

  * Users (Admin, Librarian, Staff)
  * Books
  * Authors
  * Categories
  * Publishers
  * Members
* **Activity Logging** for user CRUD operations (more logging in progress)

---

## 🛠 Technologies

* Java 21
* Spring Boot 3+
* Spring Data JPA
* Spring Security
* PostgreSQL
* Lombok
* Postman (API Testing)

---

## 📂 Project Structure

```
library-management-system/
├── src/
├── db/
│   ├── schema.sql
│   └── sample_data.sql
├── postman/
│   └── library-management-system.postman_collection.json
├── pom.xml
└── README.md
```

---

## 🧑‍💻 How to Run Locally

1. **Clone the project**

```bash
git clone https://github.com/your-username/library-management-system.git
```

2. **Create PostgreSQL DB**

```sql
CREATE DATABASE library_system;
```

3. **Run schema and data files**

```bash
psql -U postgres -d library_system -f db/schema.sql
psql -U postgres -d library_system -f db/sample_data.sql
```

4. **Run Spring Boot App**

```bash
mvn spring-boot:run
```

---

## 📬 API Testing

The `postman/` folder includes a full collection:

```bash
postman/library-management-system.postman_collection.json
```

* Test admin, librarian, and staff CRUD
* Book management with authors & categories
* Borrow and return books
* Authentication with Basic Auth (username/password)

---

## 🛡 Security (in progress)

* ✅ Basic Auth working
* 🔜 JWT Authentication & Role-based Authorization
* 🔒 Endpoint access control
* 🔐 Password hashing

---

## 📝 Logging

* Currently logs user actions to `activity_log` table
* Future plans:

  * Book operations
  * Borrowing transactions
  * Author/category edits

---

## 📊 Database ERD

![ERD](https://www.mermaidchart.com/raw/64211d3a-a026-440c-ba12-2ba8cb6d59a9?theme=light&version=v0.1&format=svg)

---

## 📌 TODO

* [x] Book CRUD
* [x] User roles
* [x] Borrowing system
* [x] Category hierarchy
* [x] JWT Security
* [ ] Logging for all operations
* [ ] Pagination and search filters


---

## 📧 Contact

Developed by **Esraa Refaat Kassem**
📩 Email: [erefaat591@gmail.com](mailto:erefaat591@gmail.com)
🔗 LinkedIn: [linkedin.com/in/esraa-refaat-kassem](https://www.linkedin.com/in/esraa-refaat-kassem/)


