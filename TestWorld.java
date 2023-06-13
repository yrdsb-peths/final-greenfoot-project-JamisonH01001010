import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TestWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TestWorld extends World
{
    BossSummon b = new BossSummon();
    FireKnight f = new FireKnight();
    public TestWorld(){
        super(800, 600, 1, false);
        
        addObject(b, 500, 300);
        addObject(f, 500, 100);
    }
    
    public void act(){
        BossSummon.setDeath(true);
        FireKnight.setDeathControl(true);
    }
}
