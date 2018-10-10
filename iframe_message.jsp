<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link type="text/css" rel="stylesheet" href="css/iframe_message.css" />
</head>

<body>

<%
	String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";  
	String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=zhibu";    
	String userName="sa";    
	String userPwd="12345678"; 
	Class.forName(driverName);  
    Connection conn1=DriverManager.getConnection(dbURL,userName,userPwd);
	Statement stmt1 = conn1.createStatement();
	Connection conn2=DriverManager.getConnection(dbURL,userName,userPwd);
	Statement stmt2 = conn2.createStatement();
	Connection conn3=DriverManager.getConnection(dbURL,userName,userPwd);
	Statement stmt3 = conn3.createStatement();
	Connection conn4=DriverManager.getConnection(dbURL,userName,userPwd);
	Statement stmt4 = conn4.createStatement();
	
	Connection conn11=DriverManager.getConnection(dbURL,userName,userPwd);
	Statement stmt11 = conn11.createStatement();
	Connection conn22=DriverManager.getConnection(dbURL,userName,userPwd);
	Statement stmt22 = conn22.createStatement();
	Connection conn33=DriverManager.getConnection(dbURL,userName,userPwd);
	Statement stmt33 = conn33.createStatement();
	Connection conn44=DriverManager.getConnection(dbURL,userName,userPwd);
	Statement stmt44 = conn44.createStatement();
	
	Connection conn111=DriverManager.getConnection(dbURL,userName,userPwd);
	Statement stmt111 = conn111.createStatement();
	Connection conn222=DriverManager.getConnection(dbURL,userName,userPwd);
	Statement stmt222 = conn222.createStatement();
	Connection conn333=DriverManager.getConnection(dbURL,userName,userPwd);
	Statement stmt333 = conn333.createStatement();
	Connection conn444=DriverManager.getConnection(dbURL,userName,userPwd);
	Statement stmt444 = conn444.createStatement();

	request. setCharacterEncoding("UTF-8");		//统一字符编码！！！！
	String email=(String)session.getAttribute("email");
	/*房源预定*/
	String sql1="select * from order_message,userinfo where order_message.email=userinfo.email and order_message.house_owner_email='"+email+"' and order_message.status='0' and order_message.message_status ='0' and order_message.order_table='1'";
	String sql2="select * from order_message,userinfo where order_message.email=userinfo.email and order_message.house_owner_email='"+email+"' and order_message.status='0' and order_message.message_status ='0' and order_message.order_table='2'";

	ResultSet rs1 = stmt1.executeQuery(sql1);
	ResultSet rs2= stmt2.executeQuery(sql2);
	
	String sql3="select * from order_message,userinfo where order_message.email=userinfo.email and order_message.house_owner_email='"+email+"' and order_message.status='0' and order_message.message_status ='1' and order_message.order_table='1'";
	String sql4="select * from order_message,userinfo where order_message.email=userinfo.email and order_message.house_owner_email='"+email+"' and order_message.status='0' and order_message.message_status ='1' and order_message.order_table='2'";
	
	ResultSet rs3 = stmt3.executeQuery(sql3);
	ResultSet rs4= stmt4.executeQuery(sql4);
	/*房源被评论*/
	String sql11="select * from order_message,userinfo where order_message.email=userinfo.email and order_message.house_owner_email='"+email+"' and order_message.status='2' and order_message.message_status ='0' and order_message.order_table='1'";
	String sql22="select * from order_message,userinfo where order_message.email=userinfo.email and order_message.house_owner_email='"+email+"' and order_message.status='2' and order_message.message_status ='0' and order_message.order_table='2'";

	ResultSet rs11 = stmt11.executeQuery(sql11);
	ResultSet rs22= stmt22.executeQuery(sql22);
	
	String sql33="select * from order_message,userinfo where order_message.email=userinfo.email and order_message.house_owner_email='"+email+"' and order_message.status='2' and order_message.message_status ='1' and order_message.order_table='1'";
	String sql44="select * from order_message,userinfo where order_message.email=userinfo.email and order_message.house_owner_email='"+email+"' and order_message.status='2' and order_message.message_status ='1' and order_message.order_table='2'";
	
	ResultSet rs33 = stmt33.executeQuery(sql33);
	ResultSet rs44= stmt44.executeQuery(sql44);
	/*房源退订*/	
	String sql111="select * from order_message,userinfo where order_message.email=userinfo.email and order_message.house_owner_email='"+email+"' and order_message.status='3' and order_message.message_status ='0' and order_message.order_table='1'";
	String sql222="select * from order_message,userinfo where order_message.email=userinfo.email and order_message.house_owner_email='"+email+"' and order_message.status='3' and order_message.message_status ='0' and order_message.order_table='2'";

	ResultSet rs111 = stmt111.executeQuery(sql111);
	ResultSet rs222= stmt222.executeQuery(sql222);
	
	String sql333="select * from order_message,userinfo where order_message.email=userinfo.email and order_message.house_owner_email='"+email+"' and order_message.status='3' and order_message.message_status ='1' and order_message.order_table='1'";
	String sql444="select * from order_message,userinfo where order_message.email=userinfo.email and order_message.house_owner_email='"+email+"' and order_message.status='3' and order_message.message_status ='1' and order_message.order_table='2'";
	
	ResultSet rs333 = stmt333.executeQuery(sql333);
	ResultSet rs444= stmt444.executeQuery(sql444);
