import java.util.*;
import java.io.*;

public class Text_Analyzer_Code {

	public static void main(String[] args) throws IOException  { 
		//1) Ask the user for the Text file
		//2)Verify the word count on the text file
		//3)Verify Character Count
				//a) Include character count with spaces
				//b) Include character count with no spaces
		//4)Show the Longest word
		//5)Show the shortest word
		//6)Display all the words that was used in the text file and delete any repetitions
		
		TextAnalyzer t1 = new TextAnalyzer("File.TXT");
	}

}

class TextAnalyzer { 
	//Fields
	private Scanner kb=new Scanner(System.in);
	private ArrayList<String> words = new ArrayList<String>();
	
	//Fields to show results
	int wordCountResult;
	int characterCountResult1;
	String longestWordResult;
	String shortestWordResult;
	String characterFrequency;
	String wordFrequency;
	String FinalResult;
	
	
	//Constructor
	TextAnalyzer(String fileName) throws IOException
	{
		//Open the file, read it, and populate array list
		File file = new File(fileName);
		Scanner inputFile = new Scanner(file);

		while (inputFile.hasNext())
		{
			//Read the next word
			String word = inputFile.next();
			
			//Add that word to array list
			words.add(word);
		}
		
		//Method 1: Get word count
		wordCountResult = wordCount(words);
		//Method 2: Get charactor count from the arraylist
		characterCountResult1=characterCount(words);
		//Method 3: Get the longest word
		longestWordResult=getLongestWord(words);
		//Method 4: Get the shortest word
		shortestWordResult =getShortestWord(words);
		//Method 5: Record the character frequency in the textfile
		characterFrequency=getCharacterFrequency(words);
		//Method 6: Show each word in the text file and show its frequency
		wordFrequency=getWordFrequency(words);
		//Method 7 - Display Result
		displayResult(wordCountResult,characterCountResult1,longestWordResult,shortestWordResult,characterFrequency,wordFrequency);
		
		
	}

//Method 1
	public static int wordCount(ArrayList <String> words)
	{
		return words.size();
	}
	
//Method 2 - Main method
	public static int characterCount(ArrayList <String> words)
	{
		int charCount;
		int charCountWithSpaces;
		
		charCount = characterCounter(words);
		charCountWithSpaces=charCount+(words.size()-1);
		
		return charCountWithSpaces;
		
	}
//Method 2 - Sub Method
	public static int characterCounter(ArrayList <String> words)
	{
		int counter =0;
		int arraySize = words.size();
		
		for(int i =0; i<=arraySize-1;i++) // Read each word on the array list
		{
			String word = words.get(i); // Get the word at i index
			int length = word.length(); // Measure the length of the word
			counter +=length; // Add the length of the word to the counter
		}
		return counter;
		
	}

//Method 3 
	public static String getLongestWord(ArrayList <String> words)
	{
		int longest =0;
		String longestWord=" ";
		//Read each word on the array list
		for(int i =0;i<=words.size()-1;i++)
		{
			String singleWord = words.get(i);
			
			if(singleWord.length()>longest)
			{
				longest = singleWord.length();
				longestWord = singleWord;
			}
		}
		return longestWord;
	}

//Method 4
	public static String getShortestWord(ArrayList <String> words)
	{
		int shortest =99999999;
		String shortestWord=" ";
		//Read each word on the array list
		for(int i =0;i<=words.size()-1;i++)
		{
			String singleWord = words.get(i);
			
			if(singleWord.length()<shortest)
			{
				shortest = singleWord.length();
				shortestWord = singleWord;
			}
		}
		return shortestWord;
	}

//Method 5 - Main Method
	public static String getCharacterFrequency(ArrayList <String> words) {
		char [] alphabetLetters = new char [26];  // store each letter in alphabet
		int [] counter = new int[alphabetLetters.length]; //keep tracks of the letter frequency in the text file
		alphabetLetters = populateArray(alphabetLetters);
		for(int i =0;i<=words.size()-1;i++)
		{
			String singleWord=words.get(i);
			singleWord=singleWord.toLowerCase();
			for(int j = 0;j<=singleWord.length()-1;j++)
			{
				char characterHolder = singleWord.charAt(j);
				for(int k=0;k<=alphabetLetters.length-1;k++)
				{
					if (characterHolder == alphabetLetters[k])
					{
						counter[k]++;
					}
				}
			}
		}
		return Arrays.toString(alphabetLetters) + " " + Arrays.toString(counter);
	}
	

//Method 5 - Sub Method
	public static char [] populateArray(char [] a)
	{
		int asciiVal = 97;
		for(int i =0; i<=a.length-1;i++)
		{
			char alphabetLetter = (char)asciiVal;	
			a[i]= alphabetLetter;
			asciiVal++;
		}
		return a;
	}

//Method 6
	public static String getWordFrequency(ArrayList <String> words)
	{
		Map<String, Integer> wordFrequency= new HashMap<>();
		
		for(int i=0;i<=words.size()-1;i++)
		{
			String singleWord = words.get(i);
			singleWord=singleWord.toLowerCase();
			if(!(wordFrequency.containsValue(singleWord)))
			{
				wordFrequency.put(singleWord, i);
			}
		}
		
		
		
		
		
		return wordFrequency.toString();

		
	}

// Method 7
	public void displayResult(int wordCount, int charCount, String longestW, String shortestW, String charFreq, String wordFreq)
	{
		System.out.println("1) Word Count:" + wordCount + "\n" +
				"2) Character Count:" + charCount + "\n" +
				"3) Longest Word:" + longestW + "\n" +
				"4) Shortest Word:" + shortestW + "\n" +
				"5) Character Frequency:" + "\n" + charFreq + "\n" + 
				"6) Word Frequency:" + "\n" + wordFreq +"\n--------------------------------"
				);
	}

	}
	

	
	
	

	

	
	

	

