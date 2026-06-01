/**

        * File: Unit 5 Problem Set

        * Author: Peter

        * Date Created: May 15, 2026

        * Date Last Modified: May 18, 2026

        */

import java.util.Scanner;

public class TextAnalyzer {

	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
	
		System.out.println("Welcome to the Text Analyzer");	

		//input
		System.out.print("Please enter a sentence or paragraph: ");
		String text = input.nextLine();

		//counting
		int totalCharacters = text.length();
		int totalspaces = 0;
		int totalVowels = 0;
		int sentenceCounter = 0;

		//Counting spaces, vowels, sentences.
		
		for (int i = 0; i < text.length(); i++){
			char chara = Character.toLowerCase(text.charAt(i));

			if (chara == ' ') {
				totalspaces++;
			}
			if (chara == 'a' || chara == 'e' || chara == 'i' || chara == 'o' || chara == 'u'){
				totalVowels++;
			}
			if (chara == '.' || chara == '!' || chara == '?'){
				sentenceCounter++;
			}
		}

		//Remove punctuation and making it lowercase
		text = text.toLowerCase();
		text = text.replaceAll("[/.!?;:]", "");

		// splitting words
		String[] words = text.split(" ");

		int totalWords = 0;
		int totalWordLength = 0;

		//word frequenecy
		String[] uniWords = new String[words.length];
		int[] frequency = new int[words.length];
		int uniCount = 0;

		// words to ignore
		String[] ignoreWords = {"the", "a", "an", "and", "is"}; 

		// longest/shortests words
		
		boolean firstWord = true;
		int longestLength = 0;
		int shortestLength = 0;

		for (int i = 0; i < words.length; i++){
			String word = words[i];

			if (!word.equals("")){
				totalWords++;
				totalWordLength += word.length();

				if (firstWord){
					longestLength = word.length();
					shortestLength = word.length();
					firstWord = false;
				}

				// longest word
				if (word.length() > longestLength) {
					longestLength = word.length();
				}
				// shortest word
				if (word.length() < shortestLength) {
					shortestLength = word.length();
				}
				// word frequency check 
				boolean found = false;

				for (int q = 0; q < uniCount; q++){
					if (word.equals(uniWords[q])){
						frequency[q]++;
						found = true;
					}
				}

				if (!found){
					uniWords[uniCount] = word;
					frequency[uniCount] = 1;
					uniCount++;
				}
			}
		}

		// output
		System.out.println("\nTotal Characters: " + totalCharacters);
		System.out.println("Total words: " + totalWords);
		System.out.println("Total Vowels: " + totalVowels);
		System.out.println("Total Spaces: " + totalspaces);

		// word frequency
		System.out.println("\nWord Frequency:\n");

		for (int i = 0; i < uniCount; i++){
			System.out.println(uniWords[i] + " - " + frequency[i]);
		}

		//longest words
		System.out.print("\nLongest word(s)");
		for (int i = 0; i < words.length; i++){
			if (!words[i].equals("") && words[i].length() == longestLength){
				System.out.print(words[i] + " ");
			}
		}

		//shortest words
		System.out.print("\nShortest word(s): ");
		for (int i = 0; i < words.length; i++){
			if (!words[i].equals("") && words[i].length() == shortestLength){
				System.out.print(words[i] + " ");
			}
		}

		//final output
		double avg = 0;
		if (totalWords > 0){
			avg = (double) totalWordLength / totalWords;
		}
		System.out.println("\nAverage Word Length: " + avg);
		System.out.println("Number of Sentences: " + sentenceCounter);
		System.out.println("Unique Words: " + uniCount);
	}
}
