import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TestWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TestWorld extends World
{
    HomeButton h = new HomeButton();
    Increaser i = new Increaser();
    GameFont a = new GameFont("test", 100, 100);
    public TestWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        addObject(i, 300, 300);
        addObject(a, 500, 500);
    }
    
    public void act(){
        if(Greenfoot.mouseClicked(i)){
            addObject(h, 100, 100);
            removeObject(a);
            a = new GameFont("test done", 100, 200);
            addObject(a, 300, 300);
        }
    }
}
