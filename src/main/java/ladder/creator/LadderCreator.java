package ladder.creator;

import ladder.Position;
import ladder.Row;

public interface LadderCreator {
    public void drawLine();
    public void drawLine(Position row, Position col);
    Row[] getRows();
}
