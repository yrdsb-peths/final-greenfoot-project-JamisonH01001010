import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)



/**
 * Write a description of class TitleScreen here.
 */
public class TitleScreen extends World
{
    GreenfootImage dungeonBG = new GreenfootImage("dungeon.jpg"); 
    GreenfootSound titleBGM = new GreenfootSound("sounds/october-rose-27659.mp3");

    Menu m = new Menu();
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        
        // Repeat TitleScreen BGM 
        // titleBGM.playLoop();
        
        // Set dungeon background
        dungeonBG.scale(800, 600);
        setBackground(dungeonBG);
        
        addObject(m, 400, 300);
        
        GameFont g = new GameFont();
        addObject(g, 400, 100);
        
        
    }
    
    
}
