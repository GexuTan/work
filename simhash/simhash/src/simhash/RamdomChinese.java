package simhash;

import java.util.Random;
import java.lang.Math;

/*
 * �����ƶ����ȵ���������ַ���
 * 
 * */
public class RamdomChinese {

	// ����ָ�����ȵ�һ�������ַ���
	public static String RandomString(int aSize) {
		int hightPos, lowPos; // ����ߵ�λ
		String str = null;
		String str1 = "";
		for (int i = 0; i < aSize; i++) {

			hightPos = (176 + Math.abs(new Random().nextInt(39)));// ��ȡ��λֵ
			lowPos = (161 + Math.abs(new Random().nextInt(93)));// ��ȡ��λֵ
			byte[] b = new byte[2];
			b[0] = (new Integer(hightPos).byteValue());
			b[1] = (new Integer(lowPos).byteValue());
			try {
				str = new String(b, "GBk");// ת������
				str1 = str1 + str;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println(str1);
		return str1;
	}
	
	
	
	// ���ز�����ָ�����ȵ�һ�������ַ���
	public static String RandomString(int aSize, int a) {
		Random random = new Random();
		aSize = random.nextInt(a) % (a) + 1;// �ƶ����ȵ��������Գ���

		String str = "";
		String str1 = "";

		int hightPos, lowPos; // ����ߵ�λ

		for (int i = 0; i < aSize; i++) {
			hightPos = (176 + Math.abs(new Random().nextInt(39)));// ��ȡ��λֵ
			lowPos = (161 + Math.abs(new Random().nextInt(93)));// ��ȡ��λֵ
			byte[] b = new byte[2];
			b[0] = (new Integer(hightPos).byteValue());
			b[1] = (new Integer(lowPos).byteValue());
			try {
				str = new String(b, "GBk");// ת������
				str1 = str1 + str;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println(str1);
		return str1;
	}	
}
