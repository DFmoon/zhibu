<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link rel="stylesheet" type="text/css" href="css/index.css" />
<link rel="stylesheet" type="text/css" href="css/iframe_person_alter.css" />
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
	
		request. setCharacterEncoding("UTF-8");		//统一字符编码！！！！
		String email=(String)request.getParameter("email");	
		if(email==null)
		{
			email=(String)request.getAttribute("email");
		}
		String sql="select * from userinfo where email='"+email+"'";	
		ResultSet rs = stmt.executeQuery(sql);
		String sex=null;
		String phone=null;
		String username=null;
		String realname=null;
		String place=null;
		String birthday=null;
		String useridentity=null;
			
		if(rs.next())
		{
			sex=rs.getString(5);
			phone=rs.getString(8);
			username=rs.getString(1);
			realname=rs.getString(4);
			place=rs.getString(7);
			birthday=rs.getString(6);
			useridentity=rs.getString(9);
		}
		conn.close();
%>

<form action="/upload?email=<%=email%>" enctype="multipart/form-data" method="post" >
	<label>上传头像</label><input type="file" name="icon"  />
    <input style="width:80px;" type="submit"value="确定"/><br />
</form>
<form action="/alterServlet" method="post">
    <label>用户名</label><input type="text" name="username" value="<%=username%>" readonly="readonly" /><br />
    <label>联系电话</label><input type="tel" name="phone" value="<%=phone%>" /><br />
    <label>邮箱地址</label><input type="email" name="email" value="<%=email%>" readonly="readonly" /><br />
    <label>真实姓名</label><input type="text" name="realname" value="<%=realname%>" /><br />
    <label>性别</label><input type="sex" name="sex" value="<%=sex%>" /><br />
    <label>籍贯</label><input type="text" name="place" value="<%=place%>" /><br />
    <label>出生日期</label><input type="date" name="birthday" value="<%=birthday%>" /><br />
    <label>身份证号</label><input type="text" name="useridentity" value="<%=useridentity%>" /><br />
    <br /><br />
    <input class="btn" style="width:100px; display:inline-block; margin-right:50px; margin-left:180px;" type="submit" value="保存" />
</form>


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