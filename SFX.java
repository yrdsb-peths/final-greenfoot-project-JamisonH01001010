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
    
    // Sound effects variables
    static boolean setClick = false;
    static boolean setNormalAttack = false;
    static boolean setMCBarrier = false;
    static boolean setMCStunSmash = false;
    static boolean setMCDeath = false;
    static boolean setSGDeath = false;
    static boolean setWizardATK1 = false;
    static boolean setWizardATK2 = false;
    static boolean setWizardDeath = false;
    static boolean setFKATK2 = false;
    static boolean setFKDefend = false;
    static boolean setFKDeath = false;
    static boolean setBossATK = false;
    static boolean setBossConsumeSummon = false;
    static boolean setBossDodge = false;
    static boolean setBossDeath = false;

    /**
     * Play corresponding SFX
     */
    public void act()
    {
        if(setClick){
            click.play();
        }
        if(setNormalAttack){
            normalAttack.play();
        }
        if(setMCBarrier){
            mcBarrier.play();
        }
        if(setMCStunSmash){
            mcStunSmash.play();
        }
        if(setMCDeath){
            mcDeath.play();
        }
        if(setSGDeath){
            SGDeath.play();
        }
        if(setWizardATK1){
            wizardATK1.play();
        }
        if(setWizardATK2){
            wizardATK2.play();
        }
        if(setWizardDeath){
            wizardDeath.play();
        }
        if(setFKATK2){
            fireKnightAttack2.play();
        }
        if(setFKDefend){
            fireKnightDefend.play();
        }
        if(setFKDeath){
            fireKnightDeath.play();
        }
        if(setBossATK){
            bossAttack.play();
        }
        if(setBossConsumeSummon){
            bossConsumeSummon.play();
        }
        if(setBossDodge){
            bossDodge.play();
        }
        if(setBossDeath){
            bossDeath.play();
        }
    }
    /**
     * Set the boolean controlling SFX of clicking
     * @param1 the new boolean value
     */
    public void setClick(boolean a){
        setClick = a;
    }
    /**
     * Set the boolean controlling SFX of a normal attack
     * @param1 the new boolean value
     */
    public void setNormalAttack(boolean a){
        setNormalAttack = a;
    }
    /**
     * Set the boolean controlling SFX of mc's barrier
     * @param1 the new boolean value
     */
    public void setMCBarrier(boolean a){
        setMCBarrier = a;
    }
    /**
     * Set the boolean controlling SFX of mc's stun smash
     * @param1 the new boolean value
     */
    public void setMCStunSmash(boolean a){
        setMCStunSmash = a;
    }
    /**
     * Set the boolean controlling SFX of mc's death
     * @param1 the new boolean value
     */
    public void setMCDeath(boolean a){
        setMCDeath = a;
    }
    /**
     * Set the boolean controlling SFX of skeleton/goblin death
     * @param1 the new boolean value
     */
    public void setSGDeath(boolean a){
        setSGDeath = a;
    }
    /**
     * Set the boolean controlling SFX of wizard atk1
     * @param1 the new boolean value
     */
    public void setWizardATK1(boolean a){
        setWizardATK1 = a;
    }
    /**
     * Set the boolean controlling SFX of wizard atk2
     * @param1 the new boolean value
     */
    public void setWizardATK2(boolean a){
        setWizardATK2 = a;
    }
    /**
     * Set the boolean controlling SFX of wizard death
     * @param1 the new boolean value
     */
    public void setWizardDeath(boolean a){
        setWizardDeath = a;
    }
    /**
     * Set the boolean controlling SFX of fire knight atk2
     * @param1 the new boolean value
     */
    public void setFKATK2(boolean a){
        setFKATK2 = a;
    }
    /**
     * Set the boolean controlling SFX of fire knight defend
     * @param1 the new boolean value
     */
    public void setFKDefend(boolean a){
        setFKDefend = a;
    }
    /**
     * Set the boolean controlling SFX of fire knight death
     * @param1 the new boolean value
     */
    public void setFKDeath(boolean a){
        setFKDeath = a;
    }
    /**
     * Set the boolean controlling SFX of boss atk
     * @param1 the new boolean value
     */
    public void setBossATK(boolean a){
        setBossATK = a;
    }
    /**
     * Set the boolean controlling SFX of boss consuming summons
     * @param1 the new boolean value
     */
    public void setBossConsumeSummon(boolean a){
        setBossConsumeSummon = a;
    }
    /**
     * Set the boolean controlling SFX of boss dodge
     * @param1 the new boolean value
     */
    public void setBossDodge(boolean a){
        setBossDodge = a;
    }
    /**
     * Set the boolean controlling SFX of boss death
     * @param1 the new boolean value
     */
    public void setBossDeath(boolean a){
        setBossDeath = a;
    }
}
