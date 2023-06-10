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
    StunSmash ss = new StunSmash();
    Attack a2 = new Attack();
    HealthBar h = new HealthBar(Health.getHealthCount());
    HealthBar hs = new HealthBar(20);
    
    Skeleton s2 = new Skeleton();
    
    boolean turn = true;
    boolean stun = false;
    int stunTurns = 0;
    int pause = 100;
    int randomStun = 0;
    public TestWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        addObject(mc, 300, 200);
        addObject(a, 100, 100);
        addObject(b, 100, 200);
        addObject(s, 100, 300);
        addObject(h, 300, 150);
        addObject(s2, 500, 200);
        addObject(hs, 500, 120);
        
        turn = true;
        stun = false;
        stunTurns = 0;
    }
    
    public void act(){
        if(stunTurns > 0) {
            stunTurns--;
            if(stunTurns == 0) {
                // Stun duration is over, switch to the next turn and remove the stun indicator
                switchTurn();
            }
        } else { //if no stuns
            if(turn){
                if(pause > 0){
                    pause--;
                }
                if(pause == 0){
                    Skeleton.setIdleControl(true);
                    Skeleton.setAttackControl(false);
                    // Repeat setting if there is stun and skeleton can't act
                    MainCharacter.setIdleControl(true);
                    MainCharacter.setAttackControl(false);
                    MainCharacter.setShieldControl(false);
                    MainCharacter.setStunControl(false);
                    if(Greenfoot.mouseClicked(a)){
                        MainCharacter.setIdleControl(false);
                        MainCharacter.setAttackControl(true);
                        hs.loseHP(Attack.getAtkCount());
                        switchTurn();
                        pause = 100;
                    }
                    if(Greenfoot.mouseClicked(b)){
                        MainCharacter.setIdleControl(false);
                        MainCharacter.setShieldControl(true);
                        switchTurn();
                        pause = 100;
                    }
                    if(Greenfoot.mouseClicked(s)){
                        MainCharacter.setIdleControl(false);
                        MainCharacter.setStunControl(true);
                        hs.loseHP((int) (Attack.getAtkCount() * 0.2));
                        randomStun = Greenfoot.getRandomNumber(2);
                        if(randomStun == 1){
                            applyStun();
                        }
                        switchTurn();
                        pause = 100;
                    }
                }
            } else {
                if(pause > 0){
                    pause--;
                }
                if(pause == 0){
                    MainCharacter.setIdleControl(true);
                    MainCharacter.setAttackControl(false);
                    MainCharacter.setShieldControl(false);
                    MainCharacter.setStunControl(false);
                    Skeleton.setIdleControl(false);
                    Skeleton.setAttackControl(true);
                    removeObject(ss);
                    h.loseHP(4);
                    switchTurn();
                    pause = 100;
                }
            }
        }
    }
    
    private void switchTurn() {
        turn = !turn;
    }

    public void applyStun() {
        stunTurns = 1;
        addObject(ss, 500, 500);
    }
}
