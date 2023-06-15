import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The stage 4 icons
 * Either completed (green) or incomplete (yellow)
 */
public class Level4 extends Actor
{
    // Level icons
    GreenfootImage noPass = new GreenfootImage("levels/b04.png");
    GreenfootImage pass = new GreenfootImage("levels/a04.png");
    // Level variable
    private static boolean passed = false;
    /**
     * Constructor: Set the inital image of stage 4 icon
     */
    public Level4(){
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
     * Get if user has passed stage 4
     * @return if user has passed the stage
     */
    public static boolean getPassed(){
        return passed;
    }
    /**
     * Set the variable controlling if user has passed stage 4
     * @param1 The value set to the pass variable
     */
    public static void setPassed(boolean a){
        passed = a;
    }
}
