import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The final boss of the game
 * Contains relating animations
 */
public class Boss extends Actor
{
    // Stats: HP = 800, ATK = 50
    
    // Images
    GreenfootImage[] bossAppear = new GreenfootImage[18]; // the reverse animations of death
    GreenfootImage[] bossAttack = new GreenfootImage[13];
    GreenfootImage[] bossDodge = new GreenfootImage[12];
    GreenfootImage[] bossIdle = new GreenfootImage[8];
    
    // Animation Timers
    SimpleTimer appearTimer = new SimpleTimer();
    SimpleTimer attackTimer = new SimpleTimer();
    SimpleTimer dodgeTimer = new SimpleTimer();
    SimpleTimer idleTimer = new SimpleTimer();
    SimpleTimer deathTimer = new SimpleTimer();
    
    // Animation Indexes
    private int appearIndex = 17; // animation needs to be done in reverse (death in reverse = appear)
    private int attackIndex = 0;
    private int dodgeIndex = 0;
    private int idleIndex = 0;
    private int deathIndex = 0;
    
    // Animation variables
    static boolean appear = false;
    static boolean attack = false;
    static boolean dodge = false;
    static boolean idle = false;
    static boolean death = false;
    /**
     * Constructor: Fill arrays with corresponding images, mark animation timers, and set an inital image
     */
    public Boss(){
        // bossAppear array will multipurpose as appear and death animation
        for(int i = 0; i < bossAppear.length; i++){
            if(i >= 10){
                bossAppear[i] = new GreenfootImage("boss/boss_death_" + i + ".png");
            } else {
                bossAppear[i] = new GreenfootImage("boss/boss_death_0" + i + ".png");
            }
            bossAppear[i].mirrorHorizontally();
            bossAppear[i].scale(200, 200);
        }
        
        for(int i = 0; i < bossAttack.length; i++){
            if(i >= 10){
                bossAttack[i] = new GreenfootImage("boss/boss_attack_" + i + ".png");
            } else {
                bossAttack[i] = new GreenfootImage("boss/boss_attack_0" + i + ".png");
            }
            bossAttack[i].mirrorHorizontally();
            bossAttack[i].scale(200, 200);
        }
        
        for(int i = 0; i < bossDodge.length; i++){
            if(i >= 10){
                bossDodge[i] = new GreenfootImage("boss/boss_dodge_" + i + ".png");
            } else {
                bossDodge[i] = new GreenfootImage("boss/boss_dodge_0" + i + ".png");
            }
            bossDodge[i].mirrorHorizontally();
            bossDodge[i].scale(200, 200);
        }
        
        for(int i = 0; i < bossIdle.length; i++){
            bossIdle[i] = new GreenfootImage("boss/boss_idle_" + i + ".png");
            bossIdle[i].mirrorHorizontally();
            bossIdle[i].scale(200, 200);
        }
        
        appearTimer.mark();
        attackTimer.mark();
        dodgeTimer.mark();
        idleTimer.mark();
        deathTimer.mark();
            
        setImage(bossAppear[0]);
    }
    /**
     * Continously check which animation to play
     */
    public void act()
    {
        if(appear){
            appearAnimation();
        }
        if(attack){
            attackAnimation();
        }
        if(dodge){
            dodgeAnimation();
        }
        if(idle){
            idleAnimation();
        }
        if(death){
            deathAnimation();
        }
    }
    /**
     * The boss appearing animation
     */
    public void appearAnimation(){
        if(appearTimer.millisElapsed() < 150){
            return;
        }
        
        appearTimer.mark();
        
        if(appearIndex >= 0){
            setImage(bossAppear[appearIndex]);
        } else {
            appearIndex = 0;
            setAppear(false);
        }
        
        appearIndex--; 
    }
    /**
     * The boss attacking animation
     */
    public void attackAnimation(){
        if(attackTimer.millisElapsed() < 100){
            return;
        }
        
        attackTimer.mark();
        
        if(attackIndex <= 12){
            setImage(bossAttack[attackIndex]);
        } else {
            attackIndex = 0;
            setAttack(false);
        }
        
        attackIndex++;
    }
    /**
     * The boss dodging animation
     */
    public void dodgeAnimation(){
        if(dodgeTimer.millisElapsed() < 100){
            return;
        }
        
        dodgeTimer.mark();
        
        if(dodgeIndex <= 11){
            setImage(bossDodge[dodgeIndex]);
        } else {
            dodgeIndex = 0;
            setDodge(false);
        }
        
        dodgeIndex++;
    }
    /**
     * The boss idle animation
     */
    public void idleAnimation(){
        if(idleTimer.millisElapsed() < 200){
            return;
        }
        
        idleTimer.mark();
        
        setImage(bossIdle[idleIndex]);
        
        idleIndex = (idleIndex + 1) % bossIdle.length;
    }
    /**
     * The boss death animation
     */
    public void deathAnimation(){
        if(deathTimer.millisElapsed() < 100){
            return;
        }
        
        deathTimer.mark();
        
        if(deathIndex <= 17){
            setImage(bossAppear[deathIndex]);
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
     * Set the value of animation variable attack
     * @param1 value of attack
     */
    public static void setAttack(boolean a){
        attack = a;
    }
    /**
     * Set the value of animation variable dodge
     * @param1 value of dodge
     */
    public static void setDodge(boolean a ){
        dodge = a;
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
