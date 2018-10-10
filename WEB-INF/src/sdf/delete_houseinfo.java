package sdf;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class delete_houseinfo extends HttpServlet {
	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws IOException,ServletException{
		
		request. setCharacterEncoding("UTF-8");	
		
		String houseid=request.getParameter("houseid");
		String housetable=request.getParameter("housetable");
		String sql1="delete from houseinfo1 where houseid='"+houseid+"'";
		String sql2="delete from houseinfo2 where houseid='"+houseid+"'";
		SqlHelper asql=new SqlHelper();
		if(housetable.equals("1"))
		{
			asql.executeUpdate(sql1);
			RequestDispatcher go=request.getRequestDispatcher("iframe_house_show.jsp");
			go.forward(request, response);
		}else if(housetable.equals("2"))
		{
			asql.executeUpdate(sql2);
			RequestDispatcher go=request.getRequestDispatcher("iframe_house_show.jsp");
			go.forward(request, response);
		}

	}
	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws IOException,ServletException{
		
		request. setCharacterEncoding("UTF-8");	
		
		String houseid=request.getParameter("houseid");
		String housetable=request.getParameter("housetable");
		
		String sql1="delete from houseinfo1 where houseid='"+houseid+"'";
		String sql2="delete from houseinfo2 where houseid='"+houseid+"'";
		SqlHelper asql=new SqlHelper();
		if(housetable.equals("1"))
		{
			asql.executeUpdate(sql1);
			RequestDispatcher go=request.getRequestDispatcher("iframe_house_show.jsp");
			go.forward(request, response);
		}else if(housetable.equals("2"))
		{
			asql.executeUpdate(sql2);
			RequestDispatcher go=request.getRequestDispatcher("iframe_house_show.jsp");
			go.forward(request, response);
		}

	}
}
