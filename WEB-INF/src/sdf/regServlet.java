package sdf;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class regServlet extends HttpServlet {
	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws IOException,ServletException{
		
		request. setCharacterEncoding("UTF-8");
		
		String uname=request.getParameter("username");//��ȡ����
		String uemail=request.getParameter("email");
		String upassword=request.getParameter("password");
		String question=request.getParameter("question");
		String answer=request.getParameter("answer");
		
		SqlHelper asql=new SqlHelper();//�������ݿ��������
		String SQL1="select * from userinfo where username='"+uname+"'";//������ѯ���
		String SQL2="select * from userinfo where email='"+uemail+"'";
		String str1=null;
		String str2=null;
		ResultSet rs1=asql.executeQuery(SQL1); 
		ResultSet rs2=asql.executeQuery(SQL2);
        try {
			while (rs1.next())   
			{  
			    str1=rs1.getString("username");
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
        try {
			while (rs2.next())   
			{  
			    str2=rs2.getString("email");
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(str1!=null)		//���û���ע��
		{
			request.setAttribute("y", "���û��Ѵ��ڣ���ֱ�ӵ�¼��");
			RequestDispatcher go=request.getRequestDispatcher("zhibu.jsp");
			go.forward(request, response);
		}
		else if(str1==null && str2!=null)		//�������ѱ�ע��
		{
			request.setAttribute("y", "�������ѱ�ע��,����������ַ��");
			RequestDispatcher go=request.getRequestDispatcher("zhibu.jsp");
			go.forward(request, response);
		}
		else{							//���û�������
			request.setAttribute("y", "ע��ɹ������¼��");
			String SQL3= "insert into userinfo (userName,email,password,ifhouse,question,answer) values ('"+uname+"','"+uemail+"','"+upassword+"','��','"+question+"','"+answer+"')";
			asql.executeQuery(SQL3);
			RequestDispatcher go=request.getRequestDispatcher("zhibu.jsp");
			go.forward(request, response);
		}
	}
	
	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws IOException,ServletException{
		
		request. setCharacterEncoding("UTF-8");
		
		String uname=request.getParameter("username");//��ȡ����
		String uemail=request.getParameter("email");
		String upassword=request.getParameter("password");
		String question=request.getParameter("question");
		String answer=request.getParameter("answer");
		
		SqlHelper asql=new SqlHelper();//�������ݿ��������
		String SQL1="select * from userinfo where username='"+uname+"'";//������ѯ���
		String SQL2="select * from userinfo where email='"+uemail+"'";
		String str1=null;
		String str2=null;
		ResultSet rs1=asql.executeQuery(SQL1); 
		ResultSet rs2=asql.executeQuery(SQL2);
        try {
			while (rs1.next())   
			{  
			    str1=rs1.getString("username");
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
        try {
			while (rs2.next())   
			{  
			    str2=rs2.getString("email");
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(str1!=null)		//���û���ע��
		{
			System.out.println("���û���ע��");
			request.setAttribute("y", "���û��Ѵ��ڣ���ֱ�ӵ�¼��");
			RequestDispatcher go=request.getRequestDispatcher("zhibu.jsp");
			go.forward(request, response);
		}
		else if(str1==null && str2!=null)		//�������ѱ�ע��
		{
			System.out.println("�������ѱ�ע��");
			request.setAttribute("y", "�������ѱ�ע��,����������ַ��");
			RequestDispatcher go=request.getRequestDispatcher("zhibu.jsp");
			go.forward(request, response);
		}
		else{							//���û�������
			System.out.println("���û�������");
			request.setAttribute("y", "ע��ɹ������¼��");
			String SQL3= "insert into userinfo (userName,email,password,ifhouse,question,answer) values ('"+uname+"','"+uemail+"','"+upassword+"','��','"+question+"','"+answer+"')";
			asql.executeQuery(SQL3);
			RequestDispatcher go=request.getRequestDispatcher("zhibu.jsp");
			go.forward(request, response);
		}
	}
}
