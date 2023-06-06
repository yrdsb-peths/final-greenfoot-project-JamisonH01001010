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
    // BladeSlash
    BladeSlash bs = new BladeSlash();
    // Barrier
    Barrier b = new Barrier();
    // Increaser
    Increaser i1 = new Increaser();
    Increaser i2 = new Increaser();
    // Text
    GameFont skillMenu = new GameFont("Skills", 300, 120);
    GameFont numCoins = new GameFont(cCount.toString(), 100, 100);
    GameFont stats = new GameFont("[Stats]", 300, 150);
    GameFont HP = new GameFont("HP:    " + Health.getHealthCount(), 300, 200);
    GameFont ATK = new GameFont("ATK: " + Attack.getAtkCount(), 300, 200);
    GameFont bs1 = new GameFont("Blade Slash", 250, 200);
    GameFont bs2 = new GameFont("Deal 100% of ATK damage", 300, 400);
    GameFont b1 = new GameFont("Barrier", 250, 200);
    GameFont b2 = new GameFont("Create shield randomly", 300, 400);
    GameFont b3 = new GameFont("between 30% - 50% of HP", 300, 400);
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
        // Add BladeSlash
        addObject(bs, 450, 200);
        // Add Barrier
        addObject(b, 450, 330);
        // Text
        addObject(skillMenu, 350, 146);
        addObject(numCoins, 608, 105);
        addObject(stats, 200, 310);
        addObject(HP, 165, 415);
        addObject(ATK, 165, 495);
        addObject(bs1, 550, 250);
        addObject(bs2, 600, 350);
        addObject(b1, 550, 390);
        addObject(b2, 600, 480);
        addObject(b3, 600, 500);
        // Add Increasers
        addObject(i1, 350, 318); 
        addObject(i2, 350, 400);
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
