package com.manasi.web;

//import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
//import java.util.Map;
//import java.util.Collections;
//import java.util.HashMap;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  protected void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException {
    req.getSession().invalidate();
    res.sendRedirect("login.jsp");
  }
}
