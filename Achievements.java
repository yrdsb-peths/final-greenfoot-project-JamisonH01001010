import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Achievements here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Achievements extends World
{
    GreenfootImage g = new GreenfootImage("621708.jpg");
    Menu m = new Menu(700, 600);
    public Achievements()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
    
        g.scale(800, 600);
        setBackground(g);
        
        addObject(m, 400, 300);
    }
}
