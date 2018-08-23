package AS;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 
 *����ļ��ṩ�򵥲����������ظ�����
 *
 * */
public class FileOperation {
	// �ļ����������飬���鳤��Ϊ��Ա����
	String filename;
	int number;
	int slength;

	// ��ʼ��
	FileOperation() {
	}

	FileOperation(String s) {
		filename = s;
	}

	FileOperation(int le) {
		number = le;
	}

	FileOperation(String s, int le) {
		filename = s;
		number = le;
	}

	// ��ȡ�ļ��������У��ṩ�ļ��������ذ����ļ��ַ���һ������
	public String[] readFile() {
		File file = new File(filename);
		System.out.println(filename);
		String ins[] = new String[number];
		System.out.println(number);
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					new FileInputStream(file), "UTF-8"));
			String s3 = "";
			
			while ((s3 = br.readLine()) != null) {
				int leng=0;
				if (((s3 != "\r") && ((s3) != "\n") && ((s3) != "\t"))) {
					String n = s3;
					ins[leng] = n;
					System.out.println("��ȡ��" + leng + "����Ӧֵ " + ins[leng]);
					leng++;
				}
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ins;
	}

	// ��ȡ�ļ��������У��ṩ�ļ��������ذ����ļ��ַ���һ������
	public String[] readFile(String filename) {
		File file = new File(filename);
		String ins[] = new String[10000];
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					new FileInputStream(file), "UTF-8"));
			String s3 = "";
			int len=0;
			while ((s3 = br.readLine()) != null) {
				if ((s3 != "\r") && (s3 != "\n") && (s3 != "\t")) {
					String n = s3;
					ins[len] = n;
					System.out.println("��ȡ��" + len + "����Ӧֵ " + ins[len]);
					len++;
				}
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ins;
	}



	// ��ȡ�ļ��������У��ṩ�ļ��������ذ����ļ��ַ���һ������
	public String[] readFile(String finumberame, int le) {
		File file = new File(finumberame);
		System.out.println(filename);
		System.out.println(number);
		number = le;
		String ins[] = new String[number];
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					new FileInputStream(file), "UTF-8"));
			String s3 = "";
			int i = 0;
			while ((s3 = br.readLine()) != null) {
				if (((s3 != "\r") && ((s3) != "\n") && ((s3) != "\t"))) {
					String n = s3;
					ins[i] = n;
					System.out.println("��ȡ��" + i + "����Ӧֵ " + ins[i]);
					i++;
				}
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ins;
	}

	// ��������д���ļ���ȥ
	public boolean writFile(String filename, String[] inst, boolean ture) {
		File file = new File(filename);
		try {
			FileOutputStream fos = new FileOutputStream(file, true);
			OutputStreamWriter oos = new OutputStreamWriter(fos, "UTF-8");
			System.out.println(filename);
			System.out.println(number);
			for (int i = 0; i < number; i++) {
				if (inst[i] != null) {
					oos.append(inst[i] + "\r\n");
				}
				System.out.println(inst[i] + "\r\n");
			}
			oos.close();
			fos.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean writFile(String finumberame, String[] inst) {
		File file = new File(finumberame);
		try {
			FileOutputStream fos = new FileOutputStream(file);
			OutputStreamWriter oos = new OutputStreamWriter(fos, "UTF-8");
			for (int i = 0; i < inst.length; i++) {
				oos.append(inst[i] + "\r\n");
				System.out.println(inst[i] + "\r\n");
			}
			oos.close();
			fos.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean writFile(String finumberame, String[] inst, String[] instr) {
		File file = new File(finumberame);
		try {
			FileOutputStream fos = new FileOutputStream(file);
			OutputStreamWriter oos = new OutputStreamWriter(fos, "UTF-8");
			for (int i = 0; i < inst.length; i++) {
				oos.append(inst[i] + "\r\n");
				oos.append(instr[i] + "\r\n");
				System.out.println(inst[i] + "\r\n");
			}
			oos.close();
			fos.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	// ��������д���ļ���ȥ
	public boolean writFile(String s) {
		File file = new File(filename);
		try {
			FileOutputStream fos = new FileOutputStream(file, true);
			OutputStreamWriter oos = new OutputStreamWriter(fos, "UTF-8");
			oos.append(s);
			System.out.println(s + "\r\n");

			oos.close();
			fos.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean writExcel(String finumberame, String[] inst) {
		File file = new File(finumberame);
		try {
			FileOutputStream fos = new FileOutputStream(file);
			OutputStreamWriter oos = new OutputStreamWriter(fos, "UTF-8");
			for (int i = 0; i < inst.length ; i ++) {
				oos.append(inst[i]+",");
			}
			oos.close();
			fos.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
