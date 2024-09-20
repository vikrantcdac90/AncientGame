package be.telemis.game.strategy;


import be.telemis.game.frame.Frame;

import java.util.List;

public class StrikeScoringStrategy implements ScoringStrategy {
    @Override
    public int calculateScore(Frame frame, List<Frame> frames, int frameIndex) {
        int score = 15;
        int bonusThrows = 0;
        int bonusScore = 0;

        // Collect the next three throws as bonus
        for (int i = frameIndex + 1; i < frames.size() && bonusThrows < 3; i++) {
            Frame nextFrame = frames.get(i);
            List<Integer> nextFrameThrows = nextFrame.getThrowsInFrame();

            for (Integer pins : nextFrameThrows) {
                if (bonusThrows < 3) {
                    bonusScore += pins;
                    bonusThrows++;
                }
            }
        }

        // If it's the last frame, simulate the additional throws
        if (frameIndex == frames.size() - 1 && bonusThrows < 3) {
            Frame lastFrame = frames.get(frameIndex);
            List<Integer> lastFrameThrows = lastFrame.getThrowsInFrame();
            for (Integer pins : lastFrameThrows) {
                if (bonusThrows < 3) {
                    bonusScore += pins;
                    bonusThrows++;
                }
            }
        }

        score += bonusScore;
        return score;
    }
}






