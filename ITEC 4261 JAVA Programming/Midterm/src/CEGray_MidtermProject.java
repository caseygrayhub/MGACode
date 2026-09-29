/* Casey Gray
 * ITEC 4261 Section 02
 * March 2, 2025
 */

/*
 * Part A:
Create a generateMonster() function/method that creates and initializes the following variables:

monsterHealth – randomly generated between 10 and 50

monsterAttack – randomly generated between 5 and 15

Create a generateCharacter() function/method that creates and initializes the following variables:

Name – via user input

characterMaxHealth – randomly generated between 100 and 250

characterCurrentHealth – starts at Max Health value

characterAttack – randomly generated between 5 and 15

characterKills – starts at zero (0)

Level – starts at one (1)

Part B:
Create the following methods:

isAlive() should accept a health variable as a parameter and determine if it is at or below zero (0).
If it is return False, if not, return True.

takeDamage() should accept an attack value and a health value and return the updated health value.

printMenu() – should not accept any parameters and should not return a value.  It should display the following options and
how to select from the menu:

Start Adventure
Continue Adventure
Display Results
Quit
startAdventure() – should call the generateCharacter() and generateMonster() methods and have them fight until one is defeated.
The character attacks first and each attack hits automatically.  Make sure to subtract the correct damage value from the
corresponding opponent’s health.

continueAdventure() – should make sure a living character exists (Hint: check the variables for the character) and if so,
create a new monster to battle until monster or character is defeated.

displayResults() – should display the character’s information (name, level, attack, max health and current health)

Quit() should end the game

 

Part C:
Create a Main method that calls the printMenu() method and runs the corresponding method that is selected.

If the character is defeated, the game ends.  Display the character’s information (name, level, attack, max health) and then
give them the option to play again.

If the monster is defeated, check if characterKills is evenly divisible by 5.  If it is, then, increase Level by 1,
add five (5) to Attack, add 50 to Max Health and set Current Health to the new Max Health value.
Then display the menu to allow them to choose their next option.

Game should continue until the user chooses to quit from the menu options.
 */

import java.util.Random;
import java.util.Scanner;
public class CEGray_MidtermProject {

	// Declare universal variables
	static Scanner scanner = new Scanner(System.in);
	static Random random = new Random();
	
	// Declare variables for monster
	static int monsterHealth;
	static int monsterAttack;
	
	// Declare variables for name, random max health between 100-250, current health, random attack between 5-15,
	// how many kills the character has, the character's level, and if the character is alive
	static String characterName;
	static int characterMaxHealth;
	static int characterCurrentHealth;
	static int characterAttack;
	static int characterKills = 0;
	static int characterLevel = 1;
	// Flag in order to track character's status
	static boolean characterAlive = false;
	
	// ___________________________________________________________PART A __________________________________________________________________
	// Function to generate a monster
	public static void generateMonster()
	{
		// Variable declaration moved to be universal
		// Randomize monster's health between 10-50 and monster's attack between 5-15
		monsterHealth = random.nextInt(41) + 10;
		monsterAttack = random.nextInt(11) + 5;
	}
	
	// Function to generate a character
	public static void generateCharacter()
	{
		// Ask for character name
		System.out.print("Character Name: ");
		
		// Declaration moved to be universal
		// Generate name, random max health between 100-250, current health, random attack between 5-15,
		// how many kills the character has, the character's level, and if the character is alive
		characterName = scanner.nextLine();
		characterMaxHealth = random.nextInt(151) + 100;
		characterCurrentHealth = characterMaxHealth;
		characterAttack = random.nextInt(11) + 5;
		characterKills = 0;
		characterLevel = 1;
		// Character is alive after generation
		characterAlive = true;
		
	}
	

	// ___________________________________________________________PART B __________________________________________________________________
	
	// Function to determine if character is alive
	public static boolean isAlive(int health)
	{
		return health > 0;
	}
	
	// Function to calculate damage taken, ensuring health does not go below zero
	public static int takeDamage(int attack, int health)
	{
		return Math.max(0, health - attack);
	}
	
	// Create function to show menu options
	public static void printMenu()
	{
		System.out.println("\nSelect an option:");
		System.out.println("1. Start Adventure");
		System.out.println("2. Continue Adventure");
		System.out.println("3. Display Results");
		System.out.println("4. Quit");
		System.out.println("Enter your choice: ");
	}
	
