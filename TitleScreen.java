import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The home screen of the game, includes pathways to all other sections besides actual levels
 */
public class TitleScreen extends World
{
    // Dungeon Background
    GreenfootImage dungeonBG = new GreenfootImage("dungeon.jpg"); 
    // Background Music
    static GreenfootSound BGM = new GreenfootSound("october-rose-27659.mp3");
    static GreenfootSound BGMNormalStages = new GreenfootSound("battle-of-the-dragons-8037.mp3");
    static GreenfootSound BGMFinalStage = new GreenfootSound("epic-dramatic-action-trailer-99525.mp3");
    // Object instantiations
    SFX sfx = new SFX();
    Menu m = new Menu(300, 300);
    MenuIcons MI = new MenuIcons();
    MenuIconsTwo MI2 = new MenuIconsTwo();
    MiniIcon mini = new MiniIcon();
    Help h = new Help();
    // Text
    GameFont title = new GameFont("Lost Sword", 1000);
    GameFont stages = new GameFont("Stages", 300);
    GameFont options = new GameFont("Options", 300);
    GameFont achievements = new GameFont("Achievements", 300);
    GameFont skillMenu = new GameFont("Skill Menu", 500);
    
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

        addObject(m, 400, 300);
        addObject(MI, 400, 300);
        addObject(MI2, 400, 500);
        
        // Text
        addObject(title, 560, 490);
        addObject(stages, 473, 350);
        addObject(options, 470, 420);
        addObject(achievements, 433, 485);
        addObject(skillMenu, 483, 700);

        addObject(mini, 750, 50);
        addObject(h, 748, 50);
    }
    /**
     * Continously check if user wants to go to another world (ex. stages)
     */
    public void act(){
        if(Greenfoot.mouseClicked(achievements)){
            sfx.getClick().play();
            Achievements.lucky(); // // Chance of completing achievement 3
            Achievements achWorld = new Achievements();
            Greenfoot.setWorld(achWorld);
        }
        if(Greenfoot.mouseClicked(stages)){
            sfx.getClick().play();
            BGM.stop();
            StageSelect stageWorld = new StageSelect();
            Greenfoot.setWorld(stageWorld);
        }
        if(Greenfoot.mouseClicked(options)){
            sfx.getClick().play();
            Options optionWorld = new Options();
            Greenfoot.setWorld(optionWorld);
        }
        if(Greenfoot.mouseClicked(skillMenu)){
            sfx.getClick().play();
            SkillMenu SMworld = new SkillMenu();
            Greenfoot.setWorld(SMworld);
        }
        if(Greenfoot.mouseClicked(h)){
            sfx.getClick().play();
            Tutorial t = new Tutorial();
            Greenfoot.setWorld(t);        
        }
    }
    
    /**
     * Gets the BGM greenfoot sound object 
     * @return BGM of pre-stages
     */
    public static GreenfootSound getBGM(){
        return BGM;
    }
    
    /**
     * Gets the normal stages BGM greenfoot sound object 
     * @return BGM of normal stages
     */
    public static GreenfootSound getBGMNormalStages(){
        return BGMNormalStages;
    }
    
    /**
     * Gets the final stage BGM greenfoot sound object 
     * @return BGM of final stage
     */
    public static GreenfootSound getBGMFinalStage(){
        return BGMFinalStage;
    }
}
