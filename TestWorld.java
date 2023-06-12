import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TestWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TestWorld extends World
{
    Wizard w = new Wizard();
    boolean a = true;
    public TestWorld(){
        super(800, 600, 1);
        
        addObject(w, 500, 300);
    }
    
    public void act(){
        if(a){
            Wizard.setAttack1Control(true);
        }
        a = false;
    }
}
