<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="edu.neu.cs5200.dao.*, edu.neu.cs5200.models.*, java.net.URLEncoder"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <div class="container">
    <h1>Champions</h1>
    
    <%
    ChampionDAO championDAO = new ChampionDAO();
    
    String action = request.getParameter("action");
    String id = request.getParameter("id");
    String title  = request.getParameter("title");
    String name = request.getParameter("name");
    
    
   
    
   
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
    
    <form action="champions.jsp">
    <table class="table table-striped">
        <thead>
            <tr>
                <th>ID</th>
                <th>Title</th>
                <th>Name</th>
                
            </tr>
            <tr>
                <th><input class="form-control" name="id" placeholder="plz type id" value="<%=id%>" /></th>
                <th><input class="form-control" name="title" placeholder="plz type title" value="<%=title%>"/></th>
                <th><input class="form-control" name="name" placeholder="plz type name"  value="<%=name%>"/></th>               
                <th>
                 
                    <button class="btn btn-primary" name="action" value="search">Search</button>
                </th>
            </tr>
        </thead>
        <tbody>
  <%  if("search".equals(action))
    {
    	ChampionDAO dao=new ChampionDAO();
    	int Id = Integer.parseInt(id);
        Champion champion=dao.readChampionById(Id);
        %>
            <tr>
                <td><%=champion.getId() %></td>
                <td><%=champion.getTitle() %></td>
                <td><a href="championsDetails.jsp?id=<%=champion.getId()%>"><%=champion.getName() %></a></td>     
                <%
               
                final  String FIND_IMAGE_BY_NAME="http://ddragon.leagueoflegends.com/cdn/5.2.1/img/champion/champion_name.png ";   
               
                String c=champion.getName().replaceAll("\\s+","");
                String url=FIND_IMAGE_BY_NAME.replace("champion_name",  c);
                if(champion.getId()==9)
                {
                	String d=champion.getName().replace("Fiddlesticks","FiddleSticks");
                	url=FIND_IMAGE_BY_NAME.replace("champion_name",  d);
                }
                else if(champion.getId()==31)
                {
                	String v=champion.getName().replace("Cho'Gath","Chogath");
                	url=FIND_IMAGE_BY_NAME.replace("champion_name",  v);
                }
                else if(champion.getId()==36)
                {
                	String v1=champion.getName().replace("Dr. Mundo","DrMundo");
                	url=FIND_IMAGE_BY_NAME.replace("champion_name",  v1);
                }
                else if(champion.getId()==96)
                {
                	String v2=champion.getName().replace("Kog'Maw","KogMaw");
                	url=FIND_IMAGE_BY_NAME.replace("champion_name",  v2);
                }
                else if(champion.getId()==121)
                {
                	String v3=champion.getName().replace("Kha'Zix","Khazix");
                	url=FIND_IMAGE_BY_NAME.replace("champion_name",  v3);
                }
                else if(champion.getId()==161)
                {
                	String v4=champion.getName().replace("Vel'Koz","Velkoz");
                	url=FIND_IMAGE_BY_NAME.replace("champion_name",  v4);
                }
                else if(champion.getId()==421)
                {
                	String v5=champion.getName().replace("Rek'Sai","RekSai");
                	url=FIND_IMAGE_BY_NAME.replace("champion_name",  v5);
                }
                else
                {
                	url=FIND_IMAGE_BY_NAME.replace("champion_name",  c);
                }
                
             	%>           
                <td><img src="<%=url %>"/></td>
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