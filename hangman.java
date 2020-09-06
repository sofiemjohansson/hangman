package hangman;

import java.util.Scanner;

public class hangman

{

	private static String[] words = { "goalie", "boarding", "stick", "puck", "tripping", "hockey", "referee", "goal" }; // Hemligt
																														// vilka
																														// ord
																														// det
																														// �r
																														// d�rmed
																														// privat
	private static String word = words[(int) (Math.random() * words.length)];
	private static String asterisk = new String(new char[word.length()]).replace("\0", "*");
	private static hangmangubbe image = new hangmangubbe(); // bokst�ver ordet har

	private static boolean gamerunning = true;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String guess = "";

		Scanner myObj = new Scanner(System.in); // skapar scanner objekt som ber om spelarens namn
		System.out.println("Name of player:"); // Ber spelaren skriva �nskat anv�ndernamn

		String userName = myObj.nextLine(); //
		System.out.println("Players name: " + userName); // Skriver namn i programmet innan spelet b�rjar
		System.out.println("Welcome to hangman hockeytheme"); // inledningen n�r man k�r programmet som visar vilket
																// tema det �r.
		while (image.getCount() < 7 && gamerunning) // visar ritar gubben vid fel samt r�knar ner till 0 f�rs�k

		{

			System.out.println("Enter number 1= attempts, 2= guess word, 3= letter"); // menyn som l�ter spelaren v�lja
																						// vilket dom vill g�ra
			while (!sc.hasNextInt()) { // koden som g�r att anv�ndaren f�r nedanst�ende meddelande vid felskrivning
				System.out.println("Not a number choose again"); //
				sc.next();
			}
			int option = sc.nextInt(); // kod som g�r s� att spelaet inte l�ser sig om spelaren r�kar v�lja en bokstav
										// ist�llet f�r en siffra
			sc.nextLine();

			if (option == 1) { // val ett i menyn som visar antal attempts man har kvar

				System.out.println("Number of attempts used: " + image.getCount() + " of 7"); // Denna kod ger
																								// anv�ndaren besked om
																								// antal f�rs�k
			}

			else if (option == 2) { // val tv� i menyn som l�ter spelaren gissa hela ordet

				System.out.println(asterisk); // L�ter anv�ndaren f�r gissa ordet.
				System.out.print("Enter word ");
				guess = sc.nextLine();
				hangmanword(guess);

			} else if (option == 3) { // Val tre i menyn som l�ter spelaren gissa bokstav.
				System.out.println(asterisk); // l�ter anv�ndaren f� gissa bokstav
				System.out.print("Enter letter ");
				guess = sc.nextLine();
				hangman(guess);

			}

		}
		// sc.close(); // st�nger den �vre scannern

	}

	public static void hangmanword(String guess) { // h�r �r koden som l�ter spelaren gissa ordet

		if (guess.equals(word)) { // denna koden visas om man lyckas gissa r�tt ord.
			System.out.println("Correct! You�re the best! The word was " + word);
			gamerunning = false; // Stoppar k�rning av spelaet d� det �r slut
		} else {
			image.countUp();
			image.hangmanImage(); // forts�tter spelet med att bygga gubben vid felgissning av ordet
		}
	}

	public static void hangman(String guess) { // h�r �r koden som l�ter spelaren gissa med bokst�ver.
		String newasterisk = "";

		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == guess.charAt(0)) {// Dessa koderna placerar bokstaven r�tt vid r�tt gissning i ordet
													// samt marker ej gissade ord som tex **h**
				newasterisk += guess.charAt(0);

			} else if (asterisk.charAt(i) != '*') {
				newasterisk += word.charAt(i);

			} else {
				newasterisk += "*";

			}
		}

		if (asterisk.equals(newasterisk)) { // denna koden r�knar ner vid felgissning

			image.countUp();
			image.hangmanImage(); // kod f�r felgissning
		} else {
			asterisk = newasterisk;
			System.out.println("Correct letter " + asterisk); // denna koden anv�nds vid r�tt gissning

		}
		if (asterisk.equals(word)) { // denna koden visas om man lyckas gissa r�tt ord.
			System.out.println("Correct! You�re the best! The word was " + word); // Detta skrivs ut vis r�tt gissning
			gamerunning = false;
		}
	}

}