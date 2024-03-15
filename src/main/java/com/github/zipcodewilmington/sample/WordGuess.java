package com.github.zipcodewilmington.sample;
import java.util.Scanner;
import java.util.Random;
public class WordGuess {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String[] words = {"cat", "pet", "bird", "dog"};
        // creating random
        String secretWord = words[random.nextInt(words.length)];

        boolean[] guessedLetters = new boolean[secretWord.length()];

        final int MAX_ATTEMPTS = 3;

        int attempts = 0;

        System.out.println("Welcome to the Word Guess Game!");

        while (attempts < MAX_ATTEMPTS) {

            for (int i = 0; i < secretWord.length(); i++) {
                if (guessedLetters[i]) {
                    System.out.print(secretWord.charAt(i) + " ");
                } else {
                    System.out.print("_ ");
                }
            }
            System.out.println();

            System.out.print("Guess a letter: ");
            String guess = scanner.nextLine().toLowerCase();

            boolean correctGuess = false;
            for (int i = 0; i < secretWord.length(); i++) {
                if (secretWord.charAt(i) == guess.charAt(0)) {
                    guessedLetters[i] = true;
                    correctGuess = true;
                }
            }

            attempts++;

            boolean wordGuessed = true;
            for (boolean guessed : guessedLetters) {
                if (!guessed) {
                    wordGuessed = false;
                    break;
                }
            }

            if (wordGuessed) {
                System.out.println("Congratulations! You guessed the word '" + secretWord + "' correctly in " + attempts + " attempts.");
                break;
            }

            if (!correctGuess) {
                System.out.println("Incorrect guess. Attempts left: " + (MAX_ATTEMPTS - attempts));
            }
        }
        if (attempts >= MAX_ATTEMPTS) {
            System.out.println("Sorry, you have run out of attempts. The word was '" + secretWord + "'.");
        }
        scanner.close();
    }
}