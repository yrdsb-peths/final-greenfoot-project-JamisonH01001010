import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TestWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TestWorld extends World
{
    MainCharacter mc = new MainCharacter();
    Attack a = new Attack();
    Barrier b = new Barrier();
    StunSmash s = new StunSmash();
    Attack a2 = new Attack();
    
    boolean turn = true;
    int pause = 100;
    public TestWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        addObject(mc, 300, 200);
        addObject(a, 100, 100);
        addObject(b, 100, 200);
        addObject(s, 100, 300);
    }
    
    public void act(){
        if(turn){
            if(Greenfoot.mouseClicked(a)){
                MainCharacter.setIdleControl(false);
                MainCharacter.setAttackControl(true);
                turn = false;
            }
            if(Greenfoot.mouseClicked(b)){
                mc.shield();
            }
            if(Greenfoot.mouseClicked(s)){
                mc.stunAnimation();
            }
        }
        if(!turn){
            if(pause > 0){
                pause--;
            }
            if(pause == 0){
                addObject(a2, 400, 100);
            }
        }
    }
}
