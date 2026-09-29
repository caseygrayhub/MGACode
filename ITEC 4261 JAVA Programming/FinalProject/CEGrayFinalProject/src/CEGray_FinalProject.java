/* Casey Gray
 * ITEC 4261 Section 02
 * April 30, 2025
 */

 /*Create a Main method that displays the main menu asking what the user wants to do:

Create new character – method should ask which of the two subclasses the user wants to play, create a new object of the chosen class and display the information generated for that object. 
Begin/Continue Adventure – method verifies that a character has been created, and if one has, method generates an object of one of the three Monster subclasses (chosen randomly) for the character to fight, the combat should continue until:
 character is defeated – game ends, results are displayed, and main menu is displayed
monster is defeated – character is given option to fight another monster, after receiving the experience points for their win and checking to see if the character reached the next level or retire
See results – display the character’s information: subclass chosen, all attributes and their values
Retire from Adventuring (Quit the game)
Required: Implement a topic that was covered in the course content and is not currently required.

Bonus: Implement a second topic that was covered in the course content and is not currently required.

Notes:

New character (including asking for the name) should only happen if the player chooses “Create new character” option from menu. 
Make sure to indicate how to select from the menu (Yes/No, 1/2/3, A/B, etc.)
Make sure to display the menu after each round of combat that the character survives */

// Import utilities
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.io.*;

public class CEGray_FinalProject
{
    // Declare class variables (player character, scanner, and csv file)
    private static Player playerCharacter;
    private static Scanner input = new Scanner(System.in);
    private static final String CHARACTER_FILE = "characters.csv";
    private static int kills = 0;

    // Main method to run the game
    public static void main(String[] args)
    {
        // Main game loop
        while (true)
        {
            // Display main menu
            displayMainMenu();

            // Get the user's choice
            int choice = getUserChoice();

            // Handles the user's choice
            handleMenuChoice(choice);

            // Exit game if user chooses number 5
            if(choice == 5)
            {
                break;
            }
        }

        // Close scanner
        input.close();
    }    

    // Method that displays the main menu to the user
    private static void displayMainMenu()
    {
        System.out.println("Main Menu:");
        System.out.println("1: Create New Character");
        System.out.println("2: Begin/Continue Adventure");
        System.out.println("3: See Results");
        System.out.println("4: View Previous Characters");
        System.out.println("5: Retire from Adventuring (Quit Game)");
        System.out.println("Please enter your choice (1-5): ");
    }

    // Method that gets the user's choice and validates it
    private static int getUserChoice()
    {
        while(true)
        {
            // Try to read an int from the user
            try
            {
                int choice = input.nextInt();

                // Consume the newline left by nextInt()
                input.nextLine();

                // If the input is an int, return it
                return choice;
            }

            // Catch the mismatch exception if the user doesn't enter an int
            catch (InputMismatchException e)
            {
                System.out.println("Invalid input. Please enter a number.");

                // Discard the invalid input
                input.next();

                // Prompt again for input
                System.out.print("Please enter your choice (1-5): ");
            }
        }
    }

    // Method to handle the user's choice by calling the appropriate method
    private static void handleMenuChoice(int choice)
    {
        switch (choice) 
        {
            case 1:
                // Call the method to create a new character
                createCharacter();
                break;

            case 2:
                // Call the method to begin or continue an adventure
                begin();
                break;

            case 3:
                // Call the method to display the character's results
                results();
                break;

            case 4:
                // Call the method to view previous adventures
                viewPrevious();
                break;

            case 5:
                // Print a goodbye message
                System.out.println("Thank you for playing!");
                break;
        
            // Handle invalid choices
            default:
                System.out.println("Invalid choice. Please enter a number 1-5: ");
        }
    }

    // Method to create a new character
    private static void createCharacter()
    {
        // Get the character's name from the user
        System.out.print("Enter your character's name: ");
        String name = input.nextLine();

        // Get the character's class type from the user
        System.out.println("Choose your character's class:");
        System.out.println("1: Warrior");
        System.out.println("2: Assassin");
        System.out.println("3: Defender");
        System.out.println("Enter your choice (1-3): ");
        int charClass = input.nextInt();

        // Consume the newline left by nextInt()
        input.nextLine();

        switch (charClass) 
        {
            // Create a new warrior object and store it in playerCharacter
            case 1:
                playerCharacter = new Player.Warrior(name);
                break;

            // Create a new assassin object and store it in playerCharacter
            case 2:
                playerCharacter = new Player.Assassin(name);
                break;

            // Create a new defender object and store it in playerCharacter
            case 3:
                playerCharacter = new Player.Defender(name);
                break;
            
            // Handle invalid choice
            default:
                System.out.println("Invalid choice. Please try again.");
                charClass = input.nextInt();
                input.nextLine();
        }

        // Display character's stats
        if (playerCharacter != null)
        {
            displayCharDetails(playerCharacter);
        }
    }

