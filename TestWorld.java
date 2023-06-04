import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TestWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TestWorld extends World
{

    /**
     * Constructor for objects of class TestWorld.
     * 
     */
    GameFont g = new GameFont("Testing text", 400);
    HomeButton h = new HomeButton();
    public TestWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        addObject(h, 350, 200);
       
        addObject(g, 270, 250);
        
    }
    
    public void act(){
        h.isClicked();
    }
}
