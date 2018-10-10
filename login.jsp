<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<script>
	function login_show()
	{
		$("#hbg").show();
		$("#login").fadeIn(600);
	}
	function login_clear()
	{
		$("#login").fadeOut(600);
		$("#hbg").hide();
	}
	function reg_show()
	{
		$("#hbg").show();
		$("#reg").fadeIn(600);
	}
	function reg_clear()
	{
		$("#reg").fadeOut(600);
		$("#hbg").hide();
	}
	function behouser_show()
	{
		$("#hbg").show();
		$("#behouser").fadeIn(600);
	}
	function behouser_clear()
	{
		$("#behouser").fadeOut(600);
		$("#hbg").hide();
	}
	function changeusername(username)
	{
		var top=document.getElementById('top');
		var top_span=top.getElementsByTagName("span")[0];
		var top_span_div0=top_span.getElementsByTagName("div")[0];
		var a=document.createElement("a");
		a.href="person.jsp";
		var textNode=document.createTextNode(username+"欢迎登录！");
		while(top_span_div0.firstChild) 
		{
        	top_span_div0.removeChild(top_span_div0.firstChild);
		}
		a.appendChild(textNode);
		top_span_div0.appendChild(a);
	}

</script>

<a href="#back" style="position:fixed; right:20px; bottom:20px; z-index:1000;"><img src="imgs/back.png" width="50" height="70" /></a>
<div id="back"></div>


<div id="top">
	<img src="imgs/logo.png" width="183" height="55" />
	<span>
    	<div style="display:inline-block; height:60px; width:150px;">
        	<a name="login" href="#" onClick="login_show()">登录</a>&nbsp;&nbsp;
        	<a name="reg" href="#" onClick="reg_show()">注册</a>&nbsp;&nbsp;
        </div>
        <div style="display:inline-block; width:100px;">
        	<a name="behouser" href="#" onclick="behouser_show()">成为房东</a>&nbsp;&nbsp;
        </div>
        <div style="display:inline-block"><a name="conmm" href="zhibu.jsp">首页</a></div>
    </span>
</div>
<br /><br />

<div id="hbg"></div>
<div id="login">
	<div id="lstop" class="clear" onClick="login_clear()">×</div>
    <div class="title">用户登录</div>
    <form action="/loginServlet" method="post">
		<span class="user">邮箱：</span>
        <input name="email" type="email" autofocus placeholder="请输入邮箱地址" required />
        <span class="must">*</span><br /><br /><br />
        <span class="user">密码：</span>
        <input name="password" type="password" required placeholder="密码不得少于6位">
        <span class="must">*</span>
        <input type="submit" value="确定" class="btn" style="width:80px; height:30px; display:inline-block; margin-top:30px; margin-right:40px;" />
         <a href="find_password1.jsp" class="btn" style="width:60px; height:17px; display:inline-block; margin-top:30px;">忘记密码</a>
	</form>
</div>

<div id="reg">
	<div class="clear" onClick="reg_clear()">×</div>
    <div class="title">用户注册</div>
    <form action="/regServlet" method="post">
		<span class="user">用户名：</span>
        <input name="username" type="text" autofocus placeholder="请输入用户名" required />
        <span class="must">*</span><br /><br />
        <span class="user">邮箱：</span>
        <input name="email" type="email" autofocus placeholder="请输入邮箱地址" required />
        <span class="must">*</span><br /><br />
        <span class="user">密码：</span>
        <input name="password" type="password" required placeholder="密码不得少于6位">
        <span class="must">*</span><br /><br />
        <span class="user">密码问题：</span>
        <input list="question" name="question" required placeholder="请选择或输入密码问题" />
			<datalist id="question">
				<option value="父亲的名字">
				<option value="最喜欢的颜色">
				<option value="最爱的电影">
			</datalist>
        <span class="must">*</span><br /><br />
        <span class="user">问题答案：</span>
        <input name="answer" type="text" required />
        <span class="must">*</span>
        <input type="submit" value="确定" class="btn" style="width:80px; height:30px; display:inline-block; margin-top:20px; margin-right:40px;" />
        <input type="button" value="重置" class="btn" style="width:80px; height:30px; display:inline-block; margin-top:20px;" />
	</form>
</div>


<%
	String mess=null;
    mess=(String)session.getAttribute("userInfo");
	String email=(String)session.getAttribute("email");
	String mess2=(String)request.getAttribute("x");
	String mess3=(String)request.getAttribute("y");
    if("".equals(mess) || mess==null){ 
		if(mess2 != null){%>  
  			<script type="text/javascript">
				alert("<%=mess2%>");
			</script>            	
    	<%}
	}
 
 else{
	 request.setAttribute("email",email);
	 %>
    <script type="text/javascript">
		var str="<%=mess%>";
		changeusername(str);
	</script>

<% }
	
	if(mess3 !=null){%>
    	<script type="text/javascript">
			alert("<%=mess3%>");
		</script>
    <%}%>  

<div id="behouser">
	<div class="clear" onClick="behouser_clear()">×</div>
    <div class="title">成为房东</div>
    <form action="/behouser" method="post">
		<span class="user">您是否确定申请成为房东？</span><br /><br />
        <input type="submit" value="确定" class="btn" style="width:80px; height:30px; display:inline-block; margin-top:20px; margin-right:40px;" />
        <input type="button" value="取消" class="btn" onclick="behouser_clear()" style="width:80px; height:30px; display:inline-block; margin-top:20px;" />
	</form>
</div>