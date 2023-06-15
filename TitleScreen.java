import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The home screen of the game, includes pathways to all other sections besides actual levels
 */
public class TitleScreen extends World
{
    // Dungeon Background
    GreenfootImage dungeonBG = new GreenfootImage("dungeon.jpg"); 
    // Background Music
    static GreenfootSound BGM = new GreenfootSound("sounds/october-rose-27659.mp3");
    // Object instantiations
    // Menu 
    Menu m = new Menu(300, 300);
    // MenuIcons
    MenuIcons MI = new MenuIcons();
    // MenuIconsTwo
    MenuIconsTwo MI2 = new MenuIconsTwo();
    // Text
    GameFont title = new GameFont("Lost Sword", 1000);
    GameFont stages = new GameFont("Stages", 300);
    GameFont options = new GameFont("Options", 300);
    GameFont achievements = new GameFont("Achievements", 300);
    GameFont skillMenu = new GameFont("Skill Menu", 500);
    // MiniIcon
    MiniIcon mini = new MiniIcon();
    // Help
    Help h = new Help();
    /**
     * Constructor: Set icons of the title screen
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1, false); 
        
        if(Options.getMusicCount() % 2 == 0){
            BGM.playLoop();
        }
        
        // Set TitleScreen background
        dungeonBG.scale(800, 600);
        setBackground(dungeonBG);
        
        // Add Menu
        addObject(m, 400, 300);
        
        // Add MenuIcons
        addObject(MI, 400, 300);
        
        // Add MenuIconsTwo
        addObject(MI2, 400, 500);
        
        // Text
        addObject(title, 560, 490);
        addObject(stages, 473, 350);
        addObject(options, 470, 420);
        addObject(achievements, 433, 485);
        addObject(skillMenu, 483, 700);
        
        // Add MiniIcon
        addObject(mini, 750, 50);
        
        // Add Help
        addObject(h, 748, 50);
    }
    /**
     * Continously check if user wants to go to another world (ex. stages)
     */
    public void act(){
        if(Greenfoot.mouseClicked(achievements)){
            Achievements.lucky(); // // Chance of completing achievement 3
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
        if(Greenfoot.mouseClicked(skillMenu)){
            SkillMenu SMworld = new SkillMenu();
            Greenfoot.setWorld(SMworld);
        }
        if(Greenfoot.mouseClicked(h)){
            Tutorial t = new Tutorial();
            Greenfoot.setWorld(t);        
        }
    }
    
    /**
     * Gets the BGM greenfoot sound object 
     * @return GreenfootSound BGM
     */
    public static GreenfootSound getBGM(){
        return BGM;
    }
}
