<%@ page contentType="text/html;charset=UTF-8" %>
<html><head>
  <script>
    function validate() {
      let u = f.username.value.trim(),
          p = f.password.value.trim();
      if (!u || !p) { alert("Both fields are required"); return false; }
      return true;
    }
  </script>
</head>
<body>
  <h2>Register</h2>
  <form name="f" action="register" method="post" onsubmit="return validate()">
    Username: <input name="username"><br>
    Password: <input type="password" name="password"><br>
    <input type="submit" value="Register">
  </form>
  <a href="login.jsp">Login</a>
</body></html>
