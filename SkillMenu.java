import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tutorial here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SkillMenu extends World
{
    Menu m = new Menu(900, 700);
    
    CoinTracker c = new CoinTracker();
    Integer cCount = CoinTracker.getCoinCount();
    
    Health health = new Health();
    
    Attack attack = new Attack();
    
    Increaser i1 = new Increaser();
    Increaser i2 = new Increaser();
    
    // Text
    GameFont skillMenu = new GameFont("Skill Menu", 900);
    GameFont numCoins = new GameFont(cCount.toString(), 400);
    GameFont stats = new GameFont("[Stats]", 600);
    GameFont HP = new GameFont("HP:    " + Health.getHealthCount(), 500);
    GameFont ATK = new GameFont("ATK: " + Attack.getAtkCount(), 500);
    public SkillMenu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1);
        
        addObject(m, 400, 300); 
        
        addObject(c, 650, 90);
        
        addObject(health, 300, 268); 
        
        addObject(attack, 280, 368);
        
        addObject(i1, 350, 268);
        addObject(i2, 350, 368);
        // Text
        addObject(skillMenu, 525, 450);
        addObject(numCoins, 760, 252);
        addObject(stats, 380, 420);
        addObject(HP, 280, 470);
        addObject(ATK, 280, 550);
    }
}
