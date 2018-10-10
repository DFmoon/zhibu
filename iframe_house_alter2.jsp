<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link rel="stylesheet" type="text/css" href="css/index.css" />
<link rel="stylesheet" type="text/css" href="css/iframe_house_alter1.css" />
<script type="text/javascript" src="js/zhibu.js"></script>
<script type="text/javascript" src="js/jquery.js"></script>
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
	
	request. setCharacterEncoding("UTF-8");
	String houseid=(String)request.getParameter("houseid");
	
	String sql="select * from houseinfo2 where houseid='"+houseid+"'";
	ResultSet rs = stmt.executeQuery(sql);
	
	String change_intro=null;
	String housename=null;
	String intro=null;
	String short_intro=null;
	String address1=null;
	String address2=null;
	String address3=null;
	String house_owner=null;
	String rest=null;
		
	if(rs.next())
	{
		change_intro=rs.getString("change_intro");
		housename=rs.getString("housename");
		intro=rs.getString("intro");
		short_intro=rs.getString("short_intro");
		address1=rs.getString("address1");
		address2=rs.getString("address2");
		address3=rs.getString("address3");
		house_owner=rs.getString("house_owner");
		rest=rs.getString("rest");
	}
%>
<form action="/alter_houseinfo?houseid=<%=houseid%>&housetable=2" method="post">
	<label>房东</label>
    	<input name="house_owner" value="<%=house_owner%>" readonly="readonly" /><br /><br />
    <label>房名</label>
    	<input type="text" name="housename" value="<%=housename%>" /><br /><br />
    <input name="ifall" type="radio" value="1" style="width:15px; height:15px; margin-left:120px;" /><label>整套房子</label>
    <input name="ifall" type="radio" value="0" style="width:15px; height:15px;" /><label>独立房间</label><br /><br />
    <label>所需物件</label>
    	<input type="text" name="change_intro" value="<%=change_intro%>"  /><br /><br />
    <label>剩余数量</label>
		<input name="rest" type="text" value="<%=rest%>" /><br /><br />
    <label>房源概述</label>
    	<input type="text" name="short_intro" value="<%=short_intro%>" placeholder="请用一句话概括您的小屋" /><br /><br />
    <label>地址</label>
    	<select name="province" id="s1" ><option></option></select>   
    	<select name="city" id="s2" onchange="getvalue()">   <option></option></select>   
        <script language="javascript">   setup(); 	</script>
    	<input type="text" name="address3" value="<%=address3%>" placeholder="详细地址"  /><br /><br />
    <label>房屋详情</label>
    	<textarea name="intro" ><%=intro%></textarea><br /><br />
        <input type="submit" style="width:100px; display:inline-block; margin-left:350px;" class="btn" value="确定上传" /><br /><br />
</form>
</body>
</html>