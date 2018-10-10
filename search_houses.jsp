<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>房源搜索</title>
<link rel="shortcut icon" href="imgs/shorticon.png" />
<link rel="stylesheet" type="text/css" href="css/index.css" />
<link rel="stylesheet" type="text/css" href="css/zhibu.css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery-1.5.1.js"></script>
<script type="text/javascript" src="js/zhibu.js"></script>

</head>

<body>

<jsp:include   page="login.jsp" flush="true"/>

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
	String str1=request.getParameter("province");
	String str2=request.getParameter("city"); 
	
	String sql1="select * from houseinfo1 where address1='"+str1+"' and address2='"+str2+"'";
	String sql2="select * from houseinfo2 where address1='"+str1+"' and address2='"+str2+"'";
	
    ResultSet rs1 = stmt1.executeQuery(sql1);
	ResultSet rs2 = stmt2.executeQuery(sql2);

%>

<!--明码标价-->
<div id="title1">
	<span>明码标价</span>
</div>
<div style="clear:both;"></div>
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
        <li>
        	<div class="houseimg1">
            	<a href="house.jsp?houseid=<%=houseid1%>" target="_blank"><img src="<%=spic1%>" width="100%" height="250" /></a>
            </div>
        	<div class="houseword">
            	<a href="house.jsp?houseid=<%=houseid1%>" target="_blank">
                <span class="span1"><span style="font-size:24px;"><%=address12%></span>&nbsp;<%=short_intro1%></span>
                <span class="span2"><%=aa%></span><span class="span3">￥<%=univalent1%>/晚</span>
            	</a>
            </div>
        </li>
       <%}
	   conn1.close();%>
	</ul>
</div>


<!--以物易房-->
<div id="title2" style="margin-top:0;">
	<span>以物易房</span>
</div>
<div style="clear:both;"></div>
<div id="house2">
     <ul>
      <%
    	 while(rs2.next())
     	{
			 String spic2=rs2.getString(10);
			 String address22=rs2.getString(13);
			 String short_intro2=rs2.getString(3);
			 String change_intro=rs2.getString(4);
			 String houseid2=rs2.getString(15);
	%>		
        <li>
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
        </li>
       <%}
		conn2.close();%>
    </ul>
</div>

<div style="clear:both;"></div>



<div id="bottom">
	<br /><br />
	友情链接：<a href="http://www.cnsfk.com/" target="_blank">沙发客网</a>&nbsp;|&nbsp;<a href="http://ljianren.com/" target="_blank">脚步网</a>&nbsp;|&nbsp;<a href="http://www.sfkkkkkkkkk.com/" target="_blank">9K沙发客</a>&nbsp;|&nbsp;<a href="https://www.couchsurfing.com/" target="_blank">couchsurfing</a>&nbsp;|&nbsp;<a href="https://zh.airbnb.com/?af=15514385&c=baidu_generic_src_demand_Couch_p1&src=Baidu&medium=PPC&ag_kwid=2299-1-d76949114ea8bcf2.f4e18b323971e388" target="_blank">Airbnb</a>&nbsp;|&nbsp;<a href="http://www.tuniu.com/?p=14183&cmpid=mkt_03029701&utm_campaign=daohang&utm_source=2345.com&utm_medium=display" target="_blank">途牛旅游</a>&nbsp;|&nbsp;<a href="http://www.lvye.cn/" target="_blank">绿野户外</a>&nbsp;|&nbsp;<a href="http://www.qyer.com/" target="_blank">穷游网</a>&nbsp;|&nbsp;<a href="http://www.12306.cn/mormhweb/" target="_blank">12306</a>
    <br /><br />
    版权归属：&copy;广西大学计算机与电子信息学院电子商务系2013级（1）班&nbsp;沈东风
</div>


</body>
</html>