package sdf;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class find_password2 extends HttpServlet {
	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws IOException,ServletException{
		
		request. setCharacterEncoding("UTF-8");
		String uname=request.getParameter("username");//获取参数
		String uemail=request.getParameter("email");
		String answer=request.getParameter("answer");
		String question=request.getParameter("question");
		
		SqlHelper asql=new SqlHelper();//建立数据库操作对象
		String SQL1="select * from userinfo where email='"+uemail+"'";//构建查询语句

		ResultSet rs1=asql.executeQuery(SQL1); 
		String str1=null;
		try {
			if(rs1.next())
			{
				str1 = rs1.getString("answer");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(str1.equals(answer))
		{
			request.setAttribute("username", uname);
			request.setAttribute("email", uemail);
			RequestDispatcher go=request.getRequestDispatcher("set_password.jsp");
			go.forward(request, response);
		}
		else
		{
			request.setAttribute("question", question);
			request.setAttribute("email", uemail);
			request.setAttribute("username", uname);
			request.setAttribute("n", "答案不正确！");
			RequestDispatcher go=request.getRequestDispatcher("find_password2.jsp");
			go.forward(request, response);
		}	
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws IOException,ServletException{
		
		request. setCharacterEncoding("UTF-8");
		String uname=request.getParameter("username");//获取参数
		String uemail=request.getParameter("email");
		String answer=request.getParameter("answer");
		String question=request.getParameter("question");
		
		SqlHelper asql=new SqlHelper();//建立数据库操作对象
		String SQL1="select * from userinfo where email='"+uemail+"'";//构建查询语句
		
		ResultSet rs1=asql.executeQuery(SQL1); 
		String str1=null;
		try {
			if(rs1.next())
			{
				str1 = rs1.getString("answer");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(str1.equals(answer))
		{
			request.setAttribute("username", uname);
			request.setAttribute("email", uemail);
			RequestDispatcher go=request.getRequestDispatcher("set_password.jsp");
			go.forward(request, response);
		}
		else
		{
			request.setAttribute("question", question);
			request.setAttribute("email", uemail);
			request.setAttribute("username", uname);
			request.setAttribute("n", "答案不正确！");
			RequestDispatcher go=request.getRequestDispatcher("find_password2.jsp");
			go.forward(request, response);
		}	
	}
}
