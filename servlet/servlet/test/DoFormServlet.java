package yang.servlet.test;
import java.io.IOException;
import java.text.MessageFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class CheckServlet
 */
@WebServlet("/DoFormServlet")
public class DoFormServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //�ͻ�������UTF-8�����ύ�����ݵģ�������Ҫ���÷���������UTF-8�ı�����н��գ���������������ݾͻ��������
        request.setCharacterEncoding("UTF-8");
        /**
         * ��&nbsp;&nbsp;��(�ı���)��
           <input type="text" name="userid" value="NO." size="2" maxlength="2">
         */
        String userid = request.getParameter("userid");//��ȡ��д�ı�ţ�userid���ı�������֣�<input type="text" name="userid">
        /**
         * �û���(�ı���)��<input type="text" name="username" value="�������û���">
         */
        String username = request.getParameter("username");//��ȡ��д���û���
        /**
         * ��&nbsp;&nbsp;��(�����)��<input type="password" name="userpass" value="����������">
         */
        String userpass = request.getParameter("userpass");//��ȡ��д������
        String sex = request.getParameter("sex");//��ȡѡ�е��Ա�
        String dept = request.getParameter("dept");//��ȡѡ�еĲ���
        //��ȡѡ�е���Ȥ����Ϊ����ѡ�ж��ֵ�����Ի�ȡ����ֵ��һ���ַ������飬�����Ҫʹ��getParameterValues��������ȡ
        String[] insts = request.getParameterValues("inst");
        String note = request.getParameter("note");//��ȡ��д��˵����Ϣ
        String hiddenField = request.getParameter("hiddenField");//��ȡ�����������
        
        String instStr="";
        /**
         * ��ȡ�������ݵļ��ɣ����Ա���insts����Ϊnullʱ�����Ŀ�ָ���쳣����
         */
        for (int i = 0; insts!=null && i < insts.length; i++) {
            if (i == insts.length-1) {
                instStr+=insts[i];
            }else {
                instStr+=insts[i]+",";
            }
        }
        
        String htmlStr = "<table>" +
                            "<tr><td>��д�ı�ţ�</td><td>{0}</td></tr>" +
                            "<tr><td>��д���û�����</td><td>{1}</td></tr>" +
                            "<tr><td>��д�����룺</td><td>{2}</td></tr>" +
                            "<tr><td>ѡ�е��Ա�</td><td>{3}</td></tr>" +
                            "<tr><td>ѡ�еĲ��ţ�</td><td>{4}</td></tr>" +
                            "<tr><td>ѡ�е���Ȥ��</td><td>{5}</td></tr>" +
                            "<tr><td>��д��˵����</td><td>{6}</td></tr>" +
                            "<tr><td>����������ݣ�</td><td>{7}</td></tr>" +
                        "</table>";
        htmlStr = MessageFormat.format(htmlStr, userid,username,userpass,sex,dept,instStr,note,hiddenField);
        
        response.setCharacterEncoding("UTF-8");//���÷���������UTF-8����������ݵ��ͻ���
        response.setContentType("text/html;charset=UTF-8");//���ÿͻ����������UTF-8�����������
        response.getWriter().write(htmlStr);//���htmlStr��������ݵ��ͻ����������ʾ
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}