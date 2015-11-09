package yang.java.test;

import java.util.Locale;
import java.util.ResourceBundle;
/**
* @ClassName: I18NTest
* @Description: ���ʵ�̶ֹ��ı��Ĺ��ʻ�
* @author: yangzhen
* @date: 2014-8-29 ����9:34:05
*
*/ 
public class I18NTest {

    public static void main(String[] args) {
        //��Դ������(����+myproperties)
        String basename = "yang.test.resource.yang_properties";
        //�������Ի���
        Locale jp =Locale.JAPAN;//����
        Locale cn = Locale.CHINA;//����
        Locale us = Locale.US;//Ӣ��
        Locale deff = Locale.getDefault();//Ĭ��
        
        //���ݻ��������Ի������ض�Ӧ��������Դ�ļ�
        ResourceBundle myResourcesCN = ResourceBundle.getBundle(basename,cn);//����myproperties_zh.properties
        ResourceBundle myResourcesUS = ResourceBundle.getBundle(basename,us);//����myproperties_en.properties
        ResourceBundle deffault = ResourceBundle.getBundle(basename,deff);
        
        //������Դ�ļ��� ����Ϳ��Ե���ResourceBundleʵ������� getString������ȡָ������Դ��Ϣ��������Ӧ��ֵ��
        //String value =  myResources.getString(��key");
        String usernameCN = myResourcesCN.getString("username");
        String passwordCN = myResourcesCN.getString("password");
        
        String usernameUS = myResourcesUS.getString("username");
        String passwordUS = myResourcesUS.getString("password");
        
        System.out.println(usernameCN+"--"+passwordCN);
        System.out.println(usernameUS+"--"+passwordUS);
    }
}
