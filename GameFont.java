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
    private int size;
    private int scale;
    
    public GameFont(String text, int size, int scale)
    {
        this.text = text;
        this.size = size;
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
            
            //new code
            GreenfootImage img = new GreenfootImage(size*2, size*2);
            img.setColor(Color.WHITE);
            img.setFont(DungeonFont);
            img.drawString(text, size, size);
            img.scale(2000, 2000);
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
