package be.telemis.game.frame;

import java.util.ArrayList;
import java.util.List;

public class Frame {
    private final List<Integer> throwsInFrame;
    private final boolean isLastFrame;

    public Frame(boolean isLastFrame) {
        this.throwsInFrame = new ArrayList<>();
        this.isLastFrame = isLastFrame;
    }

    public void addThrow(int pins) {
        if (throwsInFrame.size() < 3 || isLastFrame) {
            throwsInFrame.add(pins);
        } else {
            throw new IllegalStateException("Cannot add more throws to a non-final frame.");
        }
    }

    public int getTotalPins() {
        return throwsInFrame.stream().mapToInt(Integer::intValue).sum();
    }

    public boolean isStrike() {
        return !throwsInFrame.isEmpty() && throwsInFrame.getFirst() == 15;
    }

    public boolean isSpare() {
        return getTotalPins() == 15 && !isStrike();
    }

    public boolean isLastFrame() {
        return isLastFrame;
    }

    public List<Integer> getThrowsInFrame() {
        return throwsInFrame;
    }
}






