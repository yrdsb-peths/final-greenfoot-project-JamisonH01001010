import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The fire shield icon of the fire knight defend action
 */
public class FireShield extends Actor
{
    // Image
    GreenfootImage fs = new GreenfootImage("fire-shield.png");
    /**
     * 
     */
    public FireShield(){
        fs.scale(50, 50);
        setImage(fs);
    }
}
