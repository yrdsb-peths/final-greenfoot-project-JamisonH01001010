import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StageSelect here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
        addObject(l2, 175, 115);
        addObject(l3, 675, 125);
        addObject(l4, 685, 510);
        addObject(l5, 395, 340);
    }
    
    public void act(){
        if(Greenfoot.mouseClicked(h)){
            TitleScreen achWorld = new TitleScreen();
            Greenfoot.setWorld(achWorld);
        }
        if(Greenfoot.mouseClicked(l1)){
            Stage1 s1 = new Stage1();
            Greenfoot.setWorld(s1);
        }
        if(Greenfoot.mouseClicked(l2) && Level2.getPassed()){
            Stage2 s2 = new Stage2();
            Greenfoot.setWorld(s2);
        }
        if(Greenfoot.mouseClicked(l3) && Level3.getPassed()){
            Stage3 s3 = new Stage3();
            Greenfoot.setWorld(s3);
        }
        if(Greenfoot.mouseClicked(l4) && Level4.getPassed()){
            Stage4 s4 = new Stage4();
            Greenfoot.setWorld(s4);
        }
        if(Greenfoot.mouseClicked(l5) && Level5.getPassed()){
            Stage5 s5 = new Stage5();
            Greenfoot.setWorld(s5);
        }
    }
}
