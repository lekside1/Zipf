/**
 * (Adelekan Faruq Aliu 27064896 and Maria Rizk 40020692).
 * COMP249.
 * Assignment #(4).
 * Due Date (12/1/2018).
 */

import java.util.ArrayList;

//-----------------------------------------------------
//	Assignment (3)
//	Question: (Part 1: ArrayList & Other subjects)
//	Written by: (Adelekan Faruq Aliu 27064896 and Maria Rizk 40020692)
//	This class contains the word and its frequency. It also contains 
//	methods to sort an array of the class obejcts
//-----------------------------------------------------

/**
 * 
 * @author Adelekan Faruq Aliu and Maria Rizk.
 *
 */
public class FreqWords 
{
	// attributes
	protected int frequency;
	protected String word;

	/**
	 * The default constructor of the class.
	 */
	public FreqWords()
	{
		frequency = 0; 
		word = "";
	}

	/**
	 * This method get the frequency of a word.
	 * @return frequency of the word.
	 */
	public int getFrequency() {
		return frequency;
	}

	/**
	 * This method gets the word.
	 * @return word The word. 
	 */
	public String getWord() {
		return word;
	}
	
	/**
	 * This method sets the frequency of the word.
	 * @param frequency The int parameter of the setter method.
	 */
	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	/**
	 * This method sets the word.
	 * @param word The String parameter of the setter method.
	 */
	public void setWord(String word) {
		this.word = word;
	}

	/**
	 * The parameterized constructor of the class.
	 * @param frequency The first parameter of the constructor.
	 * @param word The second parameter of the constructor.
	 */
	public FreqWords(int frequency, String word)  
	{
		this.frequency = frequency;
		this.word = word;
	}

	/**
	 * This method sorts the Arraylist of frequency and words in descending order and in alphabetical order. 
	 * @param l The only parameter of the sortArray method.
	 */
	public static void sortArray(ArrayList<FreqWords> l)
	{
		// Auxiliary variable 
		FreqWords temp = new FreqWords();

		for (int i = 0; i < l.size(); i++) 
		{
			for (int j = i+1; j < l.size(); j++) 
			{
				// if the word have the same frequency, 
				if((l.get(i).frequency == l.get(j).frequency)) 				
				{
					// sort them in alphabetical order, Uppercase then lowercase
					if (l.get(i).word.compareTo(l.get(j).word) > 0) 
					{
						temp = l.get(i);
						l.set(i, l.get(j)); 
						l.set(j, temp);						
					}
				}
				// sort the frequency of the words in descending order
				if((l.get(i).frequency < l.get(j).frequency))
				{
					temp = l.get(i);
					l.set(i, l.get(j));
					l.set(j, temp);
				}
			}
		}
	}

	/**
	 * Overrides the default toString method
	 */
	public String toString()
	{
		return "frequency: " + frequency + ", word: " + word;
	} 
}
