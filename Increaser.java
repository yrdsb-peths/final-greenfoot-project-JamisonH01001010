import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Increaser here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Increaser extends Actor
{
    GreenfootImage plus = new GreenfootImage("increase.png");
    GameFont a = new GameFont("test", 500);
    public Increaser(){
        plus.scale(30, 30);
        setImage(plus);
        
    }
}
