package simhash;
/*计算某些属性的平均，暂时未知，用处不大
 * */

public class CalResult {


	public static void main(String[] args) {
		
		FileOperation rear=new FileOperation();
		String ins[] = rear.readFile("len/LENreSULT.txt",137);
		
		int j=ins.length;

		 float ls[]=new float[133];
		 float lens[]= new float[19];
		 float ratios[]= new float[19];
		for(int i=0;i<133;i++){
			ls[i]=Float.parseFloat(ins[i]);	
			System.out.println("第"+i+"个字符串转换成数组"+ls[i]);
		}
		int i=0;
		int j1=0;
		while(j1<20){
			while(i<128){
				lens[j1]=ls[i];	
				ratios[j1]=(ls[i+1]+ls[i+2]+ls[i+3]+ls[i+4]+ls[i+5]+ls[i+6])/6;
				System.out.println(lens[j1]+"\t"+ratios[j1]);
				i=i+7;
				j1++;
			}	
		}
		System.out.println("结束了");
}

}
