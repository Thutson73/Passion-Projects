import java.util.Random;
import java.util.Scanner;

public class Character{
	String playerName;
	String EnemyName;
	String name;
	//Abilities
	String ability1Name;
	String ability2Name;
	String ability3Name;
	boolean ability1Active;
	boolean ability2Active;
	boolean ability3Active;
	int ability1Cost;
	int ability2Cost;
	int ability3Cost;
	int ability1BaseCD;
	int ability2BaseCD;
	int ability3BaseCD;
	int ability1CCD;
	int ability2CCD;
	int ability3CCD;
	//Basic Stats
	String resourceName;
	int level;
	int exp;
	int resourceAmt;
	int resourceMax;
	int maxHealth;
	int health;
	int armor;
	int attackDmg;
	int dmgOutput;
	int critChance;
	int trueShot = 0;
	int steady = 0;
	int rapidFire = 0;
	//Status Effects
	int applyFrozen;
	int hasFrozen;
	int applyStun;
	int hasStun;
	int applyBleed;
	int hasBleed;
	int applyPoison;
	int hasPoison;
	int poisonDmg;
	int bleedDmg;
	int invisible;
	int applyWeakness;
	int hasWeakness;
	int applyEnrage;
	int hasEnrage;
	int applyArmorGain;
	int hasArmorGain;
	//Inventory
	String[] inventory = new String[6];
	String[] equipped = new String[3];
	
	public Character (String role) {
		if (role.contentEquals("Warrior")) {
			name = "Warrior";
			maxHealth = 100;
			health = 100;
			armor = 20;
			attackDmg = 8;
			critChance = 3;
			resourceName = "Rage";
			resourceAmt = 0;
			resourceMax = 100;
			ability1Name = "Fury";
			ability1BaseCD = 3;
			ability1Cost = 0;
			ability2Name = "Shield Bash";
			ability2BaseCD = 3;
			ability2Cost = 10;
			ability3Name = "Armor Up";
			ability3BaseCD = 0;
			ability3Cost = 0;
		}
		else if (role.contentEquals("Rogue")) {
			name = "Rogue";
			maxHealth = 70;
			health = 70;
			armor = 0;
			attackDmg = 10;
			critChance = 10;
			resourceName = "Energy";
			resourceAmt = 100;
			resourceMax = 100;
			ability1Name = "Eviscerate";
			ability1BaseCD = 3;
			ability1Cost = 40;
			ability2Name = "Poison Daggers";
			ability2BaseCD = 3;
			ability2Cost = 40;
			ability3Name = "Shadowdance";
			ability3BaseCD = 5;
			ability3Cost = 65;
		}
		else if (role.contentEquals("Archer")) {
			name = "Archer";
			maxHealth = 90;
			health = 90;
			armor = 10;
			attackDmg = 12;
			critChance = 5;
			resourceName = "Energy";
			resourceAmt = 100;
			resourceMax = 100;
			ability1Name = "Powershot";
			ability1BaseCD = 0;
			ability1Cost = 70;
			ability2Name = "Rapid Fire";
			ability2BaseCD = 2;
			ability2Cost = 40;
			ability3Name = "Steady Aim";
			ability3BaseCD = 2;
			ability3Cost = 0;
		}
		else if (role.contentEquals("Mage")) {
			name = "Mage";
			maxHealth = 80;
			health = 80;
			armor = 0;
			attackDmg = 12;
			critChance = 7;
			resourceName = "Runes";
			resourceAmt = 0;
			resourceMax = 3;
			ability1Name = "Siphon Magic";
			ability1BaseCD = 0;
			ability1Cost = 0;
			ability2Name = "Flash Freeze";
			ability2BaseCD = 3;
			ability2Cost = 1;
			ability3Name = "Runic Pulse";
			ability3BaseCD = 0;
			ability3Cost = 0;
		}
		else if (role.contentEquals("Thief")) {
			name = "Thief";
			maxHealth = 100;
			health = 100;
			armor = 10;
			attackDmg = 7;
			critChance = 6;
			resourceName = "Energy";
			resourceAmt = 100;
			resourceMax = 100;
			ability1Name = "Throw Sand";
			ability1BaseCD = 4;
			ability1Cost = 50;
			ability2Name = "Apply Poison";
			ability2BaseCD = 4;
			ability2Cost = 50;
			ability3Name = "Sinister Strike";
			ability3BaseCD = 3;
			ability3Cost = 50;
		}
		else if (role.contentEquals("Dragon")) {
			name = "Dragon";
			maxHealth = 200;
			health = 200;
			armor = 0;
			attackDmg = 5;
			critChance = 3;
			resourceName = "Rage";
			resourceAmt = 10;
			resourceMax = 100;
			ability1Name = "Fire Breath";
			ability1BaseCD = 4;
			ability1Cost = 40;
			ability2Name = "Ferocious Bite";
			ability2BaseCD = 4;
			ability2Cost = 40;
			ability3Name = "Flying High";
			ability3BaseCD = 4;
			ability3Cost = 40;
		}
		bleedDmg = 7;
		poisonDmg = 5;
	}
	
