package lotterynumberanalyzer;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Chapter1_Challenge_1_3 {
    public static void main(String[] args) {
        Random rand = new Random();
        try (Scanner scanner = new Scanner(System.in)) {
            int health = 100;
            
            for (int room = 1; room <= 5; room++) {
                System.out.println("Entering room " + room + "...");
                int event = rand.nextInt(3) + 1; // Random number between 1 and 3
                
                switch (event) {
                    case 1: // Trap
                        health -= 20;
                        System.out.println("A trap sprung! Health is now " + health + ".");
                        break;
                    case 2: // Healing potion
                        health += 15;
                        if (health > 100) {
                            health = 100; // Cap health at 100
                            System.out.println("You found a healing potion! Health is now capped to " + health + ".");
                        } else {
                            System.out.println("You found a healing potion! Health is now " + health + ".");
                        }
                        break;
                    case 3: // Monster
                        int monsterNumber = rand.nextInt(5) + 1; // Random number between 1 and 5
                        int guess = 0;
                        boolean validGuess = false;
                        
                        System.out.print("A monster appears! Guess a number (1-5) to defeat it: ");
                        do {
                            try {
                                guess = scanner.nextInt();
                                if (guess < 1 || guess > 5) {
                                    System.out.print("Invalid input! Please guess a number between 1 and 5: ");
                                } else if (guess != monsterNumber) {
                                    System.out.print("Wrong! Try again: ");
                                } else {
                                    validGuess = true; // Correct guess
                                }
                            } catch (InputMismatchException e) {
                                System.out.print("Invalid input! Please enter a number between 1 and 5: ");
                                scanner.next(); // Clear the invalid input
                            }
                        } while (!validGuess);
                        
                        System.out.println("You defeated the monster!");
                        break;
                }
                
                if (health <= 0) {
                    System.out.println("You have been defeated in room " + room + ".");
                    break;
                }
            }
            
            if (health > 0) {
                System.out.println("You cleared the dungeon! Victorious with " + health + " health!");
            }
        }
    }
}