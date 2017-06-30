package a01;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class HangmanApp {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		ArrayList<Character> array = new ArrayList<>();
		ArrayList<Character> letterArray = new ArrayList<>();
		ArrayList<Character> guessedLetters = new ArrayList<>();
		int life = 6;
		String word = wordBank();
		int length = word.length();
		char[] cArray = word.toCharArray();
		for(int i = 0; i < cArray.length; i++) {
			letterArray.add(cArray[i]);
		}
		
		for(int i = 0; i < length; i++) {
			array.add('_');
		}

		for(Character c: array) {
			System.out.printf("%s ", c);
		}
		System.out.printf("(lives left: %d)%n", life);
		System.out.println();
		while(life > 0 && array.contains('_')) {
			System.out.print("Your guess: ");
			char c = input.next(".").charAt(0);
			if(!guessedLetters.contains(c)) {
				guessedLetters.add(c);
			}
			else {
				System.out.println("You've already guessed that letter!\n"
						+ "");
				if(!letterArray.contains(c)) {
					life++;
				}
			}
			
			for(int i = 0; i < length; i++) {
				if(letterArray.get(i) == c) {
					array.set(i, c);
				}
			}
			if(!letterArray.contains(c)) {
				if(life == 0) {
					break;
				}
				life--;
			}
			for(int i = 0; i < length; i++) {
				System.out.printf("%s ", array.get(i));
			}
			
			System.out.printf("(lives left: %d)%n", life);
			System.out.print("Guessed Letters: ");
			for(Character ch: guessedLetters) {
				System.out.printf("%c ", ch);
			}
			System.out.print("\n\n");
		}
		if(array.contains('_')) {
			System.out.printf("The word was %s - try again%n", word);
		}
		else {
			System.out.println("congratulations!");
		}
	}
	
	private static String wordBank() {
		ArrayList<String> words = new ArrayList<>();
		Random rand = new Random();
		int n;
		words.add("apple");
		words.add("boat");
		words.add("cactus");
		words.add("doorbell");
		words.add("explain");
		words.add("copper");
		words.add("tenuous");
		words.add("notice");
		words.add("hum");
		words.add("branch");
		n = rand.nextInt(11);
		return words.get(n);
	}
}