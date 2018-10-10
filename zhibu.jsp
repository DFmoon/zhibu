<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>【止步网】在旅途中安家</title>
<link rel="shortcut icon" href="imgs/shorticon.png" />
<link rel="stylesheet" type="text/css" href="css/index.css" />
<link rel="stylesheet" type="text/css" href="css/zhibu.css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery-1.5.1.js"></script>
<script type="text/javascript" src="js/zhibu.js"></script>

</head>
<script>
	window.onload=function()
	{
		var pic=document.getElementById("pic");
		var picture=pic.getElementsByTagName("ul")[0];
		var aLi=picture.getElementsByTagName("li");
		var squares=pic.getElementsByTagName("ul")[1];
		var aLis=squares.getElementsByTagName("li");
		
		for(var i=0;i<aLi.length;i++)
		{
			aLi.index=i;
		}	
		for(var j=0;j<aLis.length;j++)
		{
			aLis[j].onmouseover=function(num){
				return function(){
					startMove(picture,{top:-420*(num)});
				}
			}(j);
		}
		
		var timer=setInterval(next,4000);

		function next()
		{
			aLi.index++;
			if(aLi.index==aLi.length)
			{
				aLi.index=0;
				startMove(picture,{top:0});
			}
			startMove(picture,{top:-420*aLi.index});
		}
			
		pic.onmouseover=function()
		{
			clearInterval(timer);
		};
		pic.onmouseout=function()
		{
			timer=setInterval(next,4000);
		};
	
	};
</script>
<body>

<jsp:include   page="login.jsp" flush="true"/>

<%
	String be=null;
	be=(String)request.getAttribute("be");
	if(be!=null)
	{%>
		<script>
		 alert("<%=be%>");
		</script>
	<%}
%>


<!--图片轮播-->
<div id="pic">
	<ul id="picture">
		<a title="" target="_blank" href="#">
			<li><img src="imgs/zhibu_1.jpg"></li>
		</a>
		<a title="" target="_blank" href="#">
			<li><img src="imgs/zhibu_2.jpg"></li>
		</a>
		<a title="" target="_blank" href="#">
			<li><img src="imgs/zhibu_3.jpg"></li>
		</a>
  		<a title="" target="_blank" href="#">
			<li><img src="imgs/zhibu_4.jpg"></li>
		</a>
	</ul>
	<ul id="squares">
		<a target="_blank" href="#">
			<li></li>
		</a>
		<a target="_blank" href="#">
			<li></li>
		</a>
		<a target="_blank" href="#">
			<li></li>
		</a>
		<a target="_blank" href="#">
			<li></li>
		</a>
	</ul>

    <!--搜索框-->
    <div id="search" style="width:800px; height:80px; position:absolute; left:20%; bottom:100px;
font-family:'微软雅黑','宋体','Arial Narrow';">
        <form method="post" action="/search_houses.jsp" target="_blank">
        <select name="province" id="s1" style="width:170px; height:40px; float:left; margin-top:20px; color:#666; border:1px solid #ccc; text-align:center;" ><option></option></select>   
        <select name="city" id="s2" style="width:170px; height:40px; float:left; margin-top:20px; color:#666; border:1px solid #ccc; text-align:center;" onchange="getvalue()">   <option></option></select>   
        <script language="javascript">   setup(); 	</script> 
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
        <input id="txtBeginDate" style="width:170px; height:38px; float:left; margin-top:20px; border:1px solid #ccc; text-align:center;" placeholder="入住时间"/>
        <input id="txtEndDate" style="width:170px; height:38px; float:left; margin-top:20px; border:1px solid #ccc; text-align:center;" placeholder="退房时间" />
        
        <input id="search_house" type="submit" value="搜索房源" style="width:100px; height:40px; float:left; border:1px solid #0b579f; text-align:center; background-color:#0b579f; color:#FFF; font-weight:bold; font-family:'宋体'; font-size:20px; margin-top:20px;" />
        </form>
    </div>
</div> 


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
	Connection conn3=DriverManager.getConnection(dbURL,userName,userPwd);
	Statement stmt3 = conn3.createStatement();
	Connection conn4=DriverManager.getConnection(dbURL,userName,userPwd);
	Statement stmt4 = conn4.createStatement();
	Connection conn5=DriverManager.getConnection(dbURL,userName,userPwd);
	Statement stmt5 = conn5.createStatement();
	
	Connection conn=DriverManager.getConnection(dbURL,userName,userPwd);
	Statement stmt = conn.createStatement();
	
	String sql1="select * from houseinfo1 where ifshow='1'";
	String sql2="select * from houseinfo2 where ifshow='1'";
	String sql3="select * from article where ifshow='1'";
	String sql4="select * from article where ifshow='2'";
	
    ResultSet rs1 = stmt1.executeQuery(sql1);
	ResultSet rs2 = stmt2.executeQuery(sql2);
	ResultSet rs3 = stmt3.executeQuery(sql3);
	ResultSet rs4 = stmt4.executeQuery(sql4);
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


