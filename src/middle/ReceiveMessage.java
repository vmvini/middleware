package middle;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReceiveMessage extends Thread {
	
	private File file;
	private String address;
	private int port;
	private Socket socket;
	
	public ReceiveMessage(File file, String address, int port, Socket socket) throws UnknownHostException, IOException{
		this.file = file;
		this.address = address;
		this.port = port;
		this.socket = socket;
	}

	public void run() {
		System.out.println("Recebendo arquivo");
	               // while (true) {
	                	
	                    try {
	                        String response = receiverFromServer();
	                        if (response != null) {
	                            write(response, this.file);
	                        }
	                    } catch (IOException ex) {
	                        Logger.getLogger(MiddlewareClient.class.getName()).log(Level.SEVERE, null, ex);
	                    } 
	                //}
	                    System.out.println("Recebido arquivo");
	            }
	
	
	public void write(String msg, File file) throws FileNotFoundException, IOException {
        FileWriter fw = new FileWriter(file, true);
        fw.write(msg+"\n");
        fw.close();

    }
	
	 public String receiverFromServer() throws IOException {

	      	InputStream input = socket.getInputStream();
	        byte[] b = new byte[1024];
	        input.read(b);
	        String msg = new String(b).trim();
	        System.out.println("recebeu nova mensagem:" + msg);
	        
	        return msg;
	    }
	

}
