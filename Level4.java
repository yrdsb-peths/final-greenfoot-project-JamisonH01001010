import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level4 extends Actor
{
    GreenfootImage noPass = new GreenfootImage("levels/b04.png");
    GreenfootImage pass = new GreenfootImage("levels/a04.png");
    
    private static boolean passed = false;
    public Level4(){
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
