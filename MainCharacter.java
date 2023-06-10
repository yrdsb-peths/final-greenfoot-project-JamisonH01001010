import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MainCharacter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MainCharacter extends Actor
{
    int shieldAmount = 0;
    
    static boolean idleControl = true;
    static boolean attackControl = false;
    static boolean shieldControl = false;
    static boolean stunControl = false;
    
    // Idle animation
    GreenfootImage[] idle = new GreenfootImage[4];
    GreenfootImage[] swordIdle = new GreenfootImage[4];
    GreenfootImage[] attack = new GreenfootImage[5];
    GreenfootImage[] stun = new GreenfootImage[10];
    
    // Idle Animation Timer
    SimpleTimer idleTimer = new SimpleTimer();
    SimpleTimer swordIdleTimer = new SimpleTimer();
    SimpleTimer attackTimer = new SimpleTimer();
    SimpleTimer stunTimer = new SimpleTimer();
    
    // Track idle image index
    private int idleIndex = 0;
    private int swordIdleIndex = 0;
    private int attackIndex = 0;
    private int stunIndex = 0;
    
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
        for(int i = 0; i < stun.length; i++){
            if(i <= 3){
                stun[i] = new GreenfootImage("mc/adventurer-air-attack1-0" + i + ".png");
                stun[i].scale(100, 100);
            } else if (i <= 6){
                stun[i] = new GreenfootImage("mc/adventurer-air-attack2-0" + (i - 4) + ".png");
                stun[i].scale(100, 100);
            } else {
                stun[i] = new GreenfootImage("mc/adventurer-air-attack-3-end-0" + (i - 7) + ".png");
                stun[i].scale(100, 100);
            }
        }
        
        // Mark start of animation
        idleTimer.mark();
        swordIdleTimer.mark();
        attackTimer.mark();
        stunTimer.mark();
        
        // Set inital MC image
        setImage(idle[0]);
    }
    public void act()
    {
        //if(Intro.getOnIntro()){
            //idleAnimation();
        //} 
        if(idleControl){
            swordIdleAnimation(); 
        }
        if(attackControl){
            attackAnimation();
        }
        if(stunControl){
            stunAnimation();
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
    
    public void attackAnimation(){
        if(attackTimer.millisElapsed() < 150){
            return;
        }
        
        attackTimer.mark();
        
        if(attackIndex <= 4){
            setImage(attack[attackIndex]);
        } else {
            setImage(swordIdle[0]);
            attackIndex = 0;
        }
        
        attackIndex++;
    }
    
    public int shield(){
        shieldAmount = Greenfoot.getRandomNumber(2);
        if(shieldAmount == 0){
            return 25;
        } else {
            return 50;
        }
    }
    
    public void stunAnimation(){
        if(stunTimer.millisElapsed() < 150){
            return;
        }
        
        stunTimer.mark();
        
        if(stunIndex <= 9){
            setImage(stun[stunIndex]);
        } else {
            setImage(swordIdle[0]);
            stunIndex = 0;
        }
        
        stunIndex++;
    }
    
    public static void setIdleControl(boolean a){
        idleControl = a;
    }
    
    public static void setAttackControl(boolean a){
        attackControl = a;
    }
    
    public static void setShieldControl(boolean a){
        shieldControl = a;
    }
    
    public static void setStunControl(boolean a ){
        stunControl = a;
    }
    
}
