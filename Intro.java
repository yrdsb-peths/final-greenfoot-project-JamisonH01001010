import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Intro here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Intro extends World
{
    // Intro Background
    GreenfootImage introBG = new GreenfootImage("intro.png");
    
    // Object instantiations
    // MCLostSword 
    MCLostSword ls = new MCLostSword();
    // MainCharacter
    MainCharacter m = new MainCharacter();
    // Boss
    Boss b = new Boss();
    public Intro()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        
        // Set Intro background
        introBG.scale(800, 600);
        setBackground(introBG);
        
        // Add MCLostSword
        addObject(ls, 250, 485);
        
        // Add MainCharacter
        addObject(m, 200, 500);
        
        // Add Boss
        addObject(b, 500, 500);
    }
}
