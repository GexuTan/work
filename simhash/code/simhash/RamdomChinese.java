package simhash;

import java.util.Random;
import java.lang.Math;

/*
 * 生成制定长度的随机中文字符串
 * 
 * */
public class RamdomChinese {

	// 返回指定长度的一个中文字符串
	public static String RandomString(int aSize) {
		int hightPos, lowPos; // 定义高低位
		String str = null;
		String str1 = "";
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
	
	
	
	// 返回不超过指定长度的一个中文字符串
	public static String RandomString(int aSize, int a) {
		Random random = new Random();
		aSize = random.nextInt(a) % (a) + 1;// 制定长度的任意属性长度

		String str = "";
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
}
