import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Stage1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NormalStages2 extends World
{
    // Background
    GreenfootImage stagesBG = new GreenfootImage("normal-stage.png");
    
    // Object instantiations
    MainCharacter mc = new MainCharacter();
    Attack a = new Attack();
    Barrier b = new Barrier();
    Barrier b2 = new Barrier();
    StunSmash ss1 = new StunSmash();
    StunSmash ss2 = new StunSmash();
    HealthBar mcHP = new HealthBar(Health.getHealthCount());

    Menu m = new Menu(580, 580);
    
    // Text
    GameFont SA = new GameFont("temp", 100, 100); // "temp" will change to shield value
    GameFont s2Clear1 = new GameFont("Stage 2 CLEAR!", 1000, 500);
    GameFont s2Clear2 = new GameFont("Tokens + 15", 500, 500);
    GameFont s2Fail1 = new GameFont("Stage 2 Fail | Try Again", 1000, 700);
    GameFont s2Fail2 = new GameFont("Tokens + 0", 500, 500);
    GameFont returnHome = new GameFont("RETURN HOME", 900, 500);
    
    // Game Variables
    int shieldAmount = 0;
    int pause = 100;
    boolean turn = true;
    boolean stun = false;
    int stunTurns = 0;
    int randomStun = 0;
    
    // Stage Variables
    static boolean s2Passed = false;
    boolean s2Over = false;
    boolean s2Clear = false;
    boolean s2Fail = false;
    public NormalStages2()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1, false); 
        
        stagesBG.scale(800, 600);
        setBackground(stagesBG);
        
        // Characters
        addObject(mc, 250, 350);
        
        // HealthBar
        addObject(mcHP, 250, 300);
        
        // Icons
        addObject(a, 120, 250);
        addObject(b, 120, 350);
        addObject(ss1, 120, 450);
        
        // Animations
        MainCharacter.setIdleControl(true);
        MainCharacter.setAttackControl(false);
        MainCharacter.setShieldControl(false);
        MainCharacter.setStunControl(false);
        MainCharacter.setDeathControl(false);
        
        // Stage Variables
        turn = true;
        stun = false;
        stunTurns = 0;
        s2Over = false;
        s2Clear = false;
        s2Fail = false;
    }
    
    public void act(){
        if(!s2Over){
            s2();
        } else { // Level Finished
            if(pause > 0){
                pause--;
            }
            if(pause == 0){
                s2Passed = true;
                if(s2Clear){
                    addObject(m, 400, 300);
                    addObject(s2Clear1, 610, 580);
                    addObject(s2Clear2, 530, 650);
                    addObject(returnHome, 565, 680);
                    returnHome();
                }
                if(s2Fail){
                    addObject(m, 400, 300);
                    addObject(s2Fail1, 622, 580);
                    addObject(s2Fail2, 540, 650);
                    addObject(returnHome, 565, 680);   
                    returnHome();
                }
            }
        }
        
    }
    
    public void s2(){
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

                    // Repeat setting if there is stun and () can't act
                    MainCharacter.setIdleControl(true);
                    MainCharacter.setAttackControl(false);
                    MainCharacter.setStunControl(false);
                    if(Greenfoot.mouseClicked(a)){
                        MainCharacter.setIdleControl(false);
                        MainCharacter.setAttackControl(true);
 
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
                        
                        randomStun = Greenfoot.getRandomNumber(2);
                        if(randomStun == 1){
                            applyStun();
                        }
                        switchTurn();
                        pause = 100;
                    }
                    if(true){ // change

                        s2Over = true;
                        s2Clear = true;
                        CoinTracker.addCoinCount(15);
                        pause = 100;
                    }
                }
            } else if(!turn) {
                if(pause > 0){
                    pause--;
                }
                if(pause == 0){
                    MainCharacter.setIdleControl(true);
                    MainCharacter.setAttackControl(false);
                    MainCharacter.setStunControl(false);

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
                if(mcHP.getCurrentHP() == 0){
                    MainCharacter.setIdleControl(false);
                    MainCharacter.setDeathControl(true);
                    s2Over = true;
                    s2Fail = true;
                    pause = 100;
                }
            }
        }
    }
    
    public void switchTurn() {
        turn = !turn;
    }

    public void applyStun() {
        stunTurns = 1;
        addObject(ss2, 590, 430);
    }
    
    public void returnHome(){
        if(Greenfoot.mouseClicked(returnHome)){
            TitleScreen t = new TitleScreen();
            Greenfoot.setWorld(t);
        }
    }
    
    public static boolean getS2Passed(){
        return s2Passed;
    }
}
