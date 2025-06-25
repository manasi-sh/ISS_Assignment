package com.manasi.web;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
//import java.util.Map;
//import java.util.Collections;
//import java.util.HashMap;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException {
    String u=req.getParameter("username"), p=req.getParameter("password");
    String expected = RegisterServlet.getUsers().get(u);
    if (expected != null && expected.equals(p)) {
      req.getSession().setAttribute("user", u);
      res.sendRedirect("welcome.jsp");
    } else {
      req.setAttribute("error","Invalid username or password");
      req.getRequestDispatcher("login.jsp").forward(req,res);
    }
  }
}
