package ladder.core;

import ladder.Direction;
import ladder.Ladder;
import ladder.LadderPosition;

public interface LadderCreator {

    Ladder createLadder(int numberOfRow, int numberOfPerson);
    void drawLine(Ladder ladder, LadderPosition position, Direction direction);
}
