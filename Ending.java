import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The end screen when the user completes the game (stage 5) for the first time
   */
public class Ending extends World
{
    // Object instantiations  
    SFX sfx = new SFX();
    Menu m = new Menu(800, 600);
    MCLostSword ls = new MCLostSword(200);
    HomeButton h = new HomeButton();
    // Text
    GameFont ending1 = new GameFont("Congratulations on beating the game!", 600, 520);
    GameFont ending2 = new GameFont("Now try to complete the hidden achievements!", 650, 700);
    /**
     * Constructor: Sets the background, text, and icons of Ending screen
     */
    public Ending()
    {    
        // Create a new world with 800x600 cells with a cell size of 1x1 pixels.
        super(800, 600, 1, false); 
        addObject(m, 400, 300);
        
        // Text
        addObject(ending1, 385, 380);
        addObject(ending2, 415, 680);

        addObject(ls, 410, 270);
        addObject(h, 400, 470);
    }
    /**
     * Continously check if user wants to return home by clicking on the home button
     */
    public void act(){
        if(Greenfoot.mouseClicked(h)){
            sfx.getClick().play();
            TitleScreen t = new TitleScreen();
            Greenfoot.setWorld(t);
        }
    }
}
