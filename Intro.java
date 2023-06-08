import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Intro here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Intro extends World
{
    // Intro Background
    GreenfootImage introBG = new GreenfootImage("intro.png");
    
    // Object instantiations
    // MCLostSword 
    MCLostSword ls = new MCLostSword();
    // MainCharacter
    MainCharacter m = new MainCharacter();
    // Boss
    Boss b = new Boss();
    // Text
    GameFont g1 = new GameFont("What a great day today!", 500, 500);
    GameFont g2 = new GameFont(". . .", 170, 100); 
    GameFont g3 = new GameFont("Nice sword you have there. . .", 500, 500);
    GameFont g4 = new GameFont("Ugh. . .", 200, 200);
    GameFont g5 = new GameFont("Come visit my dungeon if you want your sword back.", 950, 1000);
    GameFont g6 = new GameFont("Time to get revenge with my spare sword. . .", 950, 1000);
    // Continue 
    Continue c = new Continue(50);
    public Intro()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        
        // Set Intro background
        introBG.scale(800, 600);
        setBackground(introBG);
        
        // Add MCLostSword
        addObject(ls, 250, 485);
        
        // Add MainCharacter
        addObject(m, 200, 500);
        
        // Text
        //addObject(g1, 250, 290);
        //addObject(g2, 170, 90);
        //addObject(g3, 600, 290);
        //addObject(g4, 210, 150);
        //addObject(g5, 590, 515);
        //addObject(g6, 470, 515);
        
        // Continue 
        addObject(c, 760, 190);
    
    }
    
    public void act(){
        if(Greenfoot.mouseClicked(c)){
            removeObject(g1);
            addObject(b, 500, 500);
        }
    }
}
