import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The icon of the main character's attack in the skill menu
 */
public class BladeSlash extends Actor
{
    // Blade slash icon
    GreenfootImage sword = new GreenfootImage("WoodSword.png");
    /**
     * Constructor: Set the image of the blade slash icon
     */
    public BladeSlash(){
        sword.scale(50, 50);
        setImage(sword);
    }
}
