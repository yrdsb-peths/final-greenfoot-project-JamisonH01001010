import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ending here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ending extends World
{
    // Object instantiations  
    // Menu
    Menu m = new Menu(800, 600);
    // MCLostSword
    MCLostSword ls = new MCLostSword(200);
    // Text
    GameFont ending1 = new GameFont("Congratulations on beating the game!", 600, 520);
    GameFont ending2 = new GameFont("Now try to complete the hidden achievements!", 650, 700);
    // HomeButton
    HomeButton h = new HomeButton();
    public Ending()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1, false); 
        
        addObject(m, 400, 300);
        addObject(ending1, 385, 380);
        addObject(ending2, 415, 680);
        addObject(ls, 410, 270);
        
        addObject(h, 400, 470);
    }
    
    public void act(){
        if(Greenfoot.mouseClicked(h)){
            TitleScreen t = new TitleScreen();
            Greenfoot.setWorld(t);
        }
    }
}
