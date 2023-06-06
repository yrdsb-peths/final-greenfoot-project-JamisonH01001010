import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Barrier here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Barrier extends Actor
{
    GreenfootImage barrier = new GreenfootImage("barrier.png");
    public Barrier(){
        barrier.scale(50, 50);
        setImage(barrier);
    }
}
