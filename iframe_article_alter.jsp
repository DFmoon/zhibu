<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link type="text/css" rel="stylesheet" href="css/iframe_article_add.css" />
<link type="text/css" rel="stylesheet" href="css/index.css" />
</head>

<body>
<%
	String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";  
	String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=zhibu";    
	String userName="sa";    
	String userPwd="12345678"; 
	Class.forName(driverName);  
    Connection conn=DriverManager.getConnection(dbURL,userName,userPwd);
	Statement stmt = conn.createStatement();
	
	request. setCharacterEncoding("UTF-8");
	String articleid=(String)request.getParameter("articleid");
	
	String sql="select * from article where articleid='"+articleid+"'";
	ResultSet rs = stmt.executeQuery(sql);
	
	String title=null;
	String acontent=null;
		
	if(rs.next())
	{
		title=rs.getString("title");
		acontent=rs.getString("acontent");
	}	
%>
<form method="post" action="/alter_article?articleid=<%=articleid%>">
	<label>标题</label>
    <input type="text" name="title" value="<%=title%>" /><br /><br />
    <label>内容</label><br />
    <textarea name="acontent"><%=acontent%></textarea><br /><br /><br />
    <input type="submit" class="btn" style="width:100px;" value="确定修改" />
</form>
</body>
</html>