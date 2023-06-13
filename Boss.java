import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Boss here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Boss extends Actor
{
    // Stats: HP = 300, ATK = 50
    
    GreenfootImage[] bossAppear = new GreenfootImage[18]; // the reverse animaations of death
    GreenfootImage[] bossAttack = new GreenfootImage[13];
    GreenfootImage[] bossDodge = new GreenfootImage[12];
    GreenfootImage[] bossIdle = new GreenfootImage[8];
    
    SimpleTimer appearTimer = new SimpleTimer();
    SimpleTimer attackTimer = new SimpleTimer();
    SimpleTimer dodgeTimer = new SimpleTimer();
    SimpleTimer idleTimer = new SimpleTimer();
    SimpleTimer deathTimer = new SimpleTimer();
    
    private int appearIndex = 17; // animation needs to be done in reverse (death in reverse = appear)
    private int attackIndex = 0;
    private int dodgeIndex = 0;
    private int idleIndex = 0;
    private int deathIndex = 0;
    
    static boolean appear = false;
    static boolean attack = false;
    static boolean dodge = false;
    static boolean idle = false;
    static boolean death = false;
    
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
    
    public void appearAnimation(){
        if(appearTimer.millisElapsed() < 150){
            return;
        }
        
        appearTimer.mark();
        
        if(appearIndex >= 0){
            setImage(bossAppear[appearIndex]);
        } else {
            appear = false;
            appearIndex = 0;
        }
        
        appearIndex--; 
    }
    
    public void attackAnimation(){
        if(attackTimer.millisElapsed() < 150){
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
    
    public void dodgeAnimation(){
        if(dodgeTimer.millisElapsed() < 150){
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
    
    public void idleAnimation(){
        if(idleTimer.millisElapsed() < 200){
            return;
        }
        
        idleTimer.mark();
        
        setImage(bossIdle[idleIndex]);
        
        idleIndex = (idleIndex + 1) % bossIdle.length;
    }
    
    public void deathAnimation(){
        if(deathTimer.millisElapsed() < 150){
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
    
    
    public static void setAppear(boolean a){
        appear = a;
    }
    
    public static void setAttack(boolean a){
        attack = a;
    }
    
    public static void setDodge(boolean a ){
        dodge = a;
    }
    
    public static void setIdle(boolean a){
        idle = a;
    }
    
    public static void setDeath(boolean a){
        death = a;
    }
}
