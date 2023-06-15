import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A collection of various SFX used for attacks, icons, etc.
 */
public class SFX extends Actor
{
    // Sound effects
    GreenfootSound click = new GreenfootSound("button-124476.mp3");
    // Attack for MC, skeleton, goblin, fireknight atk1
    GreenfootSound normalAttack = new GreenfootSound("clean-fast-swooshaiff-14784.mp3"); 
    GreenfootSound mcBarrier = new GreenfootSound("shield-guard-6963.mp3");
    GreenfootSound mcStunSmash = new GreenfootSound("bing1-91919.mp3");
    GreenfootSound mcDeath = new GreenfootSound("videogame-death-sound-43894.mp3");
    // Death for skeleton and goblin
    GreenfootSound SGDeath = new GreenfootSound("monster-death-grunt-131480.mp3");
    GreenfootSound wizardATK1 = new GreenfootSound("wind-blow-141288.mp3");
    GreenfootSound wizardATK2 = new GreenfootSound("magic-spell-6005.mp3");
    GreenfootSound wizardDeath = new GreenfootSound("magic-strike-5856.mp3");
    GreenfootSound fireKnightAttack2 = new GreenfootSound("fire-magic-6947.mp3");
    GreenfootSound fireKnightDefend = new GreenfootSound("basic-fire-whoosh-3-104223.mp3");
    GreenfootSound fireKnightDeath = new GreenfootSound("spade-hacking-sound-with-gore-effects-96909.mp3");
    GreenfootSound bossAppear = new GreenfootSound("swoosh-142322.mp3");
    GreenfootSound bossAttack = new GreenfootSound("slash1-94367.mp3");
    GreenfootSound bossConsumeSummon = new GreenfootSound("cig_extinguish-89851.mp3");
    GreenfootSound bossDodge = new GreenfootSound("whip01-6952.mp3");
    GreenfootSound bossDeath = new GreenfootSound("umph-47201.mp3");
    /**
     * Get the GreenfootSound variable for click
     * @return click SFX
     */
    public GreenfootSound getClick(){
        return click;
    }
    /**
     * Get the GreenfootSound variable for normal attack
     * @return normal attack SFX
     */
    public GreenfootSound getNormalAttack(){
        return normalAttack;
    }
    /**
     * Get the GreenfootSound variable for mc barrier
     * @return mc barrier SFX
     */
    public GreenfootSound getMCBarrier(){
        return mcBarrier;
    }
    /**
     * Get the GreenfootSound variable for mc stun smash
     * @return mc stun smash SFX
     */
    public GreenfootSound getMCStunSmash(){
        return mcStunSmash;
    }
    /**
     * Get the GreenfootSound variable for mc death
     * @return mc death SFX
     */
    public GreenfootSound getMCDeath(){
        return mcDeath;
    }
    /**
     * Get the GreenfootSound variable for skeleton/goblin death
     * @return skeleton/goblin SFX
     */
    public GreenfootSound getSGDeath(){
        return SGDeath;
    }
    /**
     * Get the GreenfootSound variable for wizard attack1
     * @return wizard attack1 SFX
     */
    public GreenfootSound getWizardATK1(){
        return wizardATK1;
    }
    /**
     * Get the GreenfootSound variable for wizard attack2
     * @return wizard attack2 SFX
     */
    public GreenfootSound getWizardATK2(){
        return wizardATK2;
    }
    /**
     * Get the GreenfootSound variable for wizard death
     * @return wizard death SFX
     */
    public GreenfootSound getWizardDeath(){
        return wizardDeath;
    }
    /**
     * Get the GreenfootSound variable for fire knight attack2
     * @return fire knight attack2 SFX
     */
    public GreenfootSound getFireKnightAttack2(){
        return fireKnightAttack2;
    }
    /**
     * Get the GreenfootSound variable for fire knight defend
     * @return fire knight defend SFX
     */
    public GreenfootSound getFireKnightDefend(){
        return fireKnightDefend;
    }
    /**
     * Get the GreenfootSound variable for fire knight death
     * @return fire knight death SFX
     */
    public GreenfootSound getFireKnightDeath(){
        return fireKnightDeath;
    }
    /**
     * Get the GreenfootSound variable for boss appear
     * @return boss appear SFX
     */
    public GreenfootSound getBossAppear(){
        return bossAppear;
    }
    /**
     * Get the GreenfootSound variable for boss attack
     * @return boss attack SFX
     */
    public GreenfootSound getBossAttack(){
        return bossAttack;
    }
    /**
     * Get the GreenfootSound variable for boss consume summon
     * @return boss consume summon SFX
     */
    public GreenfootSound getBossConsumeSummon(){
        return bossConsumeSummon;
    }
    /**
     * Get the GreenfootSound variable for boss dodge
     * @return boss dodge SFX
     */
    public GreenfootSound getBossDodge(){
        return bossDodge;
    }
    /**
     * Get the GreenfootSound variable for boss death
     * @return boss death SFX
     */
    public GreenfootSound getBossDeath(){
        return bossDeath;
    }
}
