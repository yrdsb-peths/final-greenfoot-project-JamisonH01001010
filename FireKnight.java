import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FireKnight here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FireKnight extends Actor
{
    // Stats: HP = 150, ATK = 30;
    
    GreenfootImage[] idle = new GreenfootImage[8];
    GreenfootImage[] attack1 = new GreenfootImage[11];
    GreenfootImage[] attack2 = new GreenfootImage[18];
    GreenfootImage[] defend = new GreenfootImage[10];
    GreenfootImage[] death = new GreenfootImage[4];
    
    SimpleTimer idleTimer = new SimpleTimer();
    SimpleTimer attack1Timer = new SimpleTimer();
    SimpleTimer attack2Timer = new SimpleTimer();
    SimpleTimer defendTimer = new SimpleTimer();
    SimpleTimer deathTimer = new SimpleTimer();
    
    private int idleIndex = 0;
    private int attack1Index = 0;
    private int attack2Index = 0;
    private int defendIndex = 0;
    private int deathIndex = 0;
    
    static boolean idleControl = false;
    static boolean attack1Control = false;
    static boolean attack2Control = false;
    static boolean defendControl = false;
    static boolean deathControl = false;
    public FireKnight(){
        for(int i = 0; i < idle.length; i++){
            idle[i] = new GreenfootImage("fire-knight/idle_" + (i + 1) + ".png");
            idle[i].mirrorHorizontally();
            idle[i].scale(500, 300);
        }
        for(int i = 0; i < attack1.length; i++){
            attack1[i] = new GreenfootImage("fire-knight/1_atk_" + (i + 1) + ".png");
            attack1[i].mirrorHorizontally();
            attack1[i].scale(500, 300);
        }
        for(int i = 0; i < attack2.length; i++){
            attack2[i] = new GreenfootImage("fire-knight/sp_atk_" + (i + 1) + ".png");
            attack2[i].mirrorHorizontally();
            attack2[i].scale(500, 300);
        }
        for(int i = 0; i < defend.length; i++){
            defend[i] = new GreenfootImage("fire-knight/defend_" + (i + 1) + ".png");
            defend[i].mirrorHorizontally();
            defend[i].scale(500, 300);
        }
        for(int i = 0; i < death.length; i++){
            death[i] = new GreenfootImage("fire-knight/death_" + (i + 1) + ".png");
            death[i].mirrorHorizontally();
            death[i].scale(500, 300);
        }
        
        idleTimer.mark();
        attack1Timer.mark();
        attack2Timer.mark();
        defendTimer.mark();
        deathTimer.mark();
        
        setImage(idle[0]);
    }
    
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
        if(defendControl){
            defendAnimation();
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
    
    public void attack1Animation(){
        if(attack1Timer.millisElapsed() < 150){
            return;
        }
        
        attack1Timer.mark();
        
        if(attack1Index <= 10){
            setImage(attack1[attack1Index]);
        } else { // once full animation is over
            attack1Index = 0;
            setAttack1Control(false);
        }
        
        attack1Index++;
    }
    
    public void attack2Animation(){
        if(attack2Timer.millisElapsed() < 150){
            return;
        }
        
        attack2Timer.mark();
        
        if(attack2Index <= 17){
            setImage(attack2[attack2Index]);
        } else {
            attack2Index = 0;
            setAttack2Control(false);
        }
        
        attack2Index++;
    }
    
    
    public void defendAnimation(){
        if(defendTimer.millisElapsed() < 150){
            return;
        }
        
        defendTimer.mark();
        
        if(defendIndex <= 9){
            setImage(defend[defendIndex]);
        } else {
            defendIndex = 0;
            setDefendControl(false);
        }
        
        defendIndex++;
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
            setDeathControl(false);
        }
        
        deathIndex++;
    }
    
    public static void setIdleControl(boolean a){
        idleControl = a;
    }
    
    public static void setAttack1Control(boolean a){
        attack1Control = a;
    }
    
    public static void setAttack2Control(boolean a){
        attack2Control = a;
    }
    
    public static void setDefendControl(boolean a){
        defendControl = a;
    }
    
    public static void setDeathControl(boolean a){
        deathControl = a;
    }
}
