package sdf;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class add_houseinfo2 extends HttpServlet {
	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws IOException,ServletException{
		
		request. setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(true);
		String house_owner_email=(String)session.getAttribute("email");
		String house_owner=request.getParameter("house_owner");
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
		String SQL = "insert into houseinfo2(intro,short_intro,rest,house_owner,ifall,housename,address1,address2,address3,change_intro,house_owner_email)"
				+ "values('"+intro+"','"+short_intro+"','"+rest+"','"+house_owner+"','"+ifall+"','"+housename+"','"+address1+"','"+address2+"','"+address3+"','"+change_intro+"','"+house_owner_email+"')";  
		asql.executeUpdate(SQL);
		
		request.setAttribute("su2", "上传成功，请继续上传房源信息介绍图片吧！");
		String SQL1="select * from houseinfo2 where house_owner='"+house_owner+"'";
		int str1=0;
		ResultSet rs1=asql.executeQuery(SQL1);
	
		try {
			while(rs1.next())
			{
				int str=rs1.getInt("houseid");
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
		request.setAttribute("houseid",str);
		RequestDispatcher go=request.getRequestDispatcher("iframe_house_add22.jsp");
		go.forward(request, response);
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws IOException,ServletException{
		
		request. setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(true);
		String house_owner_email=(String)session.getAttribute("email");
		String house_owner=request.getParameter("house_owner");
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
		String SQL = "insert into houseinfo2(intro,short_intro,rest,house_owner,ifall,housename,address1,address2,address3,change_intro,house_owner_email)"
				+ "values('"+intro+"','"+short_intro+"','"+rest+"','"+house_owner+"','"+ifall+"','"+housename+"','"+address1+"','"+address2+"','"+address3+"','"+change_intro+"','"+house_owner_email+"')";  
		asql.executeUpdate(SQL);
		
		request.setAttribute("su2", "上传成功，请继续上传房源信息介绍图片吧！");
		String SQL1="select * from houseinfo2 where house_owner='"+house_owner+"'";
		int str1=0;
		ResultSet rs1=asql.executeQuery(SQL1);
	
		try {
			while(rs1.next())
			{
				int str=rs1.getInt("houseid");
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
		request.setAttribute("houseid",str);
		RequestDispatcher go=request.getRequestDispatcher("iframe_house_add22.jsp");
		go.forward(request, response);
	}
}
