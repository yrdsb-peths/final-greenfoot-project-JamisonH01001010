import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The second stage of the game battling a goblin
 */
public class NormalStages2 extends World
{
    // Background
    GreenfootImage stagesBG = new GreenfootImage("normal-stage.png");
    
    // Object instantiations
    // MainCharacter
    MainCharacter mc = new MainCharacter();
    // Goblin
    Goblin g = new Goblin();
    // Attack
    Attack a = new Attack();
    // Barrier
    Barrier b = new Barrier();
    Barrier b2 = new Barrier();
    // StunSmash
    StunSmash ss1 = new StunSmash();
    StunSmash ss2 = new StunSmash();
    // HealthBar
    HealthBar mcHP = new HealthBar(Health.getHealthCount());
    HealthBar goblinHP = new HealthBar(50); // GoblinHP = 50;
    // Menu
    Menu m1 = new Menu(580, 580);
    Menu m2 = new Menu(300, 300);
    // Pause
    Pause p1 = new Pause();
    Pause p2 = new Pause();
    // HomeButton
    HomeButton h = new HomeButton();
    
    // Text
    GameFont SA = new GameFont("temp", 100, 100); // "temp" will change to mc.shield value
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
    /**
     * Constructor: Set the inital conditions of stage 2
     */
    public NormalStages2()
    {    
        // Create a new world with 800x600 cells with a cell size of 1x1 pixels.
        super(800, 600, 1, false); 
        
        // Set Stage 2 Background
        stagesBG.scale(800, 600);
        setBackground(stagesBG);
        
        // Characters
        addObject(mc, 250, 350);
        addObject(g, 600, 350);
        
        // HealthBar
        addObject(mcHP, 250, 300);
        addObject(goblinHP, 590, 300);
        
        // Icons
        addObject(a, 120, 250);
        addObject(b, 120, 350);
        addObject(ss1, 120, 450);
        addObject(p1, 400, 100);
        
        // Animations
        MainCharacter.setIdleControl(true);
        Goblin.setIdleControl(true);
        
        // Stage Variables
        turn = true;
        stun = false;
        stunTurns = 0;
        s2Over = false;
        s2Clear = false;
        s2Fail = false;
    }
    /**
     * The main game loop of stage 2, along with detecting whether the user
     * has passed or failed the stage
     */
    public void act(){
        if(!s2Over){
            s2();
            if(Greenfoot.mouseClicked(p1)){
                addObject(m2, 400, 300);
                addObject(h, 350, 300);
                addObject(p2, 450, 300);
            }
            if(Greenfoot.mouseClicked(p2)){
                removeObject(m2);
                removeObject(h);
                removeObject(p2);
            }
            if(Greenfoot.mouseClicked(h)){
                TitleScreen t = new TitleScreen();
                Greenfoot.setWorld(t);
            }
        } else { // Level Finished
            if(pause > 0){
                pause--;
            }
            if(pause == 0){
                removeObject(a);
                removeObject(b);
                removeObject(ss1);
                if(s2Clear){
                    addObject(m1, 400, 300);
                    addObject(s2Clear1, 610, 580);
                    addObject(s2Clear2, 530, 650);
                    addObject(returnHome, 565, 680);
                    s2Passed = true;
                    Level2.setPassed(true);
                    returnHome();
                }
                if(s2Fail){
                    addObject(m1, 400, 300);
                    addObject(s2Fail1, 622, 580);
                    addObject(s2Fail2, 540, 650);
                    addObject(returnHome, 565, 680);   
                    returnHome();
                }
            }
        }
        
    }
    /**
     * The main logic of stage 2, tracking turns, skills, various effects etc.
     */
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
                    Goblin.setIdleControl(true);
                    // Repeat setting if there is stun and enemy can't act
                    MainCharacter.setIdleControl(true);
                    if(Greenfoot.mouseClicked(a)){
                        MainCharacter.setIdleControl(false);
                        MainCharacter.setAttackControl(true);
                        goblinHP.loseHP(Attack.getAtkCount());
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
                        goblinHP.loseHP((int) (Attack.getAtkCount() * 0.2));
                        randomStun = Greenfoot.getRandomNumber(2);
                        if(randomStun == 1){
                            applyStun();
                        }
                        switchTurn();
                        pause = 100;
                    }
                    if(goblinHP.getCurrentHP() == 0){ 
                        Goblin.setIdleControl(false);
                        Goblin.setDeathControl(true);
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
                    Goblin.setIdleControl(false);
                    Goblin.setAttackControl(true);
                    removeObject(ss2);
                    if(shieldAmount != 0){
                        mcHP.loseHP((int)(4 * ((100 - shieldAmount) / (double) 100)));
                        removeObject(SA);
                        removeObject(b2);
                    } else {
                        mcHP.loseHP(8); // GoblinATK = 8
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
    /**
     * Change the current turn to the opposite
     */
    public void switchTurn() {
        turn = !turn;
    }
    /**
     * Apply a 1 turn stun and add a stun icon 
     */ 
    public void applyStun() {
        stunTurns = 1;
        addObject(ss2, 590, 430);
    }
    /**
     * Return the user to the title screen
     */
    public void returnHome(){
        if(Greenfoot.mouseClicked(returnHome)){
            TitleScreen t = new TitleScreen();
            Greenfoot.setWorld(t);
        }
    }
    /**
     * Return the whether the user has passed stage 2 before
     * @return if user has passed stage
     */
    public static boolean getS2Passed(){
        return s2Passed;
    }
}
