        package com.github.zipcodewilmington.sample;
        import java.util.Random;
        import java.util.Scanner;
        public class WordGuess {

                public static void main(String[]args) {
                    Scanner scanner = new Scanner(System.in) ;
                    System.out.println("Welcome to WordGuess Game:");
                    System.out.println("=======================");
                    System.out.println("Current Guess:");
                    String a = scanner.next();
                    System.out.println("You have 3 Guesses");
                    String[] words ={"Cat","Dog","Bird"};
                    Random random = new Random();
                    String secret_Word = words[random.nextInt(words.length)];
                    int numberOftries=words.length;

                    boolean[] guessedLetter=new boolean[(secret_Word.length())];
                    int Max_Attempts=3;
                    int attempts =0;
                    {
                        while (numberOftries < Max_Attempts) {
                            for (int i = 0; i < secret_Word.length(); i++) {
                                if (guessedLetter[i]) {
                                    System.out.println(secret_Word.charAt(i) + "");
                                } else {
                                    System.out.println("_");
                                }
                            }
                            System.out.println("Guess a letter:");
                            String guess = scanner.nextLine().toLowerCase();
                            boolean correctGuess = false;
                            for (int i = 0; i < secret_Word.length(); i++) {
                                if (secret_Word.charAt(i) == guess.charAt(0)) {
                                    guessedLetter[i] = true;
                                    correctGuess = true;
                                }
                            }
                            attempts++;
                            boolean wordGuessed = true;
                            for (boolean guessed : guessedLetter) {
                                if (!guessed) {
                                    wordGuessed = false;
                                    break;
                                }
                            }
                            if (wordGuessed) {
                                System.out.println("Congratulations! You guessed the word" + secret_Word);
                                break;
                            }
                            if (!correctGuess) {
                                System.out.println("IncorrectGuess:" + (Max_Attempts));
                                {
                                    System.out.println("Sorry you run out of Attempts");
                                }
                            }
                            scanner.close();
                        }
                    }

                }}







