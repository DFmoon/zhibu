<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>听我说故事</title>
<link rel="shortcut icon" href="imgs/shorticon.png" />
<link rel="stylesheet" type="text/css" href="css/index.css" />
<link rel="stylesheet" type="text/css" href="css/article.css" />
<script type="text/javascript" src="js/jquery.js"></script>
</head>

<body>
<jsp:include   page="login.jsp" flush="true"/>

<% 
		String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";  
		String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=zhibu";    
		String userName="sa";    
		String userPwd="12345678"; 
		Class.forName(driverName);  
		Connection conn=DriverManager.getConnection(dbURL,userName,userPwd);
		Statement stmt = conn.createStatement();
	
		request. setCharacterEncoding("UTF-8");		//统一字符编码！！！！
		String articleid=(String)request.getParameter("articleid");
		
		String sql="select * from article where articleid='"+articleid+"'";
		
		ResultSet rs = stmt.executeQuery(sql);
		
		String pic=null;
		String title=null;
		String author=null;
		String replydate=null;
		String acontent=null;
			
		if(rs.next())
		{
			pic=rs.getString(1);
			title=rs.getString(2);
			author=rs.getString(3);
			replydate=rs.getString(4);
			acontent=rs.getString(5);
		}
	%>

<div id="pic">
	<img src="<%=pic%>" width="100%" height="350" />
</div>


<div id="word">
	<span class="span1"><%=title%></span><br />
    <span class="span2">作者:<%=author%>&nbsp;&nbsp;&nbsp;发表于<%=replydate%></span>
    <article>
    	<%=acontent%>
    </article>
</div>


<div id="bottom">
	<br /><br />
	友情链接：<a href="http://www.cnsfk.com/" target="_blank">沙发客网</a>&nbsp;|&nbsp;<a href="http://ljianren.com/" target="_blank">脚步网</a>&nbsp;|&nbsp;<a href="http://www.sfkkkkkkkkk.com/" target="_blank">9K沙发客</a>&nbsp;|&nbsp;<a href="https://www.couchsurfing.com/" target="_blank">couchsurfing</a>&nbsp;|&nbsp;<a href="https://zh.airbnb.com/?af=15514385&c=baidu_generic_src_demand_Couch_p1&src=Baidu&medium=PPC&ag_kwid=2299-1-d76949114ea8bcf2.f4e18b323971e388" target="_blank">Airbnb</a>&nbsp;|&nbsp;<a href="http://www.tuniu.com/?p=14183&cmpid=mkt_03029701&utm_campaign=daohang&utm_source=2345.com&utm_medium=display" target="_blank">途牛旅游</a>&nbsp;|&nbsp;<a href="http://www.lvye.cn/" target="_blank">绿野户外</a>&nbsp;|&nbsp;<a href="http://www.qyer.com/" target="_blank">穷游网</a>&nbsp;|&nbsp;<a href="http://www.12306.cn/mormhweb/" target="_blank">12306</a>
    <br /><br />
    版权归属：&copy;广西大学计算机与电子信息学院电子商务系2013级（1）班&nbsp;沈东风
</div>


</body>
</html>
