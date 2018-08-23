package others;

import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.Math;
import java.math.BigInteger;

/*
 * 生成指定长度的随机中文字符
 * 
 * 存放到文件中去
 * 生成临时会话秘钥，秘钥长度使用默认长度
	 * @param algorithm - 秘钥生成算法,包括Blowfish,DES,DESede, HmacMD5,HmacSHA1,AES等
	 * @return - 返回生成的临时会话秘钥
	 * @throws NoSuchAlgorithmException
	 * @throws IOException
 * 
 * */
public class ramdomChinese {
	private static String randomString() {
		int aSize = 2;
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

		FileOutputStream fos = new FileOutputStream("rawAttri1700.txt");
		OutputStreamWriter oos = new OutputStreamWriter(fos, "UTF-8");
		int bSize = 1700;// 要输出的属性个数，可以修改
		for (int i = 0; i < bSize; i++) {
			String str = randomString();
			oos.append(str);
			oos.write("\r\n");
		}
		oos.close();
		fos.close();
		System.out.println("生成了" + bSize + "个任意属性");
	}
}
