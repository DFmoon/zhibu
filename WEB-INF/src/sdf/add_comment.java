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

public class add_comment extends HttpServlet {
	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws IOException,ServletException{
		
		request. setCharacterEncoding("UTF-8");	
		
		String houseid=request.getParameter("houseid");
		String housetable=request.getParameter("housetable");
		String comment=request.getParameter("comment");
		String orderid=request.getParameter("orderid");
		HttpSession session = request.getSession(true);
		String email=(String)session.getAttribute("email");
		Date date=new Date();
		SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd");
		String comment_date = time.format(date);
		
		SqlHelper asql=new SqlHelper();
		String sql="insert into comment(housetable,houseid,comment,email,comment_date)values('"+housetable+"','"+houseid+"','"+comment+"','"+email+"','"+comment_date+"')";
		asql.executeUpdate(sql);
		
		String sql5="select * from order1 where orderid='"+orderid+"'";
		String sql6="select * from order2 where orderid='"+orderid+"'";
		ResultSet rs5=asql.executeQuery(sql5);
		ResultSet rs6=asql.executeQuery(sql6);
		String a5 = null,b5 = null,c5 = null,d5 = null,e5 = null,f5 = null,g5 = null,h5=null;
		String a6=null,b6=null,c6=null,d6=null,e6=null,f6=null,g6=null,h6=null;
		try {
			if(rs5.next())
			{
				a5=rs5.getString("email");
				b5=rs5.getString("house_owner_email");
				c5=rs5.getString("housename");
				d5=rs5.getString("checkin");
				e5=rs5.getString("checkout");
				f5=rs5.getString("univalent");
				g5=rs5.getString("houseid");
				h5=rs5.getString("quantity");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if(rs6.next())
			{
				a6=rs6.getString("email");
				b6=rs6.getString("house_owner_email");
				c6=rs6.getString("housename");
				d6=rs6.getString("checkin");
				e6=rs6.getString("checkout");
				f6=rs6.getString("thingid");
				g6=rs6.getString("houseid");
				h6=rs6.getString("quantity");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(housetable.equals("1"))
		{
			String  sql2 = "update order1 set status='2' where orderid='"+orderid+"' and status='1'";
			asql.executeUpdate(sql2);
			String sql3="insert into order_message(email,house_owner_email,housename,checkin,checkout,univalent,status,houseid,quantity,message_status,order_table)"
					+ "values('"+a5+"','"+b5+"','"+c5+"','"+d5+"','"+e5+"','"+f5+"','2','"+g5+"','"+h5+"','0','1')";
			asql.executeUpdate(sql3);
		}else if(housetable.equals("2"))
		{
			String  sql2 = "update order2 set status='2' where orderid='"+orderid+"' and status='1'";
			asql.executeUpdate(sql2);
			String sql4="insert into order_message(email,house_owner_email,housename,checkin,checkout,status,houseid,quantity,thingid,message_status,order_table)"
					+ "values('"+a6+"','"+b6+"','"+c6+"','"+d6+"','"+e6+"','2','"+g6+"','"+h6+"','"+f6+"','0','2')";
			asql.executeUpdate(sql4);
		}
		request.setAttribute("comm", "评论成功！");		
		RequestDispatcher go=request.getRequestDispatcher("iframe_orders.jsp");
		go.forward(request, response);
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws IOException,ServletException{
		
		request. setCharacterEncoding("UTF-8");	
		
		String houseid=request.getParameter("houseid");
		String housetable=request.getParameter("housetable");
		String comment=request.getParameter("comment");
		String orderid=request.getParameter("orderid");
		HttpSession session = request.getSession(true);
		String email=(String)session.getAttribute("email");
		Date date=new Date();
		SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd");
		String comment_date = time.format(date);
		
		SqlHelper asql=new SqlHelper();
		String sql="insert into comment(housetable,houseid,comment,email,comment_date)values('"+housetable+"','"+houseid+"','"+comment+"','"+email+"','"+comment_date+"')";
		asql.executeUpdate(sql);
		
		String sql5="select * from order1 where orderid='"+orderid+"'";
		String sql6="select * from order2 where orderid='"+orderid+"'";
		ResultSet rs5=asql.executeQuery(sql5);
		ResultSet rs6=asql.executeQuery(sql6);
		String a5 = null,b5 = null,c5 = null,d5 = null,e5 = null,f5 = null,g5 = null,h5=null;
		String a6=null,b6=null,c6=null,d6=null,e6=null,f6=null,g6=null,h6=null;
		try {
			if(rs5.next())
			{
				a5=rs5.getString("email");
				b5=rs5.getString("house_owner_email");
				c5=rs5.getString("housename");
				d5=rs5.getString("checkin");
				e5=rs5.getString("checkout");
				f5=rs5.getString("univalent");
				g5=rs5.getString("houseid");
				h5=rs5.getString("quantity");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if(rs6.next())
			{
				a6=rs6.getString("email");
				b6=rs6.getString("house_owner_email");
				c6=rs6.getString("housename");
				d6=rs6.getString("checkin");
				e6=rs6.getString("checkout");
				f6=rs6.getString("thingid");
				g6=rs6.getString("houseid");
				h6=rs6.getString("quantity");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(housetable.equals("1"))
		{
			String  sql2 = "update order1 set status='2' where orderid='"+orderid+"' and status='1'";
			asql.executeUpdate(sql2);
			String sql3="insert into order_message(email,house_owner_email,housename,checkin,checkout,univalent,status,houseid,quantity,message_status,order_table)"
					+ "values('"+a5+"','"+b5+"','"+c5+"','"+d5+"','"+e5+"','"+f5+"','2','"+g5+"','"+h5+"','0','1')";
			asql.executeUpdate(sql3);
		}else if(housetable.equals("2"))
		{
			String  sql2 = "update order2 set status='2' where orderid='"+orderid+"' and status='1'";
			asql.executeUpdate(sql2);
			String sql4="insert into order_message(email,house_owner_email,housename,checkin,checkout,status,houseid,quantity,thingid,message_status,order_table)"
					+ "values('"+a6+"','"+b6+"','"+c6+"','"+d6+"','"+e6+"','2','"+g6+"','"+h6+"','"+f6+"','0','2')";
			asql.executeUpdate(sql4);
		}
		request.setAttribute("comm", "评论成功！");
		RequestDispatcher go=request.getRequestDispatcher("iframe_orders.jsp");
		go.forward(request, response);
	}
}
