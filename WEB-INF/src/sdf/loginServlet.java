package sdf;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class loginServlet extends HttpServlet {
	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws IOException,ServletException{
		
		String email=request.getParameter("email");//获取参数
		String password=request.getParameter("password");
		
		SqlHelper asql=new SqlHelper();//建立数据库操作对象
		String SQL1="select * from userinfo where email='"+email+"'";//构建查询语句
		String str1=null;
		ResultSet rs1=asql.executeQuery(SQL1); 
        try {
			while (rs1.next())   
			{  
			    str1=rs1.getString("username");
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  

		if(str1==null)		//该用户尚未注册
		{
			request.setAttribute("x", "该用户尚未注册，请先注册！");
			RequestDispatcher go=request.getRequestDispatcher("zhibu.jsp");
			go.forward(request, response);
		}
		else{							//登录验证
			String SQL2="select password from userinfo where email='"+email+"'";
			asql.executeQuery(SQL2);
			String str2=null;
			ResultSet rs2=asql.executeQuery(SQL2); 
	        try {
				while (rs2.next())   
				{  
				    str2=rs2.getString("password");
				 }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        if(password.equals(str2))
	        {
	        	request.setAttribute("x", "登录成功！");
	        	HttpSession session = request.getSession(true);
	        	session.setAttribute("userInfo", str1);
	        	session.setAttribute("email", email);
	        	RequestDispatcher go=request.getRequestDispatcher("zhibu.jsp");
	        	go.forward(request, response);
	        }
	        else
	        {
	        	request.setAttribute("x", "密码错误！");			
	        	RequestDispatcher go=request.getRequestDispatcher("zhibu.jsp");
	        	go.forward(request, response);
	        }
		}
	}
	
	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws IOException,ServletException{
		
		String email=request.getParameter("email");//获取参数
		String password=request.getParameter("password");
		
		SqlHelper asql=new SqlHelper();//建立数据库操作对象
		String SQL1="select * from userinfo where email='"+email+"'";//构建查询语句
		String str1=null;
		ResultSet rs1=asql.executeQuery(SQL1); 
        try {
			while (rs1.next())   
			{  
			    str1=rs1.getString("username");
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  

		if(str1==null)		//该用户尚未注册
		{
			request.setAttribute("x", "该用户尚未注册，请先注册！");
			RequestDispatcher go=request.getRequestDispatcher("zhibu.jsp");
			go.forward(request, response);
		}
		else{							//登录验证
			String SQL2="select password from userinfo where email='"+email+"'";
			asql.executeQuery(SQL2);
			String str2=null;
			ResultSet rs2=asql.executeQuery(SQL2); 
	        try {
				while (rs2.next())   
				{  
				    str2=rs2.getString("password");
				 }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        if(password.equals(str2))
	        {
	        	request.setAttribute("x", "登录成功！");
	        	HttpSession session = request.getSession(true);
	        	session.setAttribute("userInfo", str1);
	        	session.setAttribute("email", email);
	        	RequestDispatcher go=request.getRequestDispatcher("zhibu.jsp");
	        	go.forward(request, response);
	        }
	        else
	        {
	        	request.setAttribute("x", "密码错误！");			
	        	RequestDispatcher go=request.getRequestDispatcher("zhibu.jsp");
	        	go.forward(request, response);
	        }
		}
	}
}