<!--听我说故事-->
<div id="story">
    <div>
    	<img src="imgs/storytitle.png" width="400" height="80" />
    </div>
    <div class="story_left">
    <ul>
    <%
    	 while(rs3.next())
     	{
			 String title=rs3.getString(2);
			 String author=rs3.getString(3);
			 String acontent=rs3.getString(5);
			 String ifall1=rs3.getString(6);
			 String articleid=rs3.getString(8);
			 String email=rs3.getString(7);
			 String sql5="select * from userinfo where email='"+email+"'";
			 ResultSet rs5 = stmt5.executeQuery(sql5);
			 String icon=null;
			 if(rs5.next())
			 {
				 icon=rs5.getString(13);
			 }	
	%>
    	<li>
        	<div class="story_left_pic">
            	<img src="<%=icon%>" width="100%" height="100%" />
            </div>
            <a href="article.jsp?articleid=<%=articleid%>" target="_blank">
                <div class="story_left_word">
                    <span class="span1">【<%=title%>】</span>
                    <span class="span2">作者：<%=author%></span><br /><br />
                    <p><%=acontent%></p>
                </div>
            </a>
        </li>
    <%}conn3.close();%>    
   	</ul>     
    </div>
    <div class="story_right">
    <%
    	 while(rs4.next())
     	{
			 String pic=rs4.getString(1);
			 String title=rs4.getString(2);
			 String articleid=rs4.getString(8);
	%>		
    	<div>
        	<a href="article.jsp?articleid=<%=articleid%>" target="_blank"><p><%=title%></p></a>
            <a href="article.jsp?articleid=<%=articleid%>" target="_blank"><img src="<%=pic%>" width="320" height="110" /></a>
        </div>
  	<%}
	conn4.close();
	conn5.close();%>
    </div>
</div>


<!--关于我们-->
<div id="about">
	<ul>
    	<li>
        	<span>止步网</span>
            <p>关于我们</p>
            <p>加入我们</p>
            <p>联系我们</p>
            <p>网站声明</p>
        </li>
        <li>
        	<span>发现</span>
            <p>旅游保险</p>
            <p>旅游基金</p>
            <p>出行手册</p>
            <p>&nbsp;</p>
        </li>
        <li>
        	<span>帮助中心</span>
            <p>帮助说明</p>
            <p>网站地图</p>
            <p>新手上路</p>
            <p>旅行贴士</p>
        </li>
    </ul>
</div>


<div id="bottom">
	<br /><br />
	友情链接：<a href="http://www.cnsfk.com/" target="_blank">沙发客网</a>&nbsp;|&nbsp;<a href="http://ljianren.com/" target="_blank">脚步网</a>&nbsp;|&nbsp;<a href="http://www.sfkkkkkkkkk.com/" target="_blank">9K沙发客</a>&nbsp;|&nbsp;<a href="https://www.couchsurfing.com/" target="_blank">couchsurfing</a>&nbsp;|&nbsp;<a href="https://zh.airbnb.com/?af=15514385&c=baidu_generic_src_demand_Couch_p1&src=Baidu&medium=PPC&ag_kwid=2299-1-d76949114ea8bcf2.f4e18b323971e388" target="_blank">Airbnb</a>&nbsp;|&nbsp;<a href="http://www.tuniu.com/?p=14183&cmpid=mkt_03029701&utm_campaign=daohang&utm_source=2345.com&utm_medium=display" target="_blank">途牛旅游</a>&nbsp;|&nbsp;<a href="http://www.lvye.cn/" target="_blank">绿野户外</a>&nbsp;|&nbsp;<a href="http://www.qyer.com/" target="_blank">穷游网</a>&nbsp;|&nbsp;<a href="http://www.12306.cn/mormhweb/" target="_blank">12306</a>
    <br /><br />
    版权归属：&copy;广西大学计算机与电子信息学院电子商务系2013级（1）班&nbsp;沈东风
</div>
<%  
	request. setCharacterEncoding("UTF-8");		//统一字符编码！！！！
	String myemail=(String)session.getAttribute("email");
	String sql="select * from order_message where house_owner_email='"+myemail+"' and message_status='0'";
	if(myemail!=null)
	{
		ResultSet rs=stmt.executeQuery(sql);
		if(rs.next())
		{%>
			<script>
				alert("您有新消息，请及时前往个人中心查看！");
			</script>
		<%}
	}	
%>
</body>
</html>
