import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CoinTracker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CoinTracker extends Actor
{
    GreenfootImage coins = new GreenfootImage("coins.png");
    public CoinTracker(){
        coins.scale(100, 100);
        setImage(coins);
    }
}
