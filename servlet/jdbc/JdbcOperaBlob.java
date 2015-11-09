package yang.jdbc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import yang.jdbc.JdbcUtils;
import org.junit.Test;

/**
* @ClassName: JdbcOperaBlob
* @Description: ʹ��JDBC����MySQL�Ķ���������(����ͼ����������������)
* @author: yangzhen
* @date: 2014-9-19 ����10:10:04
*
*/ 
public class JdbcOperaBlob {

    /**
    * @Method: add
    * @Description:�����ݿ��в������������
    * @Anthor:yangzhen
    *
    */ 
    @Test
    public void add(){
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            conn = JdbcUtils.getConnection();
            String sql = "insert into log(Log_image) values(?)";
            st = conn.prepareStatement(sql);
            //���ַ�ʽ��ȡ��·�������еĿո�ᱻʹ�á�%20������
            String path = JdbcOperaBlob.class.getClassLoader().getResource("QQ.png").getPath();
            //����%20���滻��ո�
            path = path.replaceAll("%20", " ");
            File file = new File(path);
            FileInputStream fis = new FileInputStream(file);//���ɵ���
            st.setBinaryStream(1, fis,(int) file.length());
            int num = st.executeUpdate();
            if(num>0){
                System.out.println("����ɹ�����");
            }
            fis.close();
        }catch (Exception e) {
            e.printStackTrace();
        }finally{
            JdbcUtils.release(conn, st, rs);
        }
    }
    
    /**
    * @Method: read
    * @Description: ��ȡ���ݿ��еĶ���������
    * @Anthor:�°�����
    *
    */ 
    @Test
    public void read() {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "select Log_image from log where Log_ID=?";
            st = conn.prepareStatement(sql);
            st.setInt(1, 4);
            rs = st.executeQuery();
            if (rs.next()) {
                //InputStream in = rs.getBlob("image").getBinaryStream();//���ַ���Ҳ����
                InputStream in = rs.getBinaryStream("Log_image");
                int len = 0;
                byte buffer[] = new byte[1024];
                
                FileOutputStream out = new FileOutputStream("D:\\1.jpg");
                while ((len = in.read(buffer)) > 0) {
                    out.write(buffer, 0, len);
                }
                in.close();
                out.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.release(conn, st, rs);
        }
    }
    public static void main(String[] args){
    	JdbcOperaBlob job = new JdbcOperaBlob();
    	job.add();
    	job.read();
    	
    }
}