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

public class checkdate extends HttpServlet {
	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws IOException,ServletException{
		
		request. setCharacterEncoding("UTF-8");	
		
		Date date=new Date();
		SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd");
		String now = time.format(date);
		HttpSession session = request.getSession(true);
		String email=(String)session.getAttribute("email");
		SqlHelper asql=new SqlHelper();
		String sql1="select * from order1 where email='"+email+"'";
		ResultSet rs1=asql.executeQuery(sql1);
		try {
			while(rs1.next())
			{
				String checkout=rs1.getString("checkout");
				String orderid=rs1.getString("orderid");
				String houseid=rs1.getString("houseid");
				String quantity=rs1.getString("quantity");
				
				Date bt=time.parse(now);
				Date et=time.parse(checkout);
				if (et.before(bt))
				{
					String  sql2 = "update order1 set status='1' where orderid='"+orderid+"' and status='0'";
					asql.executeUpdate(sql2);
					
					String sql11="select * from houseinfo1 where houseid='"+houseid+"'";
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
					int i = Integer.parseInt(quantity); 
					int restnow=rest+i;
					String sql12="update houseinfo1 set rest='"+restnow+"' where houseid='"+houseid+"'";
					asql.executeUpdate(sql12);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql3="select * from order2 where email='"+email+"'";
		ResultSet rs3=asql.executeQuery(sql3);
		try {
			while(rs3.next())
			{
				String checkout=rs3.getString("checkout");
				String orderid=rs3.getString("orderid");
				String houseid=rs3.getString("houseid");
				String quantity=rs3.getString("quantity");
		
				Date bt=time.parse(now);
				Date et=time.parse(checkout);
				if (et.before(bt))
				{
					String  sql4 = "update order2 set status='1' where orderid='"+orderid+"' and status='0'";
					asql.executeUpdate(sql4);
					
					String sql21="select * from houseinfo2 where houseid='"+houseid+"'";
					ResultSet rs21=asql.executeQuery(sql21);
					int rest=0;
					try {
						if(rs21.next())
						{
							rest=rs21.getInt("rest");
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					int i = Integer.parseInt(quantity); 
					int restnow=rest+i;
					String sql22="update houseinfo2 set rest='"+restnow+"' where houseid='"+houseid+"'";
					asql.executeUpdate(sql22);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher go=request.getRequestDispatcher("iframe_orders.jsp");
		go.forward(request, response);
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws IOException,ServletException{
		
		request. setCharacterEncoding("UTF-8");	
		
		Date date=new Date();
		SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd");
		String now = time.format(date);
		HttpSession session = request.getSession(true);
		String email=(String)session.getAttribute("email");
		SqlHelper asql=new SqlHelper();
		String sql1="select * from order1 where email='"+email+"'";
		ResultSet rs1=asql.executeQuery(sql1);
		try {
			while(rs1.next())
			{
				String checkout=rs1.getString("checkout");
				String orderid=rs1.getString("orderid");
				String houseid=rs1.getString("houseid");
				String quantity=rs1.getString("quantity");
		
				Date bt=time.parse(now);
				Date et=time.parse(checkout);
				if (et.before(bt))
				{
					String  sql2 = "update order1 set status='1' where orderid='"+orderid+"' and status='0'";
					asql.executeUpdate(sql2);	
					
					String sql11="select * from houseinfo1 where houseid='"+houseid+"'";
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
					int i = Integer.parseInt(quantity); 
					int restnow=rest+i;
					String sql12="update houseinfo1 set rest='"+restnow+"' where houseid='"+houseid+"'";
					asql.executeUpdate(sql12);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql3="select * from order2 where email='"+email+"'";
		ResultSet rs3=asql.executeQuery(sql3);
		try {
			while(rs3.next())
			{
				String checkout=rs3.getString("checkout");
				String orderid=rs3.getString("orderid");
				String houseid=rs3.getString("houseid");
				String quantity=rs3.getString("quantity");
		
				Date bt=time.parse(now);
				Date et=time.parse(checkout);
				if (et.before(bt))
				{
					String  sql4 = "update order2 set status='1' where orderid='"+orderid+"' and status='0'";
					asql.executeUpdate(sql4);	
					
					String sql21="select * from houseinfo2 where houseid='"+houseid+"'";
					ResultSet rs21=asql.executeQuery(sql21);
					int rest=0;
					try {
						if(rs21.next())
						{
							rest=rs21.getInt("rest");
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					int i = Integer.parseInt(quantity); 
					int restnow=rest+i;
					String sql22="update houseinfo2 set rest='"+restnow+"' where houseid='"+houseid+"'";
					asql.executeUpdate(sql22);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher go=request.getRequestDispatcher("iframe_orders.jsp");
		go.forward(request, response);
	}
}
