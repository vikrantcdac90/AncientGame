package be.telemis.game.strategy;

import be.telemis.game.frame.Frame;

import java.util.List;

public interface ScoringStrategy {
    int calculateScore(Frame frame, List<Frame> frames, int frameIndex);
}

