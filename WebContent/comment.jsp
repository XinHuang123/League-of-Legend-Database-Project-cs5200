
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="edu.neu.cs5200.dao.*, edu.neu.cs5200.models.*, java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<%
			CommentDAO commentdao=new CommentDAO();
		
			String action = request.getParameter("action");
			String commentid = request.getParameter("commentid");
			String id=request.getParameter("id");
			String content   = request.getParameter("content");
			String inputid=request.getParameter("inputid");
			String back=request.getParameter("back");
			
			int id123 = Integer.parseInt(id);
			ChampionDAO championDAO=new ChampionDAO();
			String Championname=championDAO.readChampionById(id123).getName();
					
			if("create".equals(action))
			{
				Champion champion=new Champion();
				ChampionDAO championdao=new ChampionDAO();
				Integer chid=Integer.parseInt(id);
				champion=championdao.readChampionById(chid);
				Integer id1 = Integer.parseInt(inputid);
				Comment comment = new Comment(id1,content,champion);
				commentdao.createComment(comment);
			}
			
			else if("delete".equals(action))
			{
				int cid = Integer.parseInt(commentid);
				commentdao.deleteComment(cid);
			}
				
			List<Comment> comments = commentdao.readAllComments();
		%>
		<h1>
			Comment
		</h1>
		<form action="comment.jsp">
		<table class="table table-striped">
			<tr>
			    <th>Champion Id</th>
			    <th>Champion Name</th>
			    <th>CommentId</th>
				<th>Content</th>
				
				
			</tr>
			<tr>
			    <th><input class="form-control" name="id" placeholder="plz type championid" value="<%=id%>" /></th>
			    <th><%=Championname %></th>
			    <th><input class="form-control" name="inputid" placeholder="plz type commentid" value="<%=inputid%>" /></th>
				<th><input class="form-control" name="content" placeholder="plz type content" value="<%=content%>" /></th>
				
				
							
				<td>
					<button class="btn btn-success" name="action" value="create">Create</button>
				</td>
			</tr>
		<%
			for(Comment comment : comments)
			{
				Champion yingxiong=comment.getChampionid();
				
		%>	<tr>
		        <td><%= yingxiong.getId() %></td>
		        <td><%= yingxiong.getName() %></td>
				<td><%= comment.getCommentid() %></td>
				<td><%= comment.getContent() %></td>								
				<td>
					<a href="comment.jsp?action=delete&commentid=<%=comment.getCommentid() %>" class="btn btn-danger">Delete</a>
				</td>
				<td>
				<a href="admin_Homepage.jsp" class="btn btn-danger">Back</a>
				
				</td>
			</tr>
		<%
			}
		%>
		</table>
		</form>
	</div>
</body>
</html>
