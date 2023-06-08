import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Stage1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NormalStages extends World
{
    // NormalStages Background
    GreenfootImage normalBG = new GreenfootImage("normal-stage.png");
    // Object instantiations
    // MainCharacter
    MainCharacter mc = new MainCharacter();
    // Stage 1
    Skeleton s = new Skeleton();
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
    }
}
