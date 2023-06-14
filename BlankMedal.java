import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The icon if an achievement is not completed
 */
public class BlankMedal extends Actor
{
    // Blank medal icon
    GreenfootImage blankM = new GreenfootImage("blank-medal.png");
    /**
     * Constructor: Sets the blank medal image
     */
    public BlankMedal(){
        blankM.scale(40, 40);
        setImage(blankM);
    }
}
