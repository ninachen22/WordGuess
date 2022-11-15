package com.github.zipcodewilmington;


import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.SynchronousQueue;

/**
 * @author xt0fer
 * @version 1.0.0
 * @date 5/27/21 11:02 AM
 */

//nina
public class Hangman {

    public Hangman() {}

    public static void main(String[] args) {
        Hangman game = new Hangman();
        game.runGame();
    }

    Scanner scanner = new Scanner(System.in);
    Random rand = new Random();
    int wordGenerator = rand.nextInt(3);
    int numOfGuesses = 0;
    String[] wordBank = {"bye", "hog", "and"};

    char[] randomWord;

    char[] blankArr;

    public void runGame() {
        announceGame();
        initializeGameState();
        //System.out.println(randomWord.toString() + blankArr.toString());
        while (askToPlayAgain()) {
            while (!isWordGuessed()) {
                printCurrentState();
                //char guess = getNextGuess();
                process(getNextGuess());
                numOfGuesses++;
            }
            playerWon();
            if (numOfGuesses == 5) {
                System.exit(0);
            }
            askToPlayAgain();
        }
        gameOver();
    }

    public void printArray(char[] charArray) {
        for (int i = 0; i < charArray.length; i++) {
            System.out.print(charArray[i] + " ");
        }
    }

    public void announceGame() {
        System.out.println("Welcome to hangman!");
    }

    public void gameOver() {
        System.out.println("Game over.");
    }

    public void initializeGameState() {
        blankArr = new char[]{'_', '_', '_'};
        randomWord = wordBank[wordGenerator].toCharArray();
        //return guessedByPlayer;
    }

    public Character getNextGuess() {
        System.out.println("Please guess a letter: ");
        //String guess = scanner.nextLine();
        return scanner.next().charAt(0);
    }

    public boolean isWordGuessed() {
        return Arrays.equals(randomWord, blankArr);
    }

    public boolean askToPlayAgain() {
        System.out.println("Would you like to play again?\n1. yes 2. no");
        int playAgainInput = scanner.nextInt();
        if (playAgainInput == 1) {
        } else {
            System.exit(0);
        }
        return true;
    }

    public void printCurrentState() {
        this.printArray(blankArr);
    }

    public void process(Character guess) {
        for (int i = 0; i < randomWord.length; i++) {
            if (randomWord[i] == guess) {
                blankArr[i] = randomWord[i];
            }
        }
    }

    public void randWordToArray() {
        randomWord = wordBank[wordGenerator].toCharArray();
        //return answer;
    }

    public void playerWon() {
        System.out.println("Congrats, you won!");
    }

    public void playerLost() {
        System.out.println("Sorry, maybe try again?");
    }



}
