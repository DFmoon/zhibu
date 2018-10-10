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

public class add_thing extends HttpServlet {
	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws IOException,ServletException{
		
		request. setCharacterEncoding("UTF-8");	
		
		String change_intro=request.getParameter("change_intro");
		String houseid=request.getParameter("houseid");
		
		SqlHelper asql=new SqlHelper();
		String sql="insert into changething(change_intro)values('"+change_intro+"')";
		if(change_intro==null || change_intro.equals(""))
		{	
			request.setAttribute("houseid", houseid);
			request.setAttribute("ch", "交易物品描述不得为空！");
			RequestDispatcher go=request.getRequestDispatcher("thing_introupload.jsp");
			go.forward(request, response);			
		}else
		{
			asql.executeUpdate(sql);		
			request.setAttribute("thing", "文字上传成功，继续上传描述图片吧！");
			
			String  sql2 = "select * from changething";
			int str1=0;
			ResultSet rs2=asql.executeQuery(sql2);
			try {
				while(rs2.next())
				{
					int str=rs2.getInt("thingid");
					if(str>str1)
					{	
						str1=str;
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String str=""+str1;
			request.setAttribute("thingid", str);
			request.setAttribute("houseid", houseid);
			RequestDispatcher go=request.getRequestDispatcher("thing_picupload.jsp");
			go.forward(request, response);
		}	
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws IOException,ServletException{
		
		request. setCharacterEncoding("UTF-8");	
		
		String change_intro=request.getParameter("change_intro");
		String houseid=request.getParameter("houseid");
		
		SqlHelper asql=new SqlHelper();
		String sql="insert into changething(change_intro)values('"+change_intro+"')";
		if(change_intro==null || change_intro.equals(""))
		{
			request.setAttribute("houseid", houseid);
			request.setAttribute("ch", "交易物品描述不得为空！");
			RequestDispatcher go=request.getRequestDispatcher("thing_introupload.jsp");
			go.forward(request, response);
		}else
		{
			asql.executeUpdate(sql);			
			request.setAttribute("thing", "文字上传成功，继续上传描述图片吧！");
			
			String  sql2 = "select * from changething";
			int str1=0;
			ResultSet rs2=asql.executeQuery(sql2);
			try {
				while(rs2.next())
				{
					int str=rs2.getInt("thingid");
					if(str>str1)
					{	
						str1=str;
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String str=""+str1;
			request.setAttribute("thingid", str);
			request.setAttribute("houseid", houseid);
			RequestDispatcher go=request.getRequestDispatcher("thing_picupload.jsp");
			go.forward(request, response);
		}		
	}
}
