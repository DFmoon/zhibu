<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>个人信息</title>
<link rel="shortcut icon" href="imgs/shorticon.png" />
<link rel="stylesheet" type="text/css" href="css/index.css" />
<link rel="stylesheet" type="text/css" href="css/person.css" />
<script type="text/javascript" src="js/jquery.js"></script>
</head>
<body>

<jsp:include   page="login.jsp" flush="true"/>

<div id="pic">
	<img src="imgs/person_1.jpg" width="100%" height="350" />
    <% 
		String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";  
		String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=zhibu";    
		String userName="sa";    
		String userPwd="12345678"; 
		Class.forName(driverName);  
		Connection conn=DriverManager.getConnection(dbURL,userName,userPwd);
		Statement stmt = conn.createStatement();	
	
		request. setCharacterEncoding("UTF-8");		//统一字符编码！！！！
		String email=(String)request.getAttribute("email");
		
		String sql="select * from userinfo where email='"+email+"'";
		
		ResultSet rs = stmt.executeQuery(sql);

		if(rs.next())
		{
			String username=rs.getString(1);
			String icon=rs.getString(13);
	%>
    <div class="icon">
    	<img src="<%=icon%>" width="100%" height="100%" />
    </div>
    <div class="name">
    	<span><%=username%></span>
    </div>
    <%}
	conn.close();%>
</div>


<div id="list">
	<ul>
    	<a href="iframe_message.jsp" target="kj"><li>我的消息</li></a>
    	<a href="iframe_person_show.jsp" target="kj"><li>个人信息</li></a>
    	<a href="iframe_article_list.jsp" target="kj"><li>我的故事</li></a>
        <a href="iframe_collection.jsp" target="kj"><li>我的收藏</li></a>
        <a href="iframe_house_show.jsp" target="kj"><li>我的小屋</li></a>
        <a href="/checkdate" target="kj"><li>交易记录</li></a>
    </ul>
</div>


<div id="content">
	<iframe id="kj" name="kj" scrolling="auto" src="iframe_message.jsp" >
    </iframe>

</div>


<div  style="clear:both;"></div>
<div id="bottom">
	<br /><br />
	友情链接：<a href="http://www.cnsfk.com/" target="_blank">沙发客网</a>&nbsp;|&nbsp;<a href="http://ljianren.com/" target="_blank">脚步网</a>&nbsp;|&nbsp;<a href="http://www.sfkkkkkkkkk.com/" target="_blank">9K沙发客</a>&nbsp;|&nbsp;<a href="https://www.couchsurfing.com/" target="_blank">couchsurfing</a>&nbsp;|&nbsp;<a href="https://zh.airbnb.com/?af=15514385&c=baidu_generic_src_demand_Couch_p1&src=Baidu&medium=PPC&ag_kwid=2299-1-d76949114ea8bcf2.f4e18b323971e388" target="_blank">Airbnb</a>&nbsp;|&nbsp;<a href="http://www.tuniu.com/?p=14183&cmpid=mkt_03029701&utm_campaign=daohang&utm_source=2345.com&utm_medium=display" target="_blank">途牛旅游</a>&nbsp;|&nbsp;<a href="http://www.lvye.cn/" target="_blank">绿野户外</a>&nbsp;|&nbsp;<a href="http://www.qyer.com/" target="_blank">穷游网</a>&nbsp;|&nbsp;<a href="http://www.12306.cn/mormhweb/" target="_blank">12306</a>
    <br /><br />
    版权归属：&copy;广西大学计算机与电子信息学院电子商务系2013级（1）班&nbsp;沈东风
</div>


</body>
</html>
