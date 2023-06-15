import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The stage 5 icons
 * Either completed (green) or incomplete (yellow)
 */
public class Level5 extends Actor
{
    // Level icons
    GreenfootImage noPass = new GreenfootImage("levels/b05.png");
    GreenfootImage pass = new GreenfootImage("levels/a05.png");
    // Level variable
    private static boolean passed = false;
    /**
     * Constructor: Set the inital image of stage 4 icon
     */
    public Level5(){
        noPass.scale(100, 100);
        pass.scale(100, 100);
        
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
     * Get if user has passed stage 5
     * @return if user has passed the stage
     */
    public static boolean getPassed(){
        return passed;
    }
    /**
     * Set the variable controlling if user has passed stage 5
     * @param1 The value set to the pass variable
     */
    public static void setPassed(boolean a){
        passed = a;
    }
}
