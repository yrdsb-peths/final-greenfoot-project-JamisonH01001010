import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)



/**
 * Write a description of class TitleScreen here.
 */
public class TitleScreen extends World
{
    GreenfootImage dungeonBG = new GreenfootImage("dungeon.jpg"); 
    GreenfootSound titleBGM = new GreenfootSound("sounds/october-rose-27659.mp3");

    Menu m = new Menu();
    MenuIcons MI = new MenuIcons();
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        
        // Repeat TitleScreen BGM 
        // titleBGM.playLoop();
        
        // Set dungeon background
        dungeonBG.scale(800, 600);
        setBackground(dungeonBG);
        
        // Add Menu
        addObject(m, 400, 300);
        
        // Add MenuIcons
        addObject(MI, 400, 300);
        
        // Text
        GameFont title = new GameFont("Lost Sword", 400, 2000);
        addObject(title, 230, 150);
        
        GameFont achievements = new GameFont("Achievements", 400, 700);
        addObject(achievements, 150, 350);
        
        
    }
    
    
}
