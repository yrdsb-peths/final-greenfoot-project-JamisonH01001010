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
    public NormalStages()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        
        // Set NormalStages Background
        normalBG.scale(800, 600);
        setBackground(normalBG);
    }
}
