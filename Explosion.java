import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A special effect for the boss attack
 */
public class Explosion extends Actor
{
    // Images
    GreenfootImage[] boom = new GreenfootImage[30];
    // Animation timer
    SimpleTimer s = new SimpleTimer();
    // Animation index
    private int imageIndex = 0;
    /**
     * Constructor: Fill the array with corresponding images, mark animation index, set inital image
     */
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
    /**
     * Play the explosion animation on repeat
     */
    public void act()
    {
        animation();  
    }
    /**
     * The explosion animation
     */
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
