package yang.servlet.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CheckServlet
 */
@WebServlet("/HttpServletRequestTest")
public class HttpServletRequestTest extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /**
         * 1.��ÿͻ�����Ϣ
         */
        String requestUrl = request.getRequestURL().toString();//�õ������URL��ַ
        String requestUri = request.getRequestURI();//�õ��������Դ
        String queryString = request.getQueryString();//�õ������URL��ַ�и����Ĳ���
        String remoteAddr = request.getRemoteAddr();//�õ������ߵ�IP��ַ
        String remoteHost = request.getRemoteHost();
        int remotePort = request.getRemotePort();
        String remoteUser = request.getRemoteUser();
        String method = request.getMethod();//�õ�����URL��ַʱʹ�õķ���
        String pathInfo = request.getPathInfo();
        String localAddr = request.getLocalAddr();//��ȡWEB��������IP��ַ
        String localName = request.getLocalName();//��ȡWEB��������������
        response.setCharacterEncoding("UTF-8");//���ý��ַ���"UTF-8"����������ͻ��������
        //ͨ��������Ӧͷ�����������UTF-8�ı�����ʾ���ݣ����������仰����ô�������ʾ�Ľ�������
        response.setHeader("content-type", "text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.write("��ȡ���Ŀͻ�����Ϣ���£�");
        out.write("<hr/>");
        out.write("�����URL��ַ��"+requestUrl);
        out.write("<br/>");
        out.write("�������Դ��"+requestUri);
        out.write("<br/>");
        out.write("�����URL��ַ�и����Ĳ�����"+queryString);
        out.write("<br/>");
        out.write("�����ߵ�IP��ַ��"+remoteAddr);
        out.write("<br/>");
        out.write("�����ߵ���������"+remoteHost);
        out.write("<br/>");
        out.write("ʹ�õĶ˿ںţ�"+remotePort);
        out.write("<br/>");
        out.write("remoteUser��"+remoteUser);
        out.write("<br/>");
        out.write("����ʹ�õķ�����"+method);
        out.write("<br/>");
        out.write("pathInfo��"+pathInfo);
        out.write("<br/>");
        out.write("localAddr��"+localAddr);
        out.write("<br/>");
        out.write("localName��"+localName);
        
       // response.setCharacterEncoding("UTF-8");//���ý��ַ���"UTF-8"����������ͻ��������
                 //ͨ��������Ӧͷ�����������UTF-8�ı�����ʾ����
         //        response.setHeader("content-type", "text/html;charset=UTF-8");
           //      PrintWriter out = response.getWriter();
                 Enumeration<String> reqHeadInfos = request.getHeaderNames();//��ȡ���е�����ͷ
                 out.write("��ȡ���Ŀͻ������е�����ͷ��Ϣ���£�");
                 out.write("<hr/>");
                 while (reqHeadInfos.hasMoreElements()) {
                     String headName = (String) reqHeadInfos.nextElement();
                     String headValue = request.getHeader(headName);//��������ͷ�����ֻ�ȡ��Ӧ������ͷ��ֵ
                     out.write(headName+":"+headValue);
                     out.write("<br/>");
                 }
                 out.write("<br/>");
                 out.write("��ȡ���Ŀͻ���Accept-Encoding����ͷ��ֵ��");
                 out.write("<hr/>");
                 String value = request.getHeader("Accept-Encoding");//��ȡAccept-Encoding����ͷ��Ӧ��ֵ
                 out.write(value);
                 
                 Enumeration<String> e = request.getHeaders("Accept-Encoding");
                 while (e.hasMoreElements()) {
                     String string = (String) e.nextElement();
                     System.out.println(string);
                 }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}