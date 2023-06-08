import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Boss here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Boss extends Actor
{
    GreenfootImage[] bossAppear = new GreenfootImage[18];
    GreenfootImage[] bossAttack = new GreenfootImage[13];
    GreenfootImage[] bossIdle = new GreenfootImage[8];
    
    SimpleTimer appearTimer = new SimpleTimer();
    SimpleTimer attackTimer = new SimpleTimer();
    SimpleTimer idleTimer = new SimpleTimer();
    
    private int appearIndex = 17;
    private int attackIndex = 0;
    private int idleIndex = 0;
    
    public static boolean attack = false;
    public static boolean idle = true;
    
    public Boss(){
        for(int i = 0; i < bossAppear.length; i++){
            if(i >= 10){
                bossAppear[i] = new GreenfootImage("boss-death/boss_death_" + i + ".png");
            } else {
                bossAppear[i] = new GreenfootImage("boss-death/boss_death_0" + i + ".png");
            }
            bossAppear[i].mirrorHorizontally();
            bossAppear[i].scale(200, 200);
        }
        
        for(int i = 0; i < bossAttack.length; i++){
            if(i >= 10){
                bossAttack[i] = new GreenfootImage("attacking/boss_attack_" + i + ".png");
            } else {
                bossAttack[i] = new GreenfootImage("attacking/boss_attack_0" + i + ".png");
            }
            bossAttack[i].mirrorHorizontally();
            bossAttack[i].scale(200, 200);
        }
        
        appearTimer.mark();
        attackTimer.mark();
            
        setImage(bossAppear[0]);
    }
    public void act()
    {
        // Always appear animation when summoned
        if(true){
            appearAnimation();
        }
        if(attack){
            attackAnimation();
        }
    }
    
    public void appearAnimation(){
        if(appearTimer.millisElapsed() < 150){
            return;
        }
        
        appearTimer.mark();
        
        if(appearIndex >= 0){
            setImage(bossAppear[appearIndex]);
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
        }
        
        attackIndex++;
    }
    
    public static void setAttack(boolean a){
        attack = a;
    }
}
