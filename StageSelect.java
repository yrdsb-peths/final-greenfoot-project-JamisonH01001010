import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StageSelect here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StageSelect extends World
{
    // StageSelect Background
    GreenfootImage stagesBG = new GreenfootImage("map_54x53.png");
    // Object instantiations
    // Text
    GameFont stageSelect = new GameFont("Stage Select", 1200);
    public StageSelect()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        
        // Set StageSelect Background
        stagesBG.scale(800, 600);
        setBackground(stagesBG);
        
        // Text
        addObject(stageSelect, 300, 200);
        
    }
}
