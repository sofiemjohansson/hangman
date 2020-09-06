package hangman;

import java.util.Scanner;

public class hangman

{

	private static String[] words = { "goalie", "boarding", "stick", "puck", "tripping", "hockey", "referee", "goal" }; // Hemligt
																														// vilka
																														// ord
																														// det
																														// är
																														// därmed
																														// privat
	private static String word = words[(int) (Math.random() * words.length)];
	private static String asterisk = new String(new char[word.length()]).replace("\0", "*");
	private static hangmangubbe image = new hangmangubbe(); // bokstäver ordet har

	private static boolean gamerunning = true;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String guess = "";

		Scanner myObj = new Scanner(System.in); // skapar scanner objekt som ber om spelarens namn
		System.out.println("Name of player:"); // Ber spelaren skriva önskat användernamn

		String userName = myObj.nextLine(); //
		System.out.println("Players name: " + userName); // Skriver namn i programmet innan spelet börjar
		System.out.println("Welcome to hangman hockeytheme"); // inledningen när man kör programmet som visar vilket
																// tema det är.
		while (image.getCount() < 7 && gamerunning) // visar ritar gubben vid fel samt räknar ner till 0 försök

		{

			System.out.println("Enter number 1= attempts, 2= guess word, 3= letter"); // menyn som låter spelaren välja
																						// vilket dom vill göra
			while (!sc.hasNextInt()) { // koden som gör att användaren får nedanstående meddelande vid felskrivning
				System.out.println("Not a number choose again"); //
				sc.next();
			}
			int option = sc.nextInt(); // kod som gör så att spelaet inte låser sig om spelaren råkar välja en bokstav
										// istället för en siffra
			sc.nextLine();

			if (option == 1) { // val ett i menyn som visar antal attempts man har kvar

				System.out.println("Number of attempts used: " + image.getCount() + " of 7"); // Denna kod ger
																								// användaren besked om
																								// antal försök
			}

			else if (option == 2) { // val två i menyn som låter spelaren gissa hela ordet

				System.out.println(asterisk); // Låter användaren får gissa ordet.
				System.out.print("Enter word ");
				guess = sc.nextLine();
				hangmanword(guess);

			} else if (option == 3) { // Val tre i menyn som låter spelaren gissa bokstav.
				System.out.println(asterisk); // låter användaren få gissa bokstav
				System.out.print("Enter letter ");
				guess = sc.nextLine();
				hangman(guess);

			}

		}
		// sc.close(); // stänger den övre scannern

	}

	public static void hangmanword(String guess) { // här är koden som låter spelaren gissa ordet

		if (guess.equals(word)) { // denna koden visas om man lyckas gissa rätt ord.
			System.out.println("Correct! You´re the best! The word was " + word);
			gamerunning = false; // Stoppar körning av spelaet då det är slut
		} else {
			image.countUp();
			image.hangmanImage(); // fortsätter spelet med att bygga gubben vid felgissning av ordet
		}
	}

	public static void hangman(String guess) { // här är koden som låter spelaren gissa med bokstäver.
		String newasterisk = "";

		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == guess.charAt(0)) {// Dessa koderna placerar bokstaven rätt vid rätt gissning i ordet
													// samt marker ej gissade ord som tex **h**
				newasterisk += guess.charAt(0);

			} else if (asterisk.charAt(i) != '*') {
				newasterisk += word.charAt(i);

			} else {
				newasterisk += "*";

			}
		}

		if (asterisk.equals(newasterisk)) { // denna koden räknar ner vid felgissning

			image.countUp();
			image.hangmanImage(); // kod för felgissning
		} else {
			asterisk = newasterisk;
			System.out.println("Correct letter " + asterisk); // denna koden används vid rätt gissning

		}
		if (asterisk.equals(word)) { // denna koden visas om man lyckas gissa rätt ord.
			System.out.println("Correct! You´re the best! The word was " + word); // Detta skrivs ut vis rätt gissning
			gamerunning = false;
		}
	}

}