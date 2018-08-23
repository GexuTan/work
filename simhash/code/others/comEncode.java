package others;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
/*
������ʱ�Ự��Կ����Կ����ʹ��Ĭ�ϳ���
* @param algorithm - ��Կ�����㷨,����Blowfish,DES,DESede, HmacMD5,HmacSHA1,AES��
* @return - �������ɵ���ʱ�Ự��Կ
* @throws NoSuchAlgorithmException
* @throws IOException
*/

public class comEncode {

	public static void main(String[] args) throws Exception {
		// ���ļ�encode�ļ�Ϊ�Ѿ����ܵ�hashֵ��Ҫ�޸�2������
		BufferedReader br = new BufferedReader(new InputStreamReader(
				new FileInputStream("rawHash10000.txt"), "UTF-8"));
		// comEncode�ļ��������ǽ����ܵ�hashֵ�������򣬰���ǰ�����Ƶ�λ�������бȽ�
		FileOutputStream fos = new FileOutputStream("orderHash10000.txt");
		OutputStreamWriter oos = new OutputStreamWriter(fos, "UTF-8");

		// ���ļ�input���뵽������ȥ
		// BigInteger ins[]=new BigInteger[100];
		String ins[] = new String[10000];
		int len = 0;
		String s3 = "";
		// �ڶ���ĩβ֮ǰ
		while ((s3 = br.readLine()) != null) {
			if (((s3 != "\r") && ((s3) != "\n") && ((s3) != "\t"))) {
				String n = s3;
				ins[len] = n;
				System.out.println("��ȡ��" + len + "����Ӧֵ " + ins[len]);
				len++;
			}
		}

		// ð������������Ч���޷�ʹ�䰴��Ҫ��˳������

		/*
		 * for(int i=0;i<len-1;i++){ System.out.println("i="+ins[i]); for(int
		 * j=i+1;j<len;j++){ System.out.println("j="+ins[j]);
		 * while(ins[i].compareTo(ins[j])<0) { System.out.println(ins[i]);
		 * System.out.println(ins[j]); BigInteger c=ins[i]; ins[i]=ins[j];
		 * ins[j]=c; } } }
		 */

		// �Ƚ�String�͵�
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
	
			
			// �����������뵽comEncode�ļ���ȥ
			for (int k = 0; k < len; k++) {
				System.out.println("��ȡ��" + k + "����Ӧֵ " + ins[k]);
				String bi = ins[k];
				String s2 = bi.toString();
				oos.append(s2);
				oos.write("\r\n");
			}
			oos.close();
			fos.close();
			br.close();
			System.out.println("������");

	}
}
