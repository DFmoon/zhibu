package sdf;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ifhouser extends HttpServlet {
	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws IOException,ServletException{
		
		request. setCharacterEncoding("UTF-8");
		String email=request.getParameter("email");//获取参数
		
		SqlHelper asql=new SqlHelper();//建立数据库操作对象
		String SQL="select * from userinfo where email='"+email+"'";//构建查询语句
		String ifhouse=null;
		ResultSet rs=asql.executeQuery(SQL); 
        try {
			if(rs.next())   
			{  
				ifhouse=rs.getString("ifhouse");
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		if(ifhouse.equals("是"))
		{
			RequestDispatcher go=request.getRequestDispatcher("iframe_house_add.jsp");
			go.forward(request, response);		
		}else
		{
			request.setAttribute("email", email);
			request.setAttribute("ifhouser", "请先申请成为房东，再来上传房源信息！");
			RequestDispatcher go=request.getRequestDispatcher("iframe_house_show.jsp");
			go.forward(request, response);
		}
		
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws IOException,ServletException{
		
		request. setCharacterEncoding("UTF-8");
		String email=request.getParameter("email");//获取参数
		
		SqlHelper asql=new SqlHelper();//建立数据库操作对象
		String SQL="select * from userinfo where email='"+email+"'";//构建查询语句
		String ifhouse=null;
		ResultSet rs=asql.executeQuery(SQL); 
        try {
			if(rs.next())   
			{  
				ifhouse=rs.getString("ifhouse");
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		if(ifhouse.equals("是"))
		{
			RequestDispatcher go=request.getRequestDispatcher("iframe_house_add.jsp");
			go.forward(request, response);		
		}else
		{
			request.setAttribute("email", email);
			request.setAttribute("ifhouser", "请先申请成为房东，再来上传房源信息！");
			RequestDispatcher go=request.getRequestDispatcher("iframe_house_show.jsp");
			go.forward(request, response);
		}
		
	}
}
