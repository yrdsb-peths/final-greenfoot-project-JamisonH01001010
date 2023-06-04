import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)



/**
 * Write a description of class TitleScreen here.
 */
public class TitleScreen extends World
{
    // Dungeon Background
    GreenfootImage dungeonBG = new GreenfootImage("dungeon.jpg"); 
    // Background Music
    GreenfootSound BGM = new GreenfootSound("sounds/october-rose-27659.mp3");
    // Object instantiations
    // Menu 
    Menu m = new Menu(300, 300);
    // MenuIcons
    MenuIcons MI = new MenuIcons();
    // Text
    GameFont title = new GameFont("Lost Sword", 2000);
    GameFont stages = new GameFont("Stages", 1000);
    GameFont options = new GameFont("Options", 1000);
    GameFont achievements = new GameFont("Achievements", 700);
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        
        // Set dungeon background
        dungeonBG.scale(800, 600);
        setBackground(dungeonBG);
        
        // Add Menu
        addObject(m, 400, 300);
        
        // Add MenuIcons
        addObject(MI, 400, 300);
        
        // Text
        addObject(title, 230, 125);
        addObject(stages, 353, 250);
        addObject(options, 345, 320);
        addObject(achievements, 323, 380);
        
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

        //setMusicAndSFX();
    }
    
    public void setMusicAndSFX(){
        Options o = new Options();
        if(o.musicCount % 2 == 0){
            BGM.playLoop();
        } else {
            BGM.stop();
        }
    }
    
    
    
}
