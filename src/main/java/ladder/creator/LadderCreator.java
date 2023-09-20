package ladder.creator;

import ladder.Position;
import ladder.Row;

public interface LadderCreator {

 //   private final Row[] rows;


    void drawLine(Position row, Position col);

    Row[] getRows();
}
