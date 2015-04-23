<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*, java.util.*, edu.neu.cs5200.dao.*,edu.neu.cs5200.models.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
  <%
       		UserDAO dao = UserDAO.getInstance();
        	User user = new User();
            String userName = null;
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("User")) {
                        userName = cookie.getValue();
                    	user = dao.readUserByUsername(userName);
                    	break;
                    }
                }
            }
            if (userName == null)
                response.sendRedirect("login.html");
        %>
<title><%= user.getUsername()%> 's Homepage</title>
</head>
 
<body>
    <div class="container">
        <div class="avatar">
	       
	        <form action="LogOutServlet" method="post">
            <input type="submit" value="Logout">
        </form>
        </div>
        
        
        <div class="queries">
        <form action="./searchUser.jsp" method="post">
            <br> <br> Search Username: <input type="text" name="targetUser">
            <br> <br> <input type="submit" value="Seach Usernames">
        </form>
        
    		<form action="./QueryResults.jsp" method="post" target="_blank">
            <br> <br> Search Products: <input type="text" name="keyword">
            <br> <br> <input type="Submit" name ="btn" value="Search Products">
        </form>
    </div>
         
    
</body>
</html>