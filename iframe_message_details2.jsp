<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link rel="stylesheet" type="text/css" href="css/iframe_message_details.css" />
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
	Connection conn2=DriverManager.getConnection(dbURL,userName,userPwd);
	Statement stmt2 = conn2.createStatement();
	
	request. setCharacterEncoding("UTF-8");		//统一字符编码！！！！
	String email=(String)request.getParameter("em");
	String messageid=(String)request.getParameter("messageid");
	if(email==null)
	{
		email=(String)request.getAttribute("em");
		messageid=(String)request.getAttribute("messageid");
	}
	
	String sql="select * from order_message,userinfo where order_message.email='"+email+"' and order_message.messageid='"+messageid+"'";
	ResultSet rs=stmt.executeQuery(sql);
	
	String realname=null;
	String phone=null;
	String housename=null;
	String checkin=null;
	String checkout=null;
	String univalent=null;
	String thingid=null;
	String quantity=null;
	String change_intro=null;
	String change_pic=null;
	
	if(rs.next())
	{
		realname=rs.getString("realname");
		phone=rs.getString("phone");
		housename=rs.getString("housename");
		checkin=rs.getString("checkin");
		checkout=rs.getString("checkout");
		univalent=rs.getString("univalent");
		thingid=rs.getString("thingid");
		quantity=rs.getString("quantity");
	}
	if(thingid!=null)
	{
		String sql2="select * from order_message,changething where order_message.thingid=changething.thingid";
		ResultSet rs2=stmt2.executeQuery(sql2);
		if(rs2.next())
		{
			change_intro=rs2.getString("change_intro");
			change_pic=rs2.getString("change_pic");
		}
	}
%>

<div id="metop">
  退订详情<br />
</div>
<form id="medetail" method="post" action="">
	<span>用户信息</span><br />
	<label>真实姓名：</label><input name="realname" value="<%=realname%>" readonly="readonly" /><br />
    <label>联系电话：</label><input name="phone" value="<%=phone%>" readonly="readonly" /><br />
    <label>邮箱地址：</label><input name="email" value="<%=email%>" readonly="readonly" /><br />
    <span>订单信息</span><br />
    <label>房源名：</label><input name="housename" value="<%=housename%>" readonly="readonly" /><br />
    <label>预定期间：<input name="checkin" value="<%=checkin%>" style="width:100px;"  readonly="readonly" />&nbsp;&nbsp;-
 					<input name="checkout" value="<%=checkout%>" style="width:100px;"  readonly="readonly" /></label><br />
    
        <%
			if(change_intro==null)
			{
		%>
    <label>单价：</label><input name="univalent" value="<%=univalent%>" style="width:60px;" readonly="readonly" /><label>元/晚</label><br />		
    <label>数量：</label><input name="quantity" value="<%=quantity%>" readonly="readonly" /><br />
    	<%}else{%>
    <label>数量：</label><input name="quantity" value="<%=quantity%>" readonly="readonly" /><br />
    <label>交换物品展示：</label><br />
    <textarea name="change_intro" readonly="readonly"><%=change_intro%></textarea><br />
    <img src="<%=change_pic%>" /><br />
    	<%}%>
	<br /><input type="submit"  style="margin-left:300px; width:100px; height:40px; line-height:40px; font-size:14px; font-family:'宋体'; border:1px solid #666; color:#666;" disabled="disabled" value="用户已退订" />
</form>

</body>
</html>