import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The first stage of the game battling a skeleton
 */
public class NormalStages1 extends World
{
    // Background
    GreenfootImage stagesBG = new GreenfootImage("normal-stage.png");
    
    // Object instantiations
    // MainCharacter
    MainCharacter mc = new MainCharacter();
    // Skeleton
    Skeleton s = new Skeleton();
    // Attack
    Attack a = new Attack();
    // Barrier
    Barrier b = new Barrier();
    Barrier b2 = new Barrier(); // shield indicator
    // StunSmash
    StunSmash ss1 = new StunSmash();
    StunSmash ss2 = new StunSmash(); // stun indicator
    // HealthBar
    HealthBar mcHP = new HealthBar(Health.getHealthCount());
    HealthBar skeletonHP = new HealthBar(20); // SkeletonHP = 20
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
    GameFont s1Clear1 = new GameFont("Stage 1 CLEAR!", 1000, 500);
    GameFont s1Clear2 = new GameFont("Tokens + 10", 500, 500);
    GameFont s1Fail1 = new GameFont("Stage 1 Fail | Try Again", 1000, 700);
    GameFont s1Fail2 = new GameFont("Tokens + 0", 500, 500);
    GameFont returnHome = new GameFont("RETURN HOME", 900, 500);
    
    // Game Variables
    int shieldAmount = 0;
    int pause = 100;
    boolean turn = true;
    boolean stun = false;
    int stunTurns = 0;
    int randomStun = 0;
    
    // Stage Variables
    static boolean s1Passed = false;
    boolean s1Over = false;
    boolean s1Clear = false;
    boolean s1Fail = false;
    
    // Achievement Variable
    static int timesCleared = 0; // reward ach4 for beating stage 1 10 times
    /**
     * Constructor: Set the inital conditions of stage 1
     */
    public NormalStages1()
    {    
        // Create a new world with 800x600 cells with a cell size of 1x1 pixels.
        super(800, 600, 1, false); 
        
        if(Options.getMusicCount() % 2 == 0){
            TitleScreen.getBGMNormalStages().playLoop();
        }
        
        // Set Stage 1 Background
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
        addObject(p1, 400, 100);
        
        // Animations
        MainCharacter.setIdleControl(true);
        Skeleton.setIdleControl(true);
        
        // Stage Variables
        turn = true;
        stun = false;
        stunTurns = 0;
        s1Over = false;
        s1Clear = false;
        s1Fail = false;
    }
    /**
     * The main game loop of stage 1, along with detecting whether the user
     * has passed or failed the stage
     */
    public void act(){
        if(!s1Over){
            s1();
            if(Greenfoot.mouseClicked(p1)){
                addObject(m2, 400, 300);
                addObject(h, 350, 300);
                addObject(p2, 450, 300);
                TitleScreen.getBGMNormalStages().pause();
            }
            if(Greenfoot.mouseClicked(p2)){
                removeObject(m2);
                removeObject(h);
                removeObject(p2);
                if(Options.getMusicCount() % 2 == 0){
                    TitleScreen.getBGMNormalStages().play();
                }
            }
            if(Greenfoot.mouseClicked(h)){
                TitleScreen.getBGMNormalStages().stop();
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
                if(timesCleared >= 10){
                    Achievements.completeAch4();
                }
                if(s1Clear){
                    addObject(m1, 400, 300);
                    addObject(s1Clear1, 610, 580);
                    addObject(s1Clear2, 530, 650);
                    addObject(returnHome, 565, 680);
                    s1Passed = true;
                    Level1.setPassed(true);
                    returnHome();
                }
                if(s1Fail){
                    addObject(m1, 400, 300);
                    addObject(s1Fail1, 622, 580);
                    addObject(s1Fail2, 540, 650);
                    addObject(returnHome, 565, 680);   
                    returnHome();
                }
            }
        }
        
    }
    /**
     * The main logic of stage 1, tracking turns, skills, various effects etc.
     */
    public void s1(){
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
                    // Repeat setting if there is stun and skeleton can't act
                    MainCharacter.setIdleControl(true);
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
                    if(skeletonHP.getCurrentHP() == 0){
                        Skeleton.setIdleControl(false);
                        Skeleton.setDeathControl(true);
                        s1Over = true;
                        s1Clear = true;
                        timesCleared++;
                        CoinTracker.addCoinCount(10);
                        pause = 100;
                    }
                }
            } else if(!turn) {
                if(pause > 0){
                    pause--;
                }
                if(pause == 0){
                    MainCharacter.setIdleControl(true);
                    Skeleton.setIdleControl(false);
                    Skeleton.setAttackControl(true);
                    removeObject(ss2);
                    if(shieldAmount != 0){
                        mcHP.loseHP((int)(4 * ((100 - shieldAmount) / (double) 100)));
                        removeObject(SA);
                        removeObject(b2);
                    } else {
                        mcHP.loseHP(4); // SkeletonATK = 4
                    }
                    shieldAmount = 0;
                    switchTurn();
                    pause = 100;
                }
                if(mcHP.getCurrentHP() == 0){
                    MainCharacter.setIdleControl(false);
                    MainCharacter.setDeathControl(true);
                    s1Over = true;
                    s1Fail = true;
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
            TitleScreen.getBGMNormalStages().stop();
            TitleScreen t = new TitleScreen();
            Greenfoot.setWorld(t);
        }
    }
    /**
     * Return the whether the user has passed stage 1 before
     * @return if user has passed stage
     */
    public static boolean getS1Passed(){
        return s1Passed;
    }
}
