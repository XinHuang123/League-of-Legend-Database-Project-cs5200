<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="edu.neu.cs5200.dao.*, edu.neu.cs5200.models.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Details</title>
<style type="text/css">
body {
    background-image: url('http://crunchify.com/bg.png');
}
</style>
</head>
<body>
    <div>
        <h1>User Details</h1>
        <%
        String username = request.getParameter("username");
        UserDAO userdao=new UserDAO();
        User user=userdao.readUserByUsername(username);
        %>    
        
    </div>
    
 <div>
    <h1>User Information</h1>
    Username:<%=username %>
    <br><br> 
    Role:<%=user.getRole() %>
    <br><br> 
    Firstname:<%=user.getFirstname() %>
    <br><br> 
    Lastname:<%=user.getLastname() %>
    <br><br> 
    Date of Birth:<%=user.getDateofbirth() %>
 
    
    </div>
  
   <div> 
   <h2>Liked Champion</h2>
    <form action="profile.jsp">
    <table class="table table-striped">
        <thead>
            <tr>
                <th>ID</th>
                <th>Title</th>
                <th>Name</th>
               
            </tr>
        </thead>
        <tbody>
  <%  

  Champion championid=user.getChampionid();
  Integer chid=championid.getId();
  ChampionDAO championDAO=new ChampionDAO();
  Champion champions = championDAO.readChampionById(chid);
        %>
            <tr>
                <td><%=champions.getId()%></td>
                <td><%=champions.getTitle() %></td>
                <td><%=champions.getName() %></a></td>      
               
            </tr>
   
        </tbody>
    </table>
    </form>
    </div>
</body>
</html>