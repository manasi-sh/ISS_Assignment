# Server Side (JSP & Servlets)

This module handles backend processing using Java Servlets and JSP. It controls user registration, login, and dynamic content rendering.

## Technologies Used
- Language: Java 8 (JDK 1.8)
- Server: Apache Tomcat 9
- IDE: Eclipse IDE (Enterprise Edition)
- Build Tool: Maven 
- Project Structure: Maven (with `src/main/java` and `src/main/webapp`)

## How to Run
1. Import the `HelloWorldApp` folder into Eclipse (`File → Import → Existing Maven Projects`).
2. Add Apache Tomcat 9 in the `Servers` tab and configure it with the project.
3. Right-click the project → `Run As → Run on Server`.

## Access Flow
- Open browser: `http://localhost:8080/HelloWorldApp/`  
  → This loads `index.jsp` with a **Hello World** message.
- To open the login/register app:  
  Visit `http://localhost:8080/HelloWorldApp/register`

> Make sure servlet classes are in `src/main/java/com/manasi/web` and JSP files in `src/main/webapp/`.
