
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Options here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Options extends World
{
    GreenfootImage optionsBG = new GreenfootImage("dungeon2.jpg");
    
    Menu m = new Menu(500, 500);
    HomeButton h = new HomeButton();
    BlackSquare b1 = new BlackSquare();
    
    
    GameFont options = new GameFont("Options", 1800);
    public Options()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        
        optionsBG.scale(800, 600);
        setBackground(optionsBG);
        
        addObject(m, 400, 300);
        addObject(h, 545, 155);
        
        addObject(options, 300, 190);
    }
    
    public void act(){
        if(Greenfoot.mouseClicked(h)){
            TitleScreen achWorld = new TitleScreen();
            Greenfoot.setWorld(achWorld);
        }
    }
}
