import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pause here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pause extends Actor
{
    GreenfootImage pause = new GreenfootImage("pause.png");
    public Pause(){
        pause.scale(100, 100);
        setImage(pause);
    }
}
