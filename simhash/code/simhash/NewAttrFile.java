package simhash;


/*
 * ��ʼ�������������
 * ����ָ������������ַ�����ŵ��ļ���ȥ,�޸�3��4������
 * 
 * */


public class NewAttrFile {

	public static void main(String[] args) throws Exception {
		int size=380;//ָ������
		FileOperation fi=new FileOperation(size);
		
		String ins[] = new String[size];
		
		
		for (int i = 0; i < size; i++) {
			ins[i]=RamdomChinese.RandomString(10);// ָ���ַ�����
		}
		fi.writFile("test1.txt", ins);
		System.out.println("������"+size+"����������");
	}
}
