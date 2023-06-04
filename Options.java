
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Options here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Options extends World
{
    private int musicCount = 0;
    private int SFXCount = 0;
    private boolean musicON = true;
    private boolean SFXON = true;
    // Options Background
    GreenfootImage optionsBG = new GreenfootImage("dungeon2.jpg");
    // Background Music
    GreenfootSound BGM = new GreenfootSound("sounds/october-rose-27659.mp3");
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
    GameFont music = new GameFont("Music", 1200);
    GameFont soundEffects = new GameFont("Sound Effects", 1200);
    public Options()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        // Set Options Background
        optionsBG.scale(800, 600);
        setBackground(optionsBG);
        
        // Repeat BGM 
        // BGM.playLoop();
        
        // Add Menu
        addObject(m, 400, 300);
        // Add HomeButtion
        addObject(h, 545, 155);
        // Add BlackSquare
        addObject(b1, 270, 250);
        addObject(b2, 270, 400);
        // Add Checkmark
        addObject(c1, 270, 250);
        addObject(c2, 270, 400);
        // Text
        addObject(options, 300, 190);
        addObject(music, 310, 270);
        addObject(soundEffects, 310, 420);
    }
    
    public void act(){
        if(Greenfoot.mouseClicked(h)){
            TitleScreen achWorld = new TitleScreen();
            Greenfoot.setWorld(achWorld);
        }
        if(Greenfoot.mouseClicked(b1)){
            musicCount++;
        }
        if(Greenfoot.mouseClicked(b2)){
            SFXCount++;
        }
        if(musicCount % 2 == 0){
            musicON = true;
        } else {
            musicON = false;
        }
        if(SFXCount % 2 == 0){
            SFXON = true;
        } else {
            SFXON = false;
        }
    }
    
    public boolean getMusicON(){
        return musicON;
    }
    
    public boolean getSFXON(){
        return SFXON;
    }
    
    public void setMusicAndSFX(){
        if(musicON){
            BGM.playLoop();
        } else {
            BGM.stop();
        }
    }
}