	public int ability1 () {
		Random rng = new Random();
		ability1CCD = ability1BaseCD;
		resourceAmt -= ability1Cost;
		if (name.contentEquals("Warrior")) {
			dmgOutput = 10;
			resourceAmt += 10;
			hasEnrage = 3;
			System.out.println("You become enraged and unleash your fury upon your foe to generate extra rage.");
		}
		else if (name.contentEquals("Rogue")) {
			dmgOutput = 10;
			applyBleed = 3;
			bleedDmg = rng.nextInt(2) + 8;
			System.out.println("You hack and slash at your target, causing them to bleed profusely.");
		}
		else if (name.contentEquals("Archer")) {
			dmgOutput = 12 + 8*trueShot;
			if (trueShot > 3) {
				dmgOutput *= 2;
			}
			trueShot--;
			System.out.println("You charge your bow and release a precise shot at your target's weakest point.");
		}
		else if (name.contentEquals("Mage")) {
			dmgOutput = (int)Math.round(10 + 10*.33*resourceAmt);
			resourceAmt += 2;
			System.out.println("You siphon the life force from your enemy to forge 2 new runes.");
		}
		else if (name.contentEquals("Thief")) {
			dmgOutput = 4;
			applyStun = 1;
			System.out.println("Used THROW SAND! You are stunned for a turn.");
		}
		else if (name.contentEquals("Dragon")) {
			dmgOutput = 20;
			applyWeakness = 2;
			System.out.println("Used FIRE BREATH! You are weakened for 2 turns.");
		}
		
		return dmgOutput;
	}
	
	public int ability2 () {
		Random rng = new Random();
		ability2CCD = ability2BaseCD;
		resourceAmt -= ability2Cost;
		if (name.contentEquals("Warrior")) {
			dmgOutput = 8;
			applyStun = 1;
			resourceAmt += 5;
			System.out.println("You slam your shield into your enemy, briefly stunning them.");
		}
		else if (name.contentEquals("Rogue")) {
			dmgOutput = 7;
			applyPoison = 3;
			poisonDmg = rng.nextInt(2) + 6;
			applyWeakness = 3;
		}
		else if (name.contentEquals("Archer")) {
			rapidFire = 3;
			dmgOutput = attackDmg*2;
			System.out.println("You empower your bow with Elune's Blessing allowing you to fire more frequently.");
		}
		else if (name.contentEquals("Mage")) {
			dmgOutput = (int)Math.round(6 + 6*.33*resourceAmt);
			applyFrozen = 1;
			System.out.println("You spend a rune to freeze your foe in their tracks.");
		}
		else if (name.contentEquals("Thief")) {
			dmgOutput = 4;
			applyPoison = 2;
			applyWeakness = 2;
			poisonDmg = 4;
			System.out.println("Used APPLY POISON! You are poisoned and weakened for 2 turns.");
		}
		else if (name.contentEquals("Dragon")) {
			dmgOutput = 12;
			applyBleed = 3;
			System.out.println("Used FEROCIOUS BITE! You are bleeding for 3 turns.");
		}
		
		return dmgOutput;
	}
	
	public int ability3 () {
		Random rng = new Random();
		ability3CCD = ability3BaseCD;
		resourceAmt -= ability3Cost;
		if (name.contentEquals("Warrior")) {
			dmgOutput = 0;
			armor += resourceAmt;
			System.out.println("You convert your rage into shielding and gain " + resourceAmt + " armor.");
			resourceAmt = 0;
		}
		else if (name.contentEquals("Rogue")) {
			dmgOutput = 0;
			invisible = 2;
			hasStun = 2;
			System.out.println("You swiftly sheathe your blades and dissapear, hiding in the shadows.");
		}
		else if (name.contentEquals("Archer")) {
			dmgOutput = 0;
			steady = 3;
			System.out.println("You prepare your next shots with perfect focus.");
		}
		else if (name.contentEquals("Mage")) {
			dmgOutput = (int)Math.round(18*resourceAmt);
			resourceAmt = 0;
			System.out.println("You send your runes forth and overload them with energy until they explode around your enemy.");
		}
		else if (name.contentEquals("Thief")) {
			dmgOutput = 20;
			System.out.println("Used SINISTER STRIKE!");
		}
		else if (name.contentEquals("Dragon")) {
			dmgOutput = 0;
			invisible = 1;
			System.out.println("Used FLYING HIGH! You can't damage it for a turn.");
		}
		
		return dmgOutput;
	}
	
