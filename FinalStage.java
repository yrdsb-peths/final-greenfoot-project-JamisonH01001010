import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Stage4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FinalStage extends World
{
    // Background
    GreenfootImage finalBG = new GreenfootImage("final-stageBG.jpg");
    
    // Object instantiations  
    MainCharacter mc = new MainCharacter();
    Boss boss = new Boss();
    Attack a = new Attack();
    Barrier b = new Barrier();
    Barrier b2 = new Barrier(); // shield indicator
    StunSmash ss1 = new StunSmash();
    StunSmash ss2 = new StunSmash(); // stun indicator
    HealthBar mcHP = new HealthBar(Health.getHealthCount());
    HealthBar bossHP = new HealthBar(300); // bossHP = 300
    Menu m1 = new Menu(580, 580);
    Menu m2 = new Menu(300, 300);
    Pause p1 = new Pause();
    Pause p2 = new Pause();
    HomeButton h = new HomeButton();
    
    // Text
    GameFont SA = new GameFont("temp", 100, 100); // "temp" will change to shield value
    GameFont s5Clear1 = new GameFont("Stage 5 CLEAR!", 1000, 500);
    GameFont s5Clear2 = new GameFont("Tokens + 50", 500, 500);
    GameFont s5Fail1 = new GameFont("Stage 5 Fail | Try Again", 1000, 700);
    GameFont s5Fail2 = new GameFont("Tokens + 0", 500, 500);
    GameFont returnHome = new GameFont("RETURN HOME", 900, 500);
    
    // Game Variables
    int shieldAmount = 0;
    int pause = 100;
    boolean turn = true;
    boolean stun = false;
    int stunTurns = 0;
    int randomStun = 0;
    
    // Stage Variables
    static boolean s5Passed = false;
    boolean s5Over = false;
    boolean s5Clear = false;
    boolean s5Fail = false;
    public FinalStage()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1, false); 
        
        finalBG.scale(800, 600);
        setBackground(finalBG);
        
        // Characters
        addObject(mc, 250, 350);
        addObject(boss, 600, 350);
        
        // HealthBar
        addObject(mcHP, 250, 300);
        addObject(bossHP, 590, 280);
        
        // Icons
        addObject(a, 120, 250);
        addObject(b, 120, 350);
        addObject(ss1, 120, 450);
        addObject(p1, 400, 100);
        
        // Animations
        MainCharacter.setIdleControl(true);
        Boss.setIdle(true);
        
        // Stage Variables
        turn = true;
        stun = false;
        stunTurns = 0;
        s5Over = false;
        s5Clear = false;
        s5Fail = false;
    }
    
    public void act(){
        if(!s5Over){
            s5();
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
                s5Passed = true;
                Level5.setPassed(true);
                removeObject(a);
                removeObject(b);
                removeObject(ss1);
                if(s5Clear){
                    addObject(m1, 400, 300);
                    addObject(s5Clear1, 610, 580);
                    addObject(s5Clear2, 530, 650);
                    addObject(returnHome, 565, 680);
                    returnHome();
                }
                if(s5Fail){
                    addObject(m1, 400, 300);
                    addObject(s5Fail1, 622, 580);
                    addObject(s5Fail2, 540, 650);
                    addObject(returnHome, 565, 680);   
                    returnHome();
                }
            }
        }
        
    }
    
    public void s5(){
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
                    Boss.setIdle(true);
                    // Repeat setting if there is stun and skeleton can't act
                    MainCharacter.setIdleControl(true);
                    if(Greenfoot.mouseClicked(a)){
                        MainCharacter.setIdleControl(false);
                        MainCharacter.setAttackControl(true);
                        bossHP.loseHP(Attack.getAtkCount());
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
                        bossHP.loseHP((int) (Attack.getAtkCount() * 0.2));
                        randomStun = Greenfoot.getRandomNumber(2);
                        if(randomStun == 1){
                            applyStun();
                        }
                        switchTurn();
                        pause = 100;
                    }
                    if(bossHP.getCurrentHP() == 0){
                        Boss.setIdle(false);
                        Skeleton.setDeathControl(true); //create boss death anim
                        s5Over = true;
                        s5Clear = true;
                        CoinTracker.addCoinCount(50);
                        pause = 100;
                    }
                }
            } else if(!turn) {
                if(pause > 0){
                    pause--;
                }
                if(pause == 0){
                    MainCharacter.setIdleControl(true);
                    Boss.setIdle(false);
                    
                    
                    // Randomize
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
                    s5Over = true;
                    s5Fail = true;
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
    
    public static boolean getS5Passed(){
        return s5Passed;
    }
}
