package simhash;

import java.io.BufferedReader;
import java.io.CharArrayWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;

/*对原始文本进行处理，提取出相似数据对
 * */
public class FormatAtt {

	public static void main(String[] args)throws Exception {
	
		String srcStr = "－";        
        String replaceStr = "\n";     
          
        // 读  
        File file = new File("len/RRA" +".txt");   
          
        FileReader in = new FileReader(file);  
        
        BufferedReader br = new BufferedReader(new InputStreamReader(
				new FileInputStream(file), "UTF-8"));
          
        // 内存流, 作为临时流  
        CharArrayWriter  tempStream = new CharArrayWriter();  
          
        // 替换  
        String line = null;  
          
        while ( (line = br.readLine()) != null) {  
        	
            // 替换每行中, 符合条件的字符串  
            line = line.replaceAll(srcStr, replaceStr);  
            // 将该行写入内存  
            tempStream.write(line+"\n");  
            // 添加换行符  
            tempStream.append(System.getProperty("line.separator"));  
        }  
          
        // 关闭 输入流  
        br.close();  
          
        // 将内存中的流 写入 文件  
        FileWriter out = new FileWriter(file);  
        tempStream.writeTo(out);  
        out.close();
	}

}
