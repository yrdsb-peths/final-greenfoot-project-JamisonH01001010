import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TestWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TestWorld extends World
{
    Boss b = new Boss();
    public TestWorld(){
        super(800, 600, 1);
        
        addObject(b, 500, 300);
    }
    
    public void act(){
        Boss.setDeath(true);
    }
}
