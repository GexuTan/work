package others;

import java.util.Random;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.Math;
import java.math.BigInteger;

public class ramdomChinese1 {
	private static String randomString() {
		// 返回一个不超过最大长度的随机属性
		//int a = 16;// 最长的属性长度名，在生成时进行判断
		//Random random = new Random();
		//int aSize = random.nextInt(a) % (a) + 1;
		int aSize=2;
		// 制定长度的任意属性长度
		

		String str = null;
		String str1 = "";
		int hightPos, lowPos; // 定义高低位
		

		for (int i = 0; i < aSize; i++) {

			hightPos = (176 + Math.abs(new Random().nextInt(39)));// 获取高位值
			lowPos = (161 + Math.abs(new Random().nextInt(93)));// 获取低位值
			byte[] b = new byte[2];
			b[0] = (new Integer(hightPos).byteValue());
			b[1] = (new Integer(lowPos).byteValue());
			try {
				str = new String(b, "GBk");// 转成中文
				str1 = str1 + str;
			} catch (Exception e) {
				e.printStackTrace();
			}
				}
		System.out.println(str1);
		return str1;
	}

	public static void main(String[] args) throws Exception {
		// 打开文件rawAttri文件，写入随机生成的属性
		//rawAttri文件存储随机生成的属性
		FileOutputStream fos = new FileOutputStream("rawAttri1700.txt");
		OutputStreamWriter oos = new OutputStreamWriter(fos, "UTF-8");
		int bSize = 1700;// 要输出的属性个数，可以修改
		for (int i = 0; i < bSize; i++) {
			String str=randomString();
			oos.append(str);
			oos.write("\r\n");
		}
		oos.close();
		fos.close();
		
		System.out.println("生成了"+bSize+"个任意属性");
	}
}