import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
/**
 * Write a description of class GameFont here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameFont extends Actor
{
    private String text;
    private int scale;
    private int imageNum;
    
    public GameFont(String text, int scale)
    {
        this.text = text;
        this.scale = scale;
        
        // Copied Code - https://www.greenfoot.org/topics/65058/0
        File f = new File("DungeonFont.ttf");
        try {
            FileInputStream in = new FileInputStream(f);
            Font dynamicFont, dynamicFont32;
 
            dynamicFont = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(f));
            dynamicFont32 = dynamicFont.deriveFont(32f);
 
            java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(dynamicFont32);
            greenfoot.Font DungeonFont = new greenfoot.Font(dynamicFont32.getName(), dynamicFont32.getStyle() % 2 == 1, dynamicFont32.getStyle() / 2 == 1, dynamicFont32.getSize());
            in.close();
            
            //new code (Location is scuffed, due to font scaling, drawing text, blank image creation)
            GreenfootImage img = new GreenfootImage(350, 350);
            img.setColor(Color.WHITE);
            img.setFont(DungeonFont);
            img.drawString(text, 50, 50);
            img.scale(scale, scale);
            setImage(img);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (FontFormatException e) {
            e.printStackTrace();
        }
    }
    // For more specific text problems
    public GameFont(String text, int scale, int imageNum){
        this.text = text;
        this.scale = scale;
        
        // Copied Code - https://www.greenfoot.org/topics/65058/0
        File f = new File("DungeonFont.ttf");
        try {
            FileInputStream in = new FileInputStream(f);
            Font dynamicFont, dynamicFont32;
 
            dynamicFont = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(f));
            dynamicFont32 = dynamicFont.deriveFont(32f);
 
            java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(dynamicFont32);
            greenfoot.Font DungeonFont = new greenfoot.Font(dynamicFont32.getName(), dynamicFont32.getStyle() % 2 == 1, dynamicFont32.getStyle() / 2 == 1, dynamicFont32.getSize());
            in.close();
            
            //new code (Location is scuffed, due to font scaling, drawing text, blank image creation)
            GreenfootImage img = new GreenfootImage(imageNum, imageNum);
            img.setColor(Color.WHITE);
            img.setFont(DungeonFont);
            img.drawString(text, 50, 50);
            img.scale(scale, scale);
            setImage(img);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (FontFormatException e) {
            e.printStackTrace();
        }
    }
}
