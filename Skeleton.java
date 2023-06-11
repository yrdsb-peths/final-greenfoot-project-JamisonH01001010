import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Skeleton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Skeleton extends Actor
{
    // Stats: HP = 20, ATK = 4
    
    GreenfootImage[] idle = new GreenfootImage[4];
    GreenfootImage[] attack = new GreenfootImage[15];
    GreenfootImage[] death = new GreenfootImage[4];
    
    SimpleTimer idleTimer = new SimpleTimer();
    SimpleTimer attackTimer = new SimpleTimer();
    SimpleTimer deathTimer = new SimpleTimer();
    
    private int idleIndex = 0;
    private int attackIndex = 0;
    private int deathIndex = 0;
    
    static boolean idleControl = true;
    static boolean attackControl = false;
    static boolean deathControl = false;
    public Skeleton(){
        for(int i = 0; i < idle.length; i++){
            idle[i] = new GreenfootImage("skeleton/skeleton_idle_" + i + ".png");
            idle[i].mirrorHorizontally();
            idle[i].scale(300, 300);
        }
        for(int i = 0; i < attack.length; i++){
            attack[i] = new GreenfootImage("skeleton/skeleton_attack_" + i + ".png");
            attack[i].mirrorHorizontally();
            attack[i].scale(300, 300);
        }
        for(int i = 0; i < death.length; i++){
            death[i] = new GreenfootImage("skeleton/skeleton_death" + i + ".png");
            death[i].mirrorHorizontally();
            death[i].scale(300, 300);
        }
        
        idleTimer.mark();
        attackTimer.mark();
        deathTimer.mark();
        
        setImage(idle[0]);
    }
    
    public void act(){
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
    
    public void idleAnimation(){
        if(idleTimer.millisElapsed() < 150){
            return;
        }
        
        idleTimer.mark();
        
        setImage(idle[idleIndex]);
        
        idleIndex = (idleIndex + 1) % idle.length;
    }
    
    public void attackAnimation(){
        if(attackTimer.millisElapsed() < 100){
            return;
        }
        
        attackTimer.mark();
        
        if(attackIndex <= 14){
            setImage(attack[attackIndex]);
        } else { // once full animation is over
            attackIndex = 0;
        }
        
        attackIndex++;
    }
    
    public void deathAnimation(){
        if(deathTimer.millisElapsed() < 300){
            return;
        }
        
        deathTimer.mark();
        
        if(deathIndex <= 3){
            setImage(death[deathIndex]);
        } else {
            deathIndex = 0;
        }
        
        deathIndex++;
    }
    
    public static void setIdleControl(boolean a){
        idleControl = a;
    }
    
    public static void setAttackControl(boolean a){
        attackControl = a;
    }
    
    public static void setDeathControl(boolean a){
        deathControl = a;
    }
}
