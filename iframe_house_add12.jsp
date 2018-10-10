<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="css/index.css" />
<link rel="stylesheet" type="text/css" href="css/iframe_house_alter1.css" />
<title>无标题文档</title>
</head>

<body>
<%
request. setCharacterEncoding("UTF-8");
String houseid=null;
houseid=(String)request.getAttribute("houseid");
%>
<form action="/houseupload1?houseid=<%=houseid%>&pic=1" enctype="multipart/form-data" method="post" style="margin-left:80px; margin-top:20px; width:400px;">
    <label>小图上传</label><span style="color:#F00; font-size:12px;">（建议上传250px*250px、jpg格式的图片）&nbsp;</span><br />
    <input type="file" name="spic" /><input style="width:80px;" type="submit"value="确定"/><br /><br />
</form>
<form action="/houseupload1?houseid=<%=houseid%>&pic=2" enctype="multipart/form-data" method="post" style="margin-left:80px; width:400px;">
    <label>大图上传</label><span style="color:#F00; font-size:12px;">（建议上传1200px*350px、jpg格式的图片）</span><br />
    <input type="file" name="bpic" /><input style="width:80px;" type="submit"value="确定"/><br /><br />
</form><br /><br />
<a class="btn" style="display:inline-block; width:100px;" href="iframe_house_show.jsp">返回查看</a>
<%
request. setCharacterEncoding("UTF-8");
String su1=null;
String er1=null;
String up=null;
su1=(String)request.getAttribute("su1");
er1=(String)request.getAttribute("er1");
up=(String)request.getAttribute("up");
if(su1!=null)
{%>
	<script>
		alert("<%=su1%>");
	</script>
<%}
if(er1!=null)
{%>
	<script>
		alert("<%=er1%>");
	</script>
<%}
if(up!=null)
{%>
	<script>
		alert("<%=up%>");
	</script>
<%}
%>
</body>
</html>