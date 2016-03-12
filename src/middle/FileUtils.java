package middle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;

public class FileUtils {
	
	public static String tail( File file ) throws FileNotFoundException {
		
		BufferedReader input = new BufferedReader(new FileReader(file));
	
	    String last = null, line;
	    
	    try {
			while ((line = input.readLine()) != null) {
			    last = line;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    return last;
	}
}
