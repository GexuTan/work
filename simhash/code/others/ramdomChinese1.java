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
		// ����һ����������󳤶ȵ��������
		//int a = 16;// ������Գ�������������ʱ�����ж�
		//Random random = new Random();
		//int aSize = random.nextInt(a) % (a) + 1;
		int aSize=2;
		// �ƶ����ȵ��������Գ���
		

		String str = null;
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

	public static void main(String[] args) throws Exception {
		// ���ļ�rawAttri�ļ���д��������ɵ�����
		//rawAttri�ļ��洢������ɵ�����
		FileOutputStream fos = new FileOutputStream("rawAttri1700.txt");
		OutputStreamWriter oos = new OutputStreamWriter(fos, "UTF-8");
		int bSize = 1700;// Ҫ��������Ը����������޸�
		for (int i = 0; i < bSize; i++) {
			String str=randomString();
			oos.append(str);
			oos.write("\r\n");
		}
		oos.close();
		fos.close();
		
		System.out.println("������"+bSize+"����������");
	}
}