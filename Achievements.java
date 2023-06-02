import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Achievements here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Achievements extends World
{
    // Setting Achievement completion
    private boolean finalBoss1 = false; // Hidden: Defeat Final Boss
    private boolean hoarder2 = false; // Hidden: Store 100 tokens at once
    private boolean luckySlime3 = false; // Hidden: Encounter a golden slime
    private boolean bully4 = false; // Hidden: Defeat Stage 1-1 10 times
    private boolean chest5 = false; // Hidden: Click on the background chest in the Achievements page
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
    GoldMedal gm1 = new GoldMedal();
    GoldMedal gm2 = new GoldMedal();
    GoldMedal gm3 = new GoldMedal();
    GoldMedal gm4 = new GoldMedal();
    GoldMedal gm5 = new GoldMedal();
    // Font
    GameFont ach1 = new GameFont("Sweet Sweet Revenge", 1000);
    GameFont ach2 = new GameFont("Saving for a Rainy Day", 1000);
    GameFont ach3 = new GameFont("1 in 100 chance", 1000);
    GameFont ach4 = new GameFont("Bullying the Weak", 1000);
    GameFont ach5 = new GameFont("???", 1000);
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
        
        // Add BlankMedals
        addObject(bm1, 190, 125);
        addObject(bm2, 190, 215);
        addObject(bm3, 190, 305);
        addObject(bm4, 190, 395);
        addObject(bm5, 190, 485);
        
        // Text
        addObject(ach1, 230, 140);
        addObject(ach2, 230, 230);
        addObject(ach3, 230, 320);
        addObject(ach4, 230, 410);
        addObject(ach5, 230, 500);
    }
    
    public void act(){
        if(Greenfoot.mouseClicked(h)){
            TitleScreen titleWorld = new TitleScreen();
            Greenfoot.setWorld(titleWorld);
        }
    }
    
    private void completeAchievements(){
        if(finalBoss1){
            //remove blank medal
            //add gold medal
        }
        if(hoarder2){
            //remove blank medal
            //add gold medal
        }
        if(luckySlime3){
            //remove blank medal
            //add gold medal
        }
        if(bully4){
            //remove blank medal
            //add gold medal
        }
        if(chest5){
            //remove blank medal
            //add gold medal
        }
    }
    
    public void completeAch1(){
        finalBoss1 = true;
    }
    public void completeAch2(){
        hoarder2 = true;
    }
    public void completeAch3(){
        luckySlime3 = true;
    }
    public void completeAch4(){
        bully4 = true;
    }
    public void completeAch5(){
        chest5 = true;
    }
}
