package simhash;

/*
 * 参数：输入文件（哈希值），输出文件，指定阈值（近似率）
 * 功能：将高于阈值的属性个数存储到文件中
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
		 * System.out.println(ins[2*i]+ "和" + ins[2*i+1] + "的相似度是"+
		 * similarityRatio); rat=rat+similarityRatio;
		 * 
		 * 
		 * }
		 */
		int count = 0;
		//System.out.println("共有" + rat / 10 + "个" + "结束了");
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
			System.out.println("共有" + count + "个" + "结束了");
			count = 0;
		}
	}
}
