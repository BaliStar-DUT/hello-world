package yang.servlet.test;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletTest
 */
@WebServlet("/ServletTest")
public class ServletTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/*
	 * 
	 
	private ServletConfig config;
	public void init(ServletConfig config){
		this.config=config;
	}*/
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//String paramVal = this.config.getInitParameter("name");
		//response.getWriter().println(paramVal);//��ȡwebӦ�õĳ�ʼ������
		/*
		 * ����refresh��Ӧͷ���������ÿ1��ˢ��һ��
		 */
		response.setHeader("refresh", "1");
		
		response.getWriter().print("<hr />");
		
		/*Enumeration<String> e = config.getInitParameterNames();
		while(e.hasMoreElements()){
			String name = e.nextElement();
			String value = config.getInitParameter(name);
			response.getWriter().print(name+"="+value+"<br />");
		}*/
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method<br />");
		out.println("Today is ");
		Date date= new Date();
		DateFormat dateForm = DateFormat.getDateTimeInstance();
		out.println(dateForm.format(date));
		
		out.println("<br />another time  is: ");
		
		Date date2 = new Date();
		Calendar cl= Calendar.getInstance();
		cl.setTime(date);
		cl.add(Calendar.HOUR_OF_DAY, -50);
		out.println(cl.getTime()+"<br />");
		long a = (date.getTime()-cl.getTimeInMillis())/1000;
		float b = (float)(a/3600);
		if(b>24)
		{
			int c = (int)b/24;
			out.println("day:"+c+"<br />");
		}else if(b<1){
			out.println("minutes"+b*60);
		}else{
			int d = (int)b;
			out.println("hours"+d+"<br />");
		}
		//out.println(date2.toString()+"<br />");
		date2.setMinutes(40);
		date2.setHours(13);
		out.println(date2.toString()+"<br />");
		out.println("day:"+date.getDate());
		out.println("hour :"+date.getHours()+"<br />");
		out.println("day:"+date2.getDate());
		out.println("hour :"+date2.getHours()+"<br />");
		int day= date.getDate()-date2.getDate();
		if(day>0)
		{
			out.println(day+"days before");
		}else{
			int hour= date.getHours()-date2.getHours();
			if(hour>0){
			out.println(hour+"hours before");
			}else{
			int minute = date.getMinutes()-date2.getMinutes();
			out.println(minute+"minutes before");
			}
		}
		long timebetween = date.getTime()-date2.getTime();
		out.println(timebetween+"<br />");
		date2.setTime(timebetween);
		out.println(date2.toString()+"<br />");
		out.println(date2.getMinutes()+"<br />");
		
		
		
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
		
		try {
			//outputChineseByOutputStream(response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//ʹ��OutputStream���������
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
		//doGet(request, response);
	}
	/*
	 * ʹ��outpurstream���������
	 */
	public void outputChineseByOutputStream(HttpServletResponse response) throws Exception{
		 /**
		  * ��OutputStream�������ע�����⣺
		          * �ڷ������ˣ����������ĸ��������ģ���ô��Ҫ���ƿͻ������������Ӧ�����򿪣�
		28          * ���磺outputStream.write("�й�".getBytes("UTF-8"));//ʹ��OutputStream����ͻ��������������ģ���UTF-8�ı���������
		29          * ��ʱ��Ҫ���ƿͻ����������UTF-8�ı���򿪣�������ʾ��ʱ��ͻ�����������룬��ô�ڷ���������ο��ƿͻ������������UTF-8�ı�����ʾ�����أ�
		30          * ����ͨ��������Ӧͷ�������������Ϊ�����磺
		31          * response.setHeader("content-type", "text/html;charset=UTF-8");//ͨ��������Ӧͷ�����������UTF-8�ı�����ʾ����
		32          */
		String data = "�й�";
		OutputStream outputStream = response.getOutputStream();//��ȡoutputstream�����
		response.setHeader("content-type", "text/html;charset=UTF-8");//ͨ��������Ӧͷ�����������UTF-8�ı�����ʾ���ݣ����������仰����ô�������ʾ�Ľ�������
		
		
		/**
		37          * data.getBytes()��һ�����ַ�ת�����ֽ�����Ĺ��̣����������һ����ȥ�����
		38          * ��������ĵĲ���ϵͳ������Ĭ�Ͼ��ǲ��Ҳ�GB2312�����
		39          * ���ַ�ת�����ֽ�����Ĺ��̾��ǽ������ַ�ת����GB2312������϶�Ӧ������
		40          * ���磺 "��"��GB2312������϶�Ӧ��������98
		41          *         "��"��GB2312������϶�Ӧ��������99
		42          */
	       /**
		44          * getBytes()�������������������ô�ͻ���ݲ���ϵͳ�����Ի�����ѡ��ת�������������Ĳ���ϵͳ����ô��ʹ��GB2312�����
		45          */
		
		
		byte[] dataByteArr = data.getBytes("UTF-8");//���ַ�ת�����ֽ����飬ָ����UTF-8�������ת��
		outputStream.write(dataByteArr);
	}

}
