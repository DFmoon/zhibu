package sdf;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class alter_password extends HttpServlet {
	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws IOException,ServletException{
		
		request. setCharacterEncoding("UTF-8");
		String email=request.getParameter("email");
		String yp=request.getParameter("yp");
		String xp=request.getParameter("xp");
		String xxp=request.getParameter("xxp");
		
		SqlHelper asql=new SqlHelper();//建立数据库操作对象
		String SQL1="select * from userinfo where email='"+email+"'";//构建查询语句
		String str1=null;
		ResultSet rs1=asql.executeQuery(SQL1); 
        try {
			if(rs1.next())   
			{  
			    str1=rs1.getString("password");
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  

		if(str1!=null)		//该用户已注册
		{
			if(str1.equals(yp))
			{
				if(xp.equals(xxp))
				{
					String  SQL2 = "update userinfo set password='"+xp+"' where email='"+email+"'";
					asql.executeUpdate(SQL2);
					
					request.setAttribute("z", "密码修改成功！");
					RequestDispatcher go=request.getRequestDispatcher("alter_password.jsp");
					go.forward(request, response);
				}else
				{
					request.setAttribute("z", "两次密码输入不一致！");
					RequestDispatcher go=request.getRequestDispatcher("alter_password.jsp");
					go.forward(request, response);
				}
				
			}else
			{
				request.setAttribute("z", "原密码错误！");
				RequestDispatcher go=request.getRequestDispatcher("alter_password.jsp");
				go.forward(request, response);
			}
		}

		else{							//该用户不存在
			request.setAttribute("z", "该用户尚未注册，请先注册！");
			RequestDispatcher go=request.getRequestDispatcher("alter_password.jsp");
			go.forward(request, response);
		}
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws IOException,ServletException{
		
		request. setCharacterEncoding("UTF-8");
		String email=request.getParameter("email");
		String yp=request.getParameter("yp");
		String xp=request.getParameter("xp");
		
		SqlHelper asql=new SqlHelper();//建立数据库操作对象
		String SQL1="select * from userinfo where email='"+email+"'";//构建查询语句
		String str1=null;
		ResultSet rs1=asql.executeQuery(SQL1); 
        try {
			if(rs1.next())   
			{  
			    str1=rs1.getString("password");
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  

		if(str1!=null)		//该用户已注册
		{
			if(str1.equals(yp))
			{
				String  SQL2 = "update userinfo set password='"+xp+"' where email='"+email+"'";
				asql.executeUpdate(SQL2);
		
				request.setAttribute("z", "密码修改成功！");
				RequestDispatcher go=request.getRequestDispatcher("alter_password.jsp");
				go.forward(request, response);
			}
			else
			{
				request.setAttribute("z", "原密码错误！");
				RequestDispatcher go=request.getRequestDispatcher("alter_password.jsp");
				go.forward(request, response);
			}
		}

		else{							//该用户不存在
			request.setAttribute("z", "该用户尚未注册，请先注册！");
			RequestDispatcher go=request.getRequestDispatcher("zhibu.jsp");
			go.forward(request, response);
		}
	}
}
