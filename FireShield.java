import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FireShield here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FireShield extends Actor
{
    GreenfootImage fs = new GreenfootImage("fire-shield.png");
    public FireShield(){
        fs.scale(50, 50);
        setImage(fs);
    }
}
