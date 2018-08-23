public class Timer extends Thread{
	int time=1;
	public Timer(int time){
		this.time=time;
	}
    public void run(){
	     try{
	           for(int i=1;i<=time;i++) {
                   Thread.sleep(1000);
	              System.out.println(i);
              }
          }catch(InterruptedException e){
               System.out.println(e.toString());
        }
     }
public static void main(String args[]){
	Timer timer=new Timer(10);
	timer.start();
  }
}	
