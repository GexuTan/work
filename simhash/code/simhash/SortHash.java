
package simhash;



/*
 * 对原始哈希值数据进行排序，生成有序字符串
 * 修改参数为
 * 1原始哈希值文件名
 * 2有序哈希值文件名
 * */

public class SortHash {
		public long sort(String filename,int s) {
			
			long a = System.currentTimeMillis();
			FileOperation rea=new FileOperation(s);
			String ins[] = new String[s];
			ins=rea.readFile(filename,s);		
			
			// 比较String型的
			for (int i = 0; i < rea.number-1; i++) {
				//System.out.println("i="+ins[i]);
				for (int j = i + 1; j < rea.number; j++) {
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
			rea.writFile("effi/OH"+s+".txt", ins);
			System.out.println("结束了");
			System.out.println("\r<br>执行耗时 : "+ (System.currentTimeMillis() - a) / 1000f + " 秒 ");
			return a;
		}
		
}
