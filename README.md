# Pre-Training Assignment Overview
---

## 1. Core Java

Core Java is used as the foundation for backend logic and modular programming. Key elements implemented include:

- Object-Oriented Programming (OOP):
  - Use of classes and objects
  - Inheritance and method overriding
  - Encapsulation with access modifiers and getters/setters
- Collections framework:
  - Use of `List`, `ArrayList`, `Map`, `HashMap` for storing and retrieving data
- Exception handling:
  - Try-catch blocks to handle input/output errors and custom logic errors
  - Checked exceptions like `IOException`, `ServletException`
- Utility classes for:
  - Business logic
  - Reusable validation methods
  - Data parsing or formatting where needed

---

## 2. Client Side (HTML, CSS, JavaScript)

The client-side layer serves as the user interface for input and output interaction.

- **HTML**:
  - Structured layout using `<form>`, `<input>`, `<select>`, and other tags
  - Separate pages for registration, login, display, and actions
- **CSS**:
  - Styling with selectors and layout formatting
  - Basic layout alignment and spacing
- **JavaScript**:
  - Input validation before form submission (e.g., empty field checks)
  - Dynamic behavior such as alert messages or enabling/disabling buttons

---

## 3. Server Side (JSP & Servlets)

Java Servlets and JSPs are used to handle backend request/response cycles and dynamic content rendering.

- **Servlets**:
  - Serve as controllers to process `GET` and `POST` requests
  - Extract parameters from forms using `request.getParameter()`
  - Handle logic like registration, login, data processing
  - Communicate with database layer or Java Beans
- **JSPs**:
  - Render dynamic data using Expression Language (EL) and Java code snippets
  - Present user feedback, query results, or success messages
- **Common configurations**:
  - Servlet mapping in `web.xml` or using `@WebServlet`
  - Package organization (e.g., `com.manasi.web`)
  - Error handling for undefined methods, import issues (`HttpServletRequest`, `IOException`, etc.)

---

## 4. SQL (Database Design & Operations)

The relational database (MySQL) supports data storage, consistency, and relational mapping.

- **Schema design**:
  - Tables like `students`, `courses`, `users` designed with appropriate datatypes and primary keys
- **DDL operations**:
  - `CREATE TABLE` with constraints like `AUTO_INCREMENT`, `PRIMARY KEY`, `UNIQUE`
  - `ALTER TABLE` to add foreign keys (e.g., linking `CourseID` to `StudentID`)
- **DML operations**:
  - `INSERT INTO` for adding records
  - `UPDATE`, `DELETE` for modifying/deleting data
  - `SELECT` with conditions and joins to fetch combined data from multiple tables
- **Join operations**:
  - Example: Fetching students along with their enrolled course names
- **Query samples**:
  - Assigning courses using `UPDATE students SET CourseID = 1 WHERE StudentID = 1;`
  - Summarizing totals or displaying relational views using `INNER JOIN`

---

## 5. Python (Script Logic & Validation)

Python scripts are used to demonstrate control flow, data parsing, and basic input validation.

- **Control flow**:
  - Use of `if-else`, `for`, and `while` loops for iterative and conditional logic
- **Data parsing**:
  - Reading space-separated values from input
  - Filtering valid integers using `try-except`
- **Exception handling**:
  - Handling `ValueError` to skip invalid inputs (e.g., alphabets or symbols)
  - Printing appropriate messages like `Invalid number: abc`
- **Output generation**:
  - Summing valid integers from input
  - Loop-based logic for counting, filtering (e.g., even numbers, range conditions)
- **Problem-solving examples**:
  - Divisible pairs
  - Conditional filters
  - List iterations and formatted output

---
