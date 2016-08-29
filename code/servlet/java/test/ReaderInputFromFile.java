package yang.java.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
/**
 * ������CSV�ļ�������ʶ�𶺺�',',����'"'����������������������
 * @author yangzhene
 *
 */
public class ReaderInputFromFile {

	public static void main(String[] args){
		long startTime = System.currentTimeMillis();
		Path file = Paths.get("C:\\Users\\yangzhene\\Desktop\\original_data2.csv");
		if(!Files.exists(file)){
			System.out.println(file+" does't exist.Terminating program!");
			System.exit(1);
		}
		try(BufferedReader fileIn = new BufferedReader(Files.newBufferedReader(file, Charset.forName("UTF-8")))){
			String saying = null;
			int totalRead = 0;
			while((saying = fileIn.readLine())!=null){
				//System.out.println(saying);
				readStr(saying); 
				//System.out.println();
								
				++totalRead;
			}
			System.out.format("%d sayings read.%n", totalRead);
			long endTime = System.currentTimeMillis();
			System.out.println("Use:"+(endTime-startTime)+"ms");
		}catch(IOException e){
			System.out.println("Error reading file:"+file);
			e.printStackTrace();
		}
	}
	public static void readStr(String saying){
		int a1 = saying.indexOf(',');
		if(a1==-1){
			System.out.println(readWord(saying));
		}else{
			String b = saying.substring(0,a1);
			System.out.print(readWord(b)+" | ");
			String str1 = saying.substring(a1+1, saying.length());
			readStr(str1);
		}

	}
	public static String readWord(String str){
		int a = str.indexOf('"');
		int b = str.lastIndexOf('"');
		return str.substring(a+1, b);
	}
	
}
