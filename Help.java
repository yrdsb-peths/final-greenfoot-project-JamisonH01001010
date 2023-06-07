import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Help here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Help extends Actor
{
    GreenfootImage help = new GreenfootImage("question-mark.png");
    public Help(){
        help.scale(70, 70);
        setImage(help);
    }
}
