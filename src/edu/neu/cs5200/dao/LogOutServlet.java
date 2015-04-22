package edu.neu.cs5200.dao;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
/*
 * Author: Crunchify.com
 * 
 */
 
/**
 * Servlet implementation class LogOutServlet
 */
 
@WebServlet("/LogOutServlet")
public class LogOutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        Cookie logoutCookie = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("User")) {
                    logoutCookie = cookie;
                    break;
                }
            }
        }
        if (logoutCookie != null) {
            logoutCookie.setMaxAge(0);
            response.addCookie(logoutCookie);
        }
        response.sendRedirect("login.html");
    }
 
}
