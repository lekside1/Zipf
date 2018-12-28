/**
 * (Adelekan Faruq Aliu 27064896 and Maria Rizk 40020692).
 * COMP249.
 * Assignment #(4).
 * Due Date (12/1/2018).
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

//-----------------------------------------------------
//	Assignment (4)
//	Question: (Part 1: ArrayList & Other subjects)
//	Written by: (Adelekan Faruq Aliu 27064896 and Maria Rizk 40020692)
//	This is the Driver class that contains the main method of the program
//-----------------------------------------------------

/**
 *  
 * @author Adelekan Faruq Aliu and Maria Rizk.
 *
 */
public class Driver 
{ 
	/**
	 * This is the main method in the Driver class.
	 * @param args Unused.
	 */
	public static void main(String[] args) 
	{
		// create an object of Display class
		Zipf display = new Zipf(); 

		// Scanner for user input
		Scanner kb = new Scanner(System.in);
		String file;

		System.out.print("Enter input file: ");
		file = kb.nextLine();

		// Scanner to read the input file
		Scanner sc = null;
		File myfile = null;
		try 
		{
			myfile = new File(file);
			sc = new Scanner(new FileInputStream(myfile));
		
			// calls the callAll method
			display.callAll(sc); 
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("The file: " + myfile.getName() + " was not found. ");
		}

		// close scanner
		kb.close();
	}
}
