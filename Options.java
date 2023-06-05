
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Options here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Options extends World
{
    // Count to determine "button" state of options
    public static int musicCount = 0;
    public static int SFXCount = 0;
    // Options Background
    GreenfootImage optionsBG = new GreenfootImage("dungeon2.jpg");
    // Object instantiations
    // Menu 
    Menu m = new Menu(500, 500);
    // HomeButton
    HomeButton h1 = new HomeButton();
    // BlackSquare
    BlackSquare b1 = new BlackSquare();
    BlackSquare b2 = new BlackSquare();
    // Checkmark
    Checkmark c1 = new Checkmark();
    Checkmark c2 = new Checkmark();
    // Text
    GameFont options = new GameFont("Options", 500, 250);
    GameFont music = new GameFont("Music", 300, 250);
    GameFont soundEffects = new GameFont("Sound Effects", 300, 250);
    public Options()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1, false); 
        // Set Options Background
        optionsBG.scale(800, 600);
        setBackground(optionsBG);
        
        // Add Menu
        addObject(m, 400, 300);
        // Text
        addObject(options, 460, 330);
        addObject(music, 400, 360);
        addObject(soundEffects, 400, 510);
        // Add BlackSquare
        addObject(b1, 270, 250);
        addObject(b2, 270, 400);
        // Add HomeButtion
        addObject(h1, 545, 155);
    }
    
    public void act(){
        if(Greenfoot.mouseClicked(h1)){
            TitleScreen achWorld = new TitleScreen();
            Greenfoot.setWorld(achWorld);
        }
        if(Greenfoot.mouseClicked(b1) || Greenfoot.mouseClicked(c1)){
            musicCount++;
        }
        if(musicCount % 2 == 0){
            addObject(c1, 270, 250);
        } else {
            removeObject(c1);
        }
    }
    
    public static int getMusicCount(){
        return musicCount;
    }
}
