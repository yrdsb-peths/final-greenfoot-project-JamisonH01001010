import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The displaying and tracking of the user's coin/token count
 */
public class CoinTracker extends Actor
{
    private static int coinCount = 0; // user starts at 0 coins
    // Coins/Tokens icon
    GreenfootImage coins = new GreenfootImage("coins.png");
    /**
     * Constructor: Set the image of the coins icon
     */
    public CoinTracker(){
        coins.scale(150, 50);
        setImage(coins);
    }
    /**
     * Get the current coins/tokens held by the user
     * @return the number of coins/tokens currently saved
     */
    public static int getCoinCount(){
        return coinCount;
    }
    /**
     * Add a specified amount of coins/tokens to the user's coin/token bank
     * @param1 the amount added to the current coin value
     */
    public static void addCoinCount(int a){
        coinCount += a;
    }
}
