import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Explosion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Explosion extends Actor
{
    GreenfootImage[] boom = new GreenfootImage[30];
    
    SimpleTimer s = new SimpleTimer();
    
    private int imageIndex = 0;
    
    public Explosion(){
        for(int i = 0; i < boom.length; i++){
            if(i >= 10){
                boom[i] = new GreenfootImage("Effect_Explosion2_1/Effect_Explosion2_1_0" + i + ".png");
            } else {
                boom[i] = new GreenfootImage("Effect_Explosion2_1/Effect_Explosion2_1_00" + i + ".png");
            }
            boom[i].scale(100, 100);
        }
        
        s.mark();
            
        setImage(boom[0]);
    }
    public void act()
    {
        animation();  
    }
    
    public void animation(){
        if(s.millisElapsed() < 100){
            return;
        }
        
        s.mark();
        
        if(imageIndex <= 29){
            setImage(boom[imageIndex]);
        }
        
        imageIndex++;
    }
}
