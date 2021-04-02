package netcracker.task1.dicegame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * A class that implements the dice game
 *
 * @autor Bezruk Vladislav
 */
public class Dice {

    /**
     * A method that implements the start of the game and exit to the main menu of the program
     *
     * @throws InterruptedException
     */
    public void play() throws InterruptedException {
        System.out.println("Game menu:");
        Scanner input_menu = new Scanner(System.in);
        int choice;
        outputMainMenu();
        do {
            choice = input_menu.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Game started");
                    startGame();
                    break;
                case 2:
                    System.out.println("Program is over. Exiting");
                    break;
            }
        } while (choice != 2);
    }

    /**
     * A method that implements the continuation of the current game, the selection of dice and exit to the main menu
     *
     * @throws InterruptedException
     */
    private void startGame() throws InterruptedException {
        System.out.println("Select option:");
        Scanner input_menu = new Scanner(System.in);
        int choice;
        outputGameMenu();
        do {
            choice = input_menu.nextInt();
            switch (choice) {
                case 1:
                    game();
                    break;
                case 2:
                    System.out.println("Exit to main menu");
                    outputMainMenu();
                    break;
            }
        } while (choice != 2);
    }

    /**
     * The main method of the program, responsible for the basic logic of the game
     *
     * @throws InterruptedException
     */
    private void game() throws InterruptedException {
        Scanner input_players = new Scanner(System.in);
        Scanner input_dice = new Scanner(System.in);
        System.out.print("Player numbers:");
        int players = input_players.nextInt();
        System.out.print("Dice counts:");
        int dice = input_dice.nextInt();
        int winPlayerIndex = 0;
        if (players > 1 && dice >= 1) {
            //Initializing players
            ArrayList<Player> targetPlayers = new ArrayList<Player>();
            for (int index = 0; index < players; ++index) {
                targetPlayers.add(new Player(index, 0, 0));
            }
            int maxWin = 0;
            while (maxWin < 3) {
                for (Player targetPlayer : targetPlayers) {
                    System.out.print("The dice are thrown by the player number:" +
                            (targetPlayer.getStartPosition() + 1) + "\n");
                    int randomly = generateRandomCount(dice);
                    targetPlayer.setCurrentDice(randomly);
                    Thread.sleep(1000);
                    System.out.println("A number appears:" + randomly);
                }
                //Creating an array in which we put all our winning values
                int[] results = new int[targetPlayers.size()];
                for (int index = 0; index < targetPlayers.size(); ++index) {
                    results[index] = targetPlayers.get(index).getCurrentDice();
                }
                Thread.sleep(1000);
                System.out.print("\nThe round was won by the number one player:" +
                        (targetPlayers.get(getMax(results)[1]).getStartPosition() + 1) + "\n");
                System.out.print("He scored: " + getMax(results)[0] + " points!\nNext round!\n");
                //Updating the winner's win rate
                targetPlayers.get(getMax(results)[1]).setWinRate(targetPlayers.get(getMax(results)[1]).getWinRate() + 1);
                //Find the maximum number of wins and write down the index of the winner!
                int[] winless = new int[targetPlayers.size()];
                for (int index = 0; index < targetPlayers.size(); ++index) {
                    winless[index] = targetPlayers.get(index).getWinRate();
                }
                //Putting the winner in first place
                winPlayerIndex = targetPlayers.get(getMax(winless)[1]).getStartPosition();
                maxWin = getMax(winless)[0];
                Collections.swap(targetPlayers, 0, getMax(results)[1]);
                //Resetting the player arrays
                for (Player targetPlayer : targetPlayers) {
                    targetPlayer.setCurrentDice(0);
                }
                Thread.sleep(1000);
            }
            System.out.print("\n\nGame is over! The number one player won: " + (winPlayerIndex + 1) + "\n");

        } else {
            System.out.println("Invalid data format!");
        }
        outputGameMenu();
    }

    /**
     * Structure of the main menu
     */
    private static void outputMainMenu() {
        System.out.println("1) Start game");
        System.out.println("2) Exit");
    }

    /**
     * In-game menu
     */
    private static void outputGameMenu() {
        System.out.println("1) Enter the number of players and dice");
        System.out.println("2) Exit to main menu");
    }

    /**
     * The method responsible for dropping points from the dice, depending on the number of dice
     *
     * @param diceCount - number of dice
     * @return - returns an array that stores the score value and the index of the winner
     */
    private int generateRandomCount(int diceCount) {
        int result = 0;
        for (int index = 0; index < diceCount; ++index) {
            result = result + (1 + (int) (Math.random() * 6));
        }
        return result;
    }

    /**
     * Method that searches for the maximum in an array
     *
     * @param inputArray - target array
     * @return - returns an array with the maximum value and the index of the maximum element
     */
    private int[] getMax(int[] inputArray) {
        int maxValue = inputArray[0];
        int endingIndex = 0;
        for (int index = 1; index < inputArray.length; ++index) {
            if (inputArray[index] > maxValue) {
                maxValue = inputArray[index];
                endingIndex = index;
            }
        }
        return new int[]{maxValue, endingIndex};
    }
}


