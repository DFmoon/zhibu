package sdf;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class regServlet extends HttpServlet {
	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws IOException,ServletException{
		
		request. setCharacterEncoding("UTF-8");
		
		String uname=request.getParameter("username");//获取参数
		String uemail=request.getParameter("email");
		String upassword=request.getParameter("password");
		String question=request.getParameter("question");
		String answer=request.getParameter("answer");
		
		SqlHelper asql=new SqlHelper();//建立数据库操作对象
		String SQL1="select * from userinfo where username='"+uname+"'";//构建查询语句
		String SQL2="select * from userinfo where email='"+uemail+"'";
		String str1=null;
		String str2=null;
		ResultSet rs1=asql.executeQuery(SQL1); 
		ResultSet rs2=asql.executeQuery(SQL2);
        try {
			while (rs1.next())   
			{  
			    str1=rs1.getString("username");
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
        try {
			while (rs2.next())   
			{  
			    str2=rs2.getString("email");
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(str1!=null)		//该用户已注册
		{
			request.setAttribute("y", "该用户已存在，请直接登录！");
			RequestDispatcher go=request.getRequestDispatcher("zhibu.jsp");
			go.forward(request, response);
		}
		else if(str1==null && str2!=null)		//该邮箱已被注册
		{
			request.setAttribute("y", "该邮箱已被注册,请更换邮箱地址！");
			RequestDispatcher go=request.getRequestDispatcher("zhibu.jsp");
			go.forward(request, response);
		}
		else{							//该用户不存在
			request.setAttribute("y", "注册成功，请登录！");
			String SQL3= "insert into userinfo (userName,email,password,ifhouse,question,answer) values ('"+uname+"','"+uemail+"','"+upassword+"','否','"+question+"','"+answer+"')";
			asql.executeQuery(SQL3);
			RequestDispatcher go=request.getRequestDispatcher("zhibu.jsp");
			go.forward(request, response);
		}
	}
	
	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws IOException,ServletException{
		
		request. setCharacterEncoding("UTF-8");
		
		String uname=request.getParameter("username");//获取参数
		String uemail=request.getParameter("email");
		String upassword=request.getParameter("password");
		String question=request.getParameter("question");
		String answer=request.getParameter("answer");
		
		SqlHelper asql=new SqlHelper();//建立数据库操作对象
		String SQL1="select * from userinfo where username='"+uname+"'";//构建查询语句
		String SQL2="select * from userinfo where email='"+uemail+"'";
		String str1=null;
		String str2=null;
		ResultSet rs1=asql.executeQuery(SQL1); 
		ResultSet rs2=asql.executeQuery(SQL2);
        try {
			while (rs1.next())   
			{  
			    str1=rs1.getString("username");
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
        try {
			while (rs2.next())   
			{  
			    str2=rs2.getString("email");
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(str1!=null)		//该用户已注册
		{
			System.out.println("该用户已注册");
			request.setAttribute("y", "该用户已存在，请直接登录！");
			RequestDispatcher go=request.getRequestDispatcher("zhibu.jsp");
			go.forward(request, response);
		}
		else if(str1==null && str2!=null)		//该邮箱已被注册
		{
			System.out.println("该邮箱已被注册");
			request.setAttribute("y", "该邮箱已被注册,请更换邮箱地址！");
			RequestDispatcher go=request.getRequestDispatcher("zhibu.jsp");
			go.forward(request, response);
		}
		else{							//该用户不存在
			System.out.println("该用户不存在");
			request.setAttribute("y", "注册成功，请登录！");
			String SQL3= "insert into userinfo (userName,email,password,ifhouse,question,answer) values ('"+uname+"','"+uemail+"','"+upassword+"','否','"+question+"','"+answer+"')";
			asql.executeQuery(SQL3);
			RequestDispatcher go=request.getRequestDispatcher("zhibu.jsp");
			go.forward(request, response);
		}
	}
}
