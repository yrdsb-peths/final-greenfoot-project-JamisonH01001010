import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StunSmash here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StunSmash extends Actor
{
    GreenfootImage hammer = new GreenfootImage("hammer.png");
    public StunSmash(){
        hammer.scale(60, 60);
        setImage(hammer);
    }
    
}
