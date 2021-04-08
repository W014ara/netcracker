package application.task2;

/**
 * A class that describes the player's structure
 *
 * @autor Bezruk Vladislav
 */
public class Player {
    private int startPosition;
    private int currentDice;
    private int winRate;

    /**
     * Class constructor
     *
     * @param startPosition -the original position in the array (before the permutation)
     * @param winRate       - number of wins
     * @param currentDice   - the amount dropped from the dice
     */
    public Player(int startPosition, int winRate, int currentDice) {
        this.startPosition = startPosition;
        this.winRate = winRate;
        this.currentDice = currentDice;
    }

    /**
     * Method that sets the new value of the win rate
     *
     * @param rate - Win rate value
     */
    public void setWinRate(int rate) {
        this.winRate = rate;
    }

    /**
     * A method that sets a new value for the total points dropped from the dice
     *
     * @param diceCount - Dice count value
     */
    public void setCurrentDice(int diceCount) {
        this.currentDice = diceCount;
    }

    /**
     * Start position getter
     *
     * @return - returns the original position of the object in the array
     */
    public int getStartPosition() {
        return this.startPosition;
    }

    /**
     * Current dice getter
     *
     * @return - returns the current amount of points
     */
    public int getCurrentDice() {
        return this.currentDice;
    }

    /**
     * Current win rate getter
     *
     * @return - returns the current number of wins
     */
    public int getWinRate() {
        return this.winRate;
    }
}
