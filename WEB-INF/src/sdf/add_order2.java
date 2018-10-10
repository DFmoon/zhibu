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

public class add_order2 extends HttpServlet {
	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws IOException,ServletException{
		
		request. setCharacterEncoding("UTF-8");
		
		String houseid=request.getParameter("houseid");
		String thingid=request.getParameter("thingid");
		String checkin=request.getParameter("checkin");
		String checkout=request.getParameter("checkout");
		String housename=request.getParameter("housename");
		String quantity=request.getParameter("quantity");
		HttpSession session = request.getSession(true);
		String email=(String)session.getAttribute("email");
		
		SqlHelper asql=new SqlHelper();
		String sql0="select * from houseinfo2 where houseid='"+houseid+"'";
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
			request.setAttribute("thingid",thingid);
			request.setAttribute("ff","����û�е�¼�����ȵ�¼��");
			RequestDispatcher go=request.getRequestDispatcher("house_thing.jsp");
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
				request.setAttribute("thingid",thingid);
				request.setAttribute("ff","����û�����Ƹ�����Ϣ�������������ж�����");
				RequestDispatcher go=request.getRequestDispatcher("house_thing.jsp");
				go.forward(request, response);
			}else
			{
				if(checkin.equals("") || checkout.equals(""))
				{
					request.setAttribute("houseid",houseid);
					request.setAttribute("thingid",thingid);
					request.setAttribute("ff","�����ƶ�����Ϣ��");
					RequestDispatcher go=request.getRequestDispatcher("house_thing.jsp");
					go.forward(request, response);
				}else
				{
					String sql2="insert into order2(housename,checkin,checkout,status,email,houseid,thingid,house_owner_email,quantity)"
							+ "values('"+housename+"','"+checkin+"','"+checkout+"','0','"+email+"','"+houseid+"','"+thingid+"','"+house_owner_email+"','"+quantity+"')";
					String sql4="insert into order_message(email,house_owner_email,housename,checkin,checkout,status,houseid,quantity,thingid,message_status,order_table)"
							+ "values('"+email+"','"+house_owner_email+"','"+housename+"','"+checkin+"','"+checkout+"','0','"+houseid+"','"+quantity+"','"+thingid+"','0','2')";
					asql.executeUpdate(sql2);
					asql.executeUpdate(sql4);
					int i = Integer.parseInt(quantity); 
					int restnow=rest-i;
					String sql3="update houseinfo2 set rest='"+restnow+"' where houseid='"+houseid+"'";
					asql.executeUpdate(sql3);
					request.setAttribute("houseid",houseid);
					request.setAttribute("thingid",thingid);
					request.setAttribute("ff","�����ɹ�����ǰ����������-���׼�¼�鿴������");
					RequestDispatcher go=request.getRequestDispatcher("house_thing.jsp");
					go.forward(request, response);
				}
			}
		}
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws IOException,ServletException{
		
request. setCharacterEncoding("UTF-8");
		
		String houseid=request.getParameter("houseid");
		String thingid=request.getParameter("thingid");
		String checkin=request.getParameter("checkin");
		String checkout=request.getParameter("checkout");
		String housename=request.getParameter("housename");
		String quantity=request.getParameter("quantity");
		HttpSession session = request.getSession(true);
		String email=(String)session.getAttribute("email");
		
		SqlHelper asql=new SqlHelper();
		String sql0="select * from houseinfo2 where houseid='"+houseid+"'";
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
			request.setAttribute("thingid",thingid);
			request.setAttribute("ff","����û�е�¼�����ȵ�¼��");
			RequestDispatcher go=request.getRequestDispatcher("house_thing.jsp");
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
				request.setAttribute("thingid",thingid);
				request.setAttribute("ff","����û�����Ƹ�����Ϣ�������������ж�����");
				RequestDispatcher go=request.getRequestDispatcher("house_thing.jsp");
				go.forward(request, response);
			}else
			{
				if(checkin.equals("") || checkout.equals(""))
				{
					request.setAttribute("houseid",houseid);
					request.setAttribute("thingid",thingid);
					request.setAttribute("ff","�����ƶ�����Ϣ��");
					RequestDispatcher go=request.getRequestDispatcher("house_thing.jsp");
					go.forward(request, response);
				}else
				{
					String sql2="insert into order2(housename,checkin,checkout,status,email,houseid,thingid,house_owner_email,quantity)"
							+ "values('"+housename+"','"+checkin+"','"+checkout+"','0','"+email+"','"+houseid+"','"+thingid+"','"+house_owner_email+"','"+quantity+"')";
					String sql4="insert into order_message(email,house_owner_email,housename,checkin,checkout,status,houseid,quantity,thingid,message_status,order_table)"
							+ "values('"+email+"','"+house_owner_email+"','"+housename+"','"+checkin+"','"+checkout+"','0','"+houseid+"','"+quantity+"','"+thingid+"','0','2')";
					asql.executeUpdate(sql2);
					asql.executeUpdate(sql4);
					int i = Integer.parseInt(quantity); 
					int restnow=rest-i;
					String sql3="update houseinfo2 set rest='"+restnow+"' where houseid='"+houseid+"'";
					asql.executeUpdate(sql3);
					request.setAttribute("houseid",houseid);
					request.setAttribute("thingid",thingid);
					request.setAttribute("ff","�����ɹ�����ǰ����������-���׼�¼�鿴������");
					RequestDispatcher go=request.getRequestDispatcher("house_thing.jsp");
					go.forward(request, response);
				}
			}
		}
	}
}
