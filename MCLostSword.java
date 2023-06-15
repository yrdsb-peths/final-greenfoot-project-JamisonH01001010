import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The icon of the main character's lost sword
 */
public class MCLostSword extends Actor
{
    // Animation count
    private boolean count = true;
    // MCLostSword icon
    GreenfootImage ls = new GreenfootImage("mc-lost-sword.png");
    // Animation Timer
    SimpleTimer animTimer = new SimpleTimer();
    /**
     * Constructor: Mark animation timers and set an inital image
     */
    public MCLostSword(int scale){
        ls.scale(scale, scale);
        setImage(ls);
        
        animTimer.mark();
    }
    /**
     * Animate the sword on repeat
     */
    public void act(){
        animation();
    }
    /**
     * Cycle between moving up and down (just a simple animation)
     */
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
