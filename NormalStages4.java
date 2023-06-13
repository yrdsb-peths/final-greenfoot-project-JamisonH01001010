import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class NormalStages4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NormalStages4 extends World
{
    // Background
    GreenfootImage stagesBG = new GreenfootImage("normal-stage.png");
    
    // Object instantiations
    MainCharacter mc = new MainCharacter();
    FireKnight f = new FireKnight();
    FireShield fs = new FireShield();
    Attack a = new Attack();
    Barrier b = new Barrier();
    Barrier b2 = new Barrier(); // shield indicator
    StunSmash ss1 = new StunSmash();
    StunSmash ss2 = new StunSmash(); // stun indicator
    HealthBar mcHP = new HealthBar(Health.getHealthCount());
    HealthBar fireKnightHP = new HealthBar(120); // FireKnightHP = 120
    Menu m1 = new Menu(580, 580);
    Menu m2 = new Menu(300, 300);
    Pause p1 = new Pause();
    Pause p2 = new Pause();
    HomeButton h = new HomeButton();
    
    // Text
    GameFont SA = new GameFont("temp", 100, 100); // "temp" will change to shield value
    GameFont s4Clear1 = new GameFont("Stage 4 CLEAR!", 1000, 500);
    GameFont s4Clear2 = new GameFont("Tokens + 20", 500, 500);
    GameFont s4Fail1 = new GameFont("Stage 4 Fail | Try Again", 1000, 700);
    GameFont s4Fail2 = new GameFont("Tokens + 0", 500, 500);
    GameFont returnHome = new GameFont("RETURN HOME", 900, 500);
    
    // Game Variables
    int shieldAmount = 0;
    int pause = 100;
    boolean turn = true;
    boolean stun = false;
    int stunTurns = 0;
    int randomStun = 0;
    int fireKnightAction = 0;
    boolean fireKnightDefend = false;
    
    // Stage Variables
    static boolean s4Passed = false;
    boolean s4Over = false;
    boolean s4Clear = false;
    boolean s4Fail = false;
    public NormalStages4()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1, false); 
        
        stagesBG.scale(800, 600);
        setBackground(stagesBG);
        
        // Characters
        addObject(mc, 250, 350);
        addObject(f, 600, 250);
        
        // HealthBar
        addObject(mcHP, 250, 300);
        addObject(fireKnightHP, 600, 275);
        
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
        fireKnightDefend = false;
        s4Over = false;
        s4Clear = false;
        s4Fail = false;
    }
    
    public void act(){
        if(!s4Over){
            s4();
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
                s4Passed = true;
                Level4.setPassed(true);
                removeObject(a);
                removeObject(b);
                removeObject(ss1);
                if(s4Clear){
                    addObject(m1, 400, 300);
                    addObject(s4Clear1, 610, 580);
                    addObject(s4Clear2, 530, 650);
                    addObject(returnHome, 565, 680);
                    returnHome();
                }
                if(s4Fail){
                    addObject(m1, 400, 300);
                    addObject(s4Fail1, 622, 580);
                    addObject(s4Fail2, 540, 650);
                    addObject(returnHome, 565, 680);   
                    returnHome();
                }
            }
        }
        
    }
    
    public void s4(){
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
                    FireKnight.setIdleControl(true);
                    // Repeat setting if there is stun and enemy can't act
                    MainCharacter.setIdleControl(true);
                    if(fireKnightDefend){
                        if(Greenfoot.mouseClicked(a)){
                            MainCharacter.setIdleControl(false);
                            MainCharacter.setAttackControl(true);
                            fireKnightHP.loseHP((int) (Attack.getAtkCount() * 0.5));
                            mcHP.loseHP((int) (Attack.getAtkCount() * 2));
                            fireKnightDefend = false;
                            removeObject(fs);
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
                            fireKnightDefend = false;
                            removeObject(fs);
                            switchTurn();
                            pause = 100;
                        }
                        if(Greenfoot.mouseClicked(ss1)){
                            MainCharacter.setIdleControl(false);
                            MainCharacter.setStunControl(true);
                            fireKnightHP.loseHP((int) (Attack.getAtkCount() * 0.2 * 0.5));
                            mcHP.loseHP((int) (Attack.getAtkCount() * 0.2 * 2));
                            randomStun = Greenfoot.getRandomNumber(2);
                            if(randomStun == 1){
                                applyStun();
                            }
                            fireKnightDefend = false;
                            removeObject(fs);
                            switchTurn();
                            pause = 100;
                        }
                        if(fireKnightHP.getCurrentHP() == 0){
                            FireKnight.setIdleControl(false);
                            FireKnight.setDeathControl(true);
                            s4Over = true;
                            s4Clear = true;
                            CoinTracker.addCoinCount(25);
                            pause = 100;
                        }
                    } else {
                        if(Greenfoot.mouseClicked(a)){
                            MainCharacter.setIdleControl(false);
                            MainCharacter.setAttackControl(true);
                            fireKnightHP.loseHP(Attack.getAtkCount());
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
                            fireKnightHP.loseHP((int) (Attack.getAtkCount() * 0.2));
                            randomStun = Greenfoot.getRandomNumber(2);
                            if(randomStun == 1){
                                applyStun();
                            }
                            switchTurn();
                            pause = 100;
                        }
                        if(fireKnightHP.getCurrentHP() == 0){
                            FireKnight.setIdleControl(false);
                            FireKnight.setDeathControl(true);
                            s4Over = true;
                            s4Clear = true;
                            CoinTracker.addCoinCount(25);
                            pause = 100;
                        }
                    }
                }
            } else if(!turn) {
                if(pause > 0){
                    pause--;
                }
                if(pause == 0){
                    MainCharacter.setIdleControl(true);
                    FireKnight.setIdleControl(false);
                    removeObject(ss2);
                    fireKnightAction = Greenfoot.getRandomNumber(100);
                    // Roll 0-49 [50% chance] = attack 1: Deal 100% ATK dmg
                    // Roll 50-74 [25% chance] = attack 2: Deal 166.66...% ATK dmg
                    // Roll 75-99 [25% chance] = defend: Take 50% of incoming dmg, Reflect 200% of incoming dmg
                    if(fireKnightAction <= 49){
                        FireKnight.setAttack1Control(true);
                        if(shieldAmount != 0){
                            mcHP.loseHP((int)(30 * ((100 - shieldAmount) / (double) 100)));
                            removeObject(SA);
                            removeObject(b2);
                        } else {
                            mcHP.loseHP(30); // FireKnightATK = 30
                        }
                    } else if (fireKnightAction <= 74){
                        FireKnight.setAttack2Control(true);
                        if(shieldAmount != 0){
                            mcHP.loseHP((int)(50 * ((100 - shieldAmount) / (double) 100)));
                            removeObject(SA);
                            removeObject(b2);
                        } else {
                            mcHP.loseHP(50); // FireKnightATK = 30 * 166.66%
                        }
                    } else {
                        FireKnight.setDefendControl(true);
                        fireKnightDefend = true;
                        addObject(fs, 600, 430);
                    }
                    shieldAmount = 0;
                    switchTurn();
                    pause = 100;
                }
                if(mcHP.getCurrentHP() == 0){
                    MainCharacter.setIdleControl(false);
                    MainCharacter.setDeathControl(true);
                    s4Over = true;
                    s4Fail = true;
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
    
    public static boolean getS4Passed(){
        return s4Passed;
    }
}
