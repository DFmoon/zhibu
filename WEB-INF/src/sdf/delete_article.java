package sdf;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class delete_article extends HttpServlet {
	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws IOException,ServletException{
		
		request. setCharacterEncoding("UTF-8");	
		
		String articleid=request.getParameter("articleid");
		String sql="delete from article where articleid='"+articleid+"'";
		SqlHelper asql=new SqlHelper();
		
		asql.executeUpdate(sql);
		RequestDispatcher go=request.getRequestDispatcher("iframe_article_list.jsp");
		go.forward(request, response);
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws IOException,ServletException{
		
		request. setCharacterEncoding("UTF-8");	
		
		String articleid=request.getParameter("articleid");
		String sql="delete from article where articleid='"+articleid+"'";
		SqlHelper asql=new SqlHelper();
		
		asql.executeUpdate(sql);
		RequestDispatcher go=request.getRequestDispatcher("iframe_article_list.jsp");
		go.forward(request, response);
	}
}
