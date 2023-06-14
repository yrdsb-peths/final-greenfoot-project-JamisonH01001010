import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The checkmark icon to control music in the options menu
*/
public class Checkmark extends Actor
{
    // Checkmark icon
    GreenfootImage checkmark = new GreenfootImage("checkmark.png");
    /**
     * Constructor: Sets the image for the checkmark icon
     */
    public Checkmark(){
        checkmark.scale(50, 50);
        setImage(checkmark);
    }
}
