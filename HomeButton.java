import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HomeButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HomeButton extends Actor
{
    GreenfootImage homeButton = new GreenfootImage("homebutton.png");
    
    public HomeButton(){
        homeButton.scale(80, 80);
        setImage(homeButton);
    }
    
    public void returnHome(){
        if(Greenfoot.mouseClicked(this)){
            TitleScreen titleWorld = new TitleScreen();
            Greenfoot.setWorld(titleWorld);
        }
    }
}
