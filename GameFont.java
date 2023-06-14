import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
/**
 * The font used in the game
 * 
 * @author 
 * Link: https://www.greenfoot.org/topics/65058/0
 */
public class GameFont extends Actor
{
    // Text variables
    private String text;
    private int scale;
    /**
     * Constructor: Create a GameFont from a .ttf file, then draw text according to input
     * @param1 The text to be shown
     * @param2 The size of the text
     * @version Initial version pre-optimization of drawing text
     */
    public GameFont(String text, int scale)
    {
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
    /**
     * Constructor: Create a GameFont from a .ttf file, then draw text according to input
     * @param1 The text to be shown
     * @param2 The size of the text
     * @param3 The size of the blank image the text is drawn on
     * @version Version 2, optimized drawing text for more specfic text problems
     */
    public GameFont(String text, int scale, int imageNum){
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
