package sdf;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class articleupload extends HttpServlet {

public articleupload(){
   super();
}

public void destroy() {
   super.destroy(); // Just puts "destroy" string in log
   // Put your code here
}

public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
	
	request. setCharacterEncoding("UTF-8");
	String articleid=request.getParameter("articleid");
	
	String contentType=request.getContentType();
	String servername=request.getServerName();
	String realpath="C:\\Program Files\\Apache Software Foundation\\Tomcat 8.0\\webapps\\ROOT\\upload\\";
	
//	System.out.println(contentType);

	InputStream in=null;
	OutputStream out=null;
	if(contentType.indexOf("multipart/form-data")>=0){
		in=request.getInputStream();
		int formlength=request.getContentLength();
		byte[] formcontent=new byte[formlength];
		int totalread=0;
		int nowread=0;
		while(totalread<formlength){
			nowread=in.read(formcontent,totalread, formlength);
			totalread+=nowread;
		}
	String strcontent=new String(formcontent);
	
//   截取formType    
	int typestart=strcontent.indexOf("Content-Type:")+14;
    int typeend=strcontent.indexOf("\n", typestart)-1;
    String formType=strcontent.substring(typestart, typeend);
    if(formType.equals("image/jpeg")||formType.equals("image/gif")||formType.equals("image/pjepg")){
   //   截取filename
    	int filenamestart=strcontent.indexOf("filename=\"")+10;
    	int filenameend=strcontent.indexOf("\n",filenamestart)-2;
    	String filename=strcontent.substring(filenamestart,filenameend);
    	filename=filename.substring(filename.lastIndexOf("."));
    	String newfilename=""+(new Date()).getDate()+(new Date()).getHours()+(new Date()).getMinutes()+(new Date()).getSeconds();
    	newfilename=newfilename+filename;
    	newfilename=realpath+newfilename;
    	
    	int filestart=strcontent.indexOf("\n",typestart)+1;
    	filestart=strcontent.indexOf("\n",filestart)+1;
    	int intboundary=contentType.indexOf("boundary=")+10;
    	String strboundary=contentType.substring(intboundary);
    	int fileend=strcontent.indexOf(strboundary,filestart)-4;
    	String saveFile=strcontent.substring(filestart,fileend);
    	int contentstart=strcontent.substring(0,filestart).getBytes().length;
    	int contentend=strcontent.substring(0,fileend).getBytes().length;
    	
    	
    	out=new FileOutputStream(newfilename);
    	out.write(formcontent, contentstart,contentend-contentstart);
    	int st=newfilename.indexOf("upload")+7;
    	String icon=newfilename.substring(st);
    	icon="upload/"+icon; 
    	    	
    	SqlHelper asql=new SqlHelper();//建立数据库操作对象
		String  sql = "update article set pic='"+icon+"' where articleid='"+articleid+"'";
		asql.executeUpdate(sql);
		request.setAttribute("rr2", "上传成功!");
		request.setAttribute("articleid",articleid);
    	RequestDispatcher go=request.getRequestDispatcher("iframe_article_add1.jsp");
    	go.forward(request, response);
    }else{
    	request.setAttribute("rr2", "请上传格式为jpg的图片!");
    	request.setAttribute("articleid",articleid);
    	RequestDispatcher go=request.getRequestDispatcher("iframe_article_add1.jsp");
    	go.forward(request, response);
    }
   }
	
}
public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
   doGet(request,response);
}

public void init() throws ServletException {
   // Put your code here
}

}
