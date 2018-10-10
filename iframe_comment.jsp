<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link rel="stylesheet" type="text/css" href="css/iframe_comment.css" />
<link rel="stylesheet" type="text/css" href="css/index.css" />
</head>

<body>
<%
	request. setCharacterEncoding("UTF-8");		//统一字符编码！！！！
	String houseid=(String)request.getParameter("houseid");
	String housetable=(String)request.getParameter("housetable");
	String orderid=(String)request.getParameter("orderid");
%>
<form method="post" action="/add_comment?houseid=<%=houseid%>&housetable=<%=housetable%>&orderid=<%=orderid%>">
<label>评论</label>
<div style="clear:both;"></div>
<textarea name="comment"></textarea>
<div style="clear:both;"></div>
<input type="submit" class="btn" style="display:block; float:left; margin-top:20px;" value="提交" />
</form>
</body>
</html>