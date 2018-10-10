<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>修改密码</title>
<link rel="stylesheet" type="text/css" href="css/index.css" />
<link rel="stylesheet" type="text/css" href="css/alter_password.css" />
<script type="text/javascript" src="js/jquery.js"></script>
</head>

<body>

<jsp:include   page="login.jsp" flush="true"/>

<div id="aptop">
	<span>修改密码</span>
</div>


<div id="apbottom">
	<form action="/alter_password" method="post" >
   		<span>注册邮箱</span><input type="email" name="email" required="required" /><br /><br />
    	<span>原密码</span><input type="password" name="yp" /><br /><br />
        <span>新密码</span><input type="password" name="xp" /><br /><br />
        <span>确认密码</span><input type="password" name="xxp" /><br /><br /><br /><br />
        <input id="sub" type="submit" style="width:100px; display:inline-block; margin-right:50px; margin-left:40px;" class="btn" value="确认修改" />
        <a href="find_password1.jsp" class="btn" style="width:80px; display:inline-block;">忘记密码</a>
    </form>
</div>


<%
String str=(String)request.getAttribute("z");
if(str!=null){%>
  	<script type="text/javascript">
		alert("<%=str%>");
	</script>
<%}%> 



<div  style="clear:both;"></div>
<div id="bottom">
	<br /><br />
	友情链接：<a href="http://www.cnsfk.com/" target="_blank">沙发客网</a>&nbsp;|&nbsp;<a href="http://ljianren.com/" target="_blank">脚步网</a>&nbsp;|&nbsp;<a href="http://www.sfkkkkkkkkk.com/" target="_blank">9K沙发客</a>&nbsp;|&nbsp;<a href="https://www.couchsurfing.com/" target="_blank">couchsurfing</a>&nbsp;|&nbsp;<a href="https://zh.airbnb.com/?af=15514385&c=baidu_generic_src_demand_Couch_p1&src=Baidu&medium=PPC&ag_kwid=2299-1-d76949114ea8bcf2.f4e18b323971e388" target="_blank">Airbnb</a>&nbsp;|&nbsp;<a href="http://www.tuniu.com/?p=14183&cmpid=mkt_03029701&utm_campaign=daohang&utm_source=2345.com&utm_medium=display" target="_blank">途牛旅游</a>&nbsp;|&nbsp;<a href="http://www.lvye.cn/" target="_blank">绿野户外</a>&nbsp;|&nbsp;<a href="http://www.qyer.com/" target="_blank">穷游网</a>&nbsp;|&nbsp;<a href="http://www.12306.cn/mormhweb/" target="_blank">12306</a>
    <br /><br />
    版权归属：&copy;广西大学计算机与电子信息学院电子商务系2013级（1）班&nbsp;沈东风
</div>


</body>
</html>