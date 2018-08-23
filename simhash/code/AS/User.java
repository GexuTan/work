package AS;

public class User {
	String IP;
	int port;
	int length;
	int fasNumber;
	String path;
	double threshold;
	public User(){
		
	}
	public User(String IP1,int port1,int length1,int fasNumber1,String path1,double threshold1){
		IP=IP1;
		port=port1;
		length=length1;
		fasNumber=fasNumber1;
		path=path1;
		threshold=threshold1;
	}
	
	public void setNet(String IP1,int port1){
		IP=IP1;
		port=port1;
	}
	
	public void setFalse(int length1,int fasNumber1){
		length=length1;
		fasNumber=fasNumber1;
	}
	
	
	public void setTh(double th){
		threshold=th;
	}
	
	

}
