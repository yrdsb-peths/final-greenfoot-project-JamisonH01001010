import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A Menu for the user to upgrade stats and see their 3 skill descriptions
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
    // StunSmash
    StunSmash s = new StunSmash();
    // Increaser
    Increaser i1 = new Increaser();
    Increaser i2 = new Increaser();
    // HomeButton
    HomeButton h = new HomeButton();
    // Text
    GameFont skillMenu = new GameFont("Skills", 300, 120);
    GameFont numCoins = new GameFont(cCount.toString(), 100, 100);
    GameFont stats = new GameFont("[Stats]", 300, 150);
    GameFont price = new GameFont("[10 tokens per Upgrade]", 350, 400);
    GameFont HP = new GameFont("HP:    " + Health.getHealthCount(), 300, 200);
    GameFont ATK = new GameFont("ATK: " + Attack.getAtkCount(), 300, 200);
    GameFont bs1 = new GameFont("Blade Slash", 300, 250);
    GameFont bs2 = new GameFont("Deal 100% of ATK damage", 300, 400);
    GameFont b1 = new GameFont("Barrier", 250, 200);
    GameFont b2 = new GameFont("Make shield to absorb 25% or", 300, 400);
    GameFont b3 = new GameFont("50% of next incoming attack", 300, 400);
    GameFont s1 = new GameFont("Stun Smash", 300, 250);
    GameFont s2 = new GameFont("Deal 20% of ATK with 50%", 300, 400);
    GameFont s3 = new GameFont("chance to stun for one turn", 300, 400);
    /**
     * Constructor: Set the inital values for the Skill Menu
     */
    public SkillMenu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1, false);
        
        // Play BGM
        if(Options.getMusicCount() % 2 == 0){
            TitleScreen.getBGM().play();
        }
        
        // Add Menu
        addObject(m, 400, 300); 
        // Add CoinTracker
        addObject(c, 650, 88);
        // Add Health
        addObject(health, 300, 318); 
        // Add Attack
        addObject(attack, 300, 400);
        // Add BladeSlash
        addObject(bs, 440, 200);
        // Add Barrier
        addObject(b, 440, 330);
        // Add StunSmash
        addObject(s, 440, 460);
        // Text
        addObject(skillMenu, 350, 146);
        addObject(numCoins, 608, 105);
        addObject(stats, 200, 310);
        addObject(price, 230, 620);
        addObject(HP, 165, 415);
        addObject(ATK, 165, 495);
        addObject(bs1, 565, 270);
        addObject(bs2, 590, 350);
        addObject(b1, 540, 380);
        addObject(b2, 590, 480);
        addObject(b3, 590, 500);
        addObject(s1, 565, 545);
        addObject(s2, 590, 620);
        addObject(s3, 590, 640);
        // Add Increasers
        addObject(i1, 350, 318); 
        addObject(i2, 350, 400);
        // Add HomeButton
        addObject(h, 120, 85);
    }
    /**
     * Continously check if user wants to upgrade stats or return home
     */
    public void act(){
        if(Greenfoot.mouseClicked(i1)){
            SFX.getClick().play();
            Health.increaseHealth();
            removeObject(HP);
            HP = new GameFont("HP:    " + Health.getHealthCount(), 300, 200);
            addObject(HP, 165, 415);
            removeObject(numCoins);
            numCoins = new GameFont(" " + CoinTracker.getCoinCount(), 100, 100);
            addObject(numCoins, 608, 105);
        }
        if(Greenfoot.mouseClicked(i2)){
            SFX.getClick().play();
            Attack.increaseAtk();
            removeObject(ATK);
            ATK = new GameFont("ATK: " + Attack.getAtkCount(), 300, 200);
            addObject(ATK, 165, 495);
            removeObject(numCoins);
            numCoins = new GameFont(" " + CoinTracker.getCoinCount(), 100, 100);
            addObject(numCoins, 608, 105);
        }
        if(Greenfoot.mouseClicked(h)){
            SFX.getClick().play();
            TitleScreen t = new TitleScreen();
            Greenfoot.setWorld(t);
        }
        ach2Completion();
    }
    /**
     * Check if user has enough coins/tokens to unlock achievement 2 (500 coins/tokens)
     */
    public void ach2Completion(){
        if(CoinTracker.getCoinCount() >= 500){
            Achievements.completeAch2();
        }
    }
}
