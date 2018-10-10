<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link type="text/css" rel="stylesheet" href="css/iframe_orders.css" />
</head>
<script>
function del(orderid,ordertable){
if(window.confirm("您确定要退订吗？"))
	{
   		document.location="/delete_order?orderid="+orderid+"&ordertable="+ordertable+"&me=1";
	}
}

function del1(orderid,ordertable){
if(window.confirm("您确定要删除该订单吗？"))
	{
   		document.location="/delete_order?orderid="+orderid+"&ordertable="+ordertable+"&me=2";
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
    Connection conn1=DriverManager.getConnection(dbURL,userName,userPwd);
	Statement stmt1 = conn1.createStatement();
	Connection conn2=DriverManager.getConnection(dbURL,userName,userPwd);
	Statement stmt2 = conn2.createStatement();
	Connection conn3=DriverManager.getConnection(dbURL,userName,userPwd);
	Statement stmt3 = conn3.createStatement();
	
	Connection conn4=DriverManager.getConnection(dbURL,userName,userPwd);
	Statement stmt4 = conn4.createStatement();
	Connection conn5=DriverManager.getConnection(dbURL,userName,userPwd);
	Statement stmt5 = conn5.createStatement();
	Connection conn6=DriverManager.getConnection(dbURL,userName,userPwd);
	Statement stmt6 = conn6.createStatement();

	request. setCharacterEncoding("UTF-8");		//统一字符编码！！！！
	String email=(String)session.getAttribute("email");
	
	String sql1="select * from order1 where email='"+email+"' and status ='0'";
	String sql2="select * from order1 where email='"+email+"' and status ='1'";
	String sql3="select * from order1 where email='"+email+"' and status ='2'";
	ResultSet rs1 = stmt1.executeQuery(sql1);
	ResultSet rs2= stmt2.executeQuery(sql2);
	ResultSet rs3 = stmt3.executeQuery(sql3);
	
	String sql4="select * from order2,changething where order2.email='"+email+"' and order2.status ='0' and order2.thingid=changething.thingid";
	String sql5="select * from order2,changething where order2.email='"+email+"' and order2.status ='1' and order2.thingid=changething.thingid";
	String sql6="select * from order2,changething where order2.email='"+email+"' and order2.status ='2' and order2.thingid=changething.thingid";
	ResultSet rs4 = stmt4.executeQuery(sql4);
	ResultSet rs5= stmt5.executeQuery(sql5);
	ResultSet rs6 = stmt6.executeQuery(sql6);
%>

<ul class="tabs">
<li>
<input type="radio" name="tabs" id="tab1" checked />
<label for="tab1">未完成订单</label>
<div id="tab-content1" class="tab-content">
<%
	while(rs1.next())
	{
		String orderid=rs1.getString(8);
		String housename=rs1.getString(1);
		String checkin=rs1.getString(2);
		String checkout=rs1.getString(3);
		String univalent=rs1.getString(4);
		String houseid=rs1.getString(9);
		String quantity=rs1.getString(10);
%>
<table cellpadding="0" cellspacing="0">
  <tr>
    <th scope="col">订单编号</th>
    <th scope="col">房源名称</th>
    <th scope="col">入住时间</th>
    <th scope="col">退房时间</th>
    <th scope="col">单价</th>
    <th scope="col">数量</th>
    <th scope="col">操作</th>
  </tr>
  <tr>
    <td><%=orderid%></td>
    <td><%=housename%></td>
    <td><%=checkin%></td>
    <td><%=checkout%></td>
    <td><%=univalent%>元/晚</td>
    <td><%=quantity%></td>
    <td>
    	<a href="house.jsp?houseid=<%=houseid%>" target="_blank">查看</a>/
    	<a onclick="del(<%=orderid%>,1)">退订</a>
    </td>
  </tr>
</table>
<br /><br />
<%}conn1.close();%>

<%
	while(rs4.next())
	{
		String orderid=rs4.getString(6);
		String housename=rs4.getString(1);
		String checkin=rs4.getString(2);
		String checkout=rs4.getString(3);
		String change_intro=rs4.getString("change_intro");
		String houseid=rs4.getString(7);
		String quantity=rs4.getString(10);
%>
<table cellpadding="0" cellspacing="0">
  <tr>
    <th scope="col">订单编号</th>
    <th scope="col">房源名称</th>
    <th scope="col">入住时间</th>
    <th scope="col">退房时间</th>
    <th scope="col">交换物品</th>
    <th scope="col">数量</th>
    <th scope="col">操作</th>
  </tr>
  <tr>
    <td><%=orderid%></td>
    <td><%=housename%></td>
    <td><%=checkin%></td>
    <td><%=checkout%></td>
    <td><%=change_intro%></td>
    <td><%=quantity%></td>
    <td>
    	<a href="house_thing.jsp?houseid=<%=houseid%>" target="_blank">查看</a>/
    	<a onclick="del(<%=orderid%>,2)">退订</a>
    </td>
  </tr>
</table>
<br /><br />
<%}conn4.close();%>

</div>
</li>

<li>
<input type="radio" name="tabs" id="tab2" />
<label for="tab2">未评论订单</label>
<div id="tab-content2" class="tab-content">
<%
	while(rs2.next())
	{
		String orderid=rs2.getString(8);
		String housename=rs2.getString(1);
		String checkin=rs2.getString(2);
		String checkout=rs2.getString(3);
		String univalent=rs2.getString(4);
		String houseid=rs2.getString(9);
		String quantity=rs2.getString(10);
%>
<table cellpadding="0" cellspacing="0">
  <tr>
    <th scope="col">订单编号</th>
    <th scope="col">房源名称</th>
    <th scope="col">入住时间</th>
    <th scope="col">退房时间</th>
    <th scope="col">单价</th>
    <th scope="col">数量</th>
    <th scope="col">操作</th>
  </tr>
  <tr>
    <td><%=orderid%></td>
    <td><%=housename%></td>
    <td><%=checkin%></td>
    <td><%=checkout%></td>
    <td><%=univalent%>元/晚</td>
    <td><%=quantity%></td>
    <td>
    	<a href="house.jsp?houseid=<%=houseid%>" target="_blank">查看</a>/
        <a href="iframe_comment.jsp?houseid=<%=houseid%>&housetable=1&orderid=<%=orderid%>">评论</a>
    </td>
  </tr>
</table>
<br /><br />
<%}conn2.close();%>

<%
	while(rs5.next())
	{
		String orderid=rs5.getString(6);
		String housename=rs5.getString(1);
		String checkin=rs5.getString(2);
		String checkout=rs5.getString(3);
		String change_intro=rs5.getString("change_intro");
		String houseid=rs5.getString(7);
		String quantity=rs5.getString(10);
%>
<table cellpadding="0" cellspacing="0">
  <tr>
    <th scope="col">订单编号</th>
    <th scope="col">房源名称</th>
    <th scope="col">入住时间</th>
    <th scope="col">退房时间</th>
    <th scope="col">交换物品</th>
    <th scope="col">数量</th>
    <th scope="col">操作</th>
  </tr>
  <tr>
    <td><%=orderid%></td>
    <td><%=housename%></td>
    <td><%=checkin%></td>
    <td><%=checkout%></td>
    <td><%=change_intro%></td>
    <td><%=quantity%></td>
    <td>
    	<a href="house_thing.jsp?houseid=<%=houseid%>" target="_blank">查看</a>/
    	<a href="iframe_comment.jsp?houseid=<%=houseid%>&housetable=2&orderid=<%=orderid%>">评论</a>
    </td>
  </tr>
</table>
<br /><br />
<%}conn5.close();%>

</div>
</li>

<li>
<input type="radio" name="tabs" id="tab3" />
<label for="tab3">已完成订单</label>
<div id="tab-content3" class="tab-content">
<%
	while(rs3.next())
	{
		String orderid=rs3.getString(8);
		String housename=rs3.getString(1);
		String checkin=rs3.getString(2);
		String checkout=rs3.getString(3);
		String univalent=rs3.getString(4);
		String houseid=rs3.getString(9);
		String quantity=rs3.getString(10);
%>
<table cellpadding="0" cellspacing="0">
  <tr>
    <th scope="col">订单编号</th>
    <th scope="col">房源名称</th>
    <th scope="col">入住时间</th>
    <th scope="col">退房时间</th>
    <th scope="col">单价</th>
    <th scope="col">数量</th>
    <th scope="col">操作</th>
  </tr>
  <tr>
    <td><%=orderid%></td>
    <td><%=housename%></td>
    <td><%=checkin%></td>
    <td><%=checkout%></td>
    <td><%=univalent%>元/晚</td>
    <td><%=quantity%></td>
    <td>
    	<a href="house.jsp?houseid=<%=houseid%>" target="_blank">查看</a>/
        <a onclick="del1(<%=orderid%>,1)">删除</a>
    </td>
  </tr>
</table>
<br /><br />
<%}conn3.close();%>

<%
	while(rs6.next())
	{
		String orderid=rs6.getString(6);
		String housename=rs6.getString(1);
		String checkin=rs6.getString(2);
		String checkout=rs6.getString(3);
		String change_intro=rs6.getString("change_intro");
		String houseid=rs6.getString(7);
		String quantity=rs6.getString(10);
%>
<table cellpadding="0" cellspacing="0">
  <tr>
    <th scope="col">订单编号</th>
    <th scope="col">房源名称</th>
    <th scope="col">入住时间</th>
    <th scope="col">退房时间</th>
    <th scope="col">交换物品</th>
    <th scope="col">数量</th>
    <th scope="col">操作</th>
  </tr>
  <tr>
    <td><%=orderid%></td>
    <td><%=housename%></td>
    <td><%=checkin%></td>
    <td><%=checkout%></td>
    <td><%=change_intro%></td>
    <td><%=quantity%></td>
    <td>
    	<a href="house_thing.jsp?houseid=<%=houseid%>" target="_blank">查看</a>/
    	<a onclick="del1(<%=orderid%>,2)">删除</a>
    </td>
  </tr>
</table>
<br /><br />
<%}conn6.close();%>

</div>
</li>

</ul>

<%
	String comm=null;
	comm=(String)request.getAttribute("comm");
	if(comm!=null)
	{%>
		<script>
			alert("<%=comm%>");
		</script>
	<%}
%>

</body>
</html>