import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level2 extends Actor
{
    GreenfootImage noPass = new GreenfootImage("levels/b02.png");
    GreenfootImage pass = new GreenfootImage("levels/a02.png");
    
    private static boolean passed = false;
    public Level2(){
        noPass.scale(70, 70);
        pass.scale(70, 70);
        
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
