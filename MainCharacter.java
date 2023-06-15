import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The main character of the game
 * Contains relating animations
 */
public class MainCharacter extends Actor
{
    // Shield
    int shieldAmount = 0;
    
    // Animation Variables
    static boolean noSwordControl = false;
    static boolean idleControl = false;
    static boolean attackControl = false;
    static boolean shieldControl = false;
    static boolean stunControl = false;
    static boolean deathControl = false;
    
    // Images
    GreenfootImage[] idle = new GreenfootImage[4];
    GreenfootImage[] swordIdle = new GreenfootImage[4];
    GreenfootImage[] attack = new GreenfootImage[5];
    GreenfootImage[] stun = new GreenfootImage[10];
    GreenfootImage[] death = new GreenfootImage[7];
    
    // Animation timer
    SimpleTimer idleTimer = new SimpleTimer();
    SimpleTimer swordIdleTimer = new SimpleTimer();
    SimpleTimer attackTimer = new SimpleTimer();
    SimpleTimer stunTimer = new SimpleTimer();
    SimpleTimer deathTimer = new SimpleTimer();
    
    // Animation index
    private int idleIndex = 0;
    private int swordIdleIndex = 0;
    private int attackIndex = 0;
    private int stunIndex = 0;
    private int deathIndex = 0;
    /**
     * Constructor: Fill arrays with corresponding images, mark animation timers, and set an inital image
     */
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
        for(int i = 0; i < death.length; i++){
            death[i] = new GreenfootImage("mc/adventurer-die-0" + i + ".png");
            death[i].scale(100, 100);
        }
        
        // Mark start of animation
        idleTimer.mark();
        swordIdleTimer.mark();
        attackTimer.mark();
        stunTimer.mark();
        deathTimer.mark();
        
        // Set inital MC image
        setImage(idle[0]);
    }
    /**
     * Continously check which animation to play
     */
    public void act()
    {
        if(noSwordControl){
            idleAnimation();
        } 
        if(idleControl){
            swordIdleAnimation(); 
        }
        if(attackControl){
            attackAnimation();
        }
        if(stunControl){
            stunAnimation();
        }
        if(deathControl){
            deathAnimation();
        }
    }
    /**
     * The main character idle animation (no sword)
     */
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
    /**
     * The main character idle animation (yes sword)
     */
    public void swordIdleAnimation(){
        if(swordIdleTimer.millisElapsed() < 150){
            return;
        }
        
        swordIdleTimer.mark();
        
        setImage(swordIdle[swordIdleIndex]);
        
        swordIdleIndex = (swordIdleIndex + 1) % swordIdle.length;
    }
    /**
     * The main character attack animation
     */
    public void attackAnimation(){
        if(attackTimer.millisElapsed() < 250){
            return;
        }
        
        attackTimer.mark();
        
        if(attackIndex <= 4){
            setImage(attack[attackIndex]);
        } else {
            setImage(swordIdle[0]);
            attackIndex = 0;
            setAttackControl(false);
        }
        
        
        attackIndex++;
    }
    /**
     * The randomizers for the main character's shield, 25% or 50%
     * @return the percentage of shield randomized
     */
    public int shield(){
        shieldAmount = Greenfoot.getRandomNumber(2);
        if(shieldAmount == 0){
            return 25; // 25% blocked, 75% damage
        } else {
            return 50; // 50% blocked, 50% damage
        }
    }
    /**
     * The main character stun animation
     */
    public void stunAnimation(){
        if(stunTimer.millisElapsed() < 150){
            return;
        }
        
        stunTimer.mark();
        
        if(stunIndex <= 9){
            setImage(stun[stunIndex]);
        } else {
            stunIndex = 0;
            setStunControl(false);
        }
        
        stunIndex++;
    }
    /**
     * The main character death animation
     */
    public void deathAnimation(){
        if(deathTimer.millisElapsed() < 150){
            return;
        }
        
        deathTimer.mark();
        
        if(deathIndex <= 6){
            setImage(death[deathIndex]);
        } else {
            deathIndex = 0;
            setDeathControl(false);
        }
        
        deathIndex++;
    }
    /**
     * Set the value of animation variable noSwordControl
     * @param1 value of noSwordControl
     */
    public static void setNoSwordControl(boolean a){
        noSwordControl = a;
    }
    /**
     * Set the value of animation variable idleControl
     * @param1 value of idleControl
     */
    public static void setIdleControl(boolean a){
        idleControl = a;
    }
    /**
     * Set the value of animation variable attackControl
     * @param1 value of attackControl
     */
    public static void setAttackControl(boolean a){
        attackControl = a;
    }
    /**
     * Set the value of animation variable shieldControl
     * @param1 value of shieldControl
     */
    public static void setShieldControl(boolean a){
        shieldControl = a;
    }
    /**
     * Set the value of animation variable stunControl
     * @param1 value of stunControl
     */
    public static void setStunControl(boolean a){
        stunControl = a;
    }
    /**
     * Set the value of animation variable deathControl
     * @param1 value of deathControl
     */
    public static void setDeathControl(boolean a){
        deathControl = a;
    }
    
}