	public static void combat(Character player, Character enemy) {
		Scanner in = new Scanner(System.in);
		Random rng = new Random();
		boolean isInt = false;
		boolean loop = false;
		int input;
		int enemyChoice;
		boolean enemyReRoll;
		int critical;
		
		//player reset
		player.ability1CCD = 0;
		player.ability2CCD = 0;
		player.ability3CCD = 0;
		if (player.resourceName.contentEquals("Energy")) {
			player.resourceAmt = player.resourceMax;
		}
		else if (player.resourceName.contentEquals("Rage")) {
			player.resourceAmt = 0;
		}
		else if (player.resourceName.contentEquals("Energy")) {
			player.resourceAmt = 100;
		}
		else if (player.resourceName.contentEquals("Runes")) {
			player.resourceAmt = 0;
		}
		if (player.hasFrozen > 0) {
			player.hasFrozen = 0;
		}
		if (player.hasStun > 0) {
			player.hasStun = 0;
		}
		if (player.hasBleed > 0) {
			player.hasBleed = 0;
		}
		if (player.hasPoison > 0) {
			player.hasPoison = 0;
		}
		if (player.hasWeakness > 0) {
			player.hasWeakness = 0;
		}
		if (player.hasEnrage > 0) {
			player.hasEnrage = 0;
		}
		if (player.invisible > 0) {
			player.invisible = 0;
		}
		if (player.rapidFire > 0) {
			player.rapidFire = 0;
		}
		if (player.steady > 0) {
			player.steady = 0;
		}
		if (player.applyFrozen > 0) {
			player.applyFrozen = 0;
		}
		if (player.applyStun > 0) {
			player.applyStun = 0;
		}
		if (player.applyBleed > 0) {
			player.applyBleed = 0;
		}
		if (player.applyPoison > 0) {
			player.applyPoison = 0;
		}
		if (player.applyWeakness > 0) {
			player.applyWeakness = 0;
		}
		if (player.applyEnrage > 0) {
			player.applyEnrage = 0;
		}
		//enemy reset
		if (enemy.hasFrozen > 0) {
			enemy.hasFrozen = 0;
		}
		if (enemy.hasStun > 0) {
			enemy.hasStun = 0;
		}
		if (enemy.hasBleed > 0) {
			enemy.hasBleed = 0;
		}
		if (enemy.hasPoison > 0) {
			enemy.hasPoison = 0;
		}
		if (enemy.hasWeakness > 0) {
			enemy.hasWeakness = 0;
		}
		if (enemy.hasEnrage > 0) {
			enemy.hasEnrage = 0;
		}
		if (enemy.invisible > 0) {
			enemy.invisible = 0;
		}
		if (enemy.rapidFire > 0) {
			enemy.rapidFire = 0;
		}
		if (enemy.steady > 0) {
			enemy.steady = 0;
		}
		if (enemy.applyFrozen > 0) {
			enemy.applyFrozen = 0;
		}
		if (enemy.applyStun > 0) {
			enemy.applyStun = 0;
		}
		if (enemy.applyBleed > 0) {
			enemy.applyBleed = 0;
		}
		if (enemy.applyPoison > 0) {
			enemy.applyPoison = 0;
		}
		if (enemy.applyWeakness > 0) {
			enemy.applyWeakness = 0;
		}
		if (enemy.applyEnrage > 0) {
			enemy.applyEnrage = 0;
		}
		
		while (player.health > 0 && enemy.health > 0) {
			enemyReRoll = true;
			if (player.health > player.maxHealth) {
				player.health = player.maxHealth;
			}
			if (enemy.health > enemy.maxHealth) {
				enemy.health = enemy.maxHealth;
			}
			if (player.resourceAmt > player.resourceMax) {
				player.resourceAmt = player.resourceMax;
			}
			if (enemy.resourceAmt > enemy.resourceMax) {
				enemy.resourceAmt = enemy.resourceMax;
			}
			if (player.trueShot > 3) {
				player.trueShot = 3;
			}
			if (enemy.trueShot > 3) {
				enemy.trueShot = 3;
			}
			
			if (player.applyFrozen > 0) {
				player.applyFrozen--;
				enemy.hasFrozen++;
			}
			if (enemy.applyFrozen > 0) {
				enemy.applyFrozen--;
				player.hasFrozen++;
			}
			if (player.applyStun > 0) {
				player.applyStun--;
				enemy.hasStun++;
			}
			if (enemy.applyStun > 0) {
				enemy.applyStun--;
				player.hasStun++;
			}
			if (player.applyBleed > 0) {
				player.applyBleed--;
				enemy.hasBleed++;
			}
			if (enemy.applyBleed > 0) {
				enemy.applyBleed--;
				player.hasBleed++;
			}
			if (player.applyPoison > 0) {
				player.applyPoison--;
				enemy.hasPoison++;
			}
			if (enemy.applyPoison > 0) {
				enemy.applyPoison--;
				player.hasPoison++;
			}
			if (player.applyWeakness > 0) {
				player.applyWeakness--;
				enemy.hasWeakness++;
			}
			if (enemy.applyWeakness > 0) {
				enemy.applyWeakness--;
				player.hasWeakness++;
			}
			if (player.applyEnrage > 0) {
				player.applyEnrage--;
				enemy.hasEnrage++;
			}
			if (enemy.applyEnrage > 0) {
				enemy.applyEnrage--;
				player.hasEnrage++;
			}
			
			System.out.println("-------------------------------------------------------------------------------------------------");
			if (player.armor > 0 && enemy.armor > 0) {
				System.out.println("HP: " + player.health + " |" + player.armor + "|                                                             Enemy HP: " + enemy.health + " |" + enemy.armor + "|");
			}
			else if (player.armor > 0 && enemy.armor == 0) {
				System.out.println("HP: " + player.health + " |" + player.armor + "|                                                               Enemy HP: " + enemy.health);
			}
			else if (enemy.armor > 0 && player.applyArmorGain == 0) {
				System.out.println("HP: " + player.health + "                                                                 Enemy HP: " + enemy.health + " |" + enemy.armor + "|");
			}
			else {
				System.out.println("HP: " + player.health + "                                                                    Enemy HP: " + enemy.health);
			}
			System.out.println(player.resourceName + ": " + player.resourceAmt + "                                                                   " + enemy.resourceName + ": " + enemy.resourceAmt);
			if (enemy.name.contentEquals("Archer") && player.name.contentEquals("Archer")) {
				System.out.println("True Shot: " + player.trueShot + "                                                True Shot: " + enemy.trueShot);
			}
			else if (enemy.name.contentEquals("Archer")) {
				System.out.println("                                                                           True Shot: " + enemy.trueShot);
			}
			else if (player.name.contentEquals("Archer")) {
				System.out.println("True Shot: " + player.trueShot);
			}
			System.out.println("-------------------------------------------------------------------------------------------------");
			if (enemy.hasFrozen > 0) {
				System.out.println("                                                                                           Frozen");
			}
			if (player.hasFrozen > 0) {
				System.out.println("Frozen                                                                                           ");
			}
			if (enemy.hasStun > 0) {
				System.out.println("                                                                                          Stunned");
			}
			if (player.hasStun > 0) {
				System.out.println("Stunned                                                                                          ");
			}
			if (enemy.hasWeakness > 0) {
				System.out.println("                                                                                         Weakened");
			}
			if (player.hasWeakness > 0) {
				System.out.println("Weakened                                                                                         ");
			}
			if (enemy.hasEnrage > 0) {
				System.out.println("                                                                                          Enarged");
			}
			if (player.hasEnrage > 0) {
				System.out.println("Enraged                                                                                          ");
			}
			if (enemy.hasPoison > 0) {
				System.out.println("                                                                                     Poisoned: " + player.poisonDmg);
			}
			if (player.hasPoison > 0) {
				System.out.println("Poisoned: " + enemy.poisonDmg + "                                                                                 ");
			}
			if (enemy.hasBleed > 0) {
				System.out.println("                                                                                     Bleeding: " + player.bleedDmg);
			}
			if (player.hasBleed > 0) {
				System.out.println("Bleeding: " + enemy.bleedDmg + "                                                                                 ");
			}
			
			input = -1;
			do {
				if (player.hasFrozen != 0 || player.hasStun != 0) {
					input = 20;
					break;
				}
				System.out.println("1: Basic Attack 2: " + player.ability1Name + " 3: " + player.ability2Name + " 4: " + player.ability3Name);
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
			
				if (input == 1 && player.hasStun == 0 && player.hasFrozen == 0) {
					player.dmgOutput = player.attackDmg;
					if (player.name.contentEquals("Mage")) {
						player.dmgOutput = (int)Math.round(player.attackDmg + player.attackDmg*.33*player.resourceAmt);
					}
					else if (player.resourceName.contentEquals("Rage")) {
						if (player.hasEnrage > 0) {
							player.dmgOutput += 2;
							player.resourceAmt += player.dmgOutput + 4;
						}
						else {
							player.resourceAmt += player.attackDmg;
						}
					}
					else if (player.name.contentEquals("Archer")) {
						if (player.rapidFire > 0) {
							player.dmgOutput += (int)Math.round(.66*player.dmgOutput);
						}
						if (player.steady > 0) {
							player.resourceAmt += 15;
						}
						player.trueShot++;
					}
				}
				else if (input == 2 && player.ability1CCD == 0 && player.resourceAmt >= player.ability1Cost && player.hasStun == 0 && player.hasFrozen == 0 && player.hasEnrage == 0) {
					System.out.println("Player: ");
					player.dmgOutput = player.ability1();
				}
				else if (input == 3 && player.ability2CCD == 0 && player.resourceAmt >= player.ability2Cost && player.hasStun == 0 && player.hasFrozen == 0 && player.hasEnrage == 0) {
					System.out.println("Player: ");
					player.dmgOutput = player.ability2();
				}
				else if (input == 4 && player.ability3CCD == 0 && player.resourceAmt >= player.ability3Cost && player.hasStun == 0 && player.hasFrozen == 0 && player.hasEnrage == 0) {
					System.out.println("Player: ");
					player.dmgOutput = player.ability3();
				}
				else if (input == 20) {
					player.dmgOutput = 0;
					System.out.println("Player: ");
					System.out.println("You are unable to attack or use abilities.");
				}
				else {
					if (input < 5 && input > 0) {
						System.out.println("You can't use that right now.");
					}
					loop = true;
				}
			} while(loop);
			
			//Write enemy abilities
			enemyChoice = -1;
			enemyReRoll = true;
			while (enemyReRoll) {
				enemyChoice = rng.nextInt(4);
				if (enemy.hasFrozen != 0 || enemy.hasStun != 0) {
					enemyChoice = 20;
					break;
				}
				if (enemyChoice == 0 && enemy.hasStun == 0 && enemy.hasFrozen == 0) {
					enemyReRoll = false;
					enemy.dmgOutput = enemy.attackDmg;
					if (enemy.name.contentEquals("Mage")) {
						enemy.dmgOutput = (int)Math.round(enemy.attackDmg + enemy.attackDmg*.33*enemy.resourceAmt);
					}
					else if (enemy.resourceName.contentEquals("Rage")) {
						if (enemy.hasEnrage > 0) {
							enemy.dmgOutput += 2;
							enemy.resourceAmt += enemy.dmgOutput + 4;
						}
						else {
							enemy.resourceAmt += enemy.attackDmg;
						}
					}
					else if (enemy.name.contentEquals("Archer")) {
						if (enemy.rapidFire > 0) {
							enemy.dmgOutput += (int)Math.round(.66*enemy.dmgOutput);
						}
						if (enemy.steady > 0) {
							enemy.resourceAmt += 15;
						}
						player.trueShot++;
					}
				}
				else if (enemyChoice == 1 && enemy.ability1CCD == 0 && enemy.resourceAmt >= enemy.ability1Cost && enemy.hasStun == 0 && enemy.hasFrozen == 0 && enemy.hasEnrage == 0) {
					System.out.println("Enemy: ");
					enemy.dmgOutput = enemy.ability1();
					enemyReRoll = false;
				}
				else if (enemyChoice == 2 && enemy.ability2CCD == 0 && enemy.resourceAmt >= enemy.ability2Cost && enemy.hasStun == 0 && enemy.hasFrozen == 0 && enemy.hasEnrage == 0) {
					System.out.println("Enemy: ");
					enemy.dmgOutput = enemy.ability2();
					enemyReRoll = false;
				}
				else if (enemyChoice == 3 && enemy.ability3CCD == 0 && enemy.resourceAmt >= enemy.ability3Cost && enemy.hasStun == 0 && enemy.hasFrozen == 0 && enemy.hasEnrage == 0) {
					System.out.println("Enemy: ");
					enemy.dmgOutput = enemy.ability3();
					enemyReRoll = false;
				}
				else {
					enemyReRoll = true;
					//System.out.println("potato");
				}
			}
			if (enemyChoice == 20) {
				enemy.dmgOutput = 0;
			}
			
			if (player.ability1CCD > 0) {
				player.ability1CCD--;
			}
			if (player.ability2CCD > 0) {
				player.ability2CCD--;
			}
			if (player.ability3CCD > 0) {
				player.ability3CCD--;
			}
			if (enemy.ability1CCD > 0) {
				enemy.ability1CCD--;
			}
			if (enemy.ability2CCD > 0) {
				enemy.ability2CCD--;
			}
			if (enemy.ability3CCD > 0) {
				enemy.ability3CCD--;
			}
			
			if (player.hasFrozen > 0) {
				player.hasFrozen--;
				player.dmgOutput = 0;
			}
			if (enemy.hasFrozen > 0) {
				enemy.hasFrozen--;
				enemy.dmgOutput = 0;
			}
			if (player.hasStun > 0) {
				player.hasStun--;
				player.dmgOutput = 0;
			}
			if (enemy.hasStun > 0) {
				enemy.hasStun--;
				enemy.dmgOutput = 0;
			}
			if (player.hasWeakness > 0) {
				player.hasWeakness--;
				player.dmgOutput -= (int)Math.round(player.dmgOutput/4);
			}
			if (enemy.hasWeakness > 0) {
				enemy.hasWeakness--;
				enemy.dmgOutput -= (int)Math.round(enemy.dmgOutput/4);
			}
			if (enemy.hasBleed > 0) {
				enemy.hasBleed--;
				player.dmgOutput += player.bleedDmg;
			}
			if (enemy.hasPoison > 0) {
				enemy.hasPoison--;
				player.dmgOutput += player.poisonDmg;
			}
			if (player.hasBleed > 0) {
				player.hasBleed--;
				enemy.dmgOutput += enemy.bleedDmg;
			}
			if (player.hasPoison > 0) {
				player.hasPoison--;
				enemy.dmgOutput += enemy.poisonDmg;
			}
			if (player.hasEnrage > 0) {
				player.hasEnrage--;
			}
			if (enemy.hasEnrage > 0) {
				enemy.hasEnrage--;
			}
			
			if (player.rapidFire > 0) {
				player.rapidFire--;
			}
			if (player.steady > 0) {
				player.steady--;
			}
			if (enemy.rapidFire > 0) {
				enemy.rapidFire--;
			}
			if (enemy.steady > 0) {
				enemy.steady--;
			}
			
			//critical damage
			critical = rng.nextInt(100);
			if (critical < player.critChance) {
				player.dmgOutput = (int)Math.round(player.dmgOutput * 1.5);
				System.out.println("PLAYER CRITICAL STRIKE!");
			}
			critical = rng.nextInt(100);
			if (critical < enemy.critChance) {
				enemy.dmgOutput = (int)Math.round(enemy.dmgOutput * 1.5);
				System.out.println("ENEMY CRITICAL STRIKE!");
			}
			
			//armor and damage output
			if (player.invisible > 0) {
				enemy.dmgOutput = 0;
				player.invisible--;
			}
			if (enemy.invisible > 0) {
				player.dmgOutput = 0;
				enemy.invisible--;
			}
			if (player.armor > 0) {
				player.armor -= enemy.dmgOutput;
				if (player.armor <= 0) {
					player.health += player.armor;
					player.armor = 0;
				}
			}
			else {
				player.health -= enemy.dmgOutput;
			}
			if (enemy.armor > 0) {
				enemy.armor -= player.dmgOutput;
				if (enemy.armor <= 0) {
					enemy.health += enemy.armor;
					enemy.armor = 0;
				}
			}
			else {
				enemy.health -= player.dmgOutput;
			}
			System.out.println("You dealt " + player.dmgOutput + " damage and took " + enemy.dmgOutput + " damage.");
			if (player.resourceName.contentEquals("Energy")) {
				player.resourceAmt += 15;
			}
			if (enemy.resourceName.contentEquals("Energy")) {
				enemy.resourceAmt += 15;
			}
		}
		
		if (player.health <= 0) {
			System.out.println("You lose!");
		}
		else if (enemy.health <= 0) {
			System.out.println("You win!");
		}
	}
	
