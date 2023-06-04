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
    // Menu
    Menu m = new Menu(700, 600);
    // HomeButton
    HomeButton h = new HomeButton();
    // BlankMedal
    BlankMedal bm1 = new BlankMedal();
    BlankMedal bm2 = new BlankMedal();
    BlankMedal bm3 = new BlankMedal();
    BlankMedal bm4 = new BlankMedal();
    BlankMedal bm5 = new BlankMedal();
    // GoldMedal
    GoldMedal gm1 = new GoldMedal();
    GoldMedal gm2 = new GoldMedal();
    GoldMedal gm3 = new GoldMedal();
    GoldMedal gm4 = new GoldMedal();
    GoldMedal gm5 = new GoldMedal();
    // Text
    GameFont ach1 = new GameFont("Sweet Sweet Revenge", 800);
    GameFont ach2 = new GameFont("Saving for a Rainy Day", 800);
    GameFont ach3 = new GameFont("1 in 100 chance", 800);
    GameFont ach4 = new GameFont("Bullying the Weak", 800);
    GameFont ach5 = new GameFont("???", 800);
    GameFont achText = new GameFont("Achievements", 1300);
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
        addObject(bm1, 190, 190);
        addObject(bm2, 190, 260);
        addObject(bm3, 190, 330);
        addObject(bm4, 190, 400);
        addObject(bm5, 190, 470);
        
        // Text
        addObject(ach1, 230, 200);
        addObject(ach2, 230, 270);
        addObject(ach3, 230, 340);
        addObject(ach4, 230, 410);
        addObject(ach5, 230, 480);
        addObject(achText, 260, 140);
    }
    
    public void act(){
        if(Greenfoot.mouseClicked(h)){
            TitleScreen achWorld = new TitleScreen();
            Greenfoot.setWorld(achWorld);
        }
        
        completeAchievements();
    }
    
    private void completeAchievements(){
        Achievements achWorld = new Achievements();
        if(finalBoss1){
            achWorld.removeObject(bm1);
            addObject(gm1, 190, 190);
        }
        if(hoarder2){
            achWorld.removeObject(bm2);
            addObject(gm2, 190, 260);
        }
        if(luckySlime3){
            achWorld.removeObject(bm3);
            addObject(gm3, 190, 330);
        }
        if(bully4){
            achWorld.removeObject(bm4);
            addObject(gm4, 190, 400);
        }
        if(chest5){
            achWorld.removeObject(bm5);
            addObject(gm5, 190, 470);
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
