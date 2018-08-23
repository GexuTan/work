package simhash;


/*修改文字格式,增加浮动，便于绘图
* 参数：读取的文件名String，长度int
 * 输入存储有序哈希值的问题
 * 将随机表和其对应值之间用空格符号，可以存入excel表中
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
			System.out.println("结束了");	
			return true;
	}
}
