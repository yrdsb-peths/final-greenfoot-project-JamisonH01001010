import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CoinTracker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CoinTracker extends Actor
{
    private static int coinCount = 0; // user starts at 0 coins
    GreenfootImage coins = new GreenfootImage("coins.png");
    public CoinTracker(){
        coins.scale(150, 50);
        setImage(coins);
    }
    
    public static int getCoinCount(){
        return coinCount;
    }
    
    public static void addCoinCount(int a){
        coinCount += a;
    }
}
