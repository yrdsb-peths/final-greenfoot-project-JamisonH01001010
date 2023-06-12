import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TestWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TestWorld extends World
{
    Wizard w = new Wizard
    public TestWorld(){
        super(800, 600, 1);
    }
    
    public void act(){
        Wizard.setAttack1(true);
    }
}
