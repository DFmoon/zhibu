<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link type="text/css" rel="stylesheet" href="css/index.css" />
</head>
<style>
body{ text-align:left;}
label{ width:100px; height:40px; line-height:40px; font-family:"宋体"; font-size:20px; color:#666; text-align:left; display:inline-block; margin-right:20px;}
input{ width:250px; height:30px; border:1px solid #CCC; text-align:center;}
</style>
<body>
<%
request. setCharacterEncoding("UTF-8");
String articleid=null;
articleid=(String)request.getAttribute("articleid");
%>
<form action="/articleupload?articleid=<%=articleid%>" enctype="multipart/form-data" method="post" style="margin-left:80px; margin-top:20px; width:400px;">
    <label>图片上传</label><span style="color:#F00; font-size:12px;">（建议上传12000px*350px、jpg格式的图片）&nbsp;</span><br />
    <input type="file" name="pic" /><input style="width:80px;" type="submit"value="确定"/><br /><br />
</form>
<a class="btn" style="display:inline-block; width:100px; margin-left:180px; text-align:center" href="iframe_article_list.jsp">返回查看</a>

<%
request. setCharacterEncoding("UTF-8");
String rr2=null;
String rr=null;
rr2=(String)request.getAttribute("rr2");
rr=(String)request.getAttribute("rr");

if(rr2!=null)
{%>
	<script>
		alert("<%=rr2%>");
	</script>
<%}
if(rr!=null)
{%>
	<script>
		alert("<%=rr%>");
	</script>
<%}%>

</body>
</html>