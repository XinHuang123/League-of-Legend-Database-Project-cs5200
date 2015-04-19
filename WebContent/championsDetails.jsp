<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="edu.neu.cs5200.dao.*, edu.neu.cs5200.models.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <div>
        <h1>Champion Details</h1>
        
        <%
        ChampionDAO dao = new ChampionDAO();        
        String idStr = request.getParameter("id");
        int id = Integer.parseInt(idStr);        
        Champion champion = dao.readChampionById(id);
        %>
        
        Blurb: <%=champion.getBlurb() %>
        Lore: <%=champion.getLore()%>
        
    </div>
</body>
</html>