package be.telemis.game;

import be.telemis.PlayGame;
import be.telemis.game.frame.Frame;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameTest {

    @Test
    public void testAllStrikes() {
        PlayGame game = new PlayGame();
        // Add 5 frames with strikes
        for (int i = 0; i < 5; i++) {
            Frame frame = new Frame(i == 4); // Last frame will allow extra throws
            game.addFrame(frame);
            game.throwBall(15); // Strike
        }

        // Simulate additional throws in the last frame
        Frame lastFrame = game.frames.get(4);
        lastFrame.addThrow(15); // Extra throw 1
        lastFrame.addThrow(15); // Extra throw 2

        // The total score should be 300 for all strikes
        int totalScore = game.calculateTotalScore();
        assertEquals(300, totalScore, "All strikes should result in a perfect score of 300.");
    }

    @Test
    public void testAllSpares() {
        PlayGame game = new PlayGame();

        // Add 5 frames with spares
        for (int i = 0; i < 5; i++) {
            Frame frame = new Frame(i == 4); // Last frame will allow extra throws
            game.addFrame(frame);
            game.throwBall(7);
            game.throwBall(8); // Spare
        }

        // Simulate extra throws in the last frame
        Frame lastFrame = game.frames.get(4);
        lastFrame.addThrow(5); // Extra throw 1
        lastFrame.addThrow(3); // Extra throw 2

        // Total score for each spare: 15 + (next 2 throws)
        // For frames 1 to 4, each frame will be (15 + 7 + 8) = 30
        // The last frame will be 15 + 5 + 3 = 23
        // Total = 4 * 30 + 23 = 120 + 23 = 143
        int totalScore = game.calculateTotalScore();
        assertEquals(143, totalScore, "The score for all spares with specific bonus throws should be 143.");
    }


    @Test
    public void testMixedStrikesAndSpares() {
        PlayGame game = new PlayGame();

        // Add frames with a mix of strikes and spares
        // Frame 1: Strike
        // Frame 2: Spare
        // Frame 3: 5, 3 (Regular)
        // Frame 4: Strike
        // Frame 5: 4, 6 (Spare)
        for (int i = 0; i < 5; i++) {
            Frame frame = new Frame(i == 4); // Last frame will allow extra throws
            game.addFrame(frame);
            switch (i) {
                case 0, 3:
                    game.throwBall(15); // Strike
                    break;
                case 1:
                    game.throwBall(7);
                    game.throwBall(8); // Spare
                    break;
                case 2:
                    game.throwBall(5);
                    game.throwBall(3); // Regular
                    break;
                case 4:
                    game.throwBall(4);
                    game.throwBall(6); // Spare
                    break;
            }
        }

        // Simulate extra throws in the last frame
        Frame lastFrame = game.frames.get(4);
        lastFrame.addThrow(10); // Extra throw 1 (bonus for last spare)

        // The total score should be computed based on the rules provided.
        // Example calculation: (15 + bonus) + (15 + bonus) + (8) + (15 + bonus) + (15 + 10)
        int totalScore = game.calculateTotalScore();
        assertEquals(121, totalScore, "Mixed strikes and spares should result in the correct calculated score.");
    }

    @Test
    public void testRegularFramesOnly() {
        PlayGame game = new PlayGame();

        // Add a frame with no strike or spare
        Frame frame = new Frame(false); // Not the last frame
        game.addFrame(frame);
        game.throwBall(3);
        game.throwBall(5);
        game.throwBall(6); // Total pins = 14

        int totalScore = game.calculateTotalScore();
        assertEquals(14, totalScore, "The score for a regular frame with throws of 3, 5, and 6 should be 14.");
    }


}