    // Method to start or continue the player's adventure. Handles combat
    private static void begin()
    {
        // Check to see if a character has been created. If not, return to main menu
        if (playerCharacter == null) 
        {
            System.out.println("Please create a character first.");
            return;    
        }

        // Generate a random number 0-2 to determine which type of monster to create
        Random random = new Random();
        int monsterType = random.nextInt(3);

        // Declare a monster object
        Monster monster;

        // Declare a string to store monster name
        String monsterName;

        switch (monsterType) 
        {
            // Create a goblin object
            case 0:
                monsterName = "Goblin";
                monster = new Monster.HunterMonster(monsterName);
                break;
        
            // Create a goblin object
            case 1:
                monsterName = "Orc";
                monster = new Monster.TankMonster(monsterName);
                break;

            // Create a goblin object
            case 2:
                monsterName = "Dragon";
                monster = new Monster.BossMonster(monsterName);
                break;

            // Create a hunter object with "Error" as a name. This should never be reached
            default:
                monster = new Monster.HunterMonster("Error");
                monsterName = "Error";
                break;
        }

        // Diplay a message stating that a monster appeared
        System.out.println("\nA " + monsterName + " appears!");

        // Combat loop as long as player and monster are alive
        while (playerCharacter.isAlive() && monster.isAlive()) 
        {
            // Player attacks monster
            monster.takeDamage(playerCharacter.attack);
            
            // Monster attacks player if it is still alive
            if (monster.isAlive())
            {
                playerCharacter.takeDamage(monster.attack);
            }
        }

        // If the player is defeated
        if (!playerCharacter.isAlive())
        {
            System.out.println(playerCharacter.getName() + " has been defeated. Game over!");

            // Save character data
            saveData(playerCharacter.getName(), playerCharacter.getLevel(), 0);

            // Reset playerCharacter to null
            playerCharacter = null;

            // Reset kill count
            kills = 0;
        }

        // If the monster was defeated
        else
        {
            System.out.println(monsterName + " has been defeated!");

            // Award xp to the player
            playerCharacter.setExp(playerCharacter.getExp() + 100);

            // Check to see if the character leveled up
            playerCharacter.levelUp();

            // Add to kill count
            kills++;

            // Ask the user if they want to fight again
            System.out.print("Fight another monster? (yes/no)");
            String fightAgain = input.nextLine();

            // If the player says yes, run beginAdventure() again
            if (fightAgain.equalsIgnoreCase("yes") || fightAgain.equalsIgnoreCase("y"))
            {
                begin();
            }

            // If the player says no
            else
            {
                // Show a message
                System.out.println(playerCharacter.getName() + " retires from adventuring.");

                // Save the player's data
                saveData(playerCharacter.getName(), playerCharacter.getLevel(), kills);

                // Reset playerCharacter to null
                //playerCharacter = null;
            }

        }
    }

    // Method to display the character's information
    private static void results()
    {
        // Check if a character has been created
        if (playerCharacter == null)
        {
            System.out.println("No character has been created.");
            return;
        }

        // Display character information
        displayCharDetails(playerCharacter);
    }

    // Method to display the details of a given player object
    private static void displayCharDetails(Player player)
    {
        System.out.println("\nCharacter Information:");
        System.out.println("Name: " + player.getName());
        System.out.println("Class: " + player.getClass().getSimpleName());
        System.out.println("Level: " + player.getLevel());
        System.out.println("Max Health: " + player.getMaxHealth());
        System.out.println("Current Health: " + player.getCurrentHealth());
        System.out.println("Attack: " + player.getAttack());
        System.out.println("Experience Points: " + player.getExp());
        System.out.println("Kill Count: " + kills);
    }

    // Method to view previous characters
    private static void viewPrevious()
    {
        // Create a file object representing the csv file
        File file = new File(CHARACTER_FILE);

        // Try with resources blok to automatically close the bufferedreader
        try (BufferedReader br = new BufferedReader(new FileReader(file)))
        {
            // Declare a string to store each line read from the file
            String line;
            System.out.println("\nPrevious Characters:");

            // Read lines from the file until the end is reached
            while ((line = br.readLine()) != null)
            {
                // Print each line containing data for one character
                System.out.println(line);
            }
        }

        // Handle potential IO exceptions such as file not found or an error reading
        catch (IOException e)
        {
            System.out.println("Error: No previous character found or can not read file");
        }
    }

    // Method to save character data to a csv file
    private static void saveData(String name, int level, int enemiesDefeated)
    {
        // Create a file object for the csv file
        File file = new File(CHARACTER_FILE);

        // Check if file exists on system
        boolean fileExists = file.exists();

        // Use a try with resources block to automatically close the printwriter
        // 'True' means append to the file
        try (PrintWriter pw = new PrintWriter(new FileWriter(file, true)))
        {
            // If the file doesn't exist, write a header line first
            if (!fileExists)
            {
                pw.println("Name,Max Level,Enemies Defeated");
            }

            // Append the character's data to the file as a comma separated line
            pw.println(name + "," + level + "," + enemiesDefeated);
        }

        // Handle potential IO exceptions such as error writing to file
        catch (IOException e)
        {
            System.out.println("Error saving character data.");
        }

    }
}

