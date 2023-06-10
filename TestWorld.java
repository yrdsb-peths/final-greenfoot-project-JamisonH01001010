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
    HealthBar h = new HealthBar(20);
    
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
        addObject(h, 300, 150);
    }
    
    public void act(){
        if(turn){
            if(Greenfoot.mouseClicked(a)){
                MainCharacter.setIdleControl(false);
                MainCharacter.setAttackControl(true);
                h.loseHealth(5);
                h.updateHP();
                turn = false;
            }
            if(Greenfoot.mouseClicked(b)){
                MainCharacter.setIdleControl(false);
                MainCharacter.setShieldControl(true);
                turn = false;
            }
            if(Greenfoot.mouseClicked(s)){
                MainCharacter.setIdleControl(false);
                MainCharacter.setStunControl(true);
                turn = false;
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
