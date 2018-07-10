package AS;



import java.io.BufferedReader;  
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;  
import java.io.InputStreamReader;  
import java.io.PrintWriter;  
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;  
import java.net.Socket; 
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.FileChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import others.MyServer;

public class Server {
	String addressPath;
	int portNumber;
	
	
	
	ServerSocket server;  
	
	
	
	SocketAddress socketAddress;
	static SocketChannel socketChannel;
	 Selector selector;  
     ServerSocketChannel serverSocketChannel; 
  
	
	
	private final static Logger logger = Logger.getLogger(Server.class.getName()); 
	
	
	public Server(String s,int i) throws IOException{
		String addressPath=s;
		int portNumber=i;
		server=new ServerSocket();
		
		socketAddress = new InetSocketAddress(addressPath, portNumber);
		socketChannel = null;
		
		 Selector selector = null;  
	     ServerSocketChannel serverSocketChannel = null; 
	     
	     try {  
	            // Selector for incoming time requests  
	            selector = Selector.open();  
	            // Create a new server socket and set to non blocking mode  
	            serverSocketChannel = ServerSocketChannel.open();  
	            serverSocketChannel.configureBlocking(false);  
	              
	            // Bind the server socket to the local host and port  
	            serverSocketChannel.socket().setReuseAddress(true);  
	            serverSocketChannel.socket().bind(new InetSocketAddress(i));  
	              
	            // Register accepts on the server socket with the selector. This  
	            // step tells the selector that the socket wants to be put on the  
	            // ready list when accept operations occur, so allowing multiplexed  
	            // non-blocking I/O to take place.  
	            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);  
	      
	            // Here's where everything happens. The select method will  
	            // return when any operations registered above have occurred, the  
	            // thread has been interrupted, etc.  
	            while (selector.select() > 0) {  
	                // Someone is ready for I/O, get the ready keys  
	                Iterator<SelectionKey> it = selector.selectedKeys().iterator();  
	      
	                // Walk through the ready keys collection and process date requests.  
	                while (it.hasNext()) {  
	                    SelectionKey readyKey = it.next();  
	                    it.remove();   
	                    // The key indexes into the selector so you  
	                    // can retrieve the socket that's ready for I/O  
	                  // doit((ServerSocketChannel) readyKey.channel());  
	                }  
	            }  
	        } catch (ClosedChannelException ex) {  
	            logger.log(Level.SEVERE, null, ex);  
	        } catch (IOException ex) {  
	            logger.log(Level.SEVERE, null, ex);  
	        } finally {  
	            try {  
	                selector.close();  
	            } catch(Exception ex) {}  
	            try {  
	                serverSocketChannel.close();  
	            } catch(Exception ex) {}  
	        }  
	}
	
	public boolean acceptS(int i)throws Exception{
		 server = new ServerSocket(i); 
		 System.out.println("·¢ËÍÉêÇë1"); 
		 Socket socket = server.accept(); 
		
		socketChannel = serverSocketChannel.accept();  
		System.out.println("·¢ËÍÉêÇë"); 
		return true;
	}
	/*
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
	    }  */
	    
	    
	  
 
	      
	   public boolean receiveFile() throws IOException {  
	        FileOutputStream fos = null;  
	        FileChannel channel = null;  
	        String file="clientH.txt";
	        try {  
	            fos = new FileOutputStream(file);  
	            channel = fos.getChannel();  
	            ByteBuffer buffer = ByteBuffer.allocateDirect(1024);  
	  
	            int size = 0;  
	            while ((size = socketChannel.read(buffer)) != -1) {  
	                buffer.flip();  
	                if (size > 0) {  
	                    buffer.limit(size);  
	                    channel.write(buffer);  
	                    buffer.clear();  
	                }  
	            }  
	        } finally {  
	            try {  
	                channel.close();  
	            } catch(Exception ex) {}  
	            try {  
	                fos.close();  
	            } catch(Exception ex) {}  
	        }
			return true;  
	    }  
	  
	    public boolean sendFile() throws IOException {  
	        FileInputStream fis = null;  
	        FileChannel channel = null;  
	        String file= "clientH.txt";
	        try {  
	            fis = new FileInputStream(file);  
	            channel = fis.getChannel();  
	            ByteBuffer buffer = ByteBuffer.allocateDirect(1024);  
	            int size = 0;  
	            while ((size = channel.read(buffer)) != -1) {  
	                buffer.rewind();  
	                buffer.limit(size);  
	                socketChannel.write(buffer);  
	                buffer.clear();  
	            }  
	            socketChannel.socket().shutdownOutput();  
	        } finally {  
	            try {  
	                channel.close();  
	            } catch(Exception ex) {}  
	            try {  
	                fis.close();  
	            } catch(Exception ex) {}  
	            
	        }
			return true;  
	    }  
}
