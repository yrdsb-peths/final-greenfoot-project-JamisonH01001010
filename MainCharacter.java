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
    GreenfootImage[] attack = new GreenfootImage[5];
    
    // Idle Animation Timer
    SimpleTimer idleTimer = new SimpleTimer();
    SimpleTimer swordIdleTimer = new SimpleTimer();
    SimpleTimer attackTimer = new SimpleTimer();
    
    // Track idle image index
    private int idleIndex = 0;
    private int swordIdleIndex = 0;
    private int attackIndex = 0;
    
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
        for(int i = 0; i < attack.length; i++){
            attack[i] = new GreenfootImage("mc/adventurer-attack1-0" + i + ".png");
            attack[i].scale(100, 100);
        }
        
        // Mark start of animation
        idleTimer.mark();
        swordIdleTimer.mark();
        attackTimer.mark();
        
        // Set inital MC image
        setImage(idle[0]);
    }
    public void act()
    {
        if(Intro.getOnIntro()){
            idleAnimation();
        } else {
            //swordIdleAnimation(); 
        }
        attackAnimation();
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
    
    public void attackAnimation(){
        if(attackTimer.millisElapsed() < 150){
            return;
        }
        
        attackTimer.mark();
        
        if(attackIndex <= 4){
            setImage(attack[attackIndex]);
        } else {
            setImage(swordIdle[0]);
        }
        
        attackIndex++;
    }
    
    
}
