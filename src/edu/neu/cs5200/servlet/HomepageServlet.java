package edu.neu.cs5200.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.neu.cs5200.dao.*;
 


 
@WebServlet("/HomepageServlet")
public class HomepageServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final String search = "search";
    private final String profile = "profile";
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	//UserDAO dao = UserDAO.getInstance();
 
        // get request parameters for userID and password
        String search = request.getParameter("search");
        String searchuser = request.getParameter("searchuser");
        String profile = request.getParameter("profile");
        String action = request.getParameter("action");
       
     //   if (userID.equals(User) && password.equals(pwd)) {
        if("search".equals(action)) {
        	
    		Cookie LoginCookie = new Cookie("search", search);
            // setting cookie to expiry in 60 mins
            LoginCookie.setMaxAge(60 * 60);
            response.addCookie(LoginCookie);
            response.sendRedirect("champions.jsp");	
    	
    } 
        else if("profile".equals(action))
        {
        	Cookie LoginCookie = new Cookie("profile", profile);
            // setting cookie to expiry in 60 mins
            LoginCookie.setMaxAge(60 * 60);
            response.addCookie(LoginCookie);
        	response.sendRedirect("profile.jsp");
        }
        else if("searchuser".equals(action))
        {
        	Cookie LoginCookie = new Cookie("searchuser", searchuser);
            // setting cookie to expiry in 60 mins
            LoginCookie.setMaxAge(60 * 60);
            response.addCookie(LoginCookie);
        	response.sendRedirect("searchuser.jsp");
        }
 
    }
}