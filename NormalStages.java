import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Stage1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NormalStages extends World
{
    public static boolean turn = false; // true = player turn, false = computer turn
    // NormalStages Background
    GreenfootImage normalBG = new GreenfootImage("normal-stage.png");
    // Object instantiations
    // MainCharacter
    MainCharacter mc = new MainCharacter();
    // Stage 1
    Skeleton s = new Skeleton();
    // HealthBar
    HealthBar mcHP = new HealthBar(20);
    HealthBar skeletonHP = new HealthBar(20);
    public NormalStages()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        
        // Set NormalStages Background
        normalBG.scale(800, 600);
        setBackground(normalBG);
        
        // Add Skeleton
        addObject(s, 600, 350);
        
        // Add MainCharacter
        addObject(mc, 200, 350);
        
        // Add HealthBar
        addObject(mcHP, 200, 200);
        addObject(skeletonHP, 600, 200);
    }
    
    public static boolean getTurn(){
        return turn;
    }
    
    public static void setTurn(boolean a){
        turn = a;
    }
    
    public HealthBar getHealthBar(){
        return skeletonHP;
    }
}
