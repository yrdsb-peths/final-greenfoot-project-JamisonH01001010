import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BlackSquare here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BlackSquare extends Actor
{
    GreenfootImage blackSquare = new GreenfootImage("rounded-square.png");
    
    public BlackSquare(){
        blackSquare.scale(60, 60);
        setImage(blackSquare);
    }
}
