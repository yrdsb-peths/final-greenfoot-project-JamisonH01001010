import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tutorial here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tutorial extends World
{
    // Check whether user has opened tutorial before
    private static boolean firstTutorial = true;
    // Object instantiations
    // Menu
    Menu m = new Menu(900, 700);
    
    // Continue
    Continue c = new Continue();
    
    // HomeButton
    HomeButton h = new HomeButton();
    
    // Text
    GameFont tutorial = new GameFont("Tutorial", 300, 160);
    GameFont description1 = new GameFont("Lost Sword is a turn-based RPG: You go first, then the enemy.", 600, 800);
    GameFont description2 = new GameFont("Each turn you will have 3 skills to choose from, detailed in the Skill Menu.", 650, 970);
    GameFont description3 = new GameFont("Press numbers 1, 2, or 3 on your keyboard to use a skill in battle.", 650, 900);
    GameFont description4 = new GameFont("Skill power scales off HP and ATK, upgradeable in the Skill Menu using tokens.", 720, 1100);
    GameFont description5 = new GameFont("Tokens are obtained through winning battles.", 400, 600);
    GameFont description6 = new GameFont("All achievements are hidden, decipher the requirements through their name.", 650, 1000); 
    GameFont description7 = new GameFont("Note: Enemy skills have no description, adapt accordingly.", 870, 1000);
    GameFont description8 = new GameFont("(This Tutorial will be accessable later from the Title Screen)", 350, 800);
    // description 8 will be removed after inital look
    // continue button will be removed and replaced with the home button after initial look
    
    public Tutorial()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1, false); 
        
        // Add Menu
        addObject(m, 400, 300); 
        
        // Text
        addObject(tutorial, 370, 170);
        addObject(description1, 385, 430);
        addObject(description2, 390, 500);
        addObject(description3, 405, 540);
        addObject(description4, 405, 620);
        addObject(description5, 400, 505);
        addObject(description6, 395, 675);
        addObject(description7, 485, 835);
        addObject(description8, 395, 720);
        
        // Add Continue
        addObject(c, 410, 493);
    }
    
    public void act(){
        if(Greenfoot.mouseClicked(c) || Greenfoot.mouseClicked(h)){
            TitleScreen t = new TitleScreen();
            Greenfoot.setWorld(t);
            firstTutorial = false;
        }
        if(!firstTutorial){
            removeObject(description8);
            removeObject(c);
            addObject(h, 410, 493);
        }
    }
}
