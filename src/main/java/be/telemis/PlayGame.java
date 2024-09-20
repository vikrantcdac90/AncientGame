package be.telemis;


import be.telemis.game.frame.Frame;
import be.telemis.game.strategy.RegularScoringStrategy;
import be.telemis.game.strategy.ScoringStrategy;
import be.telemis.game.strategy.SpareScoringStrategy;
import be.telemis.game.strategy.StrikeScoringStrategy;

import java.util.ArrayList;
import java.util.List;

public class PlayGame {
    public final List<Frame> frames;
    private static final int MAX_FRAMES = 5;

    public PlayGame() {
        this.frames = new ArrayList<>();
    }

    public void addFrame(Frame frame) {
        if (frames.size() < MAX_FRAMES) {
            frames.add(frame);
        }
    }

    public void throwBall(int pins) {
        Frame currentFrame = getCurrentFrame();
        if (currentFrame != null) {
            currentFrame.addThrow(pins);
        }
    }

    Frame getCurrentFrame() {
        if (frames.isEmpty()) {
            return null;
        }
        return frames.getLast();
    }

    public int calculateTotalScore() {
        int totalScore = 0;

        for (int i = 0; i < frames.size(); i++) {
            Frame currentFrame = frames.get(i);
            ScoringStrategy scoringStrategy = getScoringStrategy(currentFrame);

            int frameScore = scoringStrategy.calculateScore(currentFrame, frames, i);
            totalScore += frameScore;
        }

        return totalScore;
    }

    private ScoringStrategy getScoringStrategy(Frame frame) {
        if (frame.isStrike()) {
            return new StrikeScoringStrategy();
        } else if (frame.isSpare()) {
            return new SpareScoringStrategy();
        } else {
            return new RegularScoringStrategy();
        }
    }

}


