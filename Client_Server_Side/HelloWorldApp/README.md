# Server Side (JSP & Servlets)

This module handles backend processing using Java Servlets and JSP. It controls user registration, login, and dynamic content rendering.

## Technologies Used
- Language: Java 8 (JDK 1.8)
- Server: Apache Tomcat 9
- IDE: Eclipse IDE (Enterprise Edition)
- Servlet & JSP API: Jakarta EE / Java EE

## How to Run
1. Import the `HelloWorldApp` folder into Eclipse (`File → Import → Existing Projects into Workspace`).
2. Add Apache Tomcat 9 to the Eclipse Servers tab.
3. Right-click the project → `Run As → Run on Server`.

## Access Flow
- Open browser: `http://localhost:8080/HelloWorldApp/`  
  → This loads `index.jsp` with a **Hello World** message.
- To open the login/register app:  
  Visit `http://localhost:8080/HelloWorldApp/register`

> Ensure the servlet classes are in the correct package (`com.manasi.web`) and servlet mappings are properly configured via annotations or `web.xml`.
