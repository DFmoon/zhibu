package sdf;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class find_password1 extends HttpServlet {
	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws IOException,ServletException{
		
		request. setCharacterEncoding("UTF-8");
		
		String uname=request.getParameter("username");//��ȡ����
		String uemail=request.getParameter("email");
		
		SqlHelper asql=new SqlHelper();//�������ݿ��������
		String SQL1="select * from userinfo where username='"+uname+"'";//������ѯ���
		String str1=null;
		String str2=null;
		String str3=null;
		ResultSet rs1=asql.executeQuery(SQL1); 
        try {
			if (rs1.next())   
			{  
			    str1=rs1.getString("email");
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  

		if(str1!=null)		//���û���ע��
		{
			if(str1.equals(uemail))
			{
				try {
					str2=rs1.getString("question");
					str3=rs1.getString("username");
					request.setAttribute("question", str2);
					request.setAttribute("email", str1);
					request.setAttribute("username", str3);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				RequestDispatcher go=request.getRequestDispatcher("find_password2.jsp");
				go.forward(request, response);
			}
			else
			{
				request.setAttribute("m", "�����ַ����ȷ�����������룡");
				RequestDispatcher go=request.getRequestDispatcher("find_password1.jsp");
				go.forward(request, response);
			}
		}
		else 
		{
			request.setAttribute("m", "���û���δע�ᣡ");
			RequestDispatcher go=request.getRequestDispatcher("find_password1.jsp");
			go.forward(request, response);
		}
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws IOException,ServletException{
		
		request. setCharacterEncoding("UTF-8");
		
		String uname=request.getParameter("username");//��ȡ����
		String uemail=request.getParameter("email");
		
		SqlHelper asql=new SqlHelper();//�������ݿ��������
		String SQL1="select * from userinfo where username='"+uname+"'";//������ѯ���
		String str1=null;
		String str2=null;
		ResultSet rs1=asql.executeQuery(SQL1); 
        try {
			if (rs1.next())   
			{  
			    str1=rs1.getString("email");
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  

		if(str1!=null)		//���û���ע��
		{
			if(str1.equals(uemail))
			{
				try {
					str2=rs1.getString("question");
					request.setAttribute("m", str2);
					request.setAttribute("email", str1);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				RequestDispatcher go=request.getRequestDispatcher("find_password2.jsp");
				go.forward(request, response);
			}
			else
			{
				request.setAttribute("m", "�����ַ����ȷ�����������룡");
				RequestDispatcher go=request.getRequestDispatcher("find_password1.jsp");
				go.forward(request, response);
			}
		}
		else 
		{
			request.setAttribute("m", "���û���δע�ᣡ");
			RequestDispatcher go=request.getRequestDispatcher("find_password1.jsp");
			go.forward(request, response);
		}
	}
}