%>

<ul class="tabs">
    <li>
        <input type="radio" name="tabs" id="tab1" checked />
        <label for="tab1">新消息</label>
        <div id="tab-content1" class="tab-content">
        	<%
				while(rs1.next())
				{
					String username=rs1.getString("username");
					String housename=rs1.getString("housename");
					String messageid=rs1.getString("messageid");
					String em=rs1.getString("email");
			%>
            	<a href="/changestatus?messageid=<%=messageid%>&em=<%=em%>&st=1" style="text-decoration:none; color:#0b579f;">
                	<p><%=username%>&nbsp;预定了您的小屋“<%=housename%>”！</p>
                </a>
			<%}conn1.close();
				while(rs2.next())
				{
					String username=rs2.getString("username");
					String housename=rs2.getString("housename");
					String messageid=rs2.getString("messageid");
					String em=rs2.getString("email");
			%>
            	<a href="/changestatus?messageid=<%=messageid%>&em=<%=em%>&st=1"  style="text-decoration:none; color:#0b579f;">
                	<p><%=username%>&nbsp;预定了您的小屋“<%=housename%>”！</p>
                </a>
			<%}conn2.close();
				while(rs11.next())
				{
					String username=rs11.getString("username");
					String housename=rs11.getString("housename");
					String houseid=rs11.getString("houseid");
					String messageid=rs11.getString("messageid");
			%>
            	<a href="/changestatus?houseid=<%=houseid%>&messageid=<%=messageid%>&st=2" target="_blank" style="text-decoration:none; color:#0b579f;">
                	<p><%=username%>&nbsp;评论了您的小屋“<%=housename%>”！</p>
                </a>
			<%}conn11.close();
				while(rs22.next())
				{
					String username=rs22.getString("username");
					String housename=rs22.getString("housename");
					String houseid=rs22.getString("houseid");
					String messageid=rs22.getString("messageid");
			%>
            	<a href="/changestatus?houseid=<%=houseid%>&messageid=<%=messageid%>&st=3" target="_blank" style="text-decoration:none; color:#0b579f;">
                	<p><%=username%>&nbsp;评论了您的小屋“<%=housename%>”！</p>
                </a>
			<%}conn22.close();
				while(rs111.next())
				{
					String username=rs111.getString("username");
					String housename=rs111.getString("housename");
					String messageid=rs111.getString("messageid");
					String em=rs111.getString("email");
			%>
            	<a href="/changestatus?messageid=<%=messageid%>&em=<%=em%>&st=4"  style="text-decoration:none; color:#0b579f;">
            		<p><%=username%>&nbsp;退订了您的小屋“<%=housename%>”！</p>
                </a>
			<%}conn111.close();
				while(rs222.next())
				{
					String username=rs222.getString("username");
					String housename=rs222.getString("housename");
					String messageid=rs222.getString("messageid");
					String em=rs222.getString("email");
			%>
            	<a href="/changestatus?messageid=<%=messageid%>&em=<%=em%>&st=4"  style="text-decoration:none; color:#0b579f;">
            		<p><%=username%>&nbsp;退订了您的小屋“<%=housename%>”！</p>
                </a>
			<%}conn222.close();%>
        </div>
    </li>

    <li>
        <input type="radio" name="tabs" id="tab2" />
        <label for="tab2">历史消息</label>
        <div id="tab-content2" class="tab-content">
        	<%
				while(rs3.next())
				{
					String username=rs3.getString("username");
					String housename=rs3.getString("housename");
					String messageid=rs3.getString("messageid");
					String em=rs3.getString("email");
			%>
            	<a href="iframe_message_details.jsp?messageid=<%=messageid%>&em=<%=em%>" style="text-decoration:none; color:#0b579f;">
            		<p style="color:#666;"><%=username%>&nbsp;预定了您的小屋“<%=housename%>”！</p>
                </a>
			<%}conn3.close();
				while(rs4.next())
				{
					String username=rs4.getString("username");
					String housename=rs4.getString("housename");
					String messageid=rs4.getString("messageid");
					String em=rs4.getString("email");
			%>
            	<a href="iframe_message_details.jsp?messageid=<%=messageid%>&em=<%=em%>" style="text-decoration:none; color:#0b579f;">
            		<p style="color:#666;"><%=username%>&nbsp;预定了您的小屋“<%=housename%>”！</p>
                </a>
			<%}conn4.close();
				while(rs33.next())
				{
					String username=rs33.getString("username");
					String housename=rs33.getString("housename");
					String houseid=rs33.getString("houseid");
			%>
            	<a href="house.jsp?houseid=<%=houseid%>" target="_blank" style="text-decoration:none; color:#0b579f;">
            		<p style="color:#666;"><%=username%>&nbsp;评论了您的小屋“<%=housename%>”！</p>
                </a>
			<%}conn33.close();
				while(rs44.next())
				{
					String username=rs44.getString("username");
					String housename=rs44.getString("housename");
					String houseid=rs44.getString("houseid");
			%>
            	<a href="house_thing.jsp?houseid=<%=houseid%>" target="_blank" style="text-decoration:none; color:#0b579f;">
            		<p style="color:#666;"><%=username%>&nbsp;评论了您的小屋“<%=housename%>”！</p>
                </a>
			<%}conn44.close();
				while(rs333.next())
				{
					String username=rs333.getString("username");
					String housename=rs333.getString("housename");
					String messageid=rs333.getString("messageid");
					String em=rs333.getString("email");
			%>
            	<a href="iframe_message_details2.jsp?messageid=<%=messageid%>&em=<%=em%>"  style="text-decoration:none; color:#0b579f;">
            		<p style="color:#666;"><%=username%>&nbsp;退订了您的小屋“<%=housename%>”！</p>
                </a>
			<%}conn333.close();
				while(rs444.next())
				{
					String username=rs444.getString("username");
					String housename=rs444.getString("housename");
					String messageid=rs444.getString("messageid");
					String em=rs444.getString("email");
			%>
            	<a href="iframe_message_details2.jsp?messageid=<%=messageid%>&em=<%=em%>"  style="text-decoration:none; color:#0b579f;">
                	<p style="color:#666;"><%=username%>&nbsp;退订了您的小屋“<%=housename%>”！</p>
                </a>
			<%}conn444.close();%>
        </div>
    </li>
</ul>

</body>
</html>