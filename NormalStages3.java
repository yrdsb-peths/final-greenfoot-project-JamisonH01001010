import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class NormalStages3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NormalStages3 extends World
{
    FireKnight f = new FireKnight();
    public NormalStages3()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        addObject(f, 400, 300);
    }
    
    public void act(){
        FireKnight.setDeathControl(true);
    }
}
