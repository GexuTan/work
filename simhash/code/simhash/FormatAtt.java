package simhash;

import java.io.BufferedReader;
import java.io.CharArrayWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;

/*��ԭʼ�ı����д�����ȡ���������ݶ�
 * */
public class FormatAtt {

	public static void main(String[] args)throws Exception {
	
		String srcStr = "��";        
        String replaceStr = "\n";     
          
        // ��  
        File file = new File("len/RRA" +".txt");   
          
        FileReader in = new FileReader(file);  
        
        BufferedReader br = new BufferedReader(new InputStreamReader(
				new FileInputStream(file), "UTF-8"));
          
        // �ڴ���, ��Ϊ��ʱ��  
        CharArrayWriter  tempStream = new CharArrayWriter();  
          
        // �滻  
        String line = null;  
          
        while ( (line = br.readLine()) != null) {  
        	
            // �滻ÿ����, �����������ַ���  
            line = line.replaceAll(srcStr, replaceStr);  
            // ������д���ڴ�  
            tempStream.write(line+"\n");  
            // ��ӻ��з�  
            tempStream.append(System.getProperty("line.separator"));  
        }  
          
        // �ر� ������  
        br.close();  
          
        // ���ڴ��е��� д�� �ļ�  
        FileWriter out = new FileWriter(file);  
        tempStream.writeTo(out);  
        out.close();
	}

}
