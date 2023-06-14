import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The boss's summon to be consumed for bossATK increases
 * Contains relating animations
 */
public class BossSummon extends Actor
{   
    // Images
    GreenfootImage[] summonAppear = new GreenfootImage[6];
    GreenfootImage[] summonIdle = new GreenfootImage[4];
    GreenfootImage[] summonDeath = new GreenfootImage[5];
    // Animation Timer
    SimpleTimer appearTimer = new SimpleTimer();
    SimpleTimer idleTimer = new SimpleTimer();
    SimpleTimer deathTimer = new SimpleTimer();
    // Animation Index
    private int appearIndex = 0;
    private int idleIndex = 0;
    private int deathIndex = 0;
    // Animation variables
    static boolean appear = false;
    static boolean idle = false;
    static boolean death = false;
    /**
     * Constructor: Fill arrays with corresponding images, mark animation timers, set inital image
     */
    public BossSummon(){
        for(int i = 0; i < summonAppear.length; i++){
            summonAppear[i] = new GreenfootImage("boss/boss_summon_" + i + ".png");
            summonAppear[i].mirrorHorizontally();
            summonAppear[i].scale(100, 100);
        }
        for(int i = 0; i < summonIdle.length; i++){
            summonIdle[i] = new GreenfootImage("boss/boss_summon_idle" + i + ".png");
            summonIdle[i].mirrorHorizontally();
            summonIdle[i].scale(100, 100);
        }
        for(int i = 0; i < summonDeath.length; i++){
            summonDeath[i] = new GreenfootImage("boss/boss_summon_death_" + i + ".png");
            summonDeath[i].mirrorHorizontally();
            summonDeath[i].scale(100, 100);
        }
        
        appearTimer.mark();
        idleTimer.mark();
        deathTimer.mark();
            
        setImage(summonIdle[0]);
    }
    /**
     * Continously check which animation to play
     */
    public void act()
    {
        if(appear){
            appearAnimation();
        }
        if(idle){
            idleAnimation();
        }
        if(death){
            deathAnimation();
        }
    }
    /**
     * The boss summon appearing animation
     */
    public void appearAnimation(){
        if(appearTimer.millisElapsed() < 150){
            return;
        }
        
        appearTimer.mark();
        
        if(appearIndex <= 5){
            setImage(summonAppear[appearIndex]);
        } else {
            setAppear(false);
            appearIndex = 0;
        }
        
        appearIndex++; 
    }
    /**
     * The boss summon idle animation
     */
    public void idleAnimation(){
        if(idleTimer.millisElapsed() < 200){
            return;
        }
        
        idleTimer.mark();
        
        setImage(summonIdle[idleIndex]);
        
        idleIndex = (idleIndex + 1) % summonIdle.length;
    }
    /**
     * The boss summon death animation
     */
    public void deathAnimation(){
        if(deathTimer.millisElapsed() < 150){
            return;
        }
        
        deathTimer.mark();
        
        if(deathIndex <= 4){
            setImage(summonAppear[deathIndex]);
        } else {
            deathIndex = 0;
            setDeath(false);
        }
        
        deathIndex++;
    }
    
    /**
     * Set the value of animation variable appear
     * @param1 value of appear
     */
    public static void setAppear(boolean a){
        appear = a;
    }
    /**
     * Set the value of animation variable idle
     * @param1 value of idle
     */
    public static void setIdle(boolean a){
        idle = a;
    }
    /**
     * Set the value of animation variable death
     * @param1 value of death
     */
    public static void setDeath(boolean a){
        death = a;
    }
}
