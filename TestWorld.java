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
    GameFont stages = new GameFont("Stages", 250);
    GameFont options = new GameFont("Options", 250);
    GameFont achievements = new GameFont("Achievements", 250);
    public TestWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
       
        addObject(stages, 300, 280);
        addObject(options, 300, 350);
        addObject(achievements, 310, 420);
        
    }
    
    public void act(){
        if(Greenfoot.mouseClicked(achievements)){
            Achievements achWorld = new Achievements();
            Greenfoot.setWorld(achWorld);
        }
        if(Greenfoot.mouseClicked(stages)){
            StageSelect stageWorld = new StageSelect();
            Greenfoot.setWorld(stageWorld);
        }
        if(Greenfoot.mouseClicked(options)){
            Options optionWorld = new Options();
            Greenfoot.setWorld(optionWorld);
        }
    }
}
