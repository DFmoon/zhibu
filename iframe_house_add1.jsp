<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link rel="stylesheet" type="text/css" href="css/index.css" />
<link rel="stylesheet" type="text/css" href="css/iframe_house_alter1.css" />
<script type="text/javascript" src="js/zhibu.js"></script>
</head>

<body>
<%
	request. setCharacterEncoding("UTF-8");
	String username=null;
    username=(String)session.getAttribute("userInfo");
%>
<form action="/add_houseinfo1" method="post">
	<label>房东</label>
    	<input name="house_owner" value="<%=username%>" readonly="readonly" /><br /><br />
    <label>房名</label>
    	<input type="text" name="housename" /><br /><br />
    <input name="ifall" type="radio" value="1" checked="checked" style="width:15px; height:15px; margin-left:120px;" /><label>整套房子</label>
    <input name="ifall" type="radio" value="0" style="width:15px; height:15px;" /><label>独立房间</label><br /><br />
    <label>价格</label>
    	<input type="text" name="univalent"  /><label>元/每晚</label><br /><br />
    <label>剩余数量</label>
		<input name="rest" type="text" value="1" /><br /><br />
    <label>房源概述</label>
    	<input type="text" name="short_intro" placeholder="请用一句话概括您的小屋" /><br /><br />
    <label>地址</label>
    	<select name="province" id="s1" ><option></option></select>   
    	<select name="city" id="s2" onchange="getvalue()">   <option></option></select>   
        <script language="javascript">   setup(); 	</script>
    	<input type="text" name="address3" placeholder="详细地址"  /><br /><br />
    <label>房屋详情</label>
    	<textarea name="intro"></textarea><br /><br />
        <input type="submit" style="width:100px; display:inline-block; margin-left:350px;" class="btn" value="确定上传" /><br /><br />
</form>

</body>
</html>