package sdf;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class changestatus extends HttpServlet {
	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws IOException,ServletException{
		
		request. setCharacterEncoding("UTF-8");	
		
		String st=request.getParameter("st");
		String messageid=request.getParameter("messageid");
		String em=request.getParameter("em");
		String houseid=request.getParameter("houseid");
		
		SqlHelper asql=new SqlHelper();
		String sql="update order_message set message_status='1' where messageid='"+messageid+"'";
		asql.executeUpdate(sql);
		if(st.equals("1"))
		{
			request.setAttribute("em", em);
			request.setAttribute("messageid", messageid);
			RequestDispatcher go=request.getRequestDispatcher("iframe_message_details.jsp");
			go.forward(request, response);
		}else if(st.equals("2"))
		{
			request.setAttribute("houseid", houseid);
			RequestDispatcher go=request.getRequestDispatcher("house.jsp");
			go.forward(request, response);
		}else if(st.equals("3"))
		{
			request.setAttribute("houseid", houseid);
			RequestDispatcher go=request.getRequestDispatcher("house_thing.jsp");
			go.forward(request, response);
		}else if(st.equals("4"))
		{
			request.setAttribute("em", em);
			request.setAttribute("messageid", messageid);
			RequestDispatcher go=request.getRequestDispatcher("iframe_message_details2.jsp");
			go.forward(request, response);
		}
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws IOException,ServletException{
		
		request. setCharacterEncoding("UTF-8");	
		
		String st=request.getParameter("st");
		String messageid=request.getParameter("messageid");
		String em=request.getParameter("em");
		String houseid=request.getParameter("houseid");
		
		SqlHelper asql=new SqlHelper();
		String sql="update order_message set message_status='1' where messageid='"+messageid+"'";
		asql.executeUpdate(sql);
		if(st.equals("1"))
		{
			request.setAttribute("em", em);
			request.setAttribute("messageid", messageid);
			RequestDispatcher go=request.getRequestDispatcher("iframe_message_details.jsp");
			go.forward(request, response);
		}else if(st.equals("2"))
		{
			request.setAttribute("houseid", houseid);
			RequestDispatcher go=request.getRequestDispatcher("house.jsp");
			go.forward(request, response);
		}else if(st.equals("3"))
		{
			request.setAttribute("houseid", houseid);
			RequestDispatcher go=request.getRequestDispatcher("house_thing.jsp");
			go.forward(request, response);
		}else if(st.equals("4"))
		{
			request.setAttribute("em", em);
			request.setAttribute("messageid", messageid);
			RequestDispatcher go=request.getRequestDispatcher("iframe_message_details2.jsp");
			go.forward(request, response);
		}
	}
}