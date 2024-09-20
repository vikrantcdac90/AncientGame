package be.telemis.game.strategy;


import be.telemis.game.frame.Frame;

import java.util.List;

public class SpareScoringStrategy implements ScoringStrategy {
    @Override
    public int calculateScore(Frame frame, List<Frame> frames, int frameIndex) {
        int score = 15;
        int bonusScore = 0;
        int bonusThrows = 0;

        // Collect the next two throws as bonus
        for (int i = frameIndex + 1; i < frames.size() && bonusThrows < 2; i++) {
            Frame nextFrame = frames.get(i);
            for (Integer pins : nextFrame.getThrowsInFrame()) {
                if (bonusThrows < 2) {
                    bonusScore += pins;
                    bonusThrows++;
                }
            }
        }

        // If it’s the last frame and additional throws are needed for the bonus
        if (frameIndex == frames.size() - 1 && bonusThrows < 2) {
            Frame lastFrame = frames.get(frameIndex);
            for (Integer pins : lastFrame.getThrowsInFrame()) {
                if (bonusThrows < 2) {
                    bonusScore += pins;
                    bonusThrows++;
                }
            }
        }

        score += bonusScore;
        return score;
    }
}



