import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The dodge icon of the boss's dodge action
 */
public class Dodge extends Actor
{
    // Dodge icon
    GreenfootImage d = new GreenfootImage("dodge.png");
    /**
     * Constructor: Set the image of the dodge icon
     */
    public Dodge(){
        d.scale(50, 50);
        setImage(d);
    }
}
