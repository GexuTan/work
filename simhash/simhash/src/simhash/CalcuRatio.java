package simhash;

/*
 * �����������ļ�����ϣֵ��������ļ���ָ����ֵ�������ʣ�
 * ���ܣ���������ֵ�����Ը����洢���ļ���
 * */

public class CalcuRatio {
	// public static void main(String[] args) {
	public void calci(String inputfile,String outputfile,double ratio) {
	
		FileOperation rea = new FileOperation();
		String ins[] = rea.readFile(inputfile, 20);
	
		Levenshtein lt = new Levenshtein();
		
		
		
		FileOperation rear = new FileOperation(outputfile);

		/*
		 * for (int i = 0; i < (rea.number/2); i++) {
		 * 
		 * float similarityRatio = lt.getSimilarityRatio(ins[2*i],ins[2*i+1]);
		 * System.out.println(ins[2*i]+ "��" + ins[2*i+1] + "�����ƶ���"+
		 * similarityRatio); rat=rat+similarityRatio;
		 * 
		 * 
		 * }
		 */
		int count = 0;
		//System.out.println("����" + rat / 10 + "��" + "������");
		for ( ratio = 0.2; ratio < 1.0; ratio = ratio + 0.1) {

			for (int i = 0; i < rea.number - 1; i++) {
				for (int j = i + 1; j < rea.number; j++) {
					float similarityRatio = lt.getSimilarityRatio(ins[i],
							ins[j]);
					if (similarityRatio > ratio) {
						count++;
					}
				}
			}
			rear.writFile(ratio + "\t" + count + "\n");
			System.out.println("����" + count + "��" + "������");
			count = 0;
		}
	}
}
