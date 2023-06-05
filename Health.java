import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Health here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Health extends Actor
{
    private static int healthCount = 20;
    GreenfootImage hp = new GreenfootImage("health.png");
    public Health(){
        hp.scale(50, 50);
        setImage(hp);
    }
    
    public static void increaseHealth(){
        healthCount += 5;
    }
    
    public static int getHealthCount(){
        return healthCount;
    }
}
