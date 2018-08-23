class People {
	private String name ;
	private char sex;
	private int age;
	
	public People(String name,char sex,int age){
		this.name = name;
		this.sex=sex;
		this.age = age;
	}
	public String getDetails( ){
		return "Name:"+name+"\nsex:"+sex+"\nage: "+age;
	}
}

class StudentT extends People {
	private String studentID;
	private String major;
	
	public StudentT(String name,char sex,int age,String stuID,String major){
		super(name,sex,age);
		this.studentID=stuID;
		this.major=major;
	}
	public String getDetails( ){
		return super.getDetails( )+"\nStudentID:"+ studentID+"\nMajor:"+major;
		}
	}





public class TestSuper{
	public static void main(String[] srgs){
		StudentT s = new StudentT("TOM",'男',20,"20070308017","Computer");
		System.out.println(s.getDetails());
	}
}
