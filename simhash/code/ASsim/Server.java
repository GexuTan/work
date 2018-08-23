package ASsim;
import java.io.BufferedReader;  
import java.io.IOException;  
import java.io.InputStreamReader;  
import java.io.PrintWriter;  
import java.net.ServerSocket;  
import java.net.Socket; 

public class Server {
	String addressPath;
	int portNumber;
	
	
	public Server(){	
	}
	
	public Server(String s,int i){
		String addressPath=s;
		int portNumber=i;
	}
	
	
	public String accept(String s,int i)throws Exception{
		ServerSocket server = new ServerSocket(i);  
		 Socket socket = server.accept();  
		 return "success";
        /*while (true) {  
            Socket socket = server.accept();  
            
            //invoke(socket);  
        } */ 		
	}
	    private static void invoke(final Socket client) throws IOException {  
	        new Thread(new Runnable() {  
	            public void run() {  
	                BufferedReader in = null;  
	                PrintWriter out = null;  
	                try {  
	                    in = new BufferedReader(new InputStreamReader(client.getInputStream()));  
	                    out = new PrintWriter(client.getOutputStream());  
	  
	                    while (true) {  
	                        String msg = in.readLine();  
	                        System.out.println(msg);  
	                        out.println("Server received " + msg);  
	                        out.flush();  
	                        if (msg.equals("bye")) {  
	                            break;  
	                        }  
	                    }  
	                } catch(IOException ex) {  
	                    ex.printStackTrace();  
	                } finally {  
	                    try {  
	                        in.close();  
	                    } catch (Exception e) {}  
	                    try {  
	                        out.close();  
	                    } catch (Exception e) {}  
	                    try {  
	                        client.close();  
	                    } catch (Exception e) {}  
	                }  
	            }  
	        }).start();  
	    }  
}
