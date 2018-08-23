package ASsim;
import java.io.BufferedReader;  
import java.io.IOException;  
import java.io.InputStreamReader;  
import java.io.PrintWriter;  
import java.net.ServerSocket;  
import java.net.Socket;

public class Client {
	String addressPath;
	int portNumber;
	public Client(){
		
	}
	public Client(String s,int i){
		String addressPath=s;
		int portNumber=i;
	}
	
	public boolean apply(String s,int i)throws Exception{
		//确认是否连接起来
		Socket socket = new Socket("localhost", 10000);  
       /* BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));  
        PrintWriter out = new PrintWriter(socket.getOutputStream());  
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));  
        while (true) {  
            String msg = reader.readLine();  
            out.println(msg);  
            out.flush();  
            if (msg.equals("bye")) {  
                break;  
            }  
            System.out.println(in.readLine());  
        }  
        socket.close();*/  
        return true;
	}  
	
}
