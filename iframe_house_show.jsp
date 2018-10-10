<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link rel="shortcut icon" href="imgs/shorticon.png" />
<link rel="stylesheet" type="text/css" href="css/index.css" />
<link rel="stylesheet" type="text/css" href="css/zhibu.css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery-1.5.1.js"></script>
<script type="text/javascript" src="js/zhibu.js"></script>
</head>
<script>
function del(houseid,housetable){
if(window.confirm("您确定要删除吗？"))
	{
   		document.location="/delete_houseinfo?houseid="+houseid+"&housetable="+housetable;
	}
}
function alt(houseid,housetable){
	if(housetable==1)
   	{
		document.location="iframe_house_alter1.jsp?houseid="+houseid;
	}else
	{
		document.location="iframe_house_alter2.jsp?houseid="+houseid;
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

	request. setCharacterEncoding("UTF-8");		//统一字符编码！！！！
	String email=(String)session.getAttribute("email");
	
	String sql1="select * from houseinfo1,userinfo where houseinfo1.house_owner=userinfo.username and userinfo.email='"+email+"'";
	String sql2="select * from houseinfo2,userinfo where houseinfo2.house_owner=userinfo.username and userinfo.email='"+email+"'";

    ResultSet rs1 = stmt1.executeQuery(sql1);
	ResultSet rs2 = stmt2.executeQuery(sql2);

%>


<!--明码标价-->
<div id="house1">
    <ul>
    <%
    	 while(rs1.next())
     	{
			 String spic1=rs1.getString(8);
			 String address12=rs1.getString(12);
			 String short_intro1=rs1.getString(3);
			 String ifall1=rs1.getString(6);
			 String univalent1=rs1.getString(14);
			 String houseid1=rs1.getString(15);
			 String aa;
			 String bb="1";
			 if(ifall1.equals(bb))
			 	{aa="整套房子";}
			 else
				{aa="独立房间";}
	%>		
        <div style="display:inline-block; float:left; margin-right:80px; margin-bottom:20px;">
        <li style="width:260px;">
        	<div class="houseimg1">
            	<a href="house.jsp?houseid=<%=houseid1%>" target="_blank"><img src="<%=spic1%>" width="100%" height="250" /></a>
            </div>
        	<div class="houseword">
            	<a href="house.jsp?houseid=<%=houseid1%>" target="_blank">
                <span class="span1"><span style="font-size:24px;"><%=address12%></span>&nbsp;<%=short_intro1%></span>
                <span class="span2"><%=aa%></span><span class="span3">￥<%=univalent1%>/晚</span>
            	</a>
            </div>
        </li><br /><br />
            <a class="btn" style="display:inline-block; float:left; margin-left:60px; cursor:pointer;" onclick="alt(<%=houseid1%>,1)">编辑</a>
            <a class="btn" style="display:inline-block; float:left; margin-left:40px; cursor:pointer;" onclick="del(<%=houseid1%>,1)">删除</a>
       </div>
       <%}
	   conn1.close();%>
<!--以物易房-->
      <%
    	 while(rs2.next())
     	{
			 String spic2=rs2.getString(10);
			 String address22=rs2.getString(13);
			 String short_intro2=rs2.getString(3);
			 String change_intro=rs2.getString(4);
			 String houseid2=rs2.getString(15);
	%>	
    	<div style="display:inline-block; float:left; margin-right:80px; margin-bottom:20px;">	
        <li style="width:260px;">
        	<div class="houseimg2">
                	<a href="house_thing.jsp?houseid=<%=houseid2%>" target="_blank"><img src="<%=spic2%>" width="100%" height="230" /></a>
                <div class="zhezhao">
                	<p><%=change_intro%></p>
                    <a href="house_thing.jsp?houseid=<%=houseid2%>" target="_blank" class="btn">立即交换</a>
                </div>
            </div>
        	<div class="houseword">
            	<span class="span1">
                	<a href="house_thing.jsp?houseid=<%=houseid2%>" target="_blank"><span style="font-size:24px;"><%=address22%></span></a>
                	<a href="house_thing.jsp?houseid=<%=houseid2%>" target="_blank">&nbsp;<%=short_intro2%></a>
                </span>
            </div>
        </li><br /><br />
            <a class="btn" style="display:inline-block; float:left; margin-left:60px; cursor:pointer;" onclick="alt(<%=houseid2%>,2)">编辑</a>
            <a class="btn" style="display:inline-block; float:left; margin-left:40px; cursor:pointer;" onclick="del(<%=houseid2%>,2)">删除</a>
        </div>
       <%}
		conn2.close();%>
    </ul>
</div>

<a class="btn" href="/ifhouser?email=<%=email%>" target="kj">添加我的小屋</a>

<%
	String ifhouser=null;
	ifhouser=(String)request.getAttribute("ifhouser");
	if(ifhouser!=null)
	{%>
		<script>
			alert("<%=ifhouser%>");
		</script>
	<%}
%>

</body>
</html>