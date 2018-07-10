package simhash;
/*计算指定对相似属性的相似度
 * */
import java.math.BigInteger;

public class SimRatio {

	public static void main(String[] args) {
		//s1为字符长度
		
		for(int s1=2;s1<21;s1++){
			System.out.println("第"+s1+"\n");
			int s = 10;
			FileOperation rea = new FileOperation("len/"+s1+"LRA10" + ".txt",s);

			String ins[] = new String[10];
			String ins1[] = new String[10];

			ins = rea.readFile("len/"+s1+"LRA10" + ".txt");
			for(int i=0;i>10;i++){
				System.out.println("第"+i+"个"+ins[i] 
						+ "\n");
			}
			
			FileOperation rea3 = new FileOperation("len/SimLenResult" + s + ".txt",s);
			for (int i = 0; i < s; i++) {
				Simhash hash = new Simhash(ins[i], 256);
				BigInteger bi = hash.strSimHash;
				String s2 = bi.toString();
				ins1[i] = s2;
				System.out.println("第"+i+"个"+ins[i] + "对应" + ins1[i] + "\n");
			}
			//JaccardDistance lt =new JaccardDistance();
	        Levenshtein lt = new Levenshtein();

			float a = 0;

			for (int i = 1; i < s; i++) {
				float similarityRatio = lt.getSimilarityRatio(ins1[i], ins1[i -1]);
				System.out.println(ins[i] + "和" + ins[i - 1] + "的相似度是"+ similarityRatio);
				System.out.println(ins1[i] + "和" + ins1[i - 1] + "的相似度是"+ similarityRatio);
				a = a + similarityRatio;
				System.out.println(s + "\t" + similarityRatio + "\n");
				i++;
			}

			System.out.println(a / 5 + "\n");
			rea3.writFile(a / 5 + "\n"+ "\n"+ "\n");
			System.out.println("结束了");
		}	
	}

}
