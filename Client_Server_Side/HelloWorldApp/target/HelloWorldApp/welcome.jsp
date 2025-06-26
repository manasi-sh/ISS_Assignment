<%@ page session="true" contentType="text/html;charset=UTF-8" %>
<%
  String user = (String)session.getAttribute("user");
  if (user == null) response.sendRedirect("login.jsp");
%>
<html><body>
  <h2>Welcome, <%=user%>!</h2>
  <form action="logout" method="post"><input type="submit" value="Logout"></form>
</body></html>
