package sdf;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class alter_article extends HttpServlet {
	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws IOException,ServletException{
		
		request. setCharacterEncoding("UTF-8");	
		
		String articleid=request.getParameter("articleid");
		String title=request.getParameter("title");
		String acontent=request.getParameter("acontent");
		Date date=new Date();
		SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String replydate = time.format(date);	
		SqlHelper asql=new SqlHelper();
		String  SQL1 = "update article set title='"+title+"' where articleid='"+articleid+"'";
		String  SQL2 = "update article set acontent='"+acontent+"' where articleid='"+articleid+"'";
		String  SQL3 = "update article set replydate='"+replydate+"' where articleid='"+articleid+"'";
			
		asql.executeUpdate(SQL1);
		asql.executeUpdate(SQL2);
		asql.executeUpdate(SQL3);

		request.setAttribute("articleid", articleid);
		request.setAttribute("upd", "更新成功，可继续更新图片！");
		RequestDispatcher go=request.getRequestDispatcher("iframe_article_add1.jsp");
		go.forward(request, response);
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws IOException,ServletException{
		
		request. setCharacterEncoding("UTF-8");	
		
		String articleid=request.getParameter("articleid");
		String title=request.getParameter("title");
		String acontent=request.getParameter("acontent");
		Date date=new Date();
		SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String replydate = time.format(date);	
		SqlHelper asql=new SqlHelper();
		String  SQL1 = "update article set title='"+title+"' where articleid='"+articleid+"'";
		String  SQL2 = "update article set acontent='"+acontent+"' where articleid='"+articleid+"'";
		String  SQL3 = "update article set replydate='"+replydate+"' where articleid='"+articleid+"'";
			
		asql.executeUpdate(SQL1);
		asql.executeUpdate(SQL2);
		asql.executeUpdate(SQL3);

		request.setAttribute("articleid", articleid);
		request.setAttribute("upd", "更新成功，可继续更新图片！");
		RequestDispatcher go=request.getRequestDispatcher("iframe_article_add1.jsp");
		go.forward(request, response);
	}
}
