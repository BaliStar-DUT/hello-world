package yang.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.json.JSONObject;

public class JdbcDemo2{

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//Ҫ���ӵ����ݿ�URL
      String url = "jdbc:mysql://localhost:3306/test";
      System.out.println("The database you will connect is :"+url);
      //���ӵ����ݿ�ʱʹ�õ��û���
      String username = "root";
      //���ӵ����ݿ�ʱʹ�õ�����
      String password = "root";
      
      //1.��������
      //DriverManager.registerDriver(new com.mysql.jdbc.Driver());���Ƽ�ʹ�����ַ�ʽ����������
		System.out.println("Now load the Driver!");
      Class.forName("com.mysql.jdbc.Driver");//�Ƽ�ʹ�����ַ�ʽ����������
      //2.��ȡ�����ݿ������
      Connection conn = DriverManager.getConnection(url, username, password);
      System.out.println("Now get the connection!");
      //3.��ȡ���������ݿⷢ��sql����statement
      Statement st = conn.createStatement();
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH)+1;
		int day = c.get(Calendar.DAY_OF_MONTH);
		int hour = c.get(Calendar.HOUR_OF_DAY);
		int minute = c.get(Calendar.MINUTE);
		int second = c.get(Calendar.SECOND);
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String now = sdf.format(date);
      System.out.println("The System time is:"+now);
		System.out.println("��ǰʱ�䣺"+year+"-"+month+"-"+day+" "+hour+":"+minute+":"+second);
		
		// if(hour>0&&hour<10){
			// formatdate = formatdate+"0"+hour;
		// }else{
			// formatdate = formatdate+hour;
		// }
		//hour=3;
		String sql1 = null;
		String formatdate = null;
		ResultSet rs =null;
		List<JSONObject> val = new ArrayList<JSONObject>();
		// for(int i=0;i<23;i++){	
			// formatdate="2015-07-05 ";
			// if((hour-i)>0&&(hour-i)<10){
				// formatdate = formatdate+"0"+(hour-i);
			// }else if((hour-i)<=0){
				// formatdate = formatdate+(23+hour-i);
			// }else{
				// formatdate = formatdate+(hour-i);
			// }
			// sql1 = "select hedstate,pfdate from h_pub_hedstate where pfdate like \'"+formatdate+"%\' limit 1";
			// System.out.println(sql1);
		// }
		for(int i=0;i<24;i++){
			int time = 0;
			if((hour-i)>=0){
				System.out.println(hour-i);
				time = hour-i;
				formatdate="2015-07-15 ";
			}else{
				System.out.println(24+hour-i);
				time = 24+hour-i;
				formatdate="2015-07-14 ";
			}
			if(time>=0&&time<10){
				formatdate = formatdate+"0"+time;
			}else{
				formatdate = formatdate+time;
			}
			sql1 = "select hedstate,pfdate from h_pub_hedstate where pfdate like \'"+formatdate+"%\' limit 1";
			//System.out.println(sql1);
			 System.out.println("The sql is:"+sql1);
      //4.�����ݿⷢsql,����ȡ����������resultset
			rs = st.executeQuery(sql1);
      
      //5.ȡ�������������
      System.out.println("The result is:");
      while(rs.next()){
          // System.out.println("Student_ID=" + rs.getObject("Student_ID"));
          // System.out.println("Student_Name=" + rs.getObject("Student_Name"));
          // System.out.println("Student_Password=" + rs.getObject("Student_Password"));
          // System.out.println("Student_Class=" + rs.getObject("Student_Class"));
          // System.out.println("Student_Sex=" + rs.getObject("Student_Sex"));
			System.out.println("hedstate:"+rs.getObject("hedstate"));
			System.out.println("pfdate"+rs.getObject("pfdate"));
			JSONObject json = new JSONObject().put("hedstate", rs.getObject("hedstate"));
			json.put("pfdate", rs.getObject("pfdate"));
			val.add(json);
			
      }
		}
      String sql = "select Student_ID,Student_Name,Student_Password,Student_Class,Student_Sex from student";
      // System.out.println("The sql is:"+sql1);
     // 4.�����ݿⷢsql,����ȡ����������resultset
      // ResultSet rs = st.executeQuery(sql1);
      
    //  5.ȡ�������������
      // System.out.println("The result is:");
      // while(rs.next()){
          // System.out.println("Student_ID=" + rs.getObject("Student_ID"));
          // System.out.println("Student_Name=" + rs.getObject("Student_Name"));
          // System.out.println("Student_Password=" + rs.getObject("Student_Password"));
          // System.out.println("Student_Class=" + rs.getObject("Student_Class"));
          // System.out.println("Student_Sex=" + rs.getObject("Student_Sex"));
			// System.out.println("hedstate:"+rs.getObject("hedstate"));
			// System.out.println("pfdate"+rs.getObject("pfdate"));
      // }
      //6.ʹ��excuteUpdate(String sql)����������ݵ���Ӳ���
      // String sql2="insert into student(Student_DomitoryID,Student_Username,Student_Password,Student_Name,Student_Sex,Student_Class,Student_State)"
      		// + "values(1,'001','123','yang','��','�Ź�1101','��ס')";
      // System.out.println(">Insert into a new list:"+sql2);
      // int num = st.executeUpdate(sql2);
      // if(num>0){
      	// System.out.println("Insert Success!!");
      // }
      //6.�ر����ӣ��ͷ���Դ
      System.out.println("Now close the connection!");
      rs.close();
      st.close();
      conn.close();

	}

}
