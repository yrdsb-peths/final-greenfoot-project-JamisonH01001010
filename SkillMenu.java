import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tutorial here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SkillMenu extends World
{
    // Object instantiations
    // Menu
    Menu m = new Menu(900, 700);
    // CoinTracker
    CoinTracker c = new CoinTracker();
    Integer cCount = CoinTracker.getCoinCount();
    // Health
    Health health = new Health();
    Integer hCount = Health.getHealthCount();
    // Attack
    Attack attack = new Attack();
    // Increaser
    Increaser i1 = new Increaser();
    Increaser i2 = new Increaser();
    // Text
    GameFont skillMenu = new GameFont("Skills", 300, 120);
    GameFont numCoins = new GameFont(cCount.toString(), 100, 100);
    GameFont stats = new GameFont("[Stats]", 300, 150);
    GameFont HP = new GameFont("HP:    " + Health.getHealthCount(), 300, 200);
    GameFont ATK = new GameFont("ATK: " + Attack.getAtkCount(), 300, 200);
    public SkillMenu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1);
        // Add Menu
        addObject(m, 400, 300); 
        // Add CoinTracker
        addObject(c, 650, 88);
        // Add Health
        addObject(health, 300, 318); 
        // Add Attack
        addObject(attack, 300, 400);
        // Add Increasers
        addObject(i1, 350, 318); 
        addObject(i2, 350, 400);
        // Text
        addObject(skillMenu, 350, 146);
        addObject(numCoins, 608, 105);
        addObject(stats, 200, 310);
        addObject(HP, 165, 415);
        addObject(ATK, 165, 495);
    }
    
    public void act(){
        if(Greenfoot.mouseClicked(i1)){
            Health.increaseHealth();
            removeObject(HP);
            HP = new GameFont("HP:    " + Health.getHealthCount(), 300, 200);
            addObject(HP, 165, 415);
            removeObject(numCoins);
            numCoins = new GameFont(" " + CoinTracker.getCoinCount(), 100, 100);
            addObject(numCoins, 608, 105);
        }
        if(Greenfoot.mouseClicked(i2)){
            Attack.increaseAtk();
            removeObject(ATK);
            ATK = new GameFont("ATK: " + Attack.getAtkCount(), 300, 200);
            addObject(ATK, 165, 495);
            removeObject(numCoins);
            numCoins = new GameFont(" " + CoinTracker.getCoinCount(), 100, 100);
            addObject(numCoins, 608, 105);
        }
    }
}
