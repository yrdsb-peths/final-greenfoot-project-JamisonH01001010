import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GoldMedal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GoldMedal extends Actor
{
    GreenfootImage goldM = new GreenfootImage("goldmedal.png");
    public void act()
    {
        goldM.scale(50, 50);
        setImage(goldM);
    }
}
