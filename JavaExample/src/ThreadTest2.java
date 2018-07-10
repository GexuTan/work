public class ThreadTest2 {
    public static void main(String args[ ]){	
	   Hello1 t1 = new Hello1( );
	   Hello1 t2 = new Hello1
			   ( );	
	   t1.start( );
	   t2.start( );
   }
}
class Hello1 extends Thread{
    int i ;
    public void run( ){
	   while( true){
		System.out.println("Hello"+i++);
		if (i==5)  break ;
	   }
    	}
  }

