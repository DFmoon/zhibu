package sdf;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class alter_houseinfo extends HttpServlet {
	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws IOException,ServletException{
		
		request. setCharacterEncoding("UTF-8");	
		
		String houseid=request.getParameter("houseid");
		String housetable=request.getParameter("housetable");
		if(housetable.equals("1"))
		{
			String housename=request.getParameter("housename");
			String ifall=request.getParameter("ifall");
			String univalent=request.getParameter("univalent");
			String rest=request.getParameter("rest");
			String short_intro=request.getParameter("short_intro");
			String address1=request.getParameter("province");
			String address2=request.getParameter("city");
			String address3=request.getParameter("address3");
			String intro=request.getParameter("intro");
			SqlHelper asql=new SqlHelper();
			String  SQL1 = "update houseinfo1 set housename='"+housename+"' where houseid='"+houseid+"'";
			String  SQL2 = "update houseinfo1 set ifall='"+ifall+"' where houseid='"+houseid+"'";
			String  SQL3 = "update houseinfo1 set univalent='"+univalent+"' where houseid='"+houseid+"'";
			String  SQL4 = "update houseinfo1 set rest='"+rest+"' where houseid='"+houseid+"'";
			String  SQL5 = "update houseinfo1 set short_intro='"+short_intro+"' where houseid='"+houseid+"'";
			String  SQL6 = "update houseinfo1 set address1='"+address1+"' where houseid='"+houseid+"'";
			String  SQL7 = "update houseinfo1 set address2='"+address2+"' where houseid='"+houseid+"'";
			String  SQL8 = "update houseinfo1 set address3='"+address3+"' where houseid='"+houseid+"'";
			String  SQL9 = "update houseinfo1 set intro='"+intro+"' where houseid='"+houseid+"'";
			
			asql.executeUpdate(SQL1);
			asql.executeUpdate(SQL2);
			asql.executeUpdate(SQL3);
			asql.executeUpdate(SQL4);
			asql.executeUpdate(SQL5);
			asql.executeUpdate(SQL6);
			asql.executeUpdate(SQL7);
			asql.executeUpdate(SQL8);
			asql.executeUpdate(SQL9);
			request.setAttribute("houseid", houseid);
			request.setAttribute("up", "更新成功，可继续更新图片！");
			RequestDispatcher go=request.getRequestDispatcher("iframe_house_add12.jsp");
			go.forward(request, response);
		}else if(housetable.equals("2"))
		{
			String housename=request.getParameter("housename");
			String ifall=request.getParameter("ifall");
			String change_intro=request.getParameter("change_intro");
			String rest=request.getParameter("rest");
			String short_intro=request.getParameter("short_intro");
			String address1=request.getParameter("province");
			String address2=request.getParameter("city");
			String address3=request.getParameter("address3");
			String intro=request.getParameter("intro");
			SqlHelper asql=new SqlHelper();
			String  SQL1 = "update houseinfo2 set housename='"+housename+"' where houseid='"+houseid+"'";
			String  SQL2 = "update houseinfo2 set ifall='"+ifall+"' where houseid='"+houseid+"'";
			String  SQL3 = "update houseinfo2 set change_intro='"+change_intro+"' where houseid='"+houseid+"'";
			String  SQL4 = "update houseinfo2 set rest='"+rest+"' where houseid='"+houseid+"'";
			String  SQL5 = "update houseinfo2 set short_intro='"+short_intro+"' where houseid='"+houseid+"'";
			String  SQL6 = "update houseinfo2 set address1='"+address1+"' where houseid='"+houseid+"'";
			String  SQL7 = "update houseinfo2 set address2='"+address2+"' where houseid='"+houseid+"'";
			String  SQL8 = "update houseinfo2 set address3='"+address3+"' where houseid='"+houseid+"'";
			String  SQL9 = "update houseinfo2 set intro='"+intro+"' where houseid='"+houseid+"'";
			
			asql.executeUpdate(SQL1);
			asql.executeUpdate(SQL2);
			asql.executeUpdate(SQL3);
			asql.executeUpdate(SQL4);
			asql.executeUpdate(SQL5);
			asql.executeUpdate(SQL6);
			asql.executeUpdate(SQL7);
			asql.executeUpdate(SQL8);
			asql.executeUpdate(SQL9);
			request.setAttribute("houseid", houseid);
			request.setAttribute("up", "更新成功，可继续更新图片！");
			RequestDispatcher go=request.getRequestDispatcher("iframe_house_add22.jsp");
			go.forward(request, response);
		}
		
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws IOException,ServletException{
		
		request. setCharacterEncoding("UTF-8");	
		
		String houseid=request.getParameter("houseid");
		String housetable=request.getParameter("housetable");
		if(housetable.equals("1"))
		{
			String housename=request.getParameter("housename");
			String ifall=request.getParameter("ifall");
			String univalent=request.getParameter("univalent");
			String rest=request.getParameter("rest");
			String short_intro=request.getParameter("short_intro");
			String address1=request.getParameter("province");
			String address2=request.getParameter("city");
			String address3=request.getParameter("address3");
			String intro=request.getParameter("intro");
			SqlHelper asql=new SqlHelper();
			String  SQL1 = "update houseinfo1 set housename='"+housename+"' where houseid='"+houseid+"'";
			String  SQL2 = "update houseinfo1 set ifall='"+ifall+"' where houseid='"+houseid+"'";
			String  SQL3 = "update houseinfo1 set univalent='"+univalent+"' where houseid='"+houseid+"'";
			String  SQL4 = "update houseinfo1 set rest='"+rest+"' where houseid='"+houseid+"'";
			String  SQL5 = "update houseinfo1 set short_intro='"+short_intro+"' where houseid='"+houseid+"'";
			String  SQL6 = "update houseinfo1 set address1='"+address1+"' where houseid='"+houseid+"'";
			String  SQL7 = "update houseinfo1 set address2='"+address2+"' where houseid='"+houseid+"'";
			String  SQL8 = "update houseinfo1 set address3='"+address3+"' where houseid='"+houseid+"'";
			String  SQL9 = "update houseinfo1 set intro='"+intro+"' where houseid='"+houseid+"'";
			
			asql.executeUpdate(SQL1);
			asql.executeUpdate(SQL2);
			asql.executeUpdate(SQL3);
			asql.executeUpdate(SQL4);
			asql.executeUpdate(SQL5);
			asql.executeUpdate(SQL6);
			asql.executeUpdate(SQL7);
			asql.executeUpdate(SQL8);
			asql.executeUpdate(SQL9);
			request.setAttribute("houseid", houseid);
			request.setAttribute("up", "更新成功，可继续更新图片！");
			RequestDispatcher go=request.getRequestDispatcher("iframe_house_add12.jsp");
			go.forward(request, response);
		}else if(housetable.equals("2"))
		{
			String housename=request.getParameter("housename");
			String ifall=request.getParameter("ifall");
			String change_intro=request.getParameter("change_intro");
			String rest=request.getParameter("rest");
			String short_intro=request.getParameter("short_intro");
			String address1=request.getParameter("province");
			String address2=request.getParameter("city");
			String address3=request.getParameter("address3");
			String intro=request.getParameter("intro");
			SqlHelper asql=new SqlHelper();
			String  SQL1 = "update houseinfo2 set housename='"+housename+"' where houseid='"+houseid+"'";
			String  SQL2 = "update houseinfo2 set ifall='"+ifall+"' where houseid='"+houseid+"'";
			String  SQL3 = "update houseinfo2 set change_intro='"+change_intro+"' where houseid='"+houseid+"'";
			String  SQL4 = "update houseinfo2 set rest='"+rest+"' where houseid='"+houseid+"'";
			String  SQL5 = "update houseinfo2 set short_intro='"+short_intro+"' where houseid='"+houseid+"'";
			String  SQL6 = "update houseinfo2 set address1='"+address1+"' where houseid='"+houseid+"'";
			String  SQL7 = "update houseinfo2 set address2='"+address2+"' where houseid='"+houseid+"'";
			String  SQL8 = "update houseinfo2 set address3='"+address3+"' where houseid='"+houseid+"'";
			String  SQL9 = "update houseinfo2 set intro='"+intro+"' where houseid='"+houseid+"'";
			
			asql.executeUpdate(SQL1);
			asql.executeUpdate(SQL2);
			asql.executeUpdate(SQL3);
			asql.executeUpdate(SQL4);
			asql.executeUpdate(SQL5);
			asql.executeUpdate(SQL6);
			asql.executeUpdate(SQL7);
			asql.executeUpdate(SQL8);
			asql.executeUpdate(SQL9);
			request.setAttribute("houseid", houseid);
			request.setAttribute("up", "更新成功，可继续更新图片！");
			RequestDispatcher go=request.getRequestDispatcher("iframe_house_add22.jsp");
			go.forward(request, response);
		}
		
	}
}
