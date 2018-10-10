<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link rel="stylesheet" type="text/css" href="css/index.css" />
<link rel="stylesheet" type="text/css" href="css/iframe_person_show.css" />
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
		String email=(String)session.getAttribute("email");
		String sql="select * from userinfo where email='"+email+"'";	
		ResultSet rs = stmt.executeQuery(sql);
		String sex=null;
		String phone=null;
		String username=null;
		String realname=null;
		String place=null;
		String birthday=null;
		String useridentity=null;
		String ifhouse=null;
		String icon=null;
			
		if(rs.next())
		{
			sex=rs.getString(5);
			phone=rs.getString(8);
			username=rs.getString(1);
			realname=rs.getString(4);
			place=rs.getString(7);
			birthday=rs.getString(6);
			useridentity=rs.getString(9);
			ifhouse=rs.getString(10);
			icon=rs.getString(13);
		}
		conn.close();
%>

<div id="ips_top">
	<div class="left">
    	<div class="left_icon"><img src="<%=icon%>" width="100%" height="100%" /></div>
    </div>
    <div class="right">
    	<p>用户名：<%=username%>&nbsp;&nbsp;&nbsp;&nbsp;<%=sex%></p>
        <p>联系电话：<%=phone%></p>
        <p>邮箱地址：<%=email%></p>
    </div>
</div>


<div id="ips_bottom">
	<p>真实姓名：<%=realname%></p>
    <p>籍贯：<%=place%></p>
    <p>出生日期：<%=birthday%></p>
    <p>身份证号：<%=useridentity%></p>
    <p>是否为房东：<%=ifhouse%></p>
</div>
    <a href="iframe_person_alter.jsp?email=<%=email%>" target="kj" class="btn" >完善资料</a>&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="alter_password.jsp" class="btn" target="_blank">修改密码</a>
</body>
</html>