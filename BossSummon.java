import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BossSummon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BossSummon extends Actor
{
    // Stats: Buff bosses's ATK by 25%, unkillable
    
    GreenfootImage[] summonAppear = new GreenfootImage[6];
    GreenfootImage[] summonIdle = new GreenfootImage[4];
    GreenfootImage[] summonDeath = new GreenfootImage[5];
    
    SimpleTimer appearTimer = new SimpleTimer();
    SimpleTimer idleTimer = new SimpleTimer();
    SimpleTimer deathTimer = new SimpleTimer();
    
    private int appearIndex = 0;
    private int idleIndex = 0;
    private int deathIndex = 0;
    
    static boolean appear = false;
    static boolean idle = false;
    static boolean death = false;
    
    public BossSummon(){
        for(int i = 0; i < summonAppear.length; i++){
            summonAppear[i] = new GreenfootImage("boss/boss_summon_" + i + ".png");
            summonAppear[i].mirrorHorizontally();
            summonAppear[i].scale(50, 50);
        }
        for(int i = 0; i < summonIdle.length; i++){
            summonIdle[i] = new GreenfootImage("boss/boss_summon_idle" + i + ".png");
            summonIdle[i].mirrorHorizontally();
            summonAppear[i].scale(50, 50);
        }
        for(int i = 0; i < summonDeath.length; i++){
            summonDeath[i] = new GreenfootImage("boss/boss_summon_death_" + i + ".png");
            summonDeath[i].mirrorHorizontally();
            summonDeath[i].scale(50, 50);
        }
        
        appearTimer.mark();
        idleTimer.mark();
        deathTimer.mark();
            
        setImage(summonIdle[0]);
    }
    
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
    
    public void appearAnimation(){
        if(appearTimer.millisElapsed() < 150){
            return;
        }
        
        appearTimer.mark();
        
        if(appearIndex <= 5){
            setImage(summonAppear[appearIndex]);
        } else {
            appear = false;
            appearIndex = 0;
        }
        
        appearIndex++; 
    }
    
    public void idleAnimation(){
        if(idleTimer.millisElapsed() < 200){
            return;
        }
        
        idleTimer.mark();
        
        setImage(summonIdle[idleIndex]);
        
        idleIndex = (idleIndex + 1) % summonIdle.length;
    }
    
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
    
    
    public static void setAppear(boolean a){
        appear = a;
    }
    
    public static void setIdle(boolean a){
        idle = a;
    }
    
    public static void setDeath(boolean a){
        death = a;
    }
}
