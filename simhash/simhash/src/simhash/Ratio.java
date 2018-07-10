package simhash;




public class Ratio {

	// s1为字符长度
	public int calRatio(int s,double ratio) {
		String ins[] = new String[s];
		//String ins1[] = new String[s];

		FileOperation rea = new FileOperation("effi/RH"+s+".txt", s);
		ins = rea.readFile("effi/RH"+s+".txt");
		int 	count=0;
			Levenshtein lt = new Levenshtein();
			for (int i = 0; i < rea.number - 1; i++) {
				for (int j = i + 1; j < rea.number; j++) {
					float similarityRatio = lt.getSimilarityRatio(ins[i], ins[j]);
					if (similarityRatio > ratio) {
						count++;
						System.out.println(ins[i] + "和" + ins[j] + "的相似度是"+ similarityRatio);
						
						System.out.println(s + "\t" + similarityRatio + "\n");
					}
				}
			}
			
		return count;
	}
}
