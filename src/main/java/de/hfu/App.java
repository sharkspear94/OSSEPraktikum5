package de.hfu;
import java.io.*;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        InputStreamReader isr = new InputStreamReader(System.in);
    	BufferedReader br = new BufferedReader(isr);
	String input = br.readLine();
	System.out.println(input.toUpperCase());
    }
}
