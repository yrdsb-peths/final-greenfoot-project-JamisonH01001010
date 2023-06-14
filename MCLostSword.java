import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MCLostSword here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MCLostSword extends Actor
{
    private boolean count = true;
    
    GreenfootImage ls = new GreenfootImage("mc-lost-sword.png");
    
    SimpleTimer animTimer = new SimpleTimer();
    public MCLostSword(int scale){
        ls.scale(scale, scale);
        
        animTimer.mark();
        
        setImage(ls);
    }
    
    public void act(){
        animation();
    }
    
    public void animation(){
        if(animTimer.millisElapsed() < 300){
            return;
        }
        
        animTimer.mark();
        
        // Idle Animation - Go up and down alternating
        if(count){
            setLocation(getX(), getY() - 2); 
            count = false;
        } else {
            setLocation(getX(), getY() + 2);
            count = true;
        }
    }
}
