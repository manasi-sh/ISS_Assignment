<%@ page contentType="text/html;charset=UTF-8" %>
<html><head>
  <script>
    function validate() {
      let u = f.username.value.trim(), p = f.password.value.trim();
      if (!u || !p) { alert("Both fields are required"); return false; }
      return true;
    }
  </script>
</head>
<body>
  <h2>Login</h2>
  <form name="f" action="login" method="post" onsubmit="return validate()">
    Username: <input name="username"><br>
    Password: <input type="password" name="password"><br>
    <span style="color:red"><%=request.getAttribute("error")!=null?request.getAttribute("error"):""%></span><br>
    <input type="submit" value="Login">
  </form>
  <a href="register.jsp">Register</a>
</body></html>
