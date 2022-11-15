package com.github.zipcodewilmington;


import java.util.Random;
import java.util.Scanner;

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

    public void runGame() {

    }

    public printArray(char[] charArray) {
        for (int i = 0; i < charArray.length; i++) {

        }
    }



}
