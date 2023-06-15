
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A menu to control the music of the game
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
    /**
     * Constructor: Set the inital state of the options menu
     */
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
        addObject(music, 400, 410);
        // Add BlackSquare
        addObject(b1, 270, 300);
        // Add HomeButtion
        addObject(h1, 545, 155);
    }
    /**
     * Continously check if user wants to turn off music or return home
     */
    public void act(){
        if(Greenfoot.mouseClicked(h1)){
            TitleScreen t = new TitleScreen();
            Greenfoot.setWorld(t);
        }
        if(Greenfoot.mouseClicked(b1) || Greenfoot.mouseClicked(c1)){
            musicCount++;
        }
        if(musicCount % 2 == 0){ // music on
            addObject(c1, 270, 300);
            TitleScreen.getBGM().play();
        } else { // music off
            removeObject(c1);
            TitleScreen.getBGM().pause();
        }
    }
    /**
     * Get the value of the current tracker for music
     * @return the value of the current music count
     */
    public static int getMusicCount(){
        return musicCount;
    }
}
