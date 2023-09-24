package ladder.creator;

import ladder.Direction;
import ladder.NaturalNumber;
import ladder.Position;
import ladder.Row;

public interface LadderCreator {
    void drawLine(NaturalNumber row, Position position, Direction direction);

    public Row[] getRow();
}
