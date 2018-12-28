/**
 * (Adelekan Faruq Aliu 27064896 and Maria Rizk 40020692).
 * COMP249.
 * Assignment #(4).
 * Due Date (12/1/2018).
 */

import java.util.ArrayList;
import java.util.Scanner;

//-----------------------------------------------------
//	Assignment (4)
//	Question: (Part 1: ArrayList & Other subjects)
//	Written by: (Adelekan Faruq Aliu 27064896 and Maria Rizk 40020692)
//	This class contains methods to read a file and process the file's 
//	frequency and words according to Zipf's Laws
//-----------------------------------------------------

/**
 * 
 * @author Adelekan Faruq Aliu and Maria Rizk.
 *
 */
public class Zipf 
{
	// attributes
	private ArrayList<String> words = new ArrayList<String>();
	private int numberOfWords;
	private int numberOfTypes;
	private ArrayList<FreqWords> freqAndWords = new ArrayList<FreqWords>();  

	/**
	 * The default constructor of the class.
	 */
	public Zipf() 
	{
		numberOfWords = 0;
		numberOfTypes = 0;
	}

	// methods 
	/**
	 *  This method reads the input file and removes invalid words,
	 *  stores valid words into the words ArrayList.
	 * @param sc The scanner used to read the input file.
	 */
	private void readFile(Scanner sc) 
	{
		// scanner reads the file
		while(sc.hasNext()) 
		{
			words.add(sc.next()); // reads and stores the words from the file into the arraylist
		}

		// goes through the ArrayList words and remove all words that are not letters
		for(int i = 0; i < words.size(); i++)
		{
			for(int j = 0; j < words.get(i).length(); j++)
			{
				if(!Character.isLetter(words.get(i).charAt(j)))
				{
					words.remove(i); // remove invalid words
					i--;
					break;
				}
			}
		}
		// close scanner
		sc.close();
	}

	/**
	 * This method counts the frequency of words,
	 * calls the method to sort the array, method to get the happax and stop words, 
	 * and display the results to the console.
	 */
	private void counter()
	{
		// the numberOfWords is the number of word tokens after removing invalid words
		numberOfWords = words.size();

		int freq = 1;
		for(int k = 0; k < words.size(); k++)
		{
			freqAndWords.add(k, new FreqWords(freq, words.get(k)));
		}

		// getting the frequency of words
		for(int i = 0; i < freqAndWords.size(); i++)
		{
			for(int j = i+1; j < freqAndWords.size(); j++)
			{
				// if same word
				if(freqAndWords.get(i).word.equals(freqAndWords.get(j).word))
				{
					// remove that word
					freqAndWords.remove(j);
					freq++; // increment the frequency of that word
				}
			}
			freqAndWords.set(i, new FreqWords(freq, freqAndWords.get(i).word)); // setting the words and their frequency in the array list
			freq = 1;
		}
		numberOfTypes = freqAndWords.size();  // the number of types is the size of the arraylist

		// SORTS the ArrayList freqAndWords; word in ascending order and frequency in descending order  
		FreqWords.sortArray(freqAndWords);
		
		// displays results
		displayFormat();
	} 

	/**
	 * This method displays the result based on the file.
	 */
	private void displayFormat()
	{
		// Printing out the results 
		System.out.println("\n--------------------------------------------");
		System.out.println("RANK" + "\t\t" + "FREQ" + "\t\t" + "WORD");
		System.out.println("--------------------------------------------");

		int rank = 1;
		for(int l = 0; l < freqAndWords.size(); l++)
		{
			System.out.println((rank++) + "\t\t" + freqAndWords.get(l).frequency + "\t\t" + freqAndWords.get(l).word);
		}		

		System.out.println("\n--------------------------------------------\n");
		System.out.println("Number of word tokens: " + numberOfWords);
		System.out.println("Number of word types: " + numberOfTypes);

		// Format decimal places with String format method to display zero decimal place
		// Happax
		double percentHappax = (freqHappax()/numberOfTypes)*100;
		double accountHappax = (freqHappax()/numberOfWords)*100;

		System.out.println("\nNumber of happax: " + String.format("%,.0f", freqHappax()));
		System.out.println("% of Happax: " + String.format("%,.0f", percentHappax) + "%");
		System.out.println("Happax account for: " + String.format("%,.0f", accountHappax) + "% of the text");

		// Stop Words
		double percentStopWords = (freqStopWords()/numberOfTypes)*100;
		double accountStopWords = (freqStopWords()/numberOfWords)*100;

		System.out.println("\nNumber of stop words: " + String.format("%,.0f", freqStopWords()));
		System.out.println("% of stop words: " + String.format("%,.0f", percentStopWords) + "%");
		System.out.println("Stop words account for: " + String.format("%,.2f", accountStopWords) + "% of the text"); 
	}
	
	/**
	 * This method to get the number of Happax.
	 * @return happax The number of words with 1 frequency.
	 */
	private double freqHappax()
	{
		double happax = 0;
		for(int k = 0; k < freqAndWords.size(); k++)
		{
			if(freqAndWords.get(k).frequency == 1)
			{
				happax++;
			}
		}
		return happax;
	}

	/**
	 * This method to get the number of Happax
	 * @return stopWords The number of words with 10 or more frequency and [with 4 characters or less].
	 */
	private double freqStopWords()
	{
		double stopWords = 0;
		for(int k = 0; k < freqAndWords.size(); k++)
		{
			if(freqAndWords.get(k).frequency >= 10 && freqAndWords.get(k).word.length() <= 4)
			{
				stopWords++;
			}
		}
		return stopWords;
	}

	/**
	 * This method calls the readFile and the counter methods.
	 * @param sc The Scanner needed to read the input file.
	 */
	public void callAll(Scanner sc)
	{
		readFile(sc);
		counter();
	}
}
