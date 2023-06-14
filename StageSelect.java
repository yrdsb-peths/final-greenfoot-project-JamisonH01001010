import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A menu to selecta stage, out of 5 total
 */
public class StageSelect extends World
{
    // StageSelect Background
    GreenfootImage stagesBG = new GreenfootImage("map_54x53.png");
    // Object instantiations
    // Text
    GameFont stageSelect = new GameFont("Stage Select", 500);
    // Home Button
    HomeButton h = new HomeButton();
    // Levels
    Level1 l1 = new Level1();
    Level2 l2 = new Level2();
    Level3 l3 = new Level3();
    Level4 l4 = new Level4();
    Level5 l5 = new Level5();
    // Stages
    NormalStages1 ns1 = new NormalStages1();
    NormalStages2 ns2 = new NormalStages2();
    NormalStages3 ns3 = new NormalStages3();
    NormalStages4 ns4 = new NormalStages4();
    FinalStage fs = new FinalStage();
    /**
     * Constructor: Set the inital state of StageSelect screen
     */
    public StageSelect()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        
        // Set StageSelect Background
        stagesBG.scale(800, 600);
        setBackground(stagesBG);
        
        // Text
        addObject(stageSelect, 485, 380);
        
        // Add HomeButton
        addObject(h, 35, 40);
        
        // Add Levels
        addObject(l1, 110, 510); 
        addObject(l1, 110, 510);
        addObject(l2, 175, 115);
        addObject(l3, 675, 125);
        addObject(l4, 685, 510);
        addObject(l5, 395, 340);
    }
    /**
     * Continously check if user wants to enter a certain level or return home
     */
    public void act(){
        if(Greenfoot.mouseClicked(h)){
            TitleScreen achWorld = new TitleScreen();
            Greenfoot.setWorld(achWorld);
        }
        if(Greenfoot.mouseClicked(l1)){
            Greenfoot.setWorld(ns1);
        }
        if(Greenfoot.mouseClicked(l2) && NormalStages1.getS1Passed()){
            Greenfoot.setWorld(ns2);
        }
        if(Greenfoot.mouseClicked(l3) && NormalStages2.getS2Passed()){
            Greenfoot.setWorld(ns3);
        }
        if(Greenfoot.mouseClicked(l4) && NormalStages3.getS3Passed()){
            Greenfoot.setWorld(ns4);
        }
        if(Greenfoot.mouseClicked(l5) && NormalStages4.getS4Passed()){
            Greenfoot.setWorld(fs);
        }
    }
}
