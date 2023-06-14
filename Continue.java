import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The continue button to advance the storyline
 */
public class Continue extends Actor
{
    // Continue icon
    GreenfootImage c = new GreenfootImage("continue.png");
    /**
     * Constructor: Set the image of the continue icon
     */
    public Continue(int scale){
        c.scale(scale, scale);
        setImage(c);
    }
}
