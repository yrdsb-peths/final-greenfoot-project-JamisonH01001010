import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tutorial here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SkillMenu extends World
{
    
    Menu m = new Menu(900, 700);
    
    CoinTracker c = new CoinTracker();
    
    // Text
    GameFont skillMenu = new GameFont("Skill Menu", 900);
    
    public SkillMenu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1);
        
        addObject(m, 400, 300); 
        
        addObject(c, 650, 90);
        
        // Text
        addObject(skillMenu, 525, 450);
    }
}
