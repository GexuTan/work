package indi.sharing.bean;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

/**
 * <p>
 * Title: FileProperty
 * Description: 
 * 
 * </p>
 * @see this class package all methods needed in this project,
 * @param number, is the number of array  
 */

public class FileProperty{
	
	String filename;
	int number;
	int length;
	
	FileProperty() {
	}

	FileProperty(String s) {
		filename = s;
	}

	FileProperty(int le) {
		number = le;
	}
	
	FileProperty(String s, int le) {
		filename = s;
		number = le;
	}

	// read file into string
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
					System.out.println("" + leng + " " + ins[leng]);
					leng++;
				}
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ins;
	}

	// 
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
					System.out.println("read" + len + " " + ins[len]);
					len++;
				}
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ins;
	}

	//
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
					System.out.println("读�??�?" + i + "�?对�????? " + ins[i]);
					i++;
				}
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ins;
	}

	// 
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

	// 
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
	
	public BigInteger readBigInteger(String filename) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					new FileInputStream(filename), "UTF-8"));
			String s=br.readLine();
			BigInteger p = new BigInteger(s);
			
			br.close();
			return p;
		} catch (IOException e) {
			e.printStackTrace();
			//return null;
			}
		return null;
}
	
	public boolean writeBigInteger(String filename, BigInteger P) {
		try {
			FileOutputStream fos = new FileOutputStream(filename);
			OutputStreamWriter oos = new OutputStreamWriter(fos, "UTF-8");
			oos.write(P.toString());
			oos.close();
			fos.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
