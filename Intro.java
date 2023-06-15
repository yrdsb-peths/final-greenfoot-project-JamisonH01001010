import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The intro screen when the user first starts the game
 */
public class Intro extends World
{
    // Intro Background
    GreenfootImage introBG = new GreenfootImage("intro.png");
    // Object instantiations
    SFX sfx = new SFX(); 
    MCLostSword ls = new MCLostSword(100);
    MainCharacter m = new MainCharacter();
    Boss b = new Boss();
    Explosion e = new Explosion();
    Continue c1 = new Continue(50);
    Continue c2 = new Continue(50);
    Continue c3 = new Continue(50);
    Continue c4 = new Continue(50);
    Continue c5 = new Continue(50);
    Continue c6 = new Continue(50);
    Continue c7 = new Continue(50);
    // Text
    GameFont g1 = new GameFont("What a great day today!", 500, 500);
    GameFont g2 = new GameFont(". . .", 170, 100); 
    GameFont g3 = new GameFont("Nice sword you have there. . .", 500, 500);
    GameFont g4 = new GameFont("Ugh. . .", 200, 200);
    GameFont g5 = new GameFont("Come visit my dungeon if you want your sword back.", 950, 1000);
    GameFont g6 = new GameFont("Time to get revenge with my spare sword. . .", 950, 1000);
    /**
     * Constructor: Set the inital state of the intro screen 
     */
    public Intro()
    {    
        // Create a new world with 800x600 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        
        // Set Intro background
        introBG.scale(800, 600);
        setBackground(introBG);
        
        addObject(ls, 250, 485);
        addObject(m, 200, 500);
        
        MainCharacter.setIdleControl(false);
        MainCharacter.setNoSwordControl(true);

        addObject(g1, 250, 290);

        addObject(c1, 760, 190);
    }
    /**
     * The storyline of the game that advances upon user pressing the continue button
     */
    public void act(){
        // After each press of the continue button a new "part" of the intro starts
        // Boss.set methods are for setting the bosses multiple animations
        // Continue objects must be readded due to new text overlapping its "clickbox"
        if(Greenfoot.mouseClicked(c1)){
            sfx.getClick().play();
            removeObject(g1);
            removeObject(c1);
            addObject(g2, 170, 90);
            addObject(b, 600, 490);
            addObject(c2, 760, 190);
            Boss.setIdle(false);
            Boss.setAppear(true);
            sfx.getBossAppear().play();
        }
        if(Greenfoot.mouseClicked(c2)){
            sfx.getClick().play();
            removeObject(g2);
            removeObject(c2);
            addObject(g3, 600, 290);
            addObject(c3, 760, 190);
            Boss.setAppear(false);
            Boss.setIdle(true);
        }
        if(Greenfoot.mouseClicked(c3)){
            sfx.getClick().play();
            removeObject(g3);
            removeObject(c3);
            removeObject(ls);
            addObject(g4, 210, 150);
            addObject(e, 200, 500);
            addObject(c4, 760, 190);
            Boss.setIdle(false);
            Boss.setAttack(true);
            sfx.getBossAttack().play();
        }
        if(Greenfoot.mouseClicked(c4)){
            sfx.getClick().play();
            removeObject(g4);
            removeObject(c4);
            addObject(g5, 590, 515);
            addObject(c5, 760, 190);
            Boss.setAttack(false);
            Boss.setIdle(true);
        }
        if(Greenfoot.mouseClicked(c5)){
            sfx.getClick().play();
            removeObject(g5);
            removeObject(c5);
            addObject(g6, 470, 515);
            addObject(c6, 760, 190);
            MainCharacter.setIdleControl(true);
            MainCharacter.setNoSwordControl(false);
        }
        if(Greenfoot.mouseClicked(c6)){
            sfx.getClick().play();
            Boss.setIdle(false);
            Tutorial t = new Tutorial();
            Greenfoot.setWorld(t);
        }
    }
}
