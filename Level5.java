import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level5 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level5 extends Actor
{
    GreenfootImage noPass = new GreenfootImage("levels/b05.png");
    GreenfootImage pass = new GreenfootImage("levels/a05.png");
    
    private static boolean passed = false;
    public Level5(){
        noPass.scale(100, 100);
        pass.scale(100, 100);
        
        setImage(noPass);
    }
    public void act()
    {
        if(passed){
            setImage(pass);
        }
    }
    public static boolean getPassed(){
        return passed;
    }
    public static void setPassed(boolean a){
        passed = a;
    }
}
