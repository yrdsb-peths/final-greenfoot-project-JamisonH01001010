import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Stores the main character's max HP along with corressponding utility
 */
public class Health extends Actor
{
    private static int healthCount = 20; // mcHP starts at 20
    // Health icon
    GreenfootImage hp = new GreenfootImage("health.png");
    /**
     * Constructor: Set the icon of health in stats
     */
    public Health(){
        hp.scale(50, 50);
        setImage(hp);
    }
    /**
     * Increase the user's maxHP by 5 if they have enough coins/tokens (10)
     */
    public static void increaseHealth(){
        // Cap 999 HP
        if(healthCount < 999 && CoinTracker.getCoinCount() >= 10){
           healthCount += 5; 
           CoinTracker.addCoinCount(-10);
        }
    }
    /**
     * Return the user's current maxHP value
     * @return current maxHP value
     */
    public static int getHealthCount(){
        return healthCount;
    }
}