	public static void combat2(Character player1, Character player2) {
		Scanner in = new Scanner(System.in);
		Random rng = new Random();
		boolean isInt = false;
		boolean loop = false;
		int input;
		int player2Choice;
		boolean player2ReRoll;
		int critical;
		
		//player1 reset
		player1.ability1CCD = 0;
		player1.ability2CCD = 0;
		player1.ability3CCD = 0;
		if (player1.resourceName.contentEquals("Energy")) {
			player1.resourceAmt = player1.resourceMax;
		}
		else if (player1.resourceName.contentEquals("Rage")) {
			player1.resourceAmt = 0;
		}
		else if (player1.resourceName.contentEquals("Energy")) {
			player1.resourceAmt = 100;
		}
		else if (player1.resourceName.contentEquals("Runes")) {
			player1.resourceAmt = 0;
		}
		if (player1.hasFrozen > 0) {
			player1.hasFrozen = 0;
		}
		if (player1.hasStun > 0) {
			player1.hasStun = 0;
		}
		if (player1.hasBleed > 0) {
			player1.hasBleed = 0;
		}
		if (player1.hasPoison > 0) {
			player1.hasPoison = 0;
		}
		if (player1.hasWeakness > 0) {
			player1.hasWeakness = 0;
		}
		if (player1.hasEnrage > 0) {
			player1.hasEnrage = 0;
		}
		if (player1.invisible > 0) {
			player1.invisible = 0;
		}
		if (player1.rapidFire > 0) {
			player1.rapidFire = 0;
		}
		if (player1.steady > 0) {
			player1.steady = 0;
		}
		if (player1.applyFrozen > 0) {
			player1.applyFrozen = 0;
		}
		if (player1.applyStun > 0) {
			player1.applyStun = 0;
		}
		if (player1.applyBleed > 0) {
			player1.applyBleed = 0;
		}
		if (player1.applyPoison > 0) {
			player1.applyPoison = 0;
		}
		if (player1.applyWeakness > 0) {
			player1.applyWeakness = 0;
		}
		if (player1.applyEnrage > 0) {
			player1.applyEnrage = 0;
		}
		//player2 reset
		if (player2.hasFrozen > 0) {
			player2.hasFrozen = 0;
		}
		if (player2.hasStun > 0) {
			player2.hasStun = 0;
		}
		if (player2.hasBleed > 0) {
			player2.hasBleed = 0;
		}
		if (player2.hasPoison > 0) {
			player2.hasPoison = 0;
		}
		if (player2.hasWeakness > 0) {
			player2.hasWeakness = 0;
		}
		if (player2.hasEnrage > 0) {
			player2.hasEnrage = 0;
		}
		if (player2.invisible > 0) {
			player2.invisible = 0;
		}
		if (player2.rapidFire > 0) {
			player2.rapidFire = 0;
		}
		if (player2.steady > 0) {
			player2.steady = 0;
		}
		if (player2.applyFrozen > 0) {
			player2.applyFrozen = 0;
		}
		if (player2.applyStun > 0) {
			player2.applyStun = 0;
		}
		if (player2.applyBleed > 0) {
			player2.applyBleed = 0;
		}
		if (player2.applyPoison > 0) {
			player2.applyPoison = 0;
		}
		if (player2.applyWeakness > 0) {
			player2.applyWeakness = 0;
		}
		if (player2.applyEnrage > 0) {
			player2.applyEnrage = 0;
		}
		
		while (player1.health > 0 && player2.health > 0) {
			player2ReRoll = true;
			if (player1.health > player1.maxHealth) {
				player1.health = player1.maxHealth;
			}
			if (player2.health > player2.maxHealth) {
				player2.health = player2.maxHealth;
			}
			if (player1.resourceAmt > player1.resourceMax) {
				player1.resourceAmt = player1.resourceMax;
			}
			if (player2.resourceAmt > player2.resourceMax) {
				player2.resourceAmt = player2.resourceMax;
			}
			if (player1.trueShot > 3) {
				player1.trueShot = 3;
			}
			if (player2.trueShot > 3) {
				player2.trueShot = 3;
			}
			
			if (player1.applyFrozen > 0) {
				player1.applyFrozen--;
				player2.hasFrozen++;
			}
			if (player2.applyFrozen > 0) {
				player2.applyFrozen--;
				player1.hasFrozen++;
			}
			if (player1.applyStun > 0) {
				player1.applyStun--;
				player2.hasStun++;
			}
			if (player2.applyStun > 0) {
				player2.applyStun--;
				player1.hasStun++;
			}
			if (player1.applyBleed > 0) {
				player1.applyBleed--;
				player2.hasBleed++;
			}
			if (player2.applyBleed > 0) {
				player2.applyBleed--;
				player1.hasBleed++;
			}
			if (player1.applyPoison > 0) {
				player1.applyPoison--;
				player2.hasPoison++;
			}
			if (player2.applyPoison > 0) {
				player2.applyPoison--;
				player1.hasPoison++;
			}
			if (player1.applyWeakness > 0) {
				player1.applyWeakness--;
				player2.hasWeakness++;
			}
			if (player2.applyWeakness > 0) {
				player2.applyWeakness--;
				player1.hasWeakness++;
			}
			if (player1.applyEnrage > 0) {
				player1.applyEnrage--;
				player2.hasEnrage++;
			}
			if (player2.applyEnrage > 0) {
				player2.applyEnrage--;
				player1.hasEnrage++;
			}
			
			System.out.println("-------------------------------------------------------------------------------------------------");
			if (player1.armor > 0 && player2.armor > 0) {
				System.out.println("Player 1 HP: " + player1.health + " |" + player1.armor + "|                                                     Player 2 HP: " + player2.health + " |" + player2.armor + "|");
			}
			else if (player1.armor > 0 && player2.armor == 0) {
				System.out.println("Player 1 HP: " + player1.health + " |" + player1.armor + "|                                                       Player 2 HP: " + player2.health);
			}
			else if (player2.armor > 0 && player1.applyArmorGain == 0) {
				System.out.println("Player 1 HP: " + player1.health + "                                                         Player 2 HP: " + player2.health + " |" + player2.armor + "|");
			}
			else {
				System.out.println("Player 1 HP: " + player1.health + "                                                            Player 2 HP: " + player2.health);
			}
			System.out.println(player1.resourceName + ": " + player1.resourceAmt + "                                                                   " + player2.resourceName + ": " + player2.resourceAmt);
			if (player2.name.contentEquals("Archer") && player1.name.contentEquals("Archer")) {
				System.out.println("True Shot: " + player1.trueShot + "                                                True Shot: " + player2.trueShot);
			}
			else if (player2.name.contentEquals("Archer")) {
				System.out.println("                                                                           True Shot: " + player2.trueShot);
			}
			else if (player1.name.contentEquals("Archer")) {
				System.out.println("True Shot: " + player1.trueShot);
			}
			System.out.println("-------------------------------------------------------------------------------------------------");
			if (player2.hasFrozen > 0) {
				System.out.println("                                                                                           Frozen");
			}
			if (player1.hasFrozen > 0) {
				System.out.println("Frozen                                                                                           ");
			}
			if (player2.hasStun > 0) {
				System.out.println("                                                                                          Stunned");
			}
			if (player1.hasStun > 0) {
				System.out.println("Stunned                                                                                          ");
			}
			if (player2.hasWeakness > 0) {
				System.out.println("                                                                                         Weakened");
			}
			if (player1.hasWeakness > 0) {
				System.out.println("Weakened                                                                                         ");
			}
			if (player2.hasEnrage > 0) {
				System.out.println("                                                                                          Enraged");
			}
			if (player1.hasEnrage > 0) {
				System.out.println("Enraged                                                                                          ");
			}
			if (player2.hasPoison > 0) {
				System.out.println("                                                                                     Poisoned: " + player1.poisonDmg);
			}
			if (player1.hasPoison > 0) {
				System.out.println("Poisoned: " + player2.poisonDmg + "                                                                                 ");
			}
			if (player2.hasBleed > 0) {
				System.out.println("                                                                                     Bleeding: " + player1.bleedDmg);
			}
			if (player1.hasBleed > 0) {
				System.out.println("Bleeding: " + player2.bleedDmg + "                                                                                 ");
			}
			
			//player1
			input = -1;
			do {
				if (player1.hasFrozen != 0 || player1.hasStun != 0) {
					input = 20;
					break;
				}
				System.out.println("Player 1| 1: Basic Attack 2: " + player1.ability1Name + " 3: " + player1.ability2Name + " 4: " + player1.ability3Name);
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
			
				if (input == 1 && player1.hasStun == 0 && player1.hasFrozen == 0) {
					player1.dmgOutput = player1.attackDmg;
					if (player1.name.contentEquals("Mage")) {
						player1.dmgOutput = (int)Math.round(player1.attackDmg + player1.attackDmg*.33*player1.resourceAmt);
					}
					else if (player1.resourceName.contentEquals("Rage")) {
						if (player1.hasEnrage > 0) {
							player1.dmgOutput += 2;
							player1.resourceAmt += player1.dmgOutput + 4;
						}
						else {
							player1.resourceAmt += player1.attackDmg;
						}
					}
					else if (player1.name.contentEquals("Archer")) {
						if (player1.rapidFire > 0) {
							player1.dmgOutput += (int)Math.round(.66*player1.dmgOutput);
						}
						if (player1.steady > 0) {
							player1.resourceAmt += 15;
						}
						player1.trueShot++;
					}
				}
				else if (input == 2 && player1.ability1CCD == 0 && player1.resourceAmt >= player1.ability1Cost && player1.hasStun == 0 && player1.hasFrozen == 0 && player1.hasEnrage == 0) {
					System.out.println("Player 1: ");
					player1.dmgOutput = player1.ability1();
				}
				else if (input == 3 && player1.ability2CCD == 0 && player1.resourceAmt >= player1.ability2Cost && player1.hasStun == 0 && player1.hasFrozen == 0 && player1.hasEnrage == 0) {
					System.out.println("Player 1: ");
					player1.dmgOutput = player1.ability2();
				}
				else if (input == 4 && player1.ability3CCD == 0 && player1.resourceAmt >= player1.ability3Cost && player1.hasStun == 0 && player1.hasFrozen == 0 && player1.hasEnrage == 0) {
					System.out.println("Player 1: ");
					player1.dmgOutput = player1.ability3();
				}
				else if (input == 20) {
					player1.dmgOutput = 0;
					System.out.println("Player 1: ");
					System.out.println("You are unable to attack or use abilities.");
				}
				else {
					if (input < 5 && input > 0) {
						System.out.println("You can't use that right now.");
					}
					loop = true;
				}
			} while(loop);
			
			//player2
			input = -1;
			do {
				if (player2.hasFrozen != 0 || player2.hasStun != 0) {
					input = 20;
					break;
				}
				System.out.println("Player 2| 1: Basic Attack 2: " + player2.ability1Name + " 3: " + player2.ability2Name + " 4: " + player2.ability3Name);
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
			
				if (input == 1 && player2.hasStun == 0 && player2.hasFrozen == 0) {
					player2.dmgOutput = player2.attackDmg;
					if (player2.name.contentEquals("Mage")) {
						player2.dmgOutput = (int)Math.round(player2.attackDmg + player2.attackDmg*.33*player2.resourceAmt);
					}
					else if (player2.resourceName.contentEquals("Rage")) {
						if (player2.hasEnrage > 0) {
							player2.dmgOutput += 2;
							player2.resourceAmt += player2.dmgOutput + 4;
						}
						else {
							player2.resourceAmt += player2.attackDmg;
						}
					}
					else if (player2.name.contentEquals("Archer")) {
						if (player2.rapidFire > 0) {
							player2.dmgOutput += (int)Math.round(.66*player2.dmgOutput);
						}
						if (player2.steady > 0) {
							player2.resourceAmt += 15;
						}
						player2.trueShot++;
					}
				}
				else if (input == 2 && player2.ability1CCD == 0 && player2.resourceAmt >= player2.ability1Cost && player2.hasStun == 0 && player2.hasFrozen == 0 && player2.hasEnrage == 0) {
					System.out.println("Player 2: ");
					player2.dmgOutput = player2.ability1();
				}
				else if (input == 3 && player2.ability2CCD == 0 && player2.resourceAmt >= player2.ability2Cost && player2.hasStun == 0 && player2.hasFrozen == 0 && player2.hasEnrage == 0) {
					System.out.println("Player 2: ");
					player2.dmgOutput = player2.ability2();
				}
				else if (input == 4 && player2.ability3CCD == 0 && player2.resourceAmt >= player2.ability3Cost && player2.hasStun == 0 && player2.hasFrozen == 0 && player2.hasEnrage == 0) {
					System.out.println("Player 2: ");
					player2.dmgOutput = player2.ability3();
				}
				else if (input == 20) {
					player2.dmgOutput = 0;
					System.out.println("Player 2: ");
					System.out.println("You are unable to attack or use abilities.");
				}
				else {
					if (input < 5 && input > 0) {
						System.out.println("You can't use that right now.");
					}
					loop = true;
				}
			} while(loop);
			
			if (player1.ability1CCD > 0) {
				player1.ability1CCD--;
			}
			if (player1.ability2CCD > 0) {
				player1.ability2CCD--;
			}
			if (player1.ability3CCD > 0) {
				player1.ability3CCD--;
			}
			if (player2.ability1CCD > 0) {
				player2.ability1CCD--;
			}
			if (player2.ability2CCD > 0) {
				player2.ability2CCD--;
			}
			if (player2.ability3CCD > 0) {
				player2.ability3CCD--;
			}
			
			if (player1.hasFrozen > 0) {
				player1.hasFrozen--;
				player1.dmgOutput = 0;
			}
			if (player2.hasFrozen > 0) {
				player2.hasFrozen--;
				player2.dmgOutput = 0;
			}
			if (player1.hasStun > 0) {
				player1.hasStun--;
				player1.dmgOutput = 0;
			}
			if (player2.hasStun > 0) {
				player2.hasStun--;
				player2.dmgOutput = 0;
			}
			if (player1.hasWeakness > 0) {
				player1.hasWeakness--;
				player1.dmgOutput -= (int)Math.round(player1.dmgOutput/4);
			}
			if (player2.hasWeakness > 0) {
				player2.hasWeakness--;
				player2.dmgOutput -= (int)Math.round(player2.dmgOutput/4);
			}
			if (player2.hasBleed > 0) {
				player2.hasBleed--;
				player1.dmgOutput += player1.bleedDmg;
			}
			if (player2.hasPoison > 0) {
				player2.hasPoison--;
				player1.dmgOutput += player1.poisonDmg;
			}
			if (player1.hasBleed > 0) {
				player1.hasBleed--;
				player2.dmgOutput += player2.bleedDmg;
			}
			if (player1.hasPoison > 0) {
				player1.hasPoison--;
				player2.dmgOutput += player2.poisonDmg;
			}
			if (player1.hasEnrage > 0) {
				player1.hasEnrage--;
			}
			if (player2.hasEnrage > 0) {
				player2.hasEnrage--;
			}
			
			if (player1.rapidFire > 0) {
				player1.rapidFire--;
			}
			if (player1.steady > 0) {
				player1.steady--;
			}
			if (player2.rapidFire > 0) {
				player2.rapidFire--;
			}
			if (player2.steady > 0) {
				player2.steady--;
			}
			
			//critical damage
			critical = rng.nextInt(100);
			if (critical < player1.critChance) {
				player1.dmgOutput = (int)Math.round(player1.dmgOutput * 1.5);
				System.out.println("PLAYER 1 CRITICAL STRIKE!");
			}
			critical = rng.nextInt(100);
			if (critical < player2.critChance) {
				player2.dmgOutput = (int)Math.round(player2.dmgOutput * 1.5);
				System.out.println("PLAYER 2 CRITICAL STRIKE!");
			}
			
			//armor and damage output
			if (player1.invisible > 0) {
				player2.dmgOutput = 0;
				player1.invisible--;
			}
			if (player2.invisible > 0) {
				player1.dmgOutput = 0;
				player2.invisible--;
			}
			if (player1.armor > 0) {
				player1.armor -= player2.dmgOutput;
				if (player1.armor <= 0) {
					player1.health += player1.armor;
					player1.armor = 0;
				}
			}
			else {
				player1.health -= player2.dmgOutput;
			}
			if (player2.armor > 0) {
				player2.armor -= player1.dmgOutput;
				if (player2.armor <= 0) {
					player2.health += player2.armor;
					player2.armor = 0;
				}
			}
			else {
				player2.health -= player1.dmgOutput;
			}
			System.out.println("Player 1 dealt " + player1.dmgOutput + " damage and Player 2 dealt " + player2.dmgOutput + " damage.");
			if (player1.resourceName.contentEquals("Energy")) {
				player1.resourceAmt += 15;
			}
			if (player2.resourceName.contentEquals("Energy")) {
				player2.resourceAmt += 15;
			}
		}
		
		if (player1.health <= 0) {
			System.out.println("Player 2 wins!");
		}
		else if (player2.health <= 0) {
			System.out.println("Player 1 wins!");
		}
	}
	
	public void inventory (int action) {
		Scanner in = new Scanner(System.in);
		//Accessing Items
		if (action == 1) {
			System.out.println("-------------------------------------------------------------------------------------------------");
			System.out.println("Items: ");
			System.out.println("1: " + inventory[0] + " 2: " + inventory[1] + " 3: " + inventory[2]);
			System.out.println("4: " + inventory[3] + " 5: " + inventory[4] + " 6: " + inventory[5]);
			System.out.println("-------------------------------------------------------------------------------------------------");
		}
		//Storing Items
		if (action == 2) {
			
		}
		//Using Items
		if (action == 3) {
			
			
			
		}
	}
	
	public void items (String itemName) {
		if (itemName.equals("Healing Potion")) {
			health += 25;
		}
	}

}