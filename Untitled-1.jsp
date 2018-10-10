<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<% 
String path = request.getContextPath(); 
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>"> 
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
</head>

<body>
<%
String icon=(String)request.getAttribute("icon");
String s=(String)request.getAttribute("s");
if(icon!=null && s==null){%>
  	<script type="text/javascript">
		alert("上传成功！");
	</script>
<%}else if(icon==null && s!=null){%>
	<script type="text/javascript">
		alert("<%=s%>");
	</script>
<%}%>
</body>
</html>