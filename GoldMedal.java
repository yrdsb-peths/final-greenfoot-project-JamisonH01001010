import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The medal icon if an achievement is completed
 */
public class GoldMedal extends Actor
{
    // Gold Medal icon
    GreenfootImage goldM = new GreenfootImage("gold-medal.png");
    /**
     * Constructor: Sets the gold medal image
     */
    public void act()
    {
        goldM.scale(40, 40);
        setImage(goldM);
    }
}
