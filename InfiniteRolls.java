import java.util.Scanner;
import java.util.Random;
//sums of x amount of 6 sided dice being rolled
public class InfiniteRolls {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Random rng = new Random();
		int dieAmt;
		int die;
		int rolls;
		int sum = 0;
		
		System.out.println("How many dice would you like to roll?");
		dieAmt = in.nextInt();
		System.out.println("How many times would you like to roll them?");
		rolls = in.nextInt();
		
		int rollArray[] = new int[dieAmt*6 + 1];
		
		for(int j = 1; j <= rolls; j++) {
			for(int i = 0; i < dieAmt; i++) {
				die = rng.nextInt(6) + 1;
				sum = sum + die;
			}
			rollArray[sum]++;
			
			//System.out.println("Roll " + j + ": " + sum);
			sum = 0;
		}
		System.out.println("---------------------------------------------------------------------");
	//shows frequencies
		/*for(int i = 1; i < dieAmt*6 + 1; i++) {
		System.out.println("Amount of " + i + "s: " + rollArray[i]);
		}*/
	//shows probability in fraction form
		/*for(int i = 1; i < dieAmt*6 + 1; i++) {
			System.out.println("Probability of rolling " + i + ": " + rollArray[i] + "/" + rolls);
		}*/
	//shows probability in percents
		/*for(int i = 1; i < dieAmt*6 + 1; i++) {
			double probability = 100 * ((double)rollArray[i])/((double)rolls);
			System.out.printf("Probability of rolling " + i + ": %.3f percent\n", probability);
		}*/
		//shows total possible occurrences of each 
		for(int i = 1; i < dieAmt*6 + 1; i++) {
			double occurence = Math.round((((double)rollArray[i])/((double)rolls)) * Math.pow(6, dieAmt));
			System.out.printf("Total possible occurrences of " + i + ": %.0f \n", occurence);
		}
	}
}
