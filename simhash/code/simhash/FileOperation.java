package simhash;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 
 *针对文件提供简单操作，减少重复代码
 *
 * */
public class FileOperation {
	// 文件名，空数组，数组长度为成员变量
	String filename;
	int number;
	int slength;

	// 初始化
	FileOperation() {
	}

	public FileOperation(String s) {
		filename = s;
	}

	FileOperation(int le) {
		number = le;
	}

	FileOperation(String s, int le) {
		filename = s;
		number = le;
	}

	// 读取文件到数组中，提供文件名，返回包含文件字符的一个数组
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
					System.out.println("读取第" + leng + "个对应值 " + ins[leng]);
					leng++;
				}
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ins;
	}

	// 读取文件到数组中，提供文件名，返回包含文件字符的一个数组
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
					System.out.println("读取第" + len + "个对应值 " + ins[len]);
					len++;
				}
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ins;
	}



	// 读取文件到数组中，提供文件名，返回包含文件字符的一个数组
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
					System.out.println("读取第" + i + "个对应值 " + ins[i]);
					i++;
				}
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ins;
	}

	// 将数组续写到文件中去
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

	// 将数组续写到文件中去
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
