import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Menu extends Actor
{
    private int scaleW;
    private int scaleH;
    public Menu(int scaleW, int scaleH){
        this.scaleW = scaleW;
        this.scaleH = scaleH;
        GreenfootImage menu = new GreenfootImage("images/menu.png");
        menu.scale(scaleW, scaleH);
        setImage(menu);
    }
    public void act()
    {
        // Add your action code here.
    }
}
