import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BlankMedal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BlankMedal extends Actor
{
    GreenfootImage blankM = new GreenfootImage("blankmedal.png");
    public BlankMedal(){
        blankM.scale(50, 50);
        setImage(blankM);
    }
}
