package com.manasi.web;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.Map;
import java.util.Collections;
import java.util.HashMap;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Static map to share users across servlets
    private static Map<String,String> users = Collections.synchronizedMap(new HashMap<>());

    // Getter to access the shared users map
    public static Map<String,String> getUsers() {
        return users;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        String u = req.getParameter("username"), p = req.getParameter("password");
        if (!users.containsKey(u)) {
            users.put(u, p);
            resp.sendRedirect("login.jsp");
        } else {
            resp.sendRedirect("login.jsp?error=exists");
        }
    }
}
