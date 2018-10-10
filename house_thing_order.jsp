<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>订单详情</title>
<link rel="stylesheet" type="text/css" href="css/index.css" />
<link rel="stylesheet" type="text/css" href="css/house_order.css" />
<script type="text/javascript" src="js/jquery.js"></script>
</head>
<script>
function back(houseid,thingid)
{
	document.location="house.jsp?houseid="+houseid+"&thingid="+thingid;
}
/*数量框输入*/  
function keyup(){  
    var quantity = document.getElementById("quantity").value;  
    if(isNaN(quantity) ||  parseInt(quantity)!=quantity || parseInt(quantity)<1){  
        quantity = 1;  
        return;  
    }   
}   
/*数量+1*/  
function numAdd(rest){  
    var quantity = document.getElementById("quantity").value;  
    var num_add = parseInt(quantity)+1;
	if(num_add>rest){  
    	document.getElementById("quantity").value=num_add-1;  
        alert("不得大于剩余数量"+rest);
	 }else{    
    	document.getElementById("quantity").value=num_add;  
	 }
}  
/*数量-1*/  
function numDec(){  
    var quantity = document.getElementById("quantity").value;  
    var num_dec = parseInt(quantity)-1;  
    if(num_dec>0){  
        document.getElementById("quantity").value=num_dec;  
    }  
}    
</script>
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
	String houseid=request.getParameter("houseid");
	String thingid=request.getParameter("thingid");
	String checkin=request.getParameter("checkin");
	String checkout=request.getParameter("checkout");
	
	String sql="select * from houseinfo2 where houseid='"+houseid+"'";
	ResultSet rs = stmt.executeQuery(sql);
	
	String change_intro=null;
	String housename=null;
	String house_owner=null;
	String address1=null;
	String address2=null;
	String address3=null;
	int rest=0;
		
	if(rs.next())
	{
		change_intro=rs.getString("change_intro");
		housename=rs.getString("housename");
		house_owner=rs.getString("house_owner");
		address1=rs.getString("address1");
		address2=rs.getString("address2");
		address3=rs.getString("address3");
		rest=rs.getInt("rest");
	}		
%>

<div id="ortop">
  <span>订单详情</span><br />
  <span style="color:#F00; font-size:12px; line-height:20px;">（建议与房东联系后再行订购）</span>
</div>
<form id="order_detail" method="post" action="/add_order2?houseid=<%=houseid%>&thingid=<%=thingid%>">
	<label>房源名称：<input name="housename" value="<%=housename%>" readonly="readonly" /></label><br />
    <label>地址：<input name="address" value="<%=address1%><%=address2%><%=address3%>" readonly="readonly" /></label><br />
    <label>房东：<input name="house_owner" value="<%=house_owner%>" readonly="readonly" /></label><br />
    <label>交换物品：<input name="change_intro" value="<%=change_intro%>" readonly="readonly" /></label><br />
    <label>数量：
    	<span style="cursor:pointer;" onclick="numDec()">-</span> 
        <input name="quantity" id="quantity" style="width:30px; text-align:center; color:#000;" value="1" readonly="readonly" />
        <span style="cursor:pointer;" onclick="numAdd(<%=rest%>)">+</span>
    </label><br />
    <label>入住时间：<input name="checkin" value="<%=checkin%>" readonly="readonly" /></label><br />
    <label>退房时间：<input name="checkout" value="<%=checkout%>" readonly="readonly" /></label><br /><br /><br />
    
	<input type="submit" class="btn" style="margin-left:120px; width:80px;" value="生成订单" />
    <input type="button" class="btn" style="margin-left:80px; width:80px;" value="返回修改" onclick="back(<%=houseid%>,<%=thingid%>)" />
</form>


<div  style="clear:both;"></div>
<div id="bottom">
	<br /><br />
	友情链接：<a href="http://www.cnsfk.com/" target="_blank">沙发客网</a>&nbsp;|&nbsp;<a href="http://ljianren.com/" target="_blank">脚步网</a>&nbsp;|&nbsp;<a href="http://www.sfkkkkkkkkk.com/" target="_blank">9K沙发客</a>&nbsp;|&nbsp;<a href="https://www.couchsurfing.com/" target="_blank">couchsurfing</a>&nbsp;|&nbsp;<a href="https://zh.airbnb.com/?af=15514385&c=baidu_generic_src_demand_Couch_p1&src=Baidu&medium=PPC&ag_kwid=2299-1-d76949114ea8bcf2.f4e18b323971e388" target="_blank">Airbnb</a>&nbsp;|&nbsp;<a href="http://www.tuniu.com/?p=14183&cmpid=mkt_03029701&utm_campaign=daohang&utm_source=2345.com&utm_medium=display" target="_blank">途牛旅游</a>&nbsp;|&nbsp;<a href="http://www.lvye.cn/" target="_blank">绿野户外</a>&nbsp;|&nbsp;<a href="http://www.qyer.com/" target="_blank">穷游网</a>&nbsp;|&nbsp;<a href="http://www.12306.cn/mormhweb/" target="_blank">12306</a>
    <br /><br />
    版权归属：&copy;广西大学计算机与电子信息学院电子商务系2013级（1）班&nbsp;沈东风
</div>

</body>
</html>