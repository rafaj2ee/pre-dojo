package br.com.amil.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class FileUtils {
	public static String readFileAsString(String filePath) throws java.io.IOException{
	    byte[] buffer = new byte[(int) new File(filePath).length()];
	    BufferedInputStream f = new BufferedInputStream(new FileInputStream(filePath));
	    f.read(buffer);
	    return new String(buffer);
	}
	public static String readFileAsString(String filePath, String charset) throws java.io.IOException{
	    System.out.println(filePath);
		StringBuffer sb = new StringBuffer();
	    InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath), charset);

	    int c = 0;

	    while ((c = isr.read()) != -1){
	    	sb.append((char) c);
	    }
	    
	    return sb.toString();
	}
}
