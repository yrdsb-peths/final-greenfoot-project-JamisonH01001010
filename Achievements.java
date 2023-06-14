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
    private static boolean finalBoss1 = false; // Hidden: Defeat Final Boss
    private static boolean hoarder2 = false; // Hidden: Store 100 tokens at once
    private static boolean lucky3 = false; // Hidden: 1/100 chance to get by opening achievements
    private static boolean bully4 = false; // Hidden: Defeat Stage 1-1 10 times
    private static boolean chest5 = false; // Hidden: Click on the background chest in the Achievements page
    // Achievement Background
    GreenfootImage achBG = new GreenfootImage("621708.jpg");
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
    GameFont ach1 = new GameFont("Sweet Sweet Revenge", 450);
    GameFont ach2 = new GameFont("Saving for a Rainy Day", 450);
    GameFont ach3 = new GameFont("1 in 100 chance", 450);
    GameFont ach4 = new GameFont("Bullying the Weak", 450);
    GameFont ach5 = new GameFont("???", 450);
    GameFont achText = new GameFont("Achievements", 700);
    // Achievements
    GameFont chestText = new GameFont(" ", 500, 200); // blank text, if clicked gives ach5
    int lucky = 0;
    public Achievements()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1, false); // if true then unable to place text > dimensions
        
        // Set Achievement background
        achBG.scale(800, 600);
        setBackground(achBG);
        
        // Add Menu
        addObject(m, 400, 300);
        
        // Add BlankMedals
        addObject(bm1, 190, 190);
        addObject(bm2, 190, 260);
        addObject(bm3, 190, 330);
        addObject(bm4, 190, 400);
        addObject(bm5, 190, 470);
        addObject(chestText, 180, 620);
        
        // Text
        addObject(ach1, 390, 370); 
        addObject(ach2, 390, 440);
        addObject(ach3, 390, 510);
        addObject(ach4, 390, 580);
        addObject(ach5, 390, 650);
        addObject(achText, 470, 400);
        
        // Add HomeButton
        addObject(h, 620, 120);
        
        // Ach3
        // With every opening of achievement screen, 1 in 100 chance to get ach3
        lucky = Greenfoot.getRandomNumber(99);
        if(lucky == 14){
            completeAch3();
        }
    }
    
    public void act(){
        if(Greenfoot.mouseClicked(h)){
            TitleScreen achWorld = new TitleScreen();
            Greenfoot.setWorld(achWorld);
        }
        if(Greenfoot.mouseClicked(chestText)){
            completeAch5();
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
        if(lucky3){
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
    
    public static void completeAch1(){
        finalBoss1 = true;
    }
    public static void completeAch2(){
        hoarder2 = true;
    }
    public static void completeAch3(){
        lucky3 = true;
    }
    public static void completeAch4(){
        bully4 = true;
    }
    public static void completeAch5(){
        chest5 = true;
    }
}
