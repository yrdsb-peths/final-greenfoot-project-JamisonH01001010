import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The icon for the main character's stun smash skill
 */
public class StunSmash extends Actor
{
    // StunSmash image
    GreenfootImage hammer = new GreenfootImage("hammer.png");
    /**
     * Constructor: Set the image for the stun smash icon
     */
    public StunSmash(){
        hammer.scale(60, 60);
        setImage(hammer);
    }
}
