package sdf;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class alter_password extends HttpServlet {
	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws IOException,ServletException{
		
		request. setCharacterEncoding("UTF-8");
		String email=request.getParameter("email");
		String yp=request.getParameter("yp");
		String xp=request.getParameter("xp");
		String xxp=request.getParameter("xxp");
		
		SqlHelper asql=new SqlHelper();//�������ݿ��������
		String SQL1="select * from userinfo where email='"+email+"'";//������ѯ���
		String str1=null;
		ResultSet rs1=asql.executeQuery(SQL1); 
        try {
			if(rs1.next())   
			{  
			    str1=rs1.getString("password");
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  

		if(str1!=null)		//���û���ע��
		{
			if(str1.equals(yp))
			{
				if(xp.equals(xxp))
				{
					String  SQL2 = "update userinfo set password='"+xp+"' where email='"+email+"'";
					asql.executeUpdate(SQL2);
					
					request.setAttribute("z", "�����޸ĳɹ���");
					RequestDispatcher go=request.getRequestDispatcher("alter_password.jsp");
					go.forward(request, response);
				}else
				{
					request.setAttribute("z", "�����������벻һ�£�");
					RequestDispatcher go=request.getRequestDispatcher("alter_password.jsp");
					go.forward(request, response);
				}
				
			}else
			{
				request.setAttribute("z", "ԭ�������");
				RequestDispatcher go=request.getRequestDispatcher("alter_password.jsp");
				go.forward(request, response);
			}
		}

		else{							//���û�������
			request.setAttribute("z", "���û���δע�ᣬ����ע�ᣡ");
			RequestDispatcher go=request.getRequestDispatcher("alter_password.jsp");
			go.forward(request, response);
		}
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws IOException,ServletException{
		
		request. setCharacterEncoding("UTF-8");
		String email=request.getParameter("email");
		String yp=request.getParameter("yp");
		String xp=request.getParameter("xp");
		
		SqlHelper asql=new SqlHelper();//�������ݿ��������
		String SQL1="select * from userinfo where email='"+email+"'";//������ѯ���
		String str1=null;
		ResultSet rs1=asql.executeQuery(SQL1); 
        try {
			if(rs1.next())   
			{  
			    str1=rs1.getString("password");
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  

		if(str1!=null)		//���û���ע��
		{
			if(str1.equals(yp))
			{
				String  SQL2 = "update userinfo set password='"+xp+"' where email='"+email+"'";
				asql.executeUpdate(SQL2);
		
				request.setAttribute("z", "�����޸ĳɹ���");
				RequestDispatcher go=request.getRequestDispatcher("alter_password.jsp");
				go.forward(request, response);
			}
			else
			{
				request.setAttribute("z", "ԭ�������");
				RequestDispatcher go=request.getRequestDispatcher("alter_password.jsp");
				go.forward(request, response);
			}
		}

		else{							//���û�������
			request.setAttribute("z", "���û���δע�ᣬ����ע�ᣡ");
			RequestDispatcher go=request.getRequestDispatcher("zhibu.jsp");
			go.forward(request, response);
		}
	}
}
