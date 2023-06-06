import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Attack here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Attack extends Actor
{
    private static int atkCount = 999;
    GreenfootImage atk = new GreenfootImage("attack.png");
    public Attack(){
        atk.scale(40, 40);
        setImage(atk);
    }
    
    public static int getAtkCount(){
        return atkCount;
    }
    
    public static void increaseAtk(){
        atkCount += 3;
    }
}