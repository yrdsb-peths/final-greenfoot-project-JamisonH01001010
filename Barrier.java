import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The icon for the main character's barrier skill
 */
public class Barrier extends Actor
{
    // Barrier icon
    GreenfootImage barrier = new GreenfootImage("barrier.png");
    /**
     * Constructor: Sets the image for the barrier skill
     */
    public Barrier(){
        barrier.scale(50, 50);
        setImage(barrier);
    }
}
