<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>房源信息</title>
<link rel="shortcut icon" href="imgs/shorticon.png" />
<link rel="stylesheet" type="text/css" href="css/index.css" />
<link rel="stylesheet" type="text/css" href="css/house.css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/jscript" src="js/jquery-1.5.1.js"></script>
<script type="text/jscript" src="js/zhibu.js"></script>
<script type="text/javascript" src="http://api.map.baidu.com/api?key=&v=1.1&services=true"></script>
<script>
	$(document).ready(function(e) {			
		t = $('#list .div_1').offset().top;
		fh = $('#list .div_1').height();
		$(window).scroll(function(e){
			s = $(document).scrollTop();	
			if(s > t - 60){
				$('#list .div_1').css('position','fixed');			
			}else{
				$('#list .div_1').css('position','');
			}
		})
	});
	
function up(houseid,thingid,rest)
{
	if(thingid==null)
	{
		if(window.confirm("订购之前需要上传您的交易物品哦！"))
		{
   			document.location="thing_introupload.jsp?houseid="+houseid;
		}
	}else
	{
		
		if(rest==0)
		{
			alert("剩余数量："+rest+",无法订购！");
		}else
		{
			alert("剩余数量："+rest);
			$("#form1").submit();
		}
	}
}
</script>
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
	Connection conn1=DriverManager.getConnection(dbURL,userName,userPwd);
	Statement stmt1 = conn1.createStatement();

	request. setCharacterEncoding("UTF-8");		//统一字符编码！！！！
	String houseid=request.getParameter("houseid");
	if(houseid==null)
	{
		houseid=(String)request.getAttribute("houseid");
	}
	String thingid=(String)request.getAttribute("thingid");
	
	String sql="select * from houseinfo2,userinfo where houseinfo2.house_owner=userinfo.username and houseinfo2.houseid='"+houseid+"'";
	String sql1="select * from comment,userinfo where comment.email=userinfo.email and comment.housetable='2' and comment.houseid='"+houseid+"'";
	ResultSet rs = stmt.executeQuery(sql);
	ResultSet rs1 = stmt1.executeQuery(sql1);
	
	String bpic=null;
	String change_intro=null;
	String housename=null;
	String intro=null;
	String address1=null;
	String address2=null;
	String address3=null;
	String icon=null;
	String username=null;
	String sex=null;
	String phone=null;
	String email=null;
	int rest=0;
		
	if(rs.next())
	{
		bpic=rs.getString("bpic");
		change_intro=rs.getString("change_intro");
		housename=rs.getString("housename");
		intro=rs.getString("intro");
		address1=rs.getString("address1");
		address2=rs.getString("address2");
		address3=rs.getString("address3");
		icon=rs.getString("icon");
		username=rs.getString("username");
		sex=rs.getString("sex");
		phone=rs.getString("phone");
		email=rs.getString("email");
		rest=rs.getInt("rest");
	}	
%>

<jsp:include   page="login.jsp" flush="true"/>


<div id="pic">
	<img src="<%=bpic%>" width="100%" height="350" />
</div>


<div id="list">
	<div class="div_1">
    	<div class="top"><%=change_intro%></div>
        <form id="form1" method="post" action="house_thing_order.jsp?houseid=<%=houseid%>&thingid=<%=thingid%>">
        <div>
			<script>
				$(function () {
					$("#txtBeginDate").calendar({
						controlId: "divDate",                                 // 弹出的日期控件ID，默认: $(this).attr("id") + "Calendar"
						speed: 200,                                           // 三种预定速度之一的字符串("slow", "normal", or "fast")或表示动画时长的毫秒数值(如：1000),默认：200
						complement: true,                                     // 是否显示日期或年空白处的前后月的补充,默认：true
						readonly: true,                                       // 目标对象是否设为只读，默认：true
						upperLimit: NaN,                               // 日期上限，默认：NaN(不限制)
						lowerLimit: new Date(),                   // 日期下限，默认：NaN(不限制)
						callback: function () {                               // 点击选择日期后的回调函数
						}
					});
					$("#txtEndDate").calendar();
				});
    		</script>
            <input id="txtBeginDate" name="checkin" style=" margin-bottom:20px;width:190px; height:36px; border:1px solid #ccc; text-align:center;" placeholder="入住时间"/>
    		<input id="txtEndDate" name="checkout" style="width:190px; height:36px; border:1px solid #ccc; text-align:center;" placeholder="退房时间" />
		</div>
        <div style="margin-top:20px;">
        	<a class="btn" style="cursor:pointer;" onclick="up(<%=houseid%>,<%=thingid%>,<%=rest%>)">立即交换</a>&nbsp;&nbsp;
    		<a href="/collection?houseid=<%=houseid%>&housetable=2" class="btn">加入收藏</a>
        </div>
        </form>
    </div>