	// Function to begin adventure. Calls character generation. Monster generation moved to new battle function
	public static void startAdventure()
	{
		generateCharacter();
		battle();
	}
	
	// Function to continue adventure. Checks/monster creation moved to new battle function
	public static void continueAdventure()
	{
		if (!characterAlive)
			{
				System.out.println("No character data. Start a new adventure.");
				return;
			}
		battle();
	}
	
	// New function for the battle process, in order to reduce duplicate code
	public static void battle()
	{
		// Checks if character is alive
		if (!characterAlive) return;
		
		// Generate a new monster for each battle
		while (characterAlive)
		{
			generateMonster();
					
			// Show monster stats
			System.out.println("\nA new monster has appeared!");
	        System.out.println("Monster Health: " + monsterHealth + ", Monster Attack: " + monsterAttack);
			
			// Automate battle, with character attacking first
			while (isAlive(characterCurrentHealth) && isAlive(monsterHealth))
			{
				monsterHealth = takeDamage(characterAttack, monsterHealth);
				if (isAlive(monsterHealth))
				{
					characterCurrentHealth = takeDamage(monsterAttack, characterCurrentHealth);
				}
			}
			
			// If character is defeated, show stats and ask to play again
			if (!isAlive(characterCurrentHealth))
			{
				System.out.println("\nCharacter Defeated!");
				displayCharacterInfo();
				System.out.println("Play again? 1 for yes, 0 for no.");
				int playAgain = scanner.nextInt();
				scanner.nextLine();
				if (playAgain == 0)
				{
					characterAlive = false;
					return;
				}
			}
			
			// If monster is defeated, notify player, and level up if applicable
			
			System.out.println("\nMonster Defeated!");
			characterKills++;
			
			// Check for level up
			if (characterKills % 5 == 0)
			{
				characterLevel++;
				characterAttack += 5;
				characterMaxHealth += 50;
				characterCurrentHealth = characterMaxHealth;
				System.out.println("\n*** Level Up! ***");
	            System.out.println("New Level: " + characterLevel);
	            System.out.println("Attack Increased to: " + characterAttack);
	            System.out.println("Max Health Increased to: " + characterMaxHealth);
	            System.out.println("Current Health Restored: " + characterCurrentHealth);
			}
			
			// Ask the user if they want to continue after each battle
			System.out.println("\nDo you want to fight another monster? (1 for yes. or 0 to return to menu)");
			System.out.print("Enter your choice: ");
			int selection = -1;

			// Loop to handle incorrect inputs
			while (true)
			{
				if (scanner.hasNextInt())
				{
					selection = scanner.nextInt();
					scanner.nextLine();
					break;
				}
				else
				{
					System.out.println("Invalid input. 1 for yes or 0 to return to menu:");
					scanner.nextLine();
				}
			}
			if (selection == 0)
			{
				System.out.println("Returning to menu.");
				return;
			}
		}
	}
	
	// Function for displaying results as long as the character is still alive
	public static void displayResults()
	{
		if (characterAlive)
		{
			displayCharacterInfo();
		}
		
		else
		{
			System.out.println("No character information to display.");
		}
	}
	
	// Function to display character info
	public static void displayCharacterInfo()
	{
		System.out.println("Character name: " + characterName);
		System.out.println("Level: " + characterLevel);
		System.out.println("Attack: " + characterAttack);
		System.out.println("Max Health: " + characterMaxHealth);
		System.out.println("Current Health: " + characterCurrentHealth);
		System.out.println("Number of Kills: " + characterKills);
	}
// ___________________________________________________________PART C __________________________________________________________________
	// Main function
	public static void main(String[] args)
	{
		// Show menu and prompt user for their selection
		int selection;

		do
		{
			printMenu();
			selection = scanner.nextInt();
			// New line
			scanner.nextLine();
			
			// Switch cases for user's selection
			switch (selection)
			{
				// New adventure
				case 1:
					startAdventure();
					break;
				// Continue
				case 2:
					if (characterAlive)
					{
						continueAdventure();
					}
					else
					{
						System.out.println("No character data. Start a new adventure first.");
					}
				// Display results
				case 3:
					displayResults();
					break;
				// Quit
				case 4:
					System.out.println("Quitting the game.");
					break;
				// Invalid option
				case 5:
					System.out.println("Invalid choice.");
			}
		}
		// Run the above as long as the user does not select 'Quit'
		while (selection != 4);
	}
}
