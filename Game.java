import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class Game {
	public static void main(String[] args) {
		Character player = new Character ("ERROR");
		Character player2 = new Character("ERROR");
		Character enemy = new Character ("ERROR");
		Scanner in = new Scanner(System.in);
		Random rng = new Random();
		boolean isInt = false;
		boolean loop = false;
		int input = -1;
		int enemyChoice;
		boolean game2 = false;
		
		do {
			System.out.println("1: Single Player 2: 2 Player");
			if(in.hasNextInt()) {
				input = in.nextInt();
				in.nextLine();
				isInt = true;
			}
			else {
				in.nextLine();
				isInt = false;
			}
			
			if (!isInt || input <= 0 || input > 2) {
				loop = true;
				System.out.println("You didn't enter a valid input. Please try again.");
			}
			else {
				loop = false;
			}
		} while(loop);
		if (input == 2) {
			game2 = true;
		}
		if (game2) {
			do {
				System.out.println("Player 1: Choose your class| 1: Warrior 2: Rogue 3: Archer 4: Mage");
				if(in.hasNextInt()) {
					input = in.nextInt();
					in.nextLine();
					isInt = true;
				}
				else {
					in.nextLine();
					isInt = false;
				}
				
				if (!isInt || input <= 0 || input > 4) {
					loop = true;
					System.out.println("You didn't enter a valid input. Please try again.");
				}
				else {
					loop = false;
				}
			} while(loop);
			
			if (input == 1) {
				player = new Character("Warrior");
			}
			else if (input == 2) {
				player = new Character("Rogue");
			}
			else if (input == 3) {
				player = new Character("Archer");
			}
			else if (input == 4) {
				player = new Character("Mage");
			}
			
			do {
				System.out.println("Player 2: Choose your class| 1: Warrior 2: Rogue 3: Archer 4: Mage");
				if(in.hasNextInt()) {
					input = in.nextInt();
					in.nextLine();
					isInt = true;
				}
				else {
					in.nextLine();
					isInt = false;
				}
				
				if (!isInt || input <= 0 || input > 4) {
					loop = true;
					System.out.println("You didn't enter a valid input. Please try again.");
				}
				else {
					loop = false;
				}
			} while(loop);
			
			if (input == 1) {
				player2 = new Character("Warrior");
			}
			else if (input == 2) {
				player2 = new Character("Rogue");
			}
			else if (input == 3) {
				player2 = new Character("Archer");
			}
			else if (input == 4) {
				player2 = new Character("Mage");
			}
			
			System.out.println("You wander through the forest until suddenly you are attacked by a " + player2.name + "!");
			
			Character.combat2(player, player2);
		}
		else {
			do {
				System.out.println("Choose your class| 1: Warrior 2: Rogue 3: Archer 4: Mage");
				if(in.hasNextInt()) {
					input = in.nextInt();
					in.nextLine();
					isInt = true;
				}
				else {
					in.nextLine();
					isInt = false;
				}
				
				if (!isInt || input <= 0 || input > 4) {
					loop = true;
					System.out.println("You didn't enter a valid input. Please try again.");
				}
				else {
					loop = false;
				}
			} while(loop);
			
			if (input == 1) {
				player = new Character("Warrior");
			}
			else if (input == 2) {
				player = new Character("Rogue");
			}
			else if (input == 3) {
				player = new Character("Archer");
			}
			else if (input == 4) {
				player = new Character("Mage");
			}
			
			/*enemyChoice = rng.nextInt(4);
			if (enemyChoice == 0) {
				enemy = new Character("Warrior");
			}
			else if (enemyChoice == 1) {
				enemy = new Character("Rogue");
			}
			else if (enemyChoice == 2) {
				enemy = new Character("Archer");
			}
			else if (enemyChoice == 3) {
				enemy = new Character("Mage");
			}*/
			
			do {
				System.out.println("Choose your enemy| 1: Warrior 2: Rogue 3: Archer 4: Mage 5: Thief 6: Dragon");
				if(in.hasNextInt()) {
					input = in.nextInt();
					in.nextLine();
					isInt = true;
				}
				else {
					in.nextLine();
					isInt = false;
				}
				
				if (!isInt || input <= 0 || input > 6) {
					loop = true;
					System.out.println("You didn't enter a valid input. Please try again.");
				}
				else {
					loop = false;
				}
			} while(loop);
			
			if (input == 1) {
				enemy = new Character("Warrior");
			}
			else if (input == 2) {
				enemy = new Character("Rogue");
			}
			else if (input == 3) {
				enemy = new Character("Archer");
			}
			else if (input == 4) {
				enemy = new Character("Mage");
			}
			else if (input == 5) {
				enemy = new Character("Thief");
			}
			else if (input == 6) {
				enemy = new Character("Dragon");
			}
			
			System.out.println("You wander through the forest until suddenly you are attacked by a " + enemy.name + "!");
			Character.combat(player, enemy);
			
			if (player.health > 0) {
				enemy = new Character ("Thief");
				Character.combat(player, enemy);
			}
		}
	}
}