package yang.servlet.test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CheckServlet
 */
@WebServlet("/CheckServlet")
public class CheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String clientCheckcode = request.getParameter("validateCode");//���տͻ���������ύ��������֤��
		         String serverCheckcode = (String) request.getSession().getAttribute("checkcode");//�ӷ������˵�session��ȡ����֤��
		         if (clientCheckcode.equals(serverCheckcode)) {//���ͻ�����֤��ͷ���������֤�Ƚϣ������ȣ����ʾ��֤ͨ��
		            System.out.println("��֤����֤ͨ����");
		       }else {
		            System.out.println("��֤����֤ʧ�ܣ�");
		        }
		        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
