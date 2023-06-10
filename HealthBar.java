import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Font;
/**
 * Write a description of class HealthBar here.
 * 
 * @author https://www.youtube.com/watch?v=oJHP18bhLT0 (Copied froJim Stewart)
 * @version (a version number or a date)
 */
public class HealthBar extends Actor
{
    int HP = 1; // can't be zero, causes dividing by zero error
    int HPBarWidth = 80;
    int HPBarHeight = 15;
    int pixelsPerHP = (int) HPBarWidth/HP; // when losing HP, # of pixels to lose
    public HealthBar(int HP){
        this.HP = HP;
        updateHP();
    }
    public void act()
    {
        updateHP();
    }
    public void updateHP(){
        // For white border
        setImage(new GreenfootImage(HPBarWidth + 2, HPBarHeight + 2));
        GreenfootImage img = getImage();
        img.setColor(Color.WHITE);
        img.drawRect(0, 0, HPBarWidth + 1, HPBarHeight + 1);
        // For red insides
        img.setColor(Color.RED);
        img.fillRect(1, 1, HP * pixelsPerHP, HPBarHeight);
    }
    
    public void loseHealth(int a){
        HP = HP - a;
    }
}
