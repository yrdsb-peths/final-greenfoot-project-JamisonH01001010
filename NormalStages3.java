import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The third stage of the game battling a wizard
 */
public class NormalStages3 extends World
{
    // Background
    GreenfootImage stagesBG = new GreenfootImage("normal-stage.png");
    
    // Object instantiations
    // MainCharacter
    MainCharacter mc = new MainCharacter();
    // Wizard
    Wizard w = new Wizard();
    // Attack
    Attack a = new Attack();
    // Barrier
    Barrier b = new Barrier();
    Barrier b2 = new Barrier(); // shield indicator
    // StunSmash
    StunSmash ss1 = new StunSmash();
    StunSmash ss2 = new StunSmash(); // stun indicator
    // Magic
    Magic m = new Magic(); // DOT indicator
    // HealthBar
    HealthBar mcHP = new HealthBar(Health.getHealthCount());
    HealthBar wizardHP = new HealthBar(80); // WizardHP = 80
    // Menu
    Menu m1 = new Menu(580, 580);
    Menu m2 = new Menu(300, 300);
    // Pause
    Pause p1 = new Pause();
    Pause p2 = new Pause();
    // HomeButton
    HomeButton h = new HomeButton();
    
    // Text
    GameFont SA = new GameFont("temp", 100, 100); // "temp" will change to shield value
    GameFont s3Clear1 = new GameFont("Stage 3 CLEAR!", 1000, 500);
    GameFont s3Clear2 = new GameFont("Tokens + 20", 500, 500);
    GameFont s3Fail1 = new GameFont("Stage 3 Fail | Try Again", 1000, 700);
    GameFont s3Fail2 = new GameFont("Tokens + 0", 500, 500);
    GameFont returnHome = new GameFont("RETURN HOME", 900, 500);
    
    // Game Variables
    int shieldAmount = 0;
    int pause = 100;
    boolean turn = true;
    boolean stun = false;
    int stunTurns = 0;
    int randomStun = 0;
    int wizardAction = 0;
    int DOTAction = 0;
    int DOTTurns = 0;
    
    // Stage Variables
    static boolean s3Passed = false;
    boolean s3Over = false;
    boolean s3Clear = false;
    boolean s3Fail = false;
    /**
     * Constructor: Set inital state for stage 3
     */
    public NormalStages3()
    {    
        // Create a new world with 800x600 cells with a cell size of 1x1 pixels.
        super(800, 600, 1, false); 
        
        // Set Stage 3 Background
        stagesBG.scale(800, 600);
        setBackground(stagesBG);
        
        // Characters
        addObject(mc, 250, 350);
        addObject(w, 600, 350);
        
        // HealthBar
        addObject(mcHP, 250, 300);
        addObject(wizardHP, 590, 280);
        
        // Icons
        addObject(a, 120, 250);
        addObject(b, 120, 350);
        addObject(ss1, 120, 450);
        addObject(p1, 400, 100);
        
        // Animations
        MainCharacter.setIdleControl(true);
        Wizard.setIdleControl(true);
        
        // Stage Variables
        turn = true;
        stun = false;
        stunTurns = 0;
        DOTTurns = 0;
        s3Over = false;
        s3Clear = false;
        s3Fail = false;
    }
    /**
     * The main game loop of stage 3, along with detecting whether the user
     * has passed or failed the stage
     */
    public void act(){
        if(!s3Over){
            s3();
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
                if(s3Clear){
                    addObject(m1, 400, 300);
                    addObject(s3Clear1, 610, 580);
                    addObject(s3Clear2, 530, 650);
                    addObject(returnHome, 565, 680);
                    s3Passed = true;
                    Level3.setPassed(true);
                    returnHome();
                }
                if(s3Fail){
                    addObject(m1, 400, 300);
                    addObject(s3Fail1, 622, 580);
                    addObject(s3Fail2, 540, 650);
                    addObject(returnHome, 565, 680);   
                    returnHome();
                }
            }
        }
        
    }
    /**
     * The main logic of stage 3, tracking turns, skills, various effects etc.
     */
    public void s3(){
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
                    Wizard.setIdleControl(true);
                    MainCharacter.setIdleControl(true);
                    if(Greenfoot.mouseClicked(a)){
                        MainCharacter.setIdleControl(false);
                        MainCharacter.setAttackControl(true);
                        applyDOT();
                        wizardHP.loseHP(Attack.getAtkCount());
                        switchTurn();
                        pause = 100;
                    }
                    if(Greenfoot.mouseClicked(b)){
                        MainCharacter.setIdleControl(false);
                        addObject(b2, 250, 430);
                        applyDOT();
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
                        applyDOT();
                        wizardHP.loseHP((int) (Attack.getAtkCount() * 0.2));
                        randomStun = Greenfoot.getRandomNumber(2);
                        if(randomStun == 1){
                            applyStun();
                        }
                        switchTurn();
                        pause = 100;
                    }
                    if(wizardHP.getCurrentHP() == 0){
                        Wizard.setIdleControl(false);
                        Wizard.setDeathControl(true);
                        s3Over = true;
                        s3Clear = true;
                        CoinTracker.addCoinCount(20);
                        pause = 100;
                    }
                }
            } else if(!turn) {
                if(pause > 0){
                    pause--;
                }
                if(pause == 0){
                    MainCharacter.setIdleControl(true);
                    Wizard.setIdleControl(false);
                    removeObject(ss2);
                    wizardAction = Greenfoot.getRandomNumber(2);
                    // Roll 0 [50% chance] = attack 1: Deal 100% of ATK dmg
                    // Roll 1 [50% chance] = attack 2: Deal 75% of ATK dmg + 75% chance add DOT of 40% ATK per turn for 2 turns
                    // DOT = Damage Over Time, bypasses shield
                    if(wizardAction == 0){
                        Wizard.setAttack1Control(true);
                        if(shieldAmount != 0){
                            mcHP.loseHP((int)(20 * ((100 - shieldAmount) / (double) 100)));
                            removeObject(SA);
                            removeObject(b2);
                        } else {
                            mcHP.loseHP(20); // WizardATK = 20
                        }
                    } else {
                        Wizard.setAttack2Control(true);
                        // 75% ATK dmg 
                        if(shieldAmount != 0){
                            mcHP.loseHP((int)(15 * ((100 - shieldAmount) / (double) 100)));
                            removeObject(SA);
                            removeObject(b2);
                        } else {
                            mcHP.loseHP(15); // WizardATK = 20 * 75%
                        }

                        DOTAction = Greenfoot.getRandomNumber(4);
                        // Roll 1, 2, 3 [75% chance] = add DOT effect 2 turns
                        if(DOTAction != 0){
                            DOTTurns = 2;
                            addObject(m, 250, 250);
                        }
                    }
                    shieldAmount = 0;
                    switchTurn();
                    pause = 100;
                }
                if(mcHP.getCurrentHP() == 0){
                    MainCharacter.setIdleControl(false);
                    MainCharacter.setDeathControl(true);
                    s3Over = true;
                    s3Fail = true;
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
     * Apply the damage from the DOT and remove the DOT icon when the DOT is over
     */
    public void applyDOT(){
        if(DOTTurns != 0){
            mcHP.loseHP(8); // WizardATK = 20 * 40%
            DOTTurns--;
        } else {
            removeObject(m);
        }
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
     * Return the whether the user has passed stage 3 before
     * @return if user has passed stage
     */
    public static boolean getS3Passed(){
        return s3Passed;
    }
}
