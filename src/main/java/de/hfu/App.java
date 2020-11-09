package de.hfu;
import java.io.*;
/**
 * 
 * @author Felix K.
 * @version 1.0
 */
public class App 
{
	/**
	 * 
	 * @param args
	 * @throws IOException
	 */
    public static void main( String[] args ) throws IOException
    {
        InputStreamReader isr = new InputStreamReader(System.in);
    	BufferedReader br = new BufferedReader(isr);
    	String input = br.readLine();
    	System.out.println(input.toUpperCase());
    }
}
