package middle;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SendMessage extends Thread {
	
	private File file;
	private String address;
	private int port;
	private Socket socket;
	
	public SendMessage(File file, String address, int port, Socket socket) throws UnknownHostException, IOException{
		this.file = file;
		this.address = address;
		this.port = port;
		this.socket = socket;
	}
	

	public void run() {

        try {
        	System.out.println("Enviando arquivo");
        	 
            Message message = new Message(this.file);

            //while (true) {

                //verifica se o host está disponível
                //if (InetAddress.getByAddress(this.address.getBytes()).isReachable(1000) == true) {
                    
                    // verifica se existe nova mensagem
                    if (message.hasNewMessage()) {
                        //recebe a última linha do arquivo
                        String sendMsg = message.getLastMsg();
                        //enviar por Socket a mensagem
                        sendForServer(sendMsg);
                        System.out.println("enviou nova mensagem:" + sendMsg );
                       
                    }
                    else {
                    	sendForServer("\n");
                    }
                //}
                    System.out.println("Enviado arquivo");

            //}
        } catch (UnknownHostException ex) {
            Logger.getLogger(MiddlewareClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MiddlewareClient.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
	
	 public void sendForServer(String msg) throws IOException {
	        System.out.println("Conectando ao Middleware Server...");
	        
	        socket.getOutputStream().write(msg.getBytes());
	        socket.getOutputStream().flush();
	        
	        
	    }
	
}
