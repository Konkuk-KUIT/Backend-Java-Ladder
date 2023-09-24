package ladder.creator;

import ladder.*;

public interface LadderCreator {

    public void drawLine(Position row, Position col);

    public Row[] getRows();

}