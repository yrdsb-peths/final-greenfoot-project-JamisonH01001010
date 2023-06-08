import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level3 extends Actor
{
    GreenfootImage noPass = new GreenfootImage("levels/b03.png");
    GreenfootImage pass = new GreenfootImage("levels/a03.png");
    
    private static boolean passed = false;
    public Level3(){
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
