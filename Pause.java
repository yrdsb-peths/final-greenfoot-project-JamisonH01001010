import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The icon used to pause a stage in progress
 */
public class Pause extends Actor
{
    // Pause icon
    GreenfootImage pause = new GreenfootImage("pause.png");
    /**
     * Constructor: Set the image of the pause icon
     */
    public Pause(){
        pause.scale(100, 100);
        setImage(pause);
    }
}
