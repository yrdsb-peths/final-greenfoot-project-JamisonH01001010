import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Boss here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Boss extends Actor
{
    GreenfootImage[] bossAppear = new GreenfootImage[17];
    
    SimpleTimer appearTimer = new SimpleTimer();
    
    private int appearIndex = 0;
    
    public Boss(){
        for(int i = 0; i < bossAppear.length; i++){
            if(i >= 10){
                bossAppear[i] = new GreenfootImage("boss-death/boss_death_" + i + ".png");
            }
            bossAppear[i] = new GreenfootImage("boss-death/boss_death_0" + i + ".png");
            bossAppear[i].mirrorHorizontally();
            bossAppear[i].scale(200, 200);
        }
        
        appearTimer.mark();
            
        setImage(bossAppear[0]);
    }
    public void act()
    {
        if(true){
            appearAnimation();
        }
    }
    
    public void appearAnimation(){
        if(appearTimer.millisElapsed() < 200){
            return;
        }
        
        appearTimer.mark();
        
        setImage(bossAppear[appearIndex]);
        
        appearIndex = (appearIndex + 1) % bossAppear.length;
    }
}
