import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A collection of various SFX used for attacks, icons, etc.
 */
public class SFX extends Actor
{
    // Sound effects
    static GreenfootSound click = new GreenfootSound("button-124476.mp3");
    static GreenfootSound normalAttack = new GreenfootSound("clean-fast-swooshaiff-14784.mp3");
    static GreenfootSound mcBarrier = new GreenfootSound("shield-guard-6963.mp3");
    static GreenfootSound mcStunSmash = new GreenfootSound("bing1-91919.mp3");
    static GreenfootSound mcDeath = new GreenfootSound("videogame-death-sound-43894.mp3");
    static GreenfootSound SGDeath = new GreenfootSound("monster-death-grunt-131480.mp3");
    static GreenfootSound wizardATK1 = new GreenfootSound("wind-blow-141288.mp3");
    static GreenfootSound wizardATK2 = new GreenfootSound("magic-spell-6005.mp3");
    static GreenfootSound wizardDeath = new GreenfootSound("magic-strike-5856.mp3");
    static GreenfootSound fireKnightAttack2 = new GreenfootSound("fire-magic-6947.mp3");
    static GreenfootSound fireKnightDefend = new GreenfootSound("basic-fire-whoosh-3-104223.mp3");
    static GreenfootSound fireKnightDeath = new GreenfootSound("spade-hacking-sound-with-gore-effects-96909.mp3");
    static GreenfootSound bossAttack = new GreenfootSound("slash1-94367.mp3");
    static GreenfootSound bossConsumeSummon = new GreenfootSound("cig_extinguish-89851.mp3");
    static GreenfootSound bossDodge = new GreenfootSound("whip01-6952.mp3");
    static GreenfootSound bossDeath = new GreenfootSound("umph-47201.mp3");
    
    public static GreenfootSound getClick(){
        return click;
    }
    public static GreenfootSound getNormalAttack(){
        return normalAttack;
    }
    public static GreenfootSound getMCBarrier(){
        return mcBarrier;
    }
    public static GreenfootSound getMCStunSmash(){
        return mcStunSmash;
    }
    public static GreenfootSound getMCDeath(){
        return mcDeath;
    }
    public static GreenfootSound getSGDeath(){
        return SGDeath;
    }
    public static GreenfootSound getWizardATK1(){
        return wizardATK1;
    }
    public static GreenfootSound getWizardATK2(){
        return wizardATK2;
    }
    public static GreenfootSound getFireKnightAttack2(){
        return fireKnightAttack2;
    }
    public static GreenfootSound getFireKnightDefend(){
        return fireKnightDefend;
    }
    public static GreenfootSound getFireKnightDeath(){
        return fireKnightDeath;
    }
    public static GreenfootSound getBossAttack(){
        return bossAttack;
    }
    public static GreenfootSound getBossConsumeSummon(){
        return bossConsumeSummon;
    }
    public static GreenfootSound getBossDodge(){
        return bossDodge;
    }
    public static GreenfootSound getBossDeath(){
        return bossDeath;
    }
}
