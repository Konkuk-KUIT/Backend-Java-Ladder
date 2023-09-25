package creator;

import ladder.Position;
import ladder.Row;

public interface LadderCreator {
    public abstract void drawLine(Position row, Position startColumn);
    Row[] getRows();
}
