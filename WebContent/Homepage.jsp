<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="edu.neu.cs5200.dao.*, edu.neu.cs5200.models.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
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
                    	//System.out.println(userName);
                    	break;
                    }
                }
            }
            if (userName == null)
                response.sendRedirect("login.html");
            session.setAttribute( "username", userName );
        %>
 <title><%= user.getUsername()%>'s Homepage</title>  
      
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<style type="text/css">
body {
    background-image: url('http://ddragon.leagueoflegends.com/cdn/img/champion/splash/Nunu_0.jpg');
}
</style>
</head>
<div align="center">
<h1>Welcome to League of Legends Database Online Application</h1>

</div>
<body>
  
    <div align="center">
   
        <br> <br>
        <form action="HomepageServlet" method="post">
          <h1><%= user.getUsername()%>`s Homepage</h1>
          <A HREF="champions.jsp"></A>
           <A HREF="profile.jsp"></A>
           <button class="btn btn-success" name="action" value="search">Search</button>
            <br><br> 
           <button class="btn btn-success" name="action" value="profile">Profile</button>
            <br><br>
            <br><br>
        </form>       
    </div>
    
    <div align="center">
        <br> <br>
        <form action="LogOutServlet" method="post">
           <button class="btn btn-success" name="action" value="logout">Logout</button>
            <br><br> 

        </form>
        
    </div>
</body>
</html>