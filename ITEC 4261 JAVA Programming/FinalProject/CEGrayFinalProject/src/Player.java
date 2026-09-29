/* Casey Gray
 * ITEC 4261 Section 02
 * April 30, 2025
 */

 /*Create a Player Class according to this UML:

Character

Attack

Experience_Points

Current_Health

Max_Health

Level

Name

dealDamage()

isAlive()

takeDamage()

 

Attributes should be initialized according to the following:

Name – via user input

Max_Health – randomly generated between 100 and 250

Current_Health – starts at Max Health value

Attack – randomly generated between 5 and 15

Experience_Points – starts at zero (0)

Level – starts at one (1)

dealDamage() should return the amount of damage the character deals with each attack (their Attack attribute), it should not accept any parameters

takeDamage() should accept a parameter of how much damage was received, updating their Current_Health attribute appropriately and should return nothing

isAlive() should check if the Current_Health attribute is above zero (0), if it is return True, it not, return False

levelUp() should check if Experience_Points is greater than or equal to 500.  If it is, then subtract 500 from Experience_Points, increment Level by 1, add five (5) to Attack, add 50 to Max Health and set Current_Health to the new Max_Health value.

Create three (3) subclasses of the Player class:

One (1) must have a higher Max_Health range than the other
The one with the lower Max_Health range must have a higher Attack range
One must take less damage from every hit in their takeDamage() method */

// Import java utilities
import java.util.Random;

public class Player 
{
    // Declare variables
    private String name;
    protected int maxHealth;
    protected int currentHealth;
    protected int attack;
    private int exp;
    private int lvl;

    // Constructor
    public Player (String name)
    {
        System.out.print("Enter your character's name: ");
        // Initialize name
        this.name = name;
        Random random = new Random();

        // Generate random health value between 100-250
        this.maxHealth = random.nextInt(151) + 100;
        this.currentHealth = this.maxHealth;

        // Generate random attack value between 5-15
        this.attack = random.nextInt(11) + 5;

        // Initialize experience points
        this.exp = 0;

        // Initialize level
        this.lvl = 1;
    }

    // Method for player's damage dealt
    public int dealDamage()
    {
        return this.attack;
    }

    // Method for player taking damage, reducing player health
    public void takeDamage(int dmg)
    {
        this.currentHealth -= dmg;
        // Ensure health doesn't go below zero
        if (this.currentHealth < 0)
        {
            this.currentHealth = 0;
        }
    }

    // Check if the player is still alive
    public boolean isAlive()
    {
        return this.currentHealth > 0;
    }

    /* Levels up the player if they have enough exprience points
     * Subtracts 500 experience points and increases the level,
     * increases attack by 5 and max health by 50,
     * and sets the player's health to the new max health value
     */
    public void levelUp()
    {
        if (this.exp >= 500)
        {
            this.exp -= 500;
            this.lvl++;
            this.attack += 5;
            this.maxHealth += 50;
            this.currentHealth = this.maxHealth;
            System.out.println(this.name + " leveled up to level " + this.lvl + "!");
        }
    }

    // Getter methods
    public String getName()
    {
        return name;
    }
    
    public int getMaxHealth()
    {
        return maxHealth;
    }

    public int getCurrentHealth()
    {
        return currentHealth;
    }

    public int getAttack()
    {
        return attack;
    }

    public int getExp()
    {
        return exp;
    }

    public int getLevel()
    {
        return lvl;
    }

    // Set method for experience points
    public void setExp(int exp)
    {
        this.exp = exp;
    }

    // Create warrior subclass
    public static class Warrior extends Player
    {
        public Warrior(String name)
        {
            // Call the player class constructor
            super(name);

            // Create higher health range for tank
            Random random = new Random();
            this.maxHealth = random.nextInt(151) + 200;
            this.currentHealth = this.maxHealth;
        }

        // Override toString for helpful output
        public String toString()
        {
            return this.getName() + " the Warrior. Level: " + this.getLevel() + "\nHealth: " + getCurrentHealth() + "/" + getMaxHealth() +
            "\nAttack: " + this.getAttack() + "\nExperience: " + this.getExp();
        }
    }

    // Create assassin subclass
    public static class Assassin extends Player
    {
        public Assassin(String name)
        {
            super(name);

            // Create higher attack range for assassin
            Random random = new Random();
            this.attack = random.nextInt(11) + 10;
        }

        // Override toString for helpful output
        public String toString()
        {
            return this.getName() + " the Assassin. Level: " + this.getLevel() + "\nHealth: " + getCurrentHealth() + "/" + getMaxHealth() +
            "\nAttack: " + this.getAttack() + "\nExperience: " + this.getExp();
        }
    }

    // Create defender subclass
    public static class Defender extends Player
    {
        public Defender(String name)
        {
            super(name);
        }

        // Override takedamage() to reduce damage taken by half
        @Override
        public void takeDamage(int dmg)
        {
            super.takeDamage(dmg / 2);
        }

        // Override toString for helpful output
        public String toString()
        {
            return this.getName() + " the Defender. Level: " + this.getLevel() + "\nHealth: " + getCurrentHealth() + "/" + getMaxHealth() +
            "\nAttack: " + this.getAttack() + "\nExperience: " + this.getExp();
        }
    }
}