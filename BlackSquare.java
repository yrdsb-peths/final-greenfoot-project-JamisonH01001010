import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The background checkbox for the options menu
 */
public class BlackSquare extends Actor
{
    // Black square icon
    GreenfootImage blackSquare = new GreenfootImage("rounded-square.png");
    /**
     * Constructor: Sets the image of the black Square
     */
    public BlackSquare(){
        blackSquare.scale(60, 60);
        setImage(blackSquare);
    }
}
