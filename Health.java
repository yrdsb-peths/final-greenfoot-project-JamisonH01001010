import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Health here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Health extends Actor
{
    private static int healthCount = 200; // mcHP starts at 20
    GreenfootImage hp = new GreenfootImage("health.png");
    public Health(){
        hp.scale(50, 50);
        setImage(hp);
    }
    
    public static void increaseHealth(){
        // Cap 999 HP
        if(healthCount < 999 && CoinTracker.getCoinCount() >= 10){
           healthCount += 5; 
           CoinTracker.addCoinCount(-10);
        }
    }
    
    public static int getHealthCount(){
        return healthCount;
    }
}
