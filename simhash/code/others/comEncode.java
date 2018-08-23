package others;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
/*
生成临时会话秘钥，秘钥长度使用默认长度
* @param algorithm - 秘钥生成算法,包括Blowfish,DES,DESede, HmacMD5,HmacSHA1,AES等
* @return - 返回生成的临时会话秘钥
* @throws NoSuchAlgorithmException
* @throws IOException
*/

public class comEncode {

	public static void main(String[] args) throws Exception {
		// 打开文件encode文件为已经加密的hash值，要修改2个参数
		BufferedReader br = new BufferedReader(new InputStreamReader(
				new FileInputStream("rawHash10000.txt"), "UTF-8"));
		// comEncode文件的作用是将加密的hash值进行排序，按照前面相似的位数来进行比较
		FileOutputStream fos = new FileOutputStream("orderHash10000.txt");
		OutputStreamWriter oos = new OutputStreamWriter(fos, "UTF-8");

		// 从文件input读入到数组中去
		// BigInteger ins[]=new BigInteger[100];
		String ins[] = new String[10000];
		int len = 0;
		String s3 = "";
		// 在读到末尾之前
		while ((s3 = br.readLine()) != null) {
			if (((s3 != "\r") && ((s3) != "\n") && ((s3) != "\t"))) {
				String n = s3;
				ins[len] = n;
				System.out.println("读取第" + len + "个对应值 " + ins[len]);
				len++;
			}
		}

		// 冒泡排序，这样的效果无法使其按想要的顺序排列

		/*
		 * for(int i=0;i<len-1;i++){ System.out.println("i="+ins[i]); for(int
		 * j=i+1;j<len;j++){ System.out.println("j="+ins[j]);
		 * while(ins[i].compareTo(ins[j])<0) { System.out.println(ins[i]);
		 * System.out.println(ins[j]); BigInteger c=ins[i]; ins[i]=ins[j];
		 * ins[j]=c; } } }
		 */

		// 比较String型的
		for (int i = 0; i < len - 1; i++) {
			//System.out.println("i="+ins[i]);
			for (int j = i + 1; j < len; j++) {
				 //System.out.println("j="+ins[j]);
				while (ins[i].compareTo(ins[j])>0) {
					System.out.println(ins[i]);
					System.out.println(ins[j]);
					String c = ins[i];
					ins[i] = ins[j];
					ins[j] = c;
				}
			}
		}
	
			
			// 将排序结果输入到comEncode文件中去
			for (int k = 0; k < len; k++) {
				System.out.println("读取第" + k + "个对应值 " + ins[k]);
				String bi = ins[k];
				String s2 = bi.toString();
				oos.append(s2);
				oos.write("\r\n");
			}
			oos.close();
			fos.close();
			br.close();
			System.out.println("结束了");

	}
}
