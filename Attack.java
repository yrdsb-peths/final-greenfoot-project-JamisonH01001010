import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Attack here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Attack extends Actor
{
    private static int atkCount = 5;
    GreenfootImage atk = new GreenfootImage("attack.png");
    public Attack(){
        atk.scale(40, 40);
        setImage(atk);
    }
    
    public static void increaseAtk(){
        // Cap 999 ATK
        if(atkCount < 999 && CoinTracker.getCoinCount() >= 5){
            atkCount += 3;
            CoinTracker.setCoinCount(-5);
        }
    }
    
    public static int getAtkCount(){
        return atkCount;
    }
}
