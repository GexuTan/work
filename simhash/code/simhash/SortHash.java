
package simhash;



/*
 * ��ԭʼ��ϣֵ���ݽ����������������ַ���
 * �޸Ĳ���Ϊ
 * 1ԭʼ��ϣֵ�ļ���
 * 2�����ϣֵ�ļ���
 * */

public class SortHash {
		public long sort(String filename,int s) {
			
			long a = System.currentTimeMillis();
			FileOperation rea=new FileOperation(s);
			String ins[] = new String[s];
			ins=rea.readFile(filename,s);		
			
			// �Ƚ�String�͵�
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
			System.out.println("������");
			System.out.println("\r<br>ִ�к�ʱ : "+ (System.currentTimeMillis() - a) / 1000f + " �� ");
			return a;
		}
		
}
