import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The stage 1 icon
 * Either completed (green) or incomplete (yellow)
 */
public class Level1 extends Actor
{
    // Level icons
    GreenfootImage noPass = new GreenfootImage("levels/b01.png");
    GreenfootImage pass = new GreenfootImage("levels/a01.png");
    // Level variable
    private static boolean passed = false;
    /**
     * Constructor: Set the inital image of stage 1 icon
     */
    public Level1(){
        noPass.scale(70, 70);
        pass.scale(70, 70);
        
        setImage(noPass);
    }
    /**
     * Continously check if the user has already passed the stage
     */
    public void act()
    {
        if(passed){
            setImage(pass);
        }
    }
    /**
     * Get if user has passed stage 1
     * @return if user has passed the stage
     */
    public static boolean getPassed(){
        return passed;
    }
    /**
     * Set if user has passed stage 1
     * 
     */
    public static void setPassed(boolean a){
        passed = a;
    }
}
