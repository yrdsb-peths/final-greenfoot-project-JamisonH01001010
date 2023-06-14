import greenfoot.*;

/**
 * The healthbar for the user and enemy, scaling off maxHP
 * 
 * @author Inspired from Jim Stewart
 * Link: https://www.youtube.com/watch?v=oJHP18bhLT0
 */

public class HealthBar extends Actor {
    // Health variables
    private int maxHP;
    private int currentHP;
    private int barWidth;
    private int barHeight;
    private GreenfootImage img;
    /**
     * Constructor: Create a healthbar scaling off inputed maxHP and set dimensions
     * @param1 The maxHP of the actor the HealthBar is for 
     */
    public HealthBar(int maxHP) {
        this.maxHP = maxHP;
        currentHP = maxHP;
        barWidth = 100;
        barHeight = 10;
        img = new GreenfootImage(barWidth, barHeight);

        updateHealthBar();
    }
    /**
     * Update the health bar off the currentHP vs. maxHP
     */
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
    /**
     * Make the healthbar lose a specified HP and update it to show the new HP
     * @param1 the amount of HP to be lost
     */
    public void loseHP(int a) {
        currentHP -= a;
        if (currentHP < 0) {
            currentHP = 0;
        }
        updateHealthBar();
    }
    /**
     * Get the currentHP of the actor
     * @return currentHP of the actor
     */
    public int getCurrentHP(){
        return currentHP;
    }
}
