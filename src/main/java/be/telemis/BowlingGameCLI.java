package be.telemis;

import be.telemis.game.frame.Frame;

import java.util.Scanner;

public class BowlingGameCLI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PlayGame game = new PlayGame();

        System.out.println("Welcome to the Bowling Game!");
        System.out.println("Each frame consists of 3 throws. Enter the number of pins knocked down (0 to 15).");

        for (int frameNumber = 1; frameNumber <= 5; frameNumber++) {
            Frame currentFrame = new Frame(frameNumber == 5); // Last frame allows extra throws
            game.addFrame(currentFrame);

            System.out.println("\nFrame " + frameNumber + ":");
            for (int throwNumber = 1; throwNumber <= 3; throwNumber++) {
                System.out.print("Throw " + throwNumber + ": Enter pins knocked down: ");
                int pins = scanner.nextInt();

                // Validate the input: number of pins should be between 0 and 15
                while (pins < 0 || pins > 15) {
                    System.out.print("Invalid number of pins. Please enter a number between 0 and 15: ");
                    pins = scanner.nextInt();
                }

                game.throwBall(pins);

                if (throwNumber == 1 && pins == 15) {
                    System.out.println("Strike!");
                    break; // End the frame early after a strike
                }

                if (currentFrame.isSpare() && throwNumber > 1) {
                    System.out.println("Spare!");
                    break; // End the frame early after a spare
                }
            }

            // Show the score after the frame
            int totalScore = game.calculateTotalScore();
            System.out.println("Total Score after Frame " + frameNumber + ": " + totalScore);
        }

        // After all frames, display the final score
        System.out.println("\nGame Over! Your Final Score is: " + game.calculateTotalScore());
    }
}

