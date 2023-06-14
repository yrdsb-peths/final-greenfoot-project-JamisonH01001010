import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The help button to link to the tutorial menu
 */
public class Help extends Actor
{
    // Help icon
    GreenfootImage help = new GreenfootImage("question-mark.png");
    /**
     * Constructor: Set the image of the help icon
     */
    public Help(){
        help.scale(70, 70);
        setImage(help);
    }
}
