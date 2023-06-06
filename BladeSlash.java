import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BladeSlash here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BladeSlash extends Actor
{
    GreenfootImage sword = new GreenfootImage("WoodSword.png");
    public BladeSlash(){
        sword.scale(50, 50);
        setImage(sword);
    }
}
