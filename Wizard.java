import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The stage 3 enemy of the game
 * Contains related animations
 */
public class Wizard extends Actor
{
    // Stats: HP = 80, ATK = 20;
    // Images
    GreenfootImage[] idle = new GreenfootImage[8];
    GreenfootImage[] attack1 = new GreenfootImage[8];
    GreenfootImage[] attack2 = new GreenfootImage[8];
    GreenfootImage[] death = new GreenfootImage[7];
    // Animation timers
    SimpleTimer idleTimer = new SimpleTimer();
    SimpleTimer attack1Timer = new SimpleTimer();
    SimpleTimer attack2Timer = new SimpleTimer();
    SimpleTimer deathTimer = new SimpleTimer();
    // Animation indexes
    private int idleIndex = 0;
    private int attack1Index = 0;
    private int attack2Index = 0;
    private int deathIndex = 0;
    // Animation variables
    static boolean idleControl = false;
    static boolean attack1Control = false;
    static boolean attack2Control = false;
    static boolean deathControl = false;
    /**
     * Constructor: Fill arrays with corresponding images, mark animation timers, and set an inital image
     */
    public Wizard(){
        for(int i = 0; i < idle.length; i++){
            idle[i] = new GreenfootImage("wizard/wizard_idle_" + i + ".png");
            idle[i].mirrorHorizontally();
            idle[i].scale(300, 300);
        }
        for(int i = 0; i < attack1.length; i++){
            attack1[i] = new GreenfootImage("wizard/wizard_attack1_" + i + ".png");
            attack1[i].mirrorHorizontally();
            attack1[i].scale(300, 300);
        }
        for(int i = 0; i < attack2.length; i++){
            attack2[i] = new GreenfootImage("wizard/wizard_attack2_" + i + ".png");
            attack2[i].mirrorHorizontally();
            attack2[i].scale(300, 300);
        }
        for(int i = 0; i < death.length; i++){
            death[i] = new GreenfootImage("wizard/wizard_death_" + i + ".png");
            death[i].mirrorHorizontally();
            death[i].scale(300, 300);
        }
        
        idleTimer.mark();
        attack1Timer.mark();
        attack2Timer.mark();
        deathTimer.mark();
        
        setImage(idle[0]);
    }
    /**
     * Continously check which animation to play
     */
    public void act(){
        if(idleControl){
            idleAnimation(); 
        }
        if(attack1Control){
            attack1Animation();
        }
        if(attack2Control){
            attack2Animation();
        }
        if(deathControl){
            deathAnimation();
        }
    }
    /**
     * The wizard idle animation
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
     * The wizard attack1 animation
     */
    public void attack1Animation(){
        if(attack1Timer.millisElapsed() < 150){
            return;
        }
        
        attack1Timer.mark();
        
        if(attack1Index <= 7){
            setImage(attack1[attack1Index]);
        } else { // once full animation is over
            attack1Index = 0;
            setAttack1Control(false);
        }
        
        attack1Index++;
    }
    /**
     * The wizard attack2 animation
     */
    public void attack2Animation(){
        if(attack2Timer.millisElapsed() < 150){
            return;
        }
        
        attack2Timer.mark();
        
        if(attack2Index <= 7){
            setImage(attack2[attack2Index]);
        } else { // once full animation is over
            attack2Index = 0;
            setAttack2Control(false);
        }
        
        attack2Index++;
    }
    /**
     * The wizard death animation
     */
    public void deathAnimation(){
        if(deathTimer.millisElapsed() < 300){
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
     * Set the value of animation variable idleControl
     * @param1 value of idleControl
     */
    public static void setIdleControl(boolean a){
        idleControl = a;
    }
    /**
     * Set the value of animation variable attack1Control
     * @param1 value of attack1Control
     */
    public static void setAttack1Control(boolean a){
        attack1Control = a;
    }
    /**
     * Set the value of animation variable attack2Control
     * @param1 value of attack2Control
     */
    public static void setAttack2Control(boolean a){
        attack2Control = a;
    }
    /**
     * Set the value of animation variable deathControl
     * @param1 value of deathControl
     */
    public static void setDeathControl(boolean a){
        deathControl = a;
    }
}
