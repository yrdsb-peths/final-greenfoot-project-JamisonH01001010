import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Achievements here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Achievements extends World
{
    // Achievement Background
    GreenfootImage achBG = new GreenfootImage("621708.jpg");
    // Background Music
    GreenfootSound BGM = new GreenfootSound("sounds/october-rose-27659.mp3");
    // Object instantiations
    Menu m = new Menu(700, 600);
    HomeButton h = new HomeButton();
    BlankMedal bm1 = new BlankMedal();
    BlankMedal bm2 = new BlankMedal();
    BlankMedal bm3 = new BlankMedal();
    BlankMedal bm4 = new BlankMedal();
    BlankMedal bm5 = new BlankMedal();
    // Font
    
    public Achievements()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        
        // Repeat TitleScreen BGM 
        // BGM.playLoop();
        
        // Set Achievement background
        achBG.scale(800, 600);
        setBackground(achBG);
        
        // Add Menu
        addObject(m, 400, 300);
        
        // Add HomeButton
        addObject(h, 620, 120);
        
        // Add BlankMedal
        addObject(bm1, 200, 120);
    }
    
    public void act(){
        if(Greenfoot.mouseClicked(h)){
            TitleScreen titleWorld = new TitleScreen();
            Greenfoot.setWorld(titleWorld);
        }
    }
}
