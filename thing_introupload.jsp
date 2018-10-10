<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>上传交易物品</title>
<link rel="stylesheet" type="text/css" href="css/index.css" />
<script type="text/javascript" src="js/jquery.js"></script>
</head>
<style>
#uptop{ width:100%; height:100px; margin-top:80px; text-align:center;}
#uptop span{ font-family:"宋体"; color:#0b579f; font-size:26px; line-height:80px;}
#thing_intro{ width:600px; height:300px; text-align:left; margin-left:380px; margin-top:20px; margin-bottom:20px;}
#thing_intro textarea{ width:600px; height:200px; font-family:"宋体"; color:#666; font-size:18px; line-height:30px;}
#thing_intro input{ margin-top:20px; margin-left:250px;}
</style>
<body>
<jsp:include   page="login.jsp" flush="true"/>
<%
	request. setCharacterEncoding("UTF-8");		//统一字符编码！！！！
	String houseid=request.getParameter("houseid");
	if(houseid==null)
	{
		houseid=(String)request.getAttribute("houseid");
	}
%>
<div id="uptop">
  <span>交易物品文字描述</span><br />
</div>
<form id="thing_intro" method="post" action="/add_thing?houseid=<%=houseid%>">
<textarea name="change_intro"></textarea>
<input type="submit" class="btn" value="确定上传" />
</form>

<div  style="clear:both;"></div>
<div id="bottom">
	<br /><br />
	友情链接：<a href="http://www.cnsfk.com/" target="_blank">沙发客网</a>&nbsp;|&nbsp;<a href="http://ljianren.com/" target="_blank">脚步网</a>&nbsp;|&nbsp;<a href="http://www.sfkkkkkkkkk.com/" target="_blank">9K沙发客</a>&nbsp;|&nbsp;<a href="https://www.couchsurfing.com/" target="_blank">couchsurfing</a>&nbsp;|&nbsp;<a href="https://zh.airbnb.com/?af=15514385&c=baidu_generic_src_demand_Couch_p1&src=Baidu&medium=PPC&ag_kwid=2299-1-d76949114ea8bcf2.f4e18b323971e388" target="_blank">Airbnb</a>&nbsp;|&nbsp;<a href="http://www.tuniu.com/?p=14183&cmpid=mkt_03029701&utm_campaign=daohang&utm_source=2345.com&utm_medium=display" target="_blank">途牛旅游</a>&nbsp;|&nbsp;<a href="http://www.lvye.cn/" target="_blank">绿野户外</a>&nbsp;|&nbsp;<a href="http://www.qyer.com/" target="_blank">穷游网</a>&nbsp;|&nbsp;<a href="http://www.12306.cn/mormhweb/" target="_blank">12306</a>
    <br /><br />
    版权归属：&copy;广西大学计算机与电子信息学院电子商务系2013级（1）班&nbsp;沈东风
</div>
<%
request. setCharacterEncoding("UTF-8");
String ch=null;
ch=(String)request.getAttribute("ch");
if(ch!=null)
{%>
	<script>
		alert("<%=ch%>");
	</script>
<%}
%>
</body>
</html>