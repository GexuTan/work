package AS;

import java.math.BigInteger;

import simhash.Levenshtein;
import simhash.Ratio;

public class showResult {
	String fileR;
	String fileS;
	String AttrH;
	int num;// 可以修改
	double threshold;
	String insR[];
	String insS[];

	public showResult(double th, int nu, String AH) {
		fileR = "clientH.txt";
		fileS = "serverH.txt";
		AttrH = AH;
		num = nu;
		threshold = th;

	}

	public int commomRH() {
		FileOperation filR = new FileOperation();
		FileOperation filS = new FileOperation();

		String inshashR[] = new String[num];
		String inshashS[] = new String[num];

		inshashR = filR.readFile((fileR), num);
		inshashS = filS.readFile((fileS), num);
		// 读取密文到数组中去

		int count = 0;
		Levenshtein lt = new Levenshtein();
		FileOperation fileCommon = new FileOperation("commonH.txt");

		for (int i = 0; i < num - 1; i++) {
			for (int j = i + 1; j < num; j++) {
				float similarityRatio = lt.getSimilarityRatio(inshashR[i],
						inshashS[j]);
				if (similarityRatio > threshold) {
					count++;
					System.out.println(inshashR[i] + "和" + inshashS[j]
							+ "的相似度是" + similarityRatio);
					fileCommon.writFile(inshashR[i] + "\n");
				}
			}
		}

		// 对比密文，得出共有密文，将共有密文存到文件中，返回个数
		return count;
	}

	public int commomSH() {
		FileOperation filR = new FileOperation();
		FileOperation filS = new FileOperation();

		String inshashR[] = new String[num];
		String inshashS[] = new String[num];

		inshashR = filR.readFile((fileR), num);
		inshashS = filS.readFile((fileS), num);
		// 读取密文到数组中去

		int count = 0;

		Levenshtein lt = new Levenshtein();
		FileOperation fileCommon = new FileOperation("commonH.txt");

		for (int i = 0; i < num - 1; i++) {
			for (int j = i + 1; j < num; j++) {
				float similarityRatio = lt.getSimilarityRatio(inshashR[i],
						inshashS[j]);
				if (similarityRatio > threshold) {
					count++;
					System.out.println(inshashR[i] + "和" + inshashS[j]
							+ "的相似度是" + similarityRatio);
					fileCommon.writFile(inshashR[i] + "\n");
				}
			}
		}
		return count;
		// 对比密文，得出共有密文，将共有密文存到文件中，返回个数

	}

	public String[] showC() {
		int count = this.commomRH();

		String inshash[] = new String[num * 2];
		// 字符＋密文
		String insC[] = new String[count];
		// 密文

		String ins[] = new String[2 * count];
		// 结果

		FileOperation fileCommon = new FileOperation();
		FileOperation fileC = new FileOperation("commonH.txt");

		inshash = fileCommon.readFile("clientAH.txt", num * 2);
		insC = fileC.readFile("commonH.txt");

		// 读入数组

		for (int i = 0; i < count; i++) {
			ins[i] = insC[i];
			for (int j = 0; j < num; j++) {
				if (inshash[j + 1] == ins[i]) {
					ins[i + 1] = inshash[num - 1];
				}
			}
		}

		// 比较
		return ins;
	}

	public String[] showS() {
		int count = this.commomSH();
		String inshash[] = new String[num * 2];
		// 字符＋密文
		String insC[] = new String[count];
		// 密文

		String ins[] = new String[2 * count];
		// 结果

		FileOperation fileCommon = new FileOperation();
		FileOperation fileC = new FileOperation("commonH.txt");
		inshash = fileCommon.readFile("serverAH.txt", num * 2);
		insC = fileC.readFile("commonH.txt");

		// 读入数组

		for (int i = 0; i < count; i++) {
			ins[i] = insC[i];
			for (int j = 0; j < num; j++) {
				if (inshash[j + 1] == ins[i]) {
					ins[i + 1] = inshash[num - 1];
				}
			}
		}

		// 比较
		return ins;
	}

}
