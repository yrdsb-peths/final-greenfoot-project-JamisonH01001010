import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class NormalStages3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NormalStages3 extends World
{
    Wizard w = new Wizard();
    public NormalStages3()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        addObject(w, 400, 300);
    }
    
    public void act(){
        Wizard.setDeathControl(true);
    }
}
