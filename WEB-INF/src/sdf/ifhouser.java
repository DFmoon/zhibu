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
		String email=request.getParameter("email");//��ȡ����
		
		SqlHelper asql=new SqlHelper();//�������ݿ��������
		String SQL="select * from userinfo where email='"+email+"'";//������ѯ���
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
		if(ifhouse.equals("��"))
		{
			RequestDispatcher go=request.getRequestDispatcher("iframe_house_add.jsp");
			go.forward(request, response);		
		}else
		{
			request.setAttribute("email", email);
			request.setAttribute("ifhouser", "���������Ϊ�����������ϴ���Դ��Ϣ��");
			RequestDispatcher go=request.getRequestDispatcher("iframe_house_show.jsp");
			go.forward(request, response);
		}
		
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws IOException,ServletException{
		
		request. setCharacterEncoding("UTF-8");
		String email=request.getParameter("email");//��ȡ����
		
		SqlHelper asql=new SqlHelper();//�������ݿ��������
		String SQL="select * from userinfo where email='"+email+"'";//������ѯ���
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
		if(ifhouse.equals("��"))
		{
			RequestDispatcher go=request.getRequestDispatcher("iframe_house_add.jsp");
			go.forward(request, response);		
		}else
		{
			request.setAttribute("email", email);
			request.setAttribute("ifhouser", "���������Ϊ�����������ϴ���Դ��Ϣ��");
			RequestDispatcher go=request.getRequestDispatcher("iframe_house_show.jsp");
			go.forward(request, response);
		}
		
	}
}
