import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The icons that hold the achievement, options, stages, text in title screen
 */
public class MenuIcons extends Actor
{
    // MenuIcons image
    GreenfootImage menuI = new GreenfootImage("menu-icons.png");
    /**
     * Constructor: Set the image for the menuicons
     */
    public MenuIcons(){
        menuI.scale(200, 200);
        setImage(menuI);
    }
}
