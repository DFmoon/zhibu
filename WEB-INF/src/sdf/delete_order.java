package sdf;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class delete_order extends HttpServlet {
	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws IOException,ServletException{
		
		request. setCharacterEncoding("UTF-8");	
		
		String orderid=request.getParameter("orderid");
		String ordertable=request.getParameter("ordertable");
		String me=request.getParameter("me");		//¡°3¡±ÊÇÍË¶©£¬¡°4¡±ÊÇÉ¾³ý
		String sql1="update order1 set status='3' where orderid='"+orderid+"'";
		String sql2="update order2 set status='3' where orderid='"+orderid+"'";
		String sql3="update order1 set status='4' where orderid='"+orderid+"'";
		String sql4="update order2 set status='4' where orderid='"+orderid+"'";
		String sql5="select * from order1 where orderid='"+orderid+"'";
		String sql6="select * from order2 where orderid='"+orderid+"'";
		
		SqlHelper asql=new SqlHelper();
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
		
		if(ordertable.equals("1"))
		{
			if(me.equals("1"))
			{
				asql.executeUpdate(sql1);
				
				String sql7="insert into order_message(email,house_owner_email,housename,checkin,checkout,univalent,status,houseid,quantity,message_status,order_table)"
						+ "values('"+a5+"','"+b5+"','"+c5+"','"+d5+"','"+e5+"','"+f5+"','3','"+g5+"','"+h5+"','0','1')";
				asql.executeUpdate(sql7);
				
				String sql11="select * from houseinfo1 where houseid='"+g5+"'";
				ResultSet rs11=asql.executeQuery(sql11);
				int rest=0;
				try {
					if(rs11.next())
					{
						rest=rs11.getInt("rest");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				int i = Integer.parseInt(h5); 
				int restnow=rest+i;
				String sql9="update houseinfo1 set rest='"+restnow+"' where houseid='"+g5+"'";
				asql.executeUpdate(sql9);
				
				RequestDispatcher go=request.getRequestDispatcher("iframe_orders.jsp");
				go.forward(request, response);
			}else if(me.equals("2"))
			{
				asql.executeUpdate(sql3);
				RequestDispatcher go=request.getRequestDispatcher("iframe_orders.jsp");
				go.forward(request, response);	
			}	
		}else if(ordertable.equals("2"))
		{
			if(me.equals("1"))
			{
				asql.executeUpdate(sql2);

				String sql8="insert into order_message(email,house_owner_email,housename,checkin,checkout,status,houseid,quantity,thingid,message_status,order_table)"
						+ "values('"+a6+"','"+b6+"','"+c6+"','"+d6+"','"+e6+"','3','"+g6+"','"+h6+"','"+f6+"','0','2')";
				asql.executeUpdate(sql8);
				
				String sql22="select * from houseinfo2 where houseid='"+g6+"'";
				ResultSet rs22=asql.executeQuery(sql22);
				int rest=0;
				try {
					if(rs22.next())
					{
						rest=rs22.getInt("rest");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				int i = Integer.parseInt(h6); 
				int restnow=rest+i;
				String sql10="update houseinfo2 set rest='"+restnow+"' where houseid='"+g6+"'";
				asql.executeUpdate(sql10);
				
				RequestDispatcher go=request.getRequestDispatcher("iframe_orders.jsp");
				go.forward(request, response);
			}else if(me.equals("2"))
			{
				asql.executeUpdate(sql4);
				RequestDispatcher go=request.getRequestDispatcher("iframe_orders.jsp");
				go.forward(request, response);	
			}
		}
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws IOException,ServletException{
		
		request. setCharacterEncoding("UTF-8");	
		
		String orderid=request.getParameter("orderid");
		String ordertable=request.getParameter("ordertable");
		String me=request.getParameter("me");		//¡°3¡±ÊÇÍË¶©£¬¡°4¡±ÊÇÉ¾³ý
		String sql1="update order1 set status='3' where orderid='"+orderid+"'";
		String sql2="update order2 set status='3' where orderid='"+orderid+"'";
		String sql3="update order1 set status='4' where orderid='"+orderid+"'";
		String sql4="update order2 set status='4' where orderid='"+orderid+"'";
		String sql5="select * from order1 where orderid='"+orderid+"'";
		String sql6="select * from order2 where orderid='"+orderid+"'";
		
		SqlHelper asql=new SqlHelper();
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
		
		if(ordertable.equals("1"))
		{
			if(me.equals("1"))
			{
				asql.executeUpdate(sql1);
				
				String sql7="insert into order_message(email,house_owner_email,housename,checkin,checkout,univalent,status,houseid,quantity,message_status,order_table)"
						+ "values('"+a5+"','"+b5+"','"+c5+"','"+d5+"','"+e5+"','"+f5+"','3','"+g5+"','"+h5+"','0','1')";
				asql.executeUpdate(sql7);
				
				String sql11="select * from houseinfo1 where houseid='"+g5+"'";
				ResultSet rs11=asql.executeQuery(sql11);
				int rest=0;
				try {
					if(rs11.next())
					{
						rest=rs11.getInt("rest");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				int i = Integer.parseInt(h5); 
				int restnow=rest+i;
				String sql9="update houseinfo1 set rest='"+restnow+"' where houseid='"+g5+"'";
				asql.executeUpdate(sql9);
				
				RequestDispatcher go=request.getRequestDispatcher("iframe_orders.jsp");
				go.forward(request, response);
			}else if(me.equals("2"))
			{
				asql.executeUpdate(sql3);
				RequestDispatcher go=request.getRequestDispatcher("iframe_orders.jsp");
				go.forward(request, response);	
			}	
		}else if(ordertable.equals("2"))
		{
			if(me.equals("1"))
			{
				asql.executeUpdate(sql2);
				
				String sql8="insert into order_message(email,house_owner_email,housename,checkin,checkout,status,houseid,quantity,thingid,message_status,order_table)"
						+ "values('"+a6+"','"+b6+"','"+c6+"','"+d6+"','"+e6+"','3','"+g6+"','"+h6+"','"+f6+"','0','2')";
				asql.executeUpdate(sql8);
				
				String sql22="select * from houseinfo2 where houseid='"+g6+"'";
				ResultSet rs22=asql.executeQuery(sql22);
				int rest=0;
				try {
					if(rs22.next())
					{
						rest=rs22.getInt("rest");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				int i = Integer.parseInt(h6); 
				int restnow=rest+i;
				String sql10="update houseinfo2 set rest='"+restnow+"' where houseid='"+g6+"'";
				asql.executeUpdate(sql10);
				
				RequestDispatcher go=request.getRequestDispatcher("iframe_orders.jsp");
				go.forward(request, response);
			}else if(me.equals("2"))
			{
				asql.executeUpdate(sql4);
				RequestDispatcher go=request.getRequestDispatcher("iframe_orders.jsp");
				go.forward(request, response);	
			}
		}
	}
}
