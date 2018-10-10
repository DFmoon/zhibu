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

public class collection extends HttpServlet {
	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws IOException,ServletException{
		
		request. setCharacterEncoding("UTF-8");	
		
		String houseid=request.getParameter("houseid");
		String housetable=request.getParameter("housetable");
		HttpSession session = request.getSession(true);
		String email=(String)session.getAttribute("email");
		SqlHelper asql=new SqlHelper();
		
		if(housetable.equals("1"))
		{
			if(email==null)
			{
				request.setAttribute("cc", "ÊÕ²ØÊ§°Ü£¬ÇëÏÈµÇÂ¼£¡");
				RequestDispatcher go=request.getRequestDispatcher("house.jsp");
				go.forward(request, response);
			}else
			{
				String SQL1="select * from houseinfo1 where houseid='"+houseid+"'";
				ResultSet rs1=asql.executeQuery(SQL1);
				
				try {
					if(rs1.next()) 
					{
						String intro=rs1.getString("intro");
						String short_intro=rs1.getString("short_intro");
						String rest=rs1.getString("rest");
						String house_owner=rs1.getString("house_owner");
						String ifall=rs1.getString("ifall");
						String housename=rs1.getString("housename");
						String spic=rs1.getString("spic");
						String bpic=rs1.getString("bpic");
						String house_comment=rs1.getString("house_comment");
						String address1=rs1.getString("address1");
						String address2=rs1.getString("address2");
						String address3=rs1.getString("address3");
						String univalent=rs1.getString("univalent");
						
						String SQL11 = "insert into collection1(intro,short_intro,rest,house_owner,ifall,housename,spic,bpic,house_comment,address1,address2,address3,univalent,houseid,collecter)"
								+ "values('"+intro+"','"+short_intro+"','"+rest+"','"+house_owner+"','"+ifall+"','"+housename+"','"+spic+"','"+bpic+"','"+house_comment+"','"+address1+"','"+address2+"','"+address3+"','"+univalent+"','"+houseid+"','"+email+"')";  
						asql.executeUpdate(SQL11);
						
						request.setAttribute("cc", "ÊÕ²Ø³É¹¦£¡");
						RequestDispatcher go=request.getRequestDispatcher("house.jsp");
						go.forward(request, response);

					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}			
		}else if(housetable.equals("2"))
		{
			if(email==null)
			{
				request.setAttribute("cc", "ÊÕ²ØÊ§°Ü£¬ÇëÏÈµÇÂ¼£¡");
				RequestDispatcher go=request.getRequestDispatcher("house_thing.jsp");
				go.forward(request, response);
			}else
			{
				String SQL2="select * from houseinfo2 where houseid='"+houseid+"'";
				ResultSet rs2=asql.executeQuery(SQL2);
				
				try {
					if(rs2.next()) 
					{
						String intro=rs2.getString("intro");
						String short_intro=rs2.getString("short_intro");
						String rest=rs2.getString("rest");
						String house_owner=rs2.getString("house_owner");
						String ifall=rs2.getString("ifall");
						String housename=rs2.getString("housename");
						String spic=rs2.getString("spic");
						String bpic=rs2.getString("bpic");
						String house_comment=rs2.getString("house_comment");
						String address1=rs2.getString("address1");
						String address2=rs2.getString("address2");
						String address3=rs2.getString("address3");
						String change_intro=rs2.getString("change_intro");
						
						String SQL22 = "insert into collection2(intro,short_intro,rest,house_owner,ifall,housename,spic,bpic,house_comment,address1,address2,address3,change_intro,houseid,collecter)"
								+ "values('"+intro+"','"+short_intro+"','"+rest+"','"+house_owner+"','"+ifall+"','"+housename+"','"+spic+"','"+bpic+"','"+house_comment+"','"+address1+"','"+address2+"','"+address3+"','"+change_intro+"','"+houseid+"','"+email+"')";  
						asql.executeUpdate(SQL22);
						
						request.setAttribute("cc", "ÊÕ²Ø³É¹¦£¡");
						RequestDispatcher go=request.getRequestDispatcher("house_thing.jsp");
						go.forward(request, response);

					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}			
		}		
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws IOException,ServletException{
		
		request. setCharacterEncoding("UTF-8");	
		
		String houseid=request.getParameter("houseid");
		String housetable=request.getParameter("housetable");
		HttpSession session = request.getSession(true);
		String email=(String)session.getAttribute("email");
		SqlHelper asql=new SqlHelper();
		
		if(housetable.equals("1"))
		{
			if(email==null)
			{
				request.setAttribute("cc", "ÊÕ²ØÊ§°Ü£¬ÇëÏÈµÇÂ¼£¡");
				RequestDispatcher go=request.getRequestDispatcher("house.jsp");
				go.forward(request, response);
			}else
			{
				String SQL1="select * from houseinfo1 where houseid='"+houseid+"'";
				ResultSet rs1=asql.executeQuery(SQL1);
				
				try {
					if(rs1.next()) 
					{
						String intro=rs1.getString("intro");
						String short_intro=rs1.getString("short_intro");
						String rest=rs1.getString("rest");
						String house_owner=rs1.getString("house_owner");
						String ifall=rs1.getString("ifall");
						String housename=rs1.getString("housename");
						String spic=rs1.getString("spic");
						String bpic=rs1.getString("bpic");
						String house_comment=rs1.getString("house_comment");
						String address1=rs1.getString("address1");
						String address2=rs1.getString("address2");
						String address3=rs1.getString("address3");
						String univalent=rs1.getString("univalent");
						
						String SQL11 = "insert into collection1(intro,short_intro,rest,house_owner,ifall,housename,spic,bpic,house_comment,address1,address2,address3,univalent,houseid,collecter)"
								+ "values('"+intro+"','"+short_intro+"','"+rest+"','"+house_owner+"','"+ifall+"','"+housename+"','"+spic+"','"+bpic+"','"+house_comment+"','"+address1+"','"+address2+"','"+address3+"','"+univalent+"','"+houseid+"','"+email+"')";  
						asql.executeUpdate(SQL11);
						
						request.setAttribute("cc", "ÊÕ²Ø³É¹¦£¡");
						RequestDispatcher go=request.getRequestDispatcher("house.jsp");
						go.forward(request, response);

					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}			
		}else if(housetable.equals("2"))
		{
			if(email==null)
			{
				request.setAttribute("cc", "ÊÕ²ØÊ§°Ü£¬ÇëÏÈµÇÂ¼£¡");
				RequestDispatcher go=request.getRequestDispatcher("house_thing.jsp");
				go.forward(request, response);
			}else
			{
				String SQL2="select * from houseinfo2 where houseid='"+houseid+"'";
				ResultSet rs2=asql.executeQuery(SQL2);
				
				try {
					if(rs2.next()) 
					{
						String intro=rs2.getString("intro");
						String short_intro=rs2.getString("short_intro");
						String rest=rs2.getString("rest");
						String house_owner=rs2.getString("house_owner");
						String ifall=rs2.getString("ifall");
						String housename=rs2.getString("housename");
						String spic=rs2.getString("spic");
						String bpic=rs2.getString("bpic");
						String house_comment=rs2.getString("house_comment");
						String address1=rs2.getString("address1");
						String address2=rs2.getString("address2");
						String address3=rs2.getString("address3");
						String change_intro=rs2.getString("change_intro");
						
						String SQL22 = "insert into collection2(intro,short_intro,rest,house_owner,ifall,housename,spic,bpic,house_comment,address1,address2,address3,change_intro,houseid,collecter)"
								+ "values('"+intro+"','"+short_intro+"','"+rest+"','"+house_owner+"','"+ifall+"','"+housename+"','"+spic+"','"+bpic+"','"+house_comment+"','"+address1+"','"+address2+"','"+address3+"','"+change_intro+"','"+houseid+"','"+email+"')";  
						asql.executeUpdate(SQL22);
						
						request.setAttribute("cc", "ÊÕ²Ø³É¹¦£¡");
						RequestDispatcher go=request.getRequestDispatcher("house_thing.jsp");
						go.forward(request, response);

					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}			
		}		
	}
}
