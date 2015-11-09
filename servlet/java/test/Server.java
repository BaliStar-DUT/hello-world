package yang.java.test;

import java.net.ServerSocket; 
import java.net.Socket;
import java.net.InetAddress;
import java.net.SocketTimeoutException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.util.Timer;
/*
����TCPЭ���Socketͨ�ţ��������ˣ�ʵ���û���¼
*/
public class Server{
public static void main(String[] args){
		try{
		//1.����һ���������˵�Socket��ָ���󶨵Ķ˿�	
		ServerSocket serverSocket = new ServerSocket(8888);
		serverSocket.setSoTimeout(30*1000);//�������ӵĳ�ʱʱ��10��
		Socket socket = null;
		//��¼�ͻ������Ӵ���
		int count = 0;
		System.out.println("=======�����������������ȴ��ͻ��˵�����===========");
		while(true){
			//����accept()������ʼ�������ȴ��ͻ��˵�����
			socket = serverSocket.accept();
			 if(socket.isConnected()){
			 System.out.println("�Ѿ����ӡ���");
			 }
			//����һ���µ��߳�
			ServerThread serverThread = new ServerThread(socket);	
			//�����߳�
			serverThread.start();
			count++;
			System.out.println("�ͻ������Ӵ���"+count);
			InetAddress address = socket.getInetAddress();
			System.out.println("��ǰ�ͻ���IP:"+address.getHostAddress());
		}
		}catch(SocketTimeoutException e){
			System.out.println("���ӳ�ʱ��");
			//e.printStackTrace();
		}catch(Exception e){
			System.out.println("something goes wrong!");
			e.printStackTrace();
		}
	}
}