</div>


<div id="content">
	<div class="house_name">
    	<span><%=housename%></span>
    </div>
    
	<div class="title">
    	<span>房主</span>
    </div>
    <div class="house_holder">
    	<div class="pic">
    		<img src="<%=icon%>" width="100%" height="100%" />
        </div>
        <div class="word">
        	<p><%=username%>&nbsp;&nbsp;<%=sex%></p>
            <p>联系电话：<%=phone%></p>
            <p>邮箱地址：<%=email%></p>
        </div>
    </div>
    
    <div class="title">
    	<span>房屋介绍</span>
    </div>
    <div class="house_info">
    	<p>
        	<%=intro%>
        </p>
    </div>
    
    <div class="title">
    	<span>具体位置</span>
    </div>
    <div class="house_address">
    	<p>地址：<%=address1%><%=address2%><%=address3%> </p>
    </div>
    
    <div class="title">
    	<span>评价</span>
    </div>
    <div class="communication">
        <%
		while(rs1.next())
		{
			String icon1=rs1.getString("icon");
			String username1=rs1.getString("username");
			String comment_date=rs1.getString("comment_date");
			String comment=rs1.getString("comment");
			
	%>
        <div class="commu">
            <div class="commu_top">
                <div class="commu_top_pic">
                    <img src="<%=icon1%>" width="100%" height="100%" />
                </div>
                <div class="commu_top_name">
                    <span class="span3"><%=username1%></span>
                    <span class="span4"><%=comment_date%></span>
                </div>
            </div>
            <div class="commu_middle">
                <p>
                    <%=comment%>
                </p>
            </div>
            <div class="commu_bottom">
                <img src="imgs/article_zan.gif" width="24" height="24" />&nbsp;
                <img src="imgs/article_cai.gif" width="24" height="24" />
            </div>
        </div>
    <%}conn1.close();%> 
    </div>
</div>

<div  style="clear:both;"></div>
<div id="bottom">
	<br /><br />
	友情链接：<a href="http://www.cnsfk.com/" target="_blank">沙发客网</a>&nbsp;|&nbsp;<a href="http://ljianren.com/" target="_blank">脚步网</a>&nbsp;|&nbsp;<a href="http://www.sfkkkkkkkkk.com/" target="_blank">9K沙发客</a>&nbsp;|&nbsp;<a href="https://www.couchsurfing.com/" target="_blank">couchsurfing</a>&nbsp;|&nbsp;<a href="https://zh.airbnb.com/?af=15514385&c=baidu_generic_src_demand_Couch_p1&src=Baidu&medium=PPC&ag_kwid=2299-1-d76949114ea8bcf2.f4e18b323971e388" target="_blank">Airbnb</a>&nbsp;|&nbsp;<a href="http://www.tuniu.com/?p=14183&cmpid=mkt_03029701&utm_campaign=daohang&utm_source=2345.com&utm_medium=display" target="_blank">途牛旅游</a>&nbsp;|&nbsp;<a href="http://www.lvye.cn/" target="_blank">绿野户外</a>&nbsp;|&nbsp;<a href="http://www.qyer.com/" target="_blank">穷游网</a>&nbsp;|&nbsp;<a href="http://www.12306.cn/mormhweb/" target="_blank">12306</a>
    <br /><br />
    版权归属：&copy;广西大学计算机与电子信息学院电子商务系2013级（1）班&nbsp;沈东风
</div>

<%
request. setCharacterEncoding("UTF-8");
String cc=null;
String pic=null;
String ff=null;
cc=(String)request.getAttribute("cc");
pic=(String)request.getAttribute("pic");
ff=(String)request.getAttribute("ff");
if(cc!=null)
{%>
	<script>
		alert("<%=cc%>");
	</script>
<%}
if(pic!=null)
{%>
	<script>
		alert("<%=pic%>");
	</script>
<%}
if(ff!=null)
{%>
	<script>
		alert("<%=ff%>");
	</script>
<%}
%>
</body>
</html>
