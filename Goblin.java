import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The stage 2 enemy of the game
 * Contains relating animations
 */
public class Goblin extends Actor
{
    // Stats: HP = 50, ATK = 8 
    // Images
    GreenfootImage[] idle = new GreenfootImage[4];
    GreenfootImage[] attack = new GreenfootImage[15];
    GreenfootImage[] death = new GreenfootImage[4];
    // Animation timers
    SimpleTimer idleTimer = new SimpleTimer();
    SimpleTimer attackTimer = new SimpleTimer();
    SimpleTimer deathTimer = new SimpleTimer();
    // Animation indexes
    private int idleIndex = 0;
    private int attackIndex = 0;
    private int deathIndex = 0;
    // Animation variables
    static boolean idleControl = false;
    static boolean attackControl = false;
    static boolean deathControl = false;
    /**
     * Constructor: Fill arrays with corresponding images, mark animation timers, and set an inital image
     */
    public Goblin(){
        for(int i = 0; i < idle.length; i++){
            idle[i] = new GreenfootImage("goblin/goblin_idle_" + i + ".png");
            idle[i].mirrorHorizontally();
            idle[i].scale(300, 300);
        }
        for(int i = 0; i < attack.length; i++){
            attack[i] = new GreenfootImage("goblin/goblin_attack_" + i + ".png");
            attack[i].mirrorHorizontally();
            attack[i].scale(300, 300);
        }
        for(int i = 0; i < death.length; i++){
            death[i] = new GreenfootImage("goblin/goblin_death_" + i + ".png");
            death[i].mirrorHorizontally();
            death[i].scale(300, 300);
        }
        
        idleTimer.mark();
        attackTimer.mark();
        deathTimer.mark();
        
        setImage(idle[0]);
    }
    /**
     * Continously check which animation to play
     */
    public void act()
    {
        if(idleControl){
            idleAnimation(); 
        }
        if(attackControl){
            attackAnimation();
        }
        if(deathControl){
            deathAnimation();
        }
    }
    /**
     * The goblin idle animation
     */
    public void idleAnimation(){
        if(idleTimer.millisElapsed() < 150){
            return;
        }
        
        idleTimer.mark();
        
        setImage(idle[idleIndex]);
        
        idleIndex = (idleIndex + 1) % idle.length;
    }
    /**
     * The goblin attack animation
     */
    public void attackAnimation(){
        if(attackTimer.millisElapsed() < 100){
            return;
        }
        
        attackTimer.mark();
        
        if(attackIndex <= 14){
            setImage(attack[attackIndex]);
        } else { // once full animation is over
            attackIndex = 0;
            setAttackControl(false);
        }
        
        attackIndex++;
    }
    /**
     * The goblin death animation
     */
    public void deathAnimation(){
        if(deathTimer.millisElapsed() < 300){
            return;
        }
        
        deathTimer.mark();
        
        if(deathIndex <= 3){
            setImage(death[deathIndex]);
        } else {
            deathIndex = 0;
            setDeathControl(false);
        }
        
        deathIndex++;
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
     * Set the value of animation variable deathControl
     * @param1 value of deathControl
     */
    public static void setDeathControl(boolean a){
        deathControl = a;
    }
}
