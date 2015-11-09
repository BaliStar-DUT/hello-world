package yang.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

import yang.jdbc.JdbcUtils;

//import org.junit.Test;

/**
* @ClassName: JdbcCRUDByStatement
* @Description: ͨ��Statement������ɶ����ݿ��CRUD����
* @author: yangzhen
* @date: 2014-9-15 ����11:22:12
*
*/ 
public class JdbcCRUDByStatement {

    @Test
    public void insert(){
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try{
            //��ȡһ�����ݿ�����
            conn = JdbcUtils.getConnection();
            //ͨ��conn�����ȡ����ִ��SQL�����Statement����
            st = conn.createStatement();
            //Ҫִ�е�SQL����
            String sql="insert into student(Student_DomitoryID,Student_Username,Student_Password,Student_Name,Student_Sex,Student_Class,Student_State)"
            		+ "values(1,'001','123','yang','��','�Ź�1101','��ס')";            //ִ�в��������executeUpdate�������سɹ�������
            int num = st.executeUpdate(sql);
            if(num>0){
                System.out.println("����ɹ�����");
            }
            
        }catch (Exception e) {
            e.printStackTrace();
        }finally{
            //SQLִ�����֮���ͷ������Դ
            JdbcUtils.release(conn, st, rs);
        }
    }
    
    @Test
    public void delete(){
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try{
            conn = JdbcUtils.getConnection();
            String sql = "delete from student where Student_ID=3";
            st = conn.createStatement();
            int num = st.executeUpdate(sql);
            if(num>0){
                System.out.println("ɾ���ɹ�����");
            }
        }catch (Exception e) {
            e.printStackTrace();
            
        }finally{
            JdbcUtils.release(conn, st, rs);
        }
    }
    
    @Test
    public void update(){
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try{
            conn = JdbcUtils.getConnection();
            String sql = "update users set name='�°�����',email='gacl@sina.com' where id=3";
            st = conn.createStatement();
            int num = st.executeUpdate(sql);
            if(num>0){
                System.out.println("���³ɹ�����");
            }
        }catch (Exception e) {
            e.printStackTrace();
            
        }finally{
            JdbcUtils.release(conn, st, rs);
        }
    }
    
    @Test
    public void find(){
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try{
            conn = JdbcUtils.getConnection();
            String sql = "select * from student";
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            if(rs.next()){
                System.out.println(rs.getString("Student_Name"));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally{
            JdbcUtils.release(conn, st, rs);
        }
    }
}