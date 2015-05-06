<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="edu.neu.cs5200.dao.*, edu.neu.cs5200.models.*, java.net.URLEncoder"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Login Successful</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<style type="text/css">
body {
    background-image: url('http://crunchify.com/bg.png');
}
</style>
</head>
    <div class="container">
    <h1>Users</h1>
    
    <%
   
    
    
    ChampionDAO championDAO = new ChampionDAO();
    String username=(String)session.getAttribute( "username" ) ;
    String action = request.getParameter("action");
    String username1 = request.getParameter("username1");
    String role  = request.getParameter("role");  
    String back=request.getParameter("back");
    
    if("follow".equals(action))
    {
    	
    	UserDAO userdao=new UserDAO();
    	User user2=userdao.readUserByUsername(username);    	
    	User userid=new User(username1,null,null,null,null,null,null,null);
    	String password=user2.getPassword();
    	String role1=user2.getRole();
    	String firstname=user2.getFirstname();
    	String lastname=user2.getLastname();
    	String dateofbirth=user2.getDateofbirth();
    	Champion championid=user2.getChampionid();
  	User user1=new User(username,password,role1,championid,firstname,lastname,dateofbirth,userid);		
  	userdao.UpdateUser(user1);
  		
    }
    

    /*
    else if("delete".equals(action))
    {
        int idInt = Integer.parseInt(id);
        movieDAO.deleteMovie(idInt);   
    }
    else if("update".equals(action))
    {
        int idInt = Integer.parseInt(id);
        Movie movie = new Movie();
        movie.setTitle(title);
        movie.setPoster(poster);
        movie.setMovieId(movieId);
        movieDAO.updateMovie(idInt, movie);
    }
    
    */
   //Champion champions = championDAO.readChampionByName(name);
 
    %>
    
    <form action="searchuser.jsp">
    <table class="table table-striped">
        <thead>
            <tr>
                <th>Username</th>
                <th>Role</th>
                
            </tr>
            <tr>
                <th><input class="form-control" name="username1" placeholder="plz type username" value="<%=username1%>" /></th>
                <th><input class="form-control" name="role" placeholder="plz type title" value="<%=role%>"/></th>
                
                <th><%= username %></th>              
                <th>
                 
                    <button class="btn btn-success" name="action" value="search">Search</button>
                    <button class="btn btn-success" name="action" value="follow">Follow</button>
                    
                </th>
            </tr>
        </thead>
        <tbody>
  <%  if("search".equals(action))
    {
  	  UserDAO userdao=new UserDAO();
  	  User user=userdao.readUserByUsername(username1);
     
        %>
            <tr>
                <td><a href="userdetail.jsp?username=<%=user.getUsername()%>"><%=user.getUsername()%></td>
                <td><%=user.getRole() %></td>
                                          
               
                <td>
               <a class="btn btn-primary" href="searchuser.jsp?action=select&username1=<%=user.getUsername() %>&role=<%=user.getRole()%>">Select</a>
                
                </td>
                <td>
				<a href="Homepage.jsp" class="btn btn-danger">Back</a>
				
				</td>
            </tr>
   <%
    }
  
   %>
    
        </tbody>
    </table>
    </form>
    </div>
</body>
</html>






