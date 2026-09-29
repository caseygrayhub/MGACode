/* Casey Gray
 * ITEC 4261 Section 02
 * April 30, 2025
 */

 /* Create a Monster Class according to this UML:

* Monster

* Attack

* Experience Value

* Health

* dealDamage()

* isAlive()

* takeDamage()

* Attributes should be initialized according to the following:

* Health – randomly generated between 10 and 50

* Attack – randomly generated between 5 and 15

* Experience Points – health and attack for that monster divided by 2 (rounded down)

* dealDamage() should return the amount of damage the monster deals with each attack (their Attack attribute), it should not accept any parameters

* takeDamage() should accept a parameter of how much damage was received, updating their Health attribute appropriately and should return nothing

* isAlive() should check if the Health attribute is above zero (0), if it is return True, it not, return False

* Create three (3) subclasses of the Monster class:
* One (1) must have a higher Health range than the other
* The one with the lower Health range must have a higher Attack range
* The third one should grant more experience points than the other two 
*/

// Import utility for random number generator
import java.util.Random;

public class Monster
{
    // Declare variables for monster health, attack, and experience
    protected int health;
    protected int attack;
    protected int exp;
    private Random random = new Random();

    // Construct default monster
    public Monster()
    {
        // Initialize variables with randomized attributes for this monster
        // Random health between 10 and 50
        this.health = random.nextInt(41) + 10;

        // Random attack between 5 and 15
        this.attack = random.nextInt(11) + 5;

        // Experience value that adds monster's health and attack, then divides it by 2
        this.exp = (this.health + this.attack) / 2;
    }

    // Create method for the monster dealing damage
    public int dealDamage()
    {
        return this.attack;
    }

    // Create method for the monster taking damage
    public void takeDamage(int damage)
    {
        this.health -= damage;
    }

    // Create method to check if monster is still alive
    public boolean isAlive()
    {
        return this.health > 0;
    }

    // Getter methods for health, attack, and experience values
    public int getHealth()
    {
        return health;
    }

    public int getAttack()
    {
        return attack;
    }

    public int getExp()
    {
        return exp;
    }

    // Subclass for monster with a higher Health range than the other, but lower attack
public static class TankMonster extends Monster
{
    // Constructor for the tank monster
    public TankMonster(String name)
    {
        // Higher health range
        this.health = new Random().nextInt(71) + 50;

        // Lower attack range
        this.attack = new Random().nextInt(8) + 3;

        // Calculate experiece value
        this.exp = (this.health + this.attack) / 2;
    }
}

// Subclass for monster with higher attack range, but lower health
public static class HunterMonster extends Monster
{
    // Constructor for the hunter monster
    public HunterMonster(String name)
    {
        // Lower health range
        this.health = new Random().nextInt(31) + 10;

        // Higher attack range
        this.attack = new Random().nextInt(16) + 15;

        // Calculate experience value
        this.exp = (this.health + this.attack) / 2;
    }
}

// Subclass for boss monster
public static class BossMonster extends Monster
{
    // Constructor for boss monster
    public BossMonster(String name)
    {
        // Call the monster constructor to get initial health and attack
        super();

        // Calculate higher experience value
        this.exp = (int) ((this.health * 1.5) + (this.attack * 1.5)) / 2;
    }
}
}