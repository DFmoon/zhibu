<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link rel="stylesheet" type="text/css" href="css/index.css" />
<link rel="stylesheet" type="text/css" href="css/iframe_article_list.css" />
</head>
<script>
function del(articleid){
if(window.confirm("您确定要删除吗？"))
	{
   		document.location="/delete_article?articleid="+articleid;
	}
}
</script>
<body>
<% 
		String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";  
		String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=zhibu";    
		String userName="sa";    
		String userPwd="12345678"; 
		Class.forName(driverName);  
		Connection conn=DriverManager.getConnection(dbURL,userName,userPwd);
		Statement stmt = conn.createStatement();
		request. setCharacterEncoding("UTF-8");		//统一字符编码！！！！
		String email=(String)session.getAttribute("email");
		String sql="select * from article where email='"+email+"'";
		ResultSet rs = stmt.executeQuery(sql);
	%>
    <a href="iframe_article_add.jsp" class="btn" style="margin-top:20px;">发表新文章</a>
<ul>
	<%
		while(rs.next())
		{
			String title=rs.getString(2);
			String articleid=rs.getString(8);
	%>
    <li>
    	<a href="article.jsp?articleid=<%=articleid%>" target="_blank"><%=title%></a>
    </li>
    <a style="display:inline-block; float:left; margin-left:60px; color:#0b579f; font-size:18px; font-family:'宋体'; cursor:pointer;"  href="/iframe_article_alter.jsp?articleid=<%=articleid%>">编辑</a>
    <a style="display:inline-block; float:left; margin-left:40px; color:#0b579f; font-size:18px; font-family:'宋体'; cursor:pointer;" onclick="del(<%=articleid%>)">删除</a>
    <div style="clear:both"></div><br />
    <%}%>
</ul>
</body>
</html>