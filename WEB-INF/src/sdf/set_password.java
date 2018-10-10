package sdf;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class set_password extends HttpServlet {
	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws IOException,ServletException{
		
		request. setCharacterEncoding("UTF-8");	
		String email=request.getParameter("email");
		String username=request.getParameter("username");
		String xp=request.getParameter("xp");
		String xxp=request.getParameter("xxp");
			
		SqlHelper asql=new SqlHelper();//建立数据库操作对象
		String  SQL = "update userinfo set password='"+xp+"' where email='"+email+"'";
		if(xp.equals(xxp))
		{
			asql.executeUpdate(SQL);			
			request.setAttribute("p", "密码已重置！");
			request.setAttribute("username", username);
			request.setAttribute("email", email);
			RequestDispatcher go=request.getRequestDispatcher("set_password.jsp");
			go.forward(request, response);
		}else
		{
			request.setAttribute("username", username);
			request.setAttribute("email", email);
			request.setAttribute("p", "两次密码输入不一致！");
			RequestDispatcher go=request.getRequestDispatcher("set_password.jsp");
			go.forward(request, response);
		}
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws IOException,ServletException{
		
		request. setCharacterEncoding("UTF-8");
		String email=request.getParameter("email");
		String username=request.getParameter("username");
		String xp=request.getParameter("xp");
		String xxp=request.getParameter("xxp");
			
		SqlHelper asql=new SqlHelper();//建立数据库操作对象
		String  SQL = "update userinfo set password='"+xp+"' where email='"+email+"'";
		if(xp.equals(xxp))
		{
			asql.executeUpdate(SQL);			
			request.setAttribute("p", "密码已重置！");
			request.setAttribute("username", username);
			request.setAttribute("email", email);
			RequestDispatcher go=request.getRequestDispatcher("set_password.jsp");
			go.forward(request, response);
		}else
		{
			request.setAttribute("username", username);
			request.setAttribute("email", email);
			request.setAttribute("p", "两次密码输入不一致！");
			RequestDispatcher go=request.getRequestDispatcher("set_password.jsp");
			go.forward(request, response);
		}
	}
}
