package hangman;

public class hangmangubbe {

	private static int count; // Anv�nder mig av en class enbart f�r nedr�kningen och gubben just f�r att g�ra
								// den andra koden kortare och mer kompakt

	public hangmangubbe() {
		count=0;
	}
	public static void hangmanImage() { // Koden f�r gubben. Bildar en gubbe f�r varje felgissning
		
		if (count == 1) {
			System.out.println("Wrong,pick a letter again, you have 6 attempts left");
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("___|___");
			System.out.println();
		}
		if (count == 2) {
			System.out.println("Wrong, pick a letter again, you have 5 attempts left");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("___|___");
		}
		if (count == 3) {
			System.out.println("Wrong, pick a letter again, you have 4 attempts left");
			System.out.println("   ____________");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   | ");
			System.out.println("___|___");
		}
		if (count == 4) {
			System.out.println("Wrong, pick a letter again, you have 3 attempts left");
			System.out.println("   ____________");
			System.out.println("   |          _|_");
			System.out.println("   |         /   \\");
			System.out.println("   |        |     |");
			System.out.println("   |         \\_ _/");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("___|___");
		}
		if (count == 5) {
			System.out.println("Wrong, guess again, you have 2 attempts left");
			System.out.println("   ____________");
			System.out.println("   |          _|_");
			System.out.println("   |         /   \\");
			System.out.println("   |        |     |");
			System.out.println("   |         \\_ _/");
			System.out.println("   |           |");
			System.out.println("   |           |");
			System.out.println("   |");
			System.out.println("___|___");
		}
		if (count == 6) {
			System.out.println("Wrong, guess again, your last chance 1 attempt left");
			System.out.println("   ____________");
			System.out.println("   |          _|_");
			System.out.println("   |         /   \\");
			System.out.println("   |        |     |");
			System.out.println("   |         \\_ _/");
			System.out.println("   |           |");
			System.out.println("   |           |");
			System.out.println("   |          / \\ ");
			System.out.println("___|___      /   \\");
		}
		if (count == 7) {
			System.out.println("You loose!");
			System.out.println("   ____________");
			System.out.println("   |          _|_");
			System.out.println("   |         /   \\");
			System.out.println("   |        |     |");
			System.out.println("   |         \\_ _/");
			System.out.println("   |          _|_");
			System.out.println("   |         / | \\");
			System.out.println("   |          / \\ ");
			System.out.println("___|___      /   \\");
			
			System.out.println("You loose! Game over");
		}
	}

	public static int getCount() {
		return count;
	}

	public static void countUp() {  // koden f�ratt spelet ska r�kna vid felgissning
		hangmangubbe.count = count+1;
	}



	
}


