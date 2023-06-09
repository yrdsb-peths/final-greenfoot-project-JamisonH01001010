import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Skeleton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Skeleton extends Actor
{
    GreenfootImage[] idle = new GreenfootImage[4];
    GreenfootImage[] attack = new GreenfootImage[15];
    
    SimpleTimer idleTimer = new SimpleTimer();
    SimpleTimer attackTimer = new SimpleTimer();
    
    private int idleIndex = 0;
    private int attackIndex = 0;
    
    boolean i = true;
    public Skeleton(){
        for(int i = 0; i < idle.length; i++){
            idle[i] = new GreenfootImage("skeleton-idle/skeleton_idle_" + i + ".png");
            idle[i].mirrorHorizontally();
            idle[i].scale(300, 300);
        }
        for(int i = 0; i < attack.length; i++){
            attack[i] = new GreenfootImage("skeleton-attack/skeleton_attack_" + i + ".png");
            attack[i].mirrorHorizontally();
            attack[i].scale(300, 300);
        }
        
        idleTimer.mark();
        attackTimer.mark();
        
        setImage(idle[0]);
    }
    
    public void act(){
        if(i){
           idleAnimation(); 
        }
        if(!NormalStages.getTurn()){
            attackAnimation(); // only one action, attacking 
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
        if(attackTimer.millisElapsed() < 150){
            return;
        }
        
        attackTimer.mark();
        
        if(attackIndex <= 14){
            setImage(attack[attackIndex]);
        } else {
            NormalStages.setTurn(true);
        }
        
        attackIndex++;
    }
}
