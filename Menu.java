import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The image background of multiple screens (ex. tutorial, skill menu)
 */
public class Menu extends Actor
{
    // Menu dimensions
    private int scaleW;
    private int scaleH;
    /**
     * Constructor: Set the width and height of a menu and set its image
     * @param1 the width of the menu
     * @param2 the height of the menu
     */
    public Menu(int scaleW, int scaleH){
        this.scaleW = scaleW;
        this.scaleH = scaleH;
        GreenfootImage menu = new GreenfootImage("images/menu.png");
        menu.scale(scaleW, scaleH);
        setImage(menu);
    }
}
