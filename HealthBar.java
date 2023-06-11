import greenfoot.*;

/**
 * Write a description of class HealthBar here.
 * 
 * @author https://www.youtube.com/watch?v=oJHP18bhLT0 (Inspired from Jim Stewart)
 * @version (a version number or a date)
 */

public class HealthBar extends Actor {
    private int maxHP;
    private int currentHP;
    private int barWidth;
    private int barHeight;
    private GreenfootImage img;

    public HealthBar(int maxHP) {
        this.maxHP = maxHP;
        currentHP = maxHP;
        barWidth = 100;
        barHeight = 10;
        img = new GreenfootImage(barWidth, barHeight);

        updateHealthBar();
    }

    public void updateHealthBar() {
        img.clear();

        // Draw the background rectangle
        img.setColor(Color.BLACK);
        img.fillRect(0, 0, barWidth, barHeight);

        // Calculate the width of the filled portion
        int filledWidth = (int) ((double) currentHP / maxHP * barWidth);

        // Draw the filled portion
        img.setColor(Color.RED);
        img.fillRect(0, 0, filledWidth, barHeight);

        setImage(img);
    }

    public void loseHP(int a) {
        currentHP -= a;
        if (currentHP < 0) {
            currentHP = 0;
        }
        updateHealthBar();
    }
    
    public int getCurrentHP(){
        return currentHP;
    }
}
