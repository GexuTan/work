package simhash;


/*
 * 开始，生成随机属性
 * 生成指定个数个随机字符串存放到文件中去,修改3－4个参数
 * 
 * */


public class NewAttrFile {

	public static void main(String[] args) throws Exception {
		int size=380;//指定个数
		FileOperation fi=new FileOperation(size);
		
		String ins[] = new String[size];
		
		
		for (int i = 0; i < size; i++) {
			ins[i]=RamdomChinese.RandomString(10);// 指定字符长度
		}
		fi.writFile("test1.txt", ins);
		System.out.println("生成了"+size+"个任意属性");
	}
}
