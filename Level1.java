import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level1 extends Actor
{
    // Initally yellow, change to green after level completion
    GreenfootImage noPass = new GreenfootImage("levels/b01.png");
    GreenfootImage pass = new GreenfootImage("levels/a01.png");
    
    private static boolean passed = false;
    public Level1(){
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
    
    public static void setPassed(boolean a){
        passed = a;
    }
}
