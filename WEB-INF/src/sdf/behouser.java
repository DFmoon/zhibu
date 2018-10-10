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

public class behouser extends HttpServlet {
	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws IOException,ServletException{
		
		request. setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(true);
		String email=(String)session.getAttribute("email");
		
		SqlHelper asql=new SqlHelper();//建立数据库操作对象
		String SQL="select * from userinfo where email='"+email+"'";//构建查询语句
		ResultSet rs=asql.executeQuery(SQL); 
		if(email!=null){
	        try {
				if(rs.next())   
				{  
					String useridentity=rs.getString("useridentity");
					String realname=rs.getString("realname");
					String ifhouse=rs.getString("ifhouse");
					if(useridentity!=null && realname!=null)
					{
						if(ifhouse.equals("否"))
						{
							String  SQL2 = "update userinfo set ifhouse='是' where email='"+email+"'";
							asql.executeUpdate(SQL2);
							request.setAttribute("be", "申请成功，请前往个人中心上传房源信息！");
							RequestDispatcher go=request.getRequestDispatcher("zhibu.jsp");
							go.forward(request, response);
						}else
						{
							request.setAttribute("be", "您已成为房东，请前往个人中心上传房源信息！");
							RequestDispatcher go=request.getRequestDispatcher("zhibu.jsp");
							go.forward(request, response);
						}
					}else
					{
						request.setAttribute("be", "申请失败，请先完善个人信息！");
						RequestDispatcher go=request.getRequestDispatcher("zhibu.jsp");
						go.forward(request, response);
					}
				} 
	        }catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}else
		{
			request.setAttribute("be", "该用户尚未登录！");
			RequestDispatcher go=request.getRequestDispatcher("zhibu.jsp");
			go.forward(request, response);
		}
		
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws IOException,ServletException{
		
		request. setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(true);
		String email=(String)session.getAttribute("email");
		
		SqlHelper asql=new SqlHelper();//建立数据库操作对象
		String SQL="select * from userinfo where email='"+email+"'";//构建查询语句
		ResultSet rs=asql.executeQuery(SQL); 
		if(email!=null){
	        try {
				if(rs.next())   
				{  
					String useridentity=rs.getString("useridentity");
					String realname=rs.getString("realname");
					String ifhouse=rs.getString("ifhouse");
					if(useridentity!=null && realname!=null)
					{
						if(ifhouse.equals("否"))
						{
							String  SQL2 = "update userinfo set ifhouse='是' where email='"+email+"'";
							asql.executeUpdate(SQL2);
							request.setAttribute("be", "申请成功，请前往个人中心上传房源信息！");
							RequestDispatcher go=request.getRequestDispatcher("zhibu.jsp");
							go.forward(request, response);
						}else
						{
							request.setAttribute("be", "您已成为房东，请前往个人中心上传房源信息！");
							RequestDispatcher go=request.getRequestDispatcher("zhibu.jsp");
							go.forward(request, response);
						}
					}else
					{
						request.setAttribute("be", "申请失败，请先完善个人信息！");
						RequestDispatcher go=request.getRequestDispatcher("zhibu.jsp");
						go.forward(request, response);
					}
				} 
	        }catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}else
		{
			request.setAttribute("be", "该用户尚未登录！");
			RequestDispatcher go=request.getRequestDispatcher("zhibu.jsp");
			go.forward(request, response);
		}
	}
}
