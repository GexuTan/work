package AS;

import java.math.BigInteger;

import simhash.Levenshtein;
import simhash.Ratio;

public class showResult {
	String fileR;
	String fileS;
	String AttrH;
	int num;// �����޸�
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
		// ��ȡ���ĵ�������ȥ

		int count = 0;
		Levenshtein lt = new Levenshtein();
		FileOperation fileCommon = new FileOperation("commonH.txt");

		for (int i = 0; i < num - 1; i++) {
			for (int j = i + 1; j < num; j++) {
				float similarityRatio = lt.getSimilarityRatio(inshashR[i],
						inshashS[j]);
				if (similarityRatio > threshold) {
					count++;
					System.out.println(inshashR[i] + "��" + inshashS[j]
							+ "�����ƶ���" + similarityRatio);
					fileCommon.writFile(inshashR[i] + "\n");
				}
			}
		}

		// �Ա����ģ��ó��������ģ����������Ĵ浽�ļ��У����ظ���
		return count;
	}

	public int commomSH() {
		FileOperation filR = new FileOperation();
		FileOperation filS = new FileOperation();

		String inshashR[] = new String[num];
		String inshashS[] = new String[num];

		inshashR = filR.readFile((fileR), num);
		inshashS = filS.readFile((fileS), num);
		// ��ȡ���ĵ�������ȥ

		int count = 0;

		Levenshtein lt = new Levenshtein();
		FileOperation fileCommon = new FileOperation("commonH.txt");

		for (int i = 0; i < num - 1; i++) {
			for (int j = i + 1; j < num; j++) {
				float similarityRatio = lt.getSimilarityRatio(inshashR[i],
						inshashS[j]);
				if (similarityRatio > threshold) {
					count++;
					System.out.println(inshashR[i] + "��" + inshashS[j]
							+ "�����ƶ���" + similarityRatio);
					fileCommon.writFile(inshashR[i] + "\n");
				}
			}
		}
		return count;
		// �Ա����ģ��ó��������ģ����������Ĵ浽�ļ��У����ظ���

	}

	public String[] showC() {
		int count = this.commomRH();

		String inshash[] = new String[num * 2];
		// �ַ�������
		String insC[] = new String[count];
		// ����

		String ins[] = new String[2 * count];
		// ���

		FileOperation fileCommon = new FileOperation();
		FileOperation fileC = new FileOperation("commonH.txt");

		inshash = fileCommon.readFile("clientAH.txt", num * 2);
		insC = fileC.readFile("commonH.txt");

		// ��������

		for (int i = 0; i < count; i++) {
			ins[i] = insC[i];
			for (int j = 0; j < num; j++) {
				if (inshash[j + 1] == ins[i]) {
					ins[i + 1] = inshash[num - 1];
				}
			}
		}

		// �Ƚ�
		return ins;
	}

	public String[] showS() {
		int count = this.commomSH();
		String inshash[] = new String[num * 2];
		// �ַ�������
		String insC[] = new String[count];
		// ����

		String ins[] = new String[2 * count];
		// ���

		FileOperation fileCommon = new FileOperation();
		FileOperation fileC = new FileOperation("commonH.txt");
		inshash = fileCommon.readFile("serverAH.txt", num * 2);
		insC = fileC.readFile("commonH.txt");

		// ��������

		for (int i = 0; i < count; i++) {
			ins[i] = insC[i];
			for (int j = 0; j < num; j++) {
				if (inshash[j + 1] == ins[i]) {
					ins[i + 1] = inshash[num - 1];
				}
			}
		}

		// �Ƚ�
		return ins;
	}

}
