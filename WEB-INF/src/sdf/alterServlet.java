package sdf;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class alterServlet extends HttpServlet {
	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws IOException,ServletException{
		
		request. setCharacterEncoding("UTF-8");	
		
		String username=request.getParameter("username");
		String sex=request.getParameter("sex");
		String phone=request.getParameter("phone");
		String email=request.getParameter("email");
		String realname=request.getParameter("realname");
		String place=request.getParameter("place");
		String birthday=request.getParameter("birthday");
		String useridentity=request.getParameter("useridentity");
		
		SqlHelper asql=new SqlHelper();//建立数据库操作对象
		String SQL="select * from userinfo where username='"+username+"'";//构建查询语句		
		ResultSet rs=asql.executeQuery(SQL); 
		
		try {
			if(rs.next())
			{
				String  SQL2 = "update userinfo set phone='"+phone+"' where username='"+username+"'";
				String  SQL3 = "update userinfo set email='"+email+"' where username='"+username+"'";
				String  SQL4 = "update userinfo set realname='"+realname+"' where username='"+username+"'";
				String  SQL5 = "update userinfo set place='"+place+"' where username='"+username+"'";
				String  SQL6 = "update userinfo set birthday='"+birthday+"' where username='"+username+"'";
				String  SQL7 = "update userinfo set useridentity='"+useridentity+"' where username='"+username+"'";
				String  SQL8 = "update userinfo set sex='"+sex+"' where username='"+username+"'";

				asql.executeUpdate(SQL2);
				asql.executeUpdate(SQL3);
				asql.executeUpdate(SQL4);
				asql.executeUpdate(SQL5);
				asql.executeUpdate(SQL6);
				asql.executeUpdate(SQL7);
				asql.executeUpdate(SQL8);
				RequestDispatcher go=request.getRequestDispatcher("iframe_person_show.jsp");
				go.forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws IOException,ServletException{
		
		request. setCharacterEncoding("UTF-8");	

		String username=request.getParameter("username");
		String sex=request.getParameter("sex");
		String phone=request.getParameter("phone");
		String email=request.getParameter("email");
		String realname=request.getParameter("realname");
		String place=request.getParameter("place");
		String birthday=request.getParameter("birthday");
		String useridentity=request.getParameter("useridentity");
		
		SqlHelper asql=new SqlHelper();//建立数据库操作对象
		String SQL="select * from userinfo where username='"+username+"'";//构建查询语句		
		ResultSet rs=asql.executeQuery(SQL); 
		
		try {
			if(rs.next())
			{
				String  SQL2 = "update userinfo set phone='"+phone+"' where username='"+username+"'";
				String  SQL3 = "update userinfo set email='"+email+"' where username='"+username+"'";
				String  SQL4 = "update userinfo set realname='"+realname+"' where username='"+username+"'";
				String  SQL5 = "update userinfo set place='"+place+"' where username='"+username+"'";
				String  SQL6 = "update userinfo set birthday='"+birthday+"' where username='"+username+"'";
				String  SQL7 = "update userinfo set useridentity='"+useridentity+"' where username='"+username+"'";
				String  SQL8 = "update userinfo set sex='"+sex+"' where username='"+username+"'";

				asql.executeUpdate(SQL2);
				asql.executeUpdate(SQL3);
				asql.executeUpdate(SQL4);
				asql.executeUpdate(SQL5);
				asql.executeUpdate(SQL6);
				asql.executeUpdate(SQL7);
				asql.executeUpdate(SQL8);
				RequestDispatcher go=request.getRequestDispatcher("iframe_person_show.jsp");
				go.forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
