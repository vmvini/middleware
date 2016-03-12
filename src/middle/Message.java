package middle;

import java.io.File;
import java.io.FileNotFoundException;

import middle.FileUtils;

public class Message {
	
	public static String currentLastMsg = "";
	
	private File file;
	
	public Message(File file) throws FileNotFoundException{
		this.file = file;
	}
	
	public String getLastLine() throws FileNotFoundException{
		return FileUtils.tail(this.file);
	}
	
	public String getLastMsg(){
		return currentLastMsg;
	}
	
	public boolean hasNewMessage() throws FileNotFoundException{
		String lastLine = getLastLine();
		if(lastLine == null) lastLine = "";
		if(!lastLine.equals(currentLastMsg)){
			currentLastMsg = lastLine;
			return true;
		}
		else
			return false;
		
	}

}
