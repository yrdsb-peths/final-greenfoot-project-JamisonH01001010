import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitleScreen here.
 */
public class TitleScreen extends World
{
    GreenfootSound titleBGM = new GreenfootSound("sounds/october-rose-27659.mp3");
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        titleBGM.playLoop();
    }
}
