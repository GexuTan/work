class MultiThread extends Thread{
     int threadNum;
     public static void main(String args[]){
         MultiThread array[]=new MultiThread [3];
         for (int i=0;i<3;i++) 
            array[i]=new MultiThread (i+1);
         for (int i=0;i<3;i++)   
            array[i].start();  
    }

  MultiThread (int SerialNum){
     super();  
     threadNum=SerialNum; 
  }
  public void run(){
	    int MySerialNum=0;
	    for(int j=1;j<=10;j++){
	       MySerialNum++;
	       try{
		     Thread.sleep(1000);
		  }catch(Exception e){
	          System.out.println(e.toString());
	      }             
	      System.out.println("<"+ j + ">loop:" + MySerialNum);
	      System.out.println("thread:"+threadNum+ "  bye.");  
	    }
	  }
	}
