import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Checkmark here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Checkmark extends Actor
{
    GreenfootImage checkmark = new GreenfootImage("checkmark.png");
    public Checkmark(){
        checkmark.scale(50, 50);
        setImage(checkmark);
    }
}
