package simhash;
/*
 * �Ƚϲ�ͬ��С�����Լ��д���ĳ���ƶȵ����Ը���
 * 
 * */
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import others.Levenshtein;

public class compareHash {
	public static void main(String[] args) throws Exception {
		int s = 2000;//���Լ��ϵĴ�С
		// int str[] = { 50, 100, 200, 500, 1000, 2000,3000, 5000, 7000, 8000,
		// 9000,10000 };���Լ��Ĵ�С
		
		
		int count = 0;
		double ratio = 0.9;//�趨�ı��ʣ������޸ģ�Ҳ��������ѭ�����Ƚϼ��
		Levenshtein lt = new Levenshtein();
		
		FileOutputStream fos = new FileOutputStream("resultsnumber.txt", true);//��Ÿ���
		FileOutputStream fos1 = new FileOutputStream("resultsratio.txt", true);//��ű���
		OutputStreamWriter oos = new OutputStreamWriter(fos, "UTF-8");
		OutputStreamWriter oos1 = new OutputStreamWriter(fos1, "UTF-8");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("orderHash" + s + ".txt"), "UTF-8"));
		//��ȡ�ļ����˲�����ԸĽ�������д��ô��
		int len = 0;
		String s3 = "";
		String ins[] = new String[10000];
		while ((s3 = br.readLine()) != null) {
			if (((s3 != "\r") && ((s3) != "\n") && ((s3) != "\t"))) {
				String n = s3;
				ins[len] = n;
				System.out.println("��ȡ��" + len + "����Ӧֵ " + ins[len]);
				len++;
			}
		}

		for (int i = 0; i < len - 1; i++) {
			for (int j = i + 1; j < len; j++) {
				float similarityRatio = lt.getSimilarityRatio(ins[i], ins[j]);
				if (similarityRatio > ratio) {
					count++;
					System.out.println(ins[i] + "��" + ins[j] + "�����ƶ���"
							+ similarityRatio);

				}
			}
		}

		float s1 = (float) count / s;
		oos.append(count + ",");
		oos1.append(s1 + ",");
		System.out.println(s + "," + count);
		br.close();

		oos.close();
		oos1.close();
		fos.close();
		fos1.close();
		System.out.println("������");
	}
}