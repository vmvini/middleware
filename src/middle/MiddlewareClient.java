/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package middle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jederson
 */
public class MiddlewareClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws UnknownHostException {
        // TODO code application logic here
    	String sfile1 = "/home/vmvini/Documentos/chat/sendMsgs.txt";
		String sfile2 = "/home/vmvini/Documentos/chat/receivedMsgs.txt";
    	
        File enviarFile = new File(sfile1);
        File receberFile = new File(sfile2);
      
        String address = "192.168.1.100";
        int port = 9999;
        

        //Thread para envio de msg para o servidor
        try{
          while(true){
        	  //
        	  System.out.println("Mensagem para enviar: " + Message.currentLastMsg);
	        Socket s = new Socket(address, port);
	        SendMessage sm = new SendMessage(enviarFile, address, port, s);
	        sm.run();
	        
	        //thread para receber mensagem
	        ReceiveMessage rm = new ReceiveMessage(receberFile, address, port, s);
	        rm.run();
	        //
	        s.close();
	        //
	        Thread.sleep(20000);
          }
        
        }
        catch(IOException e){
        	e.printStackTrace();
        }
        catch (InterruptedException e) {
			e.printStackTrace();
		}
        

    }



   

   

}