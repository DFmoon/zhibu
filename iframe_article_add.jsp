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
String email=(String)session.getAttribute("email");
if(email==null)
{%>
	<script>
		alert("请先登录！");
		document.location="iframe_article_list.jsp";
	</script>
<%}
%>
<form method="post" action="/add_article">
	<label>标题</label>
    <input type="text" name="title" /><br /><br />
    <label>内容</label><br />
    <textarea name="acontent"></textarea><br /><br /><br />
    <input type="submit" class="btn" style="width:100px;" value="确定发表" />
</form>
<%
request. setCharacterEncoding("UTF-8");
String bd=null;
bd=(String)request.getAttribute("bd");
if(bd!=null)
{%>
	<script>
	alert("<%=bd%>");
	</script>
<%}
%>
</body>
</html>