package sdf;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class add_article extends HttpServlet {
	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws IOException,ServletException{
		
		request. setCharacterEncoding("UTF-8");	
		
		String title=request.getParameter("title");
		String acontent=request.getParameter("acontent");
		Date date=new Date();
		SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String replydate = time.format(date);
		HttpSession session = request.getSession(true);
		String email=(String)session.getAttribute("email");
		SqlHelper asql=new SqlHelper();
		String sql1="select * from userinfo where email='"+email+"'";
		ResultSet rs1=asql.executeQuery(sql1);
		String author=null;
		try {
			if(rs1.next())
			{
				author=rs1.getString("username");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql2="insert into article(title,author,replydate,acontent,email)values('"+title+"','"+author+"','"+replydate+"','"+acontent+"','"+email+"')";
		if(title==null || title.equals(""))
		{
			request.setAttribute("bd", "标题不得为空！");
			RequestDispatcher go=request.getRequestDispatcher("iframe_article_add.jsp");
			go.forward(request, response);
		}else
		{
			asql.executeUpdate(sql2);
			
			request.setAttribute("rr", "发表成功，为文章添加一张封面图吧！");
			String sql3="select * from article where email='"+email+"'";
			int str1=0;
			ResultSet rs3=asql.executeQuery(sql3);
		
			try {
				while(rs3.next())
				{
					int str=rs3.getInt("articleid");
					if(str>str1)
					{	
						str1=str;
					}
				}
			} catch (NumberFormatException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String str=""+str1;
			
			request.setAttribute("articleid",str);
			RequestDispatcher go=request.getRequestDispatcher("iframe_article_add1.jsp");
			go.forward(request, response);
		}
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws IOException,ServletException{
		
		request. setCharacterEncoding("UTF-8");	
		
		String title=request.getParameter("title");
		String acontent=request.getParameter("acontent");
		Date date=new Date();
		SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String replydate = time.format(date);
		HttpSession session = request.getSession(true);
		String email=(String)session.getAttribute("email");
		SqlHelper asql=new SqlHelper();
		String sql1="select * from userinfo where email='"+email+"'";
		ResultSet rs1=asql.executeQuery(sql1);
		String author=null;
		try {
			if(rs1.next())
			{
				author=rs1.getString("username");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql2="insert into article(title,author,replydate,acontent,email)values('"+title+"','"+author+"','"+replydate+"','"+acontent+"','"+email+"')";
		if(title==null || title.equals(""))
		{
			request.setAttribute("bd", "标题不得为空！");
			RequestDispatcher go=request.getRequestDispatcher("iframe_article_add.jsp");
			go.forward(request, response);
		}else
		{
			asql.executeUpdate(sql2);
			
			request.setAttribute("rr", "发表成功，为文章添加一张封面图吧！");
			String sql3="select * from article where email='"+email+"'";
			int str1=0;
			ResultSet rs3=asql.executeQuery(sql3);
		
			try {
				while(rs3.next())
				{
					int str=rs3.getInt("articleid");
					if(str>str1)
					{	
						str1=str;
					}
				}
			} catch (NumberFormatException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String str=""+str1;
			
			request.setAttribute("articleid",str);
			request.setAttribute("rr", "发表成功，为文章添加一张封面图吧！");
			RequestDispatcher go=request.getRequestDispatcher("iframe_article_add1.jsp");
			go.forward(request, response);
		}
	}
}
