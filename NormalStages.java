import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Stage1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NormalStages extends World
{
    GreenfootImage stagesBG = new GreenfootImage("normal-stage.png");
    
    MainCharacter mc = new MainCharacter();
    Attack a = new Attack();
    Barrier b = new Barrier();
    Barrier b2 = new Barrier();
    StunSmash ss1 = new StunSmash();
    StunSmash ss2 = new StunSmash();
    Attack a2 = new Attack();
    HealthBar mcHP = new HealthBar(Health.getHealthCount());
    HealthBar skeletonHP = new HealthBar(20);
    Skeleton s = new Skeleton();
    
    int shieldAmount = 0;
    GameFont SA = new GameFont("temp", 100, 100);
    
    boolean turn = true;
    boolean stun = false;
    int stunTurns = 0;
    int pause = 100;
    int randomStun = 0;
    public NormalStages()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        
        stagesBG.scale(800, 600);
        setBackground(stagesBG);
        
        // Characters
        addObject(mc, 250, 350);
        addObject(s, 600, 350);
        
        // HealthBar
        addObject(mcHP, 250, 300);
        addObject(skeletonHP, 590, 280);
        
        // Icons
        addObject(a, 120, 250);
        addObject(b, 120, 350);
        addObject(ss1, 120, 450);
        
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
                    MainCharacter.setStunControl(false);
                    if(Greenfoot.mouseClicked(a)){
                        MainCharacter.setIdleControl(false);
                        MainCharacter.setAttackControl(true);
                        skeletonHP.loseHP(Attack.getAtkCount());
                        switchTurn();
                        pause = 100;
                    }
                    if(Greenfoot.mouseClicked(b)){
                        MainCharacter.setIdleControl(false);
                        addObject(b2, 250, 430);
                        shieldAmount = mc.shield();
                        Integer shieldAmountv2 = shieldAmount;
                        SA = new GameFont(Integer.toString(shieldAmountv2) + "%", 100, 100);
                        addObject(SA, 230, 490);
                        switchTurn();
                        pause = 100;
                    }
                    if(Greenfoot.mouseClicked(ss1)){
                        MainCharacter.setIdleControl(false);
                        MainCharacter.setStunControl(true);
                        skeletonHP.loseHP((int) (Attack.getAtkCount() * 0.2));
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
                    MainCharacter.setStunControl(false);
                    Skeleton.setIdleControl(false);
                    Skeleton.setAttackControl(true);
                    removeObject(ss2);
                    if(shieldAmount != 0){
                        mcHP.loseHP((int)(4 * ((100 - shieldAmount) / (double) 100)));
                        removeObject(SA);
                        removeObject(b2);
                    } else {
                        mcHP.loseHP(4);
                    }
                    shieldAmount = 0;
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
        addObject(ss2, 590, 430);
    }
}
