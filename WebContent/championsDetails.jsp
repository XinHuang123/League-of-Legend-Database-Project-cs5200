<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="edu.neu.cs5200.dao.*, edu.neu.cs5200.models.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Champion Details</title>
<style type="text/css">
body {
    background-image: url('http://crunchify.com/bg.png');
}
</style>
</head>
<body>
    <div>
    <form action="championsDetails.jsp">
        <h1>Champion Details</h1>
        
        <%
        String action = request.getParameter("action");
        String id1 = request.getParameter("id1");
        
        ChampionDAO dao = new ChampionDAO();        
        String idStr = request.getParameter("id");
        int id = Integer.parseInt(idStr);        
        Champion champion = dao.readChampionById(id);
        String couple= champion.getCouple();
       Integer coupleid=Integer.parseInt(couple); 
        %>
        
        Blurb: <%=champion.getBlurb() %>
        Lore: <%=champion.getLore()%>
        <br><br>
      
       <a href="champions.jsp?id=<%=coupleid%>&action=search">Related Champions</a>
        </form>
    </div>
</body>
</html>