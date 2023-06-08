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
    
    SimpleTimer idleTimer = new SimpleTimer();
    
    private int idleIndex = 0;
    
    public Skeleton(){
        for(int i = 0; i < idle.length; i++){
            idle[i] = new GreenfootImage("skeleton-idle/skeleton_idle_" + i + ".png");
            idle[i].mirrorHorizontally();
            idle[i].scale(300, 300);
        }
        
        idleTimer.mark();
        
        setImage(idle[0]);
    }
    
    public void act(){
        idleAnimation();
    }
    
    public void idleAnimation(){
        if(idleTimer.millisElapsed() < 150){
            return;
        }
        
        idleTimer.mark();
        
        setImage(idle[idleIndex]);
        
        idleIndex = (idleIndex + 1) % idle.length;
    }
}
