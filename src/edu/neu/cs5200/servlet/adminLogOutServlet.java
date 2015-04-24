package edu.neu.cs5200.servlet;

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
 
@WebServlet("/adminLogOutServlet")
public class adminLogOutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final String logout = "logout";
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	String logout = request.getParameter("logout");
    	String action = request.getParameter("action");
    	if("logout".equals(action)) {
        	
    		Cookie LoginCookie = new Cookie("logout", logout);
            // setting cookie to expiry in 60 mins
            LoginCookie.setMaxAge(60 * 60);
            response.addCookie(LoginCookie);
            response.sendRedirect("login.html");	
    	
    } 
    }
}