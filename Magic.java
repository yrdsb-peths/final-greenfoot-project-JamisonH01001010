import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The icon for the magic DOT dealt by wizard, boss
 */
public class Magic extends Actor
{
    // Magic icon
    GreenfootImage magic = new GreenfootImage("magic.png");
    /**
     * Constructor: Set the image of the magic icon
     */
    public Magic(){
        magic.scale(50, 50);
        setImage(magic);
    }
}
