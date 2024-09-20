package be.telemis.game.strategy;

import be.telemis.game.frame.Frame;

import java.util.List;

public class RegularScoringStrategy implements ScoringStrategy {
    @Override
    public int calculateScore(Frame frame, List<Frame> frames, int frameIndex) {
        return frame.getTotalPins();
    }
}
