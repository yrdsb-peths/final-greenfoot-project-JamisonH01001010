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
    GreenfootImage[] swordIdle = new GreenfootImage[4];
    
    // Idle Animation Timer
    SimpleTimer idleTimer = new SimpleTimer();
    SimpleTimer swordIdleTimer = new SimpleTimer();
    
    // Track idle image index
    private int idleIndex = 0;
    private int swordIdleIndex;
    
    public MainCharacter(){
        // Loop through idle images
        for(int i = 0; i < idle.length; i++){
            idle[i] = new GreenfootImage("mc/adventurer-idle-0" + i + ".png");
            idle[i].scale(100, 100);
        }
        for(int i = 0; i < swordIdle.length; i++){
            swordIdle[i] = new GreenfootImage("mc/adventurer-idle-2-0" + i + ".png");
            swordIdle[i].scale(100, 100);
        }
        
        // Mark start of animation
        idleTimer.mark();
        swordIdleTimer.mark();
        
        // Set inital MC image
        setImage(idle[0]);
    }
    public void act()
    {
        if(Intro.getOnIntro()){
            idleAnimation();
        } else {
            swordIdleAnimation(); 
        }
    }
    
    public void idleAnimation(){
        // 0.15s delay
        if(idleTimer.millisElapsed() < 150){
            return;
        }
        
        // Set timer
        idleTimer.mark();
        // Set current mage
        setImage(idle[idleIndex]);
        // Go to the next image
        idleIndex = (idleIndex + 1) % idle.length; // To not cause array out of bounds error
    }
    
    public void swordIdleAnimation(){
        if(swordIdleTimer.millisElapsed() < 150){
            return;
        }
        
        swordIdleTimer.mark();
        
        setImage(swordIdle[swordIdleIndex]);
        
        swordIdleIndex = (swordIdleIndex + 1) % swordIdle.length;
    }
}
