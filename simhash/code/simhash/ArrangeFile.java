package simhash;


/*�޸����ָ�ʽ,���Ӹ��������ڻ�ͼ
* ��������ȡ���ļ���String������int
 * ����洢�����ϣֵ������
 * �����������Ӧֵ֮���ÿո���ţ����Դ���excel����
 * 
 * */
public class ArrangeFile {
	public boolean arran(String inputfile,int num){
			FileOperation rea=new FileOperation(inputfile);
			String ins[]=new String[num*2];
			String ins1[]=new String[num];
			String ins2[]=new String[num];
			float ins3[]=new float[num];
			
			ins=rea.readFile(inputfile);
			
			for(int i=0;i<num;i++){
				float s = Float.parseFloat(ins[2*i]);
				float err=((float)Math.random()*800);
				ins2[i]=ins[2*i+1];
				ins3[i]=s+err;
				ins1[i]=ins3[i]+"";
			}
			rea.writExcel("len/resultExcel1.txt",ins1);
			rea.writExcel("len/resultExcel2.txt",ins2);
			System.out.println("������");	
			return true;
	}
}
