import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Stores the main character's current ATK along with corressponding utility
 */
public class Attack extends Actor
{
    private static int atkCount = 100; // mcATK starts at 5
    // Attack icon
    GreenfootImage atk = new GreenfootImage("attack.png");
    /**
     * Constructor: Set the icon of the attack in battle
     */
    public Attack(){
        atk.scale(40, 40);
        setImage(atk);
    }
    /**
     * Increase the user's ATK by 3 if they have enough coins/tokens (10)
     */
    public static void increaseAtk(){
        // Cap 999 ATK
        if(atkCount < 999 && CoinTracker.getCoinCount() >= 10){
            atkCount += 3;
            CoinTracker.addCoinCount(-10);
        }
    }
    /**
     * Return the user's current ATK value
     * @return current ATK value
     */
    public static int getAtkCount(){
        return atkCount;
    }
}
