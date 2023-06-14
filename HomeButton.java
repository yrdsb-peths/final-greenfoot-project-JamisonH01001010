import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The home button icon to link back to the title screen
 */
public class HomeButton extends Actor
{
    // HomeButton icon
    GreenfootImage homeButton = new GreenfootImage("home-button.png");
    /**
     * Constructor: Set the image of the home button icon
     */
    public HomeButton(){
        homeButton.scale(80, 80);
        setImage(homeButton);
    }
}
