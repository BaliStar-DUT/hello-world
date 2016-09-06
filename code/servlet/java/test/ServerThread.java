package yang.java.test;

import java.net.Socket;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedReader;
/*
����TCPЭ���Socketͨ�ţ����������̴߳���
*/
public class ServerThread extends Thread{
	//�ͱ��߳���ص�socket
	Socket socket = null;	
	PrintWriter pw = null;
	OutputStream os = null;
	BufferedReader br = null;
	InputStreamReader isr = null;
	InputStream is = null;
	public ServerThread(Socket socket){
		this.socket = socket;
	}
	//�߳�ִ�еĲ�������Ӧ�ͻ��˵�����
	public void run(){
	try{
		InputStream is = socket.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String info = null;
		while((info = br.readLine())!=null){
			System.out.println("I am the Server the client Syas:"+info);
		}
		socket.shutdownInput();
		OutputStream os = socket.getOutputStream();
		PrintWriter pw = new PrintWriter(os);
		pw.write("Welcome!");
		pw.flush();
		}catch(Exception e){
		System.out.println("something goes wrong!");
		}finally{
			try{
			//�ر���Դ
			pw.close();
			os.close();
			br.close();
			isr.close();
			is.close();
			socket.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}
