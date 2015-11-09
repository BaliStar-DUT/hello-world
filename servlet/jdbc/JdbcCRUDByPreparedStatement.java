package yang.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import yang.jdbc.JdbcUtils;

import org.junit.Test;

/**
* @ClassName: JdbcCRUDByPreparedStatement
* @Description: ͨ��PreparedStatement������ɶ����ݿ��CRUD����
* @author: yangzhen
* @date: 2014-9-15 ����11:21:42
*
*/ 
public class JdbcCRUDByPreparedStatement {

    @Test
    public void insert(){
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            //��ȡһ�����ݿ�����
            conn = JdbcUtils.getConnection();
            //Ҫִ�е�SQL���SQL�еĲ���ʹ��?��Ϊռλ��
            String sql = "insert into users(id,name,password,email,birthday) values(?,?,?,?,?)";
            //ͨ��conn�����ȡ����ִ��SQL�����prepareStatement����
            st = conn.prepareStatement(sql);
            //ΪSQL����еĲ�����ֵ��ע�⣬�����Ǵ�1��ʼ��
            /**
             * SQL����и����ֶε��������£�
             *  +----------+-------------+
                | Field    | Type        |
                +----------+-------------+
                | id       | int(11)     |
                | name     | varchar(40) |
                | password | varchar(40) |
                | email    | varchar(60) |
                | birthday | date        |
                +----------+-------------+
             */
            st.setInt(1, 1);//id��int���͵�
            st.setString(2, "�׻����");//name��varchar(�ַ�������)
            st.setString(3, "123");//password��varchar(�ַ�������)
            st.setString(4, "bhsh@sina.com");//email��varchar(�ַ�������)
            st.setDate(5, new java.sql.Date(new Date().getTime()));//birthday��date����
            //ִ�в��������executeUpdate�������سɹ�������
            int num = st.executeUpdate();
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
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            conn = JdbcUtils.getConnection();
            String sql = "delete from users where id=?";
            st = conn.prepareStatement(sql);
            st.setInt(1, 1);
            int num = st.executeUpdate();
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
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            conn = JdbcUtils.getConnection();
            String sql = "update users set name=?,email=? where id=?";
            st = conn.prepareStatement(sql);
            st.setString(1, "gacl");
            st.setString(2, "gacl@sina.com");
            st.setInt(3, 2);
            int num = st.executeUpdate();
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
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            conn = JdbcUtils.getConnection();
            String sql = "select * from users where id=?";
            st = conn.prepareStatement(sql);
            st.setInt(1, 1);
            rs = st.executeQuery();
            if(rs.next()){
                System.out.println(rs.getString("name"));
            }
        }catch (Exception e) {
            
        }finally{
            JdbcUtils.release(conn, st, rs);
        }
    }
}
