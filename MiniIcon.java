import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MiniIcon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MiniIcon extends Actor
{
    GreenfootImage m = new GreenfootImage("mini-icon.png");
    public MiniIcon(){
        m.scale(100, 100);
        setImage(m);
    }
    
}
