package sdf;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class add_order1 extends HttpServlet {
	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws IOException,ServletException{
		
		request. setCharacterEncoding("UTF-8");
		
		String houseid=request.getParameter("houseid");
		String checkin=request.getParameter("checkin");
		String checkout=request.getParameter("checkout");
		String housename=request.getParameter("housename");
		String univalent=request.getParameter("univalent");
		String quantity=request.getParameter("quantity");
		HttpSession session = request.getSession(true);
		String email=(String)session.getAttribute("email");
		
		SqlHelper asql=new SqlHelper();
		String sql0="select * from houseinfo1 where houseid='"+houseid+"'";
		ResultSet rs0=asql.executeQuery(sql0);
		String house_owner_email=null;
		int rest=0;
		try {
			if(rs0.next())
			{
				house_owner_email=rs0.getString("house_owner_email");
				rest=rs0.getInt("rest");
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(email==null)
		{
			request.setAttribute("houseid",houseid);
			request.setAttribute("ff","您还没有登录，请先登录！");
			RequestDispatcher go=request.getRequestDispatcher("house.jsp");
			go.forward(request, response);
		}else
		{
			String sql1="select * from userinfo where email='"+email+"'";
			ResultSet rs1=asql.executeQuery(sql1);
			String useridentity=null;
			try {
				if(rs1.next())
				{
					useridentity=rs1.getString("useridentity");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(useridentity==null)
			{
				request.setAttribute("houseid",houseid);
				request.setAttribute("ff","您还没有完善个人信息，请先完善再行订购！");
				RequestDispatcher go=request.getRequestDispatcher("house.jsp");
				go.forward(request, response);
			}else
			{
				if(checkin.equals("") || checkout.equals(""))
				{
					request.setAttribute("houseid",houseid);
					request.setAttribute("ff","请完善订单信息！");
					RequestDispatcher go=request.getRequestDispatcher("house.jsp");
					go.forward(request, response);
				}else
				{
					String sql2="insert into order1(housename,checkin,checkout,univalent,status,email,house_owner_email,houseid,quantity)"
							+ "values('"+housename+"','"+checkin+"','"+checkout+"','"+univalent+"','0','"+email+"','"+house_owner_email+"','"+houseid+"','"+quantity+"')";
					String sql4="insert into order_message(email,house_owner_email,housename,checkin,checkout,univalent,status,houseid,quantity,message_status,order_table)"
							+ "values('"+email+"','"+house_owner_email+"','"+housename+"','"+checkin+"','"+checkout+"','"+univalent+"','0','"+houseid+"','"+quantity+"','0','1')";
					asql.executeUpdate(sql2);
					asql.executeUpdate(sql4);
					int i = Integer.parseInt(quantity); 
					int restnow=rest-i;
					String sql3="update houseinfo1 set rest='"+restnow+"' where houseid='"+houseid+"'";
					asql.executeUpdate(sql3);
					request.setAttribute("houseid",houseid);
					request.setAttribute("ff","订购成功，可前往个人中心-交易记录查看订单！");
					RequestDispatcher go=request.getRequestDispatcher("house.jsp");
					go.forward(request, response);
				}
			}
		}
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws IOException,ServletException{
		
		request. setCharacterEncoding("UTF-8");
		
		String houseid=request.getParameter("houseid");
		String checkin=request.getParameter("checkin");
		String checkout=request.getParameter("checkout");
		String housename=request.getParameter("housename");
		String univalent=request.getParameter("univalent");
		String quantity=request.getParameter("quantity");
		HttpSession session = request.getSession(true);
		String email=(String)session.getAttribute("email");
		
		SqlHelper asql=new SqlHelper();
		String sql0="select * from houseinfo1 where houseid='"+houseid+"'";
		ResultSet rs0=asql.executeQuery(sql0);
		String house_owner_email=null;
		int rest=0;
		try {
			if(rs0.next())
			{
				house_owner_email=rs0.getString("house_owner_email");
				rest=rs0.getInt("rest");
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(email==null)
		{
			request.setAttribute("houseid",houseid);
			request.setAttribute("ff","您还没有登录，请先登录！");
			RequestDispatcher go=request.getRequestDispatcher("house.jsp");
			go.forward(request, response);
		}else
		{
			String sql1="select * from userinfo where email='"+email+"'";
			ResultSet rs1=asql.executeQuery(sql1);
			String useridentity=null;
			try {
				if(rs1.next())
				{
					useridentity=rs1.getString("useridentity");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(useridentity==null)
			{
				request.setAttribute("houseid",houseid);
				request.setAttribute("ff","您还没有完善个人信息，请先完善再行订购！");
				RequestDispatcher go=request.getRequestDispatcher("house.jsp");
				go.forward(request, response);
			}else
			{
				if(checkin.equals("") || checkout.equals(""))
				{
					request.setAttribute("houseid",houseid);
					request.setAttribute("ff","请完善订单信息！");
					RequestDispatcher go=request.getRequestDispatcher("house.jsp");
					go.forward(request, response);
				}else
				{	
					String sql2="insert into order1(housename,checkin,checkout,univalent,status,email,house_owner_email,houseid,quantity)"
							+ "values('"+housename+"','"+checkin+"','"+checkout+"','"+univalent+"','0','"+email+"','"+house_owner_email+"','"+houseid+"','"+quantity+"')";
					String sql4="insert into order_message(email,house_owner_email,housename,checkin,checkout,univalent,status,houseid,quantity,message_status,order_table)"
							+ "values('"+email+"','"+house_owner_email+"','"+housename+"','"+checkin+"','"+checkout+"','"+univalent+"','0','"+houseid+"','"+quantity+"','0','1')";
					asql.executeUpdate(sql2);
					asql.executeUpdate(sql4);
					int i = Integer.parseInt(quantity); 
					int restnow=rest-i;
					String sql3="update houseinfo1 set rest='"+restnow+"' where houseid='"+houseid+"'";
					asql.executeUpdate(sql3);
					request.setAttribute("houseid",houseid);
					request.setAttribute("ff","订购成功，可前往个人中心-交易记录查看订单！");
					RequestDispatcher go=request.getRequestDispatcher("house.jsp");
					go.forward(request, response);
				}
			}
		}
	}
}
