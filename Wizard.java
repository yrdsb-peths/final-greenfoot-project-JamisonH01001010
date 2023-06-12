import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Wizard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Wizard extends Actor
{
    GreenfootImage[] idle = new GreenfootImage[8];
    GreenfootImage[] attack1 = new GreenfootImage[8];
    GreenfootImage[] attack2 = new GreenfootImage[8];
    GreenfootImage[] death = new GreenfootImage[7];
    
    SimpleTimer idleTimer = new SimpleTimer();
    SimpleTimer attack1Timer = new SimpleTimer();
    SimpleTimer attack2Timer = new SimpleTimer();
    SimpleTimer deathTimer = new SimpleTimer();
    
    private int idleIndex = 0;
    private int attack1Index = 0;
    private int attack2Index = 0;
    private int deathIndex = 0;
    
    static boolean idleControl = false;
    static boolean attack1Control = false;
    static boolean attack2Control = false;
    static boolean deathControl = false;
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
            death[i] = new GreenfootImage("wizard/wizard_death" + i + ".png");
            death[i].mirrorHorizontally();
            death[i].scale(300, 300);
        }
        
        idleTimer.mark();
        attack1Timer.mark();
        attack2Timer.mark();
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
        if(attack1Timer.millisElapsed() < 100){
            return;
        }
        
        attack1Timer.mark();
        
        if(attack1Index <= 7){
            setImage(attack1[attack1Index]);
        } else { // once full animation is over
            attack1Index = 0;
        }
        
        attack1Index++;
    }
    
    public void attack2Animation(){
        if(attack2Timer.millisElapsed() < 100){
            return;
        }
        
        attack2Timer.mark();
        
        if(attack2Index <= 7){
            setImage(attack2[attack2Index]);
        } else { // once full animation is over
            attack2Index = 0;
        }
        
        attack2Index++;
    }
    
    public void deathAnimation(){
        if(deathTimer.millisElapsed() < 300){
            return;
        }
        
        deathTimer.mark();
        
        if(deathIndex <= 6){
            setImage(death[deathIndex]);
        } else {
            deathIndex = 0;
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
    
    public static void setDeathControl(boolean a){
        deathControl = a;
    }
}
