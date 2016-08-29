package yang.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDemo1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//Ҫ���ӵ����ݿ�URL
        String url = "jdbc:mysql://localhost:3306/sushe";
        System.out.println("The database you will connect is :"+url);
        //���ӵ����ݿ�ʱʹ�õ��û���
        String username = "root";
        //���ӵ����ݿ�ʱʹ�õ�����
        String password = "root";
        
        //1.��������
        //DriverManager.registerDriver(new com.mysql.jdbc.Driver());���Ƽ�ʹ�����ַ�ʽ����������
        Class.forName("com.mysql.jdbc.Driver");//�Ƽ�ʹ�����ַ�ʽ����������
        //2.��ȡ�����ݿ������
        Connection conn = DriverManager.getConnection(url, username, password);
        
        //3.��ȡ���������ݿⷢ��sql����statement
        Statement st = conn.createStatement();
        
        String sql = "select Student_ID,Student_Name,Student_Password,Student_Class,Student_Sex from student";
        System.out.println("The sql is:"+sql);
        //4.�����ݿⷢsql,����ȡ����������resultset
        ResultSet rs = st.executeQuery(sql);
        
        //5.ȡ�������������
        System.out.println("The result is:");
        while(rs.next()){
            System.out.println("Student_ID=" + rs.getObject("Student_ID"));
            System.out.println("Student_Name=" + rs.getObject("Student_Name"));
            System.out.println("Student_Password=" + rs.getObject("Student_Password"));
            System.out.println("Student_Class=" + rs.getObject("Student_Class"));
            System.out.println("Student_Sex=" + rs.getObject("Student_Sex"));
           // List<JSONObject> val = null;
        }
        //6.ʹ��excuteUpdate(String sql)����������ݵ���Ӳ���
        String sql2="insert into student(Student_DomitoryID,Student_Username,Student_Password,Student_Name,Student_Sex,Student_Class,Student_State)"
        		+ "values(1,'001','123','yang','��','�Ź�1101','��ס')";
        System.out.println(">Insert into a new list:"+sql2);
        int num = st.executeUpdate(sql2);
        if(num>0){
        	System.out.println("Insert Success!!");
        //	sysout
        }
        //6.�ر����ӣ��ͷ���Դ
        System.out.println("Now close the connection!");
        rs.close();
        st.close();
        conn.close();

	}

}
