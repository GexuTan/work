package simhash;

public class AddFalseHash {
	
	int falseNumber;
	int falseLength;
	
	public  AddFalseHash(){
		
	}
	
	public  AddFalseHash(int n1,int n2){
		falseNumber=n1;
		falseLength=n2;
	}
	public void AddValue(){
		int size=falseNumber;//ָ������
		
		FileOperation fi=new FileOperation("H.txt");
		
		String ins[] = new String[size];
		
		for (int i = 0; i < size; i++) {
			RandomNumber nu=new RandomNumber();
			ins[i]=nu.RandomString(falseLength);
			// ���ⳤ�ȵ�
		}
		fi.writFile("H.txt", ins,true);
		System.out.println("������"+size+"����������");
		
	}

}
