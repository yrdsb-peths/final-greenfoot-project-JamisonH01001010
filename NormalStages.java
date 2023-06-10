import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Stage1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NormalStages extends World
{
    public static boolean turn = true; // true = player turn, false = computer turn
    public static boolean onS1 = true;
    public static boolean skeletonAttack = false;
    public int pause = 100;
    // NormalStages Background
    GreenfootImage normalBG = new GreenfootImage("normal-stage.png");
    // Object instantiations
    // MainCharacter
    MainCharacter mc = new MainCharacter();
    // Stage 1
    Skeleton s = new Skeleton();
    // HealthBar
    HealthBar mcHP = new HealthBar(20);
    HealthBar skeletonHP = new HealthBar(20);
    public NormalStages()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        
        // Set NormalStages Background
        normalBG.scale(800, 600);
        setBackground(normalBG);
        
        // Add Skeleton
        addObject(s, 600, 350);
        
        // Add MainCharacter
        addObject(mc, 200, 350);
        
        // Add HealthBar
        addObject(mcHP, 200, 200);
        addObject(skeletonHP, 600, 200);
    }
    
    public void act(){
        if(turn && pause == 0){
            if(Greenfoot.isKeyDown("1")){
                MainCharacter.setIdleControl(false);
                mc.attackAnimation();
            } else if (Greenfoot.isKeyDown("2")){
                MainCharacter.setIdleControl(false);
                mc.attackAnimation();
            } else if(Greenfoot.isKeyDown("3")){
                MainCharacter.setIdleControl(false);
                mc.stunAnimation();
            }
            pause = 100;
        }
        if(pause > 0){
            pause--;
        } 
        if(!turn && pause == 0){
            MainCharacter.setIdleControl(true);
        }
    }
    
    public static boolean getTurn(){
        return turn;
    }
    
    public static void setTurn(boolean a){
        turn = a;
    }
    
    public HealthBar getSkeletonHealthBar(){
        return skeletonHP;
    }
    
    public HealthBar getMCHealthBar(){
        return mcHP;
    }
}
