
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Options here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Options extends World
{
    // Options Background
    GreenfootImage optionsBG = new GreenfootImage("dungeon2.jpg");
    // Object instantiations
    // Menu 
    Menu m = new Menu(500, 500);
    // HomeButton
    HomeButton h = new HomeButton();
    // BlackSquare
    BlackSquare b1 = new BlackSquare();
    BlackSquare b2 = new BlackSquare();
    // Checkmark
    Checkmark c1 = new Checkmark();
    Checkmark c2 = new Checkmark();
    // Text
    GameFont options = new GameFont("Options", 1800);
    public Options()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        // Set Options Background
        optionsBG.scale(800, 600);
        setBackground(optionsBG);
        // Add Menu
        addObject(m, 400, 300);
        // Add HomeButtion
        addObject(h, 545, 155);
        // Add BlackSqaure
        addObject(b1, 200, 200);
        addObject(b2, 200, 300);
        // Add Checkmark
        addObject(c1, 200, 200);
        addObject(c2,  200, 300);
        // Text
        addObject(options, 300, 190);
    }
    
    public void act(){
        if(Greenfoot.mouseClicked(h)){
            TitleScreen achWorld = new TitleScreen();
            Greenfoot.setWorld(achWorld);
        }
    }
}
