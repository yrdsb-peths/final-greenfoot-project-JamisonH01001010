import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The mini icon used to construct a themed help button
 * (As a premade help button was not included in the themed spritesheet)
 */
public class MiniIcon extends Actor
{
    // MiniIcon image
    GreenfootImage m = new GreenfootImage("mini-icon.png");
    /**
     * Constructor: Set the image of the miniicon
     */
    public MiniIcon(){
        m.scale(100, 100);
        setImage(m);
    }
}
