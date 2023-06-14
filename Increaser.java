import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The plus icon to increase HP or ATK in the skill Menu
 */
public class Increaser extends Actor
{
    // Increaser icon
    GreenfootImage plus = new GreenfootImage("increase.png");
    /**
     * Constructor: Set the image of the increaser icon
     */
    public Increaser(){
        plus.scale(30, 30);
        setImage(plus);
    }
}
