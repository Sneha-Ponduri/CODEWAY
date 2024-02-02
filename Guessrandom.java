import java.util.Random; 
import java.util.Scanner; 
public class Guessrandom { 
	public static void main(String[] args) 
	{ 
		int ans, guessnum; 
		final int max = 100; 
		Scanner in = new Scanner(System.in); 
		Random rand = new Random(); 
		boolean correct = false; 
		ans = rand.nextInt(max) + 1; 
		while (!correct) { 
			System.out.println( 
				"Guess a number between 1 and 100: "); 
			guessnum = in.nextInt(); 
			if (guessnum > ans) { 
				System.out.println("Too high, try again"); 
			} 
			else if (guessnum < ans) { 
				System.out.println("Too low, try again"); 
			} 
			else { 
				System.out.println( 
					"Yes, you guessed the number."); 
				correct = true; 
			} 
		} 
		System.exit(0); 
	} 
}
