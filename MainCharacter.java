import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MainCharacter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MainCharacter extends Actor
{
    // Idle animation
    GreenfootImage[] idle = new GreenfootImage[4];
    
    // Idle Animation Timer
    SimpleTimer animationTimerI = new SimpleTimer();
    
    // Track idle image index
    private int imageIndexI = 0;
    
    public MainCharacter(){
        // Loop through idle images
        for(int i = 0; i < idle.length; i++){
            idle[i] = new GreenfootImage("idle/adventurer-idle-2-0" + i + ".png");
            idle[i].scale(70, 70);
        }
        
        // Mark start of animation
        animationTimerI.mark();
        
        // Set inital MC image
        setImage(idle[0]);
    }
    public void act()
    {
        idleAnimation();
    }
    
    public void idleAnimation(){
        // 0.1s delay
        if(animationTimerI.millisElapsed() < 100){
            return;
        }
        
        // Set timer
        animationTimerI.mark();
        // Set current mage
        setImage(idle[imageIndexI]);
        // Go to the next image
        imageIndexI = (imageIndexI + 1) % idle.length; // To not cause array out of bounds error
    }
}
