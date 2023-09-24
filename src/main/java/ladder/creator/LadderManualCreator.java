package ladder.creator;

import ladder.LadderSize;
import ladder.NaturalNumber;
import ladder.Position;
import ladder.Row;

public class LadderManualCreator implements LadderCreator{
    private final Row[] rows;
        public LadderManualCreator(LadderSize ladderSize) {
            rows = new Row[ladderSize.getNumberOfRow().getNumber()];
            for (int i = 0; i < ladderSize.getNumberOfRow().getNumber(); i++) {
                rows[i] = new Row(ladderSize.getNumberOfPerson());
            }
        }
    public void drawLine(Position row, Position col){
        rows[row.getValue()].drawLine(col);
    }

    public Row[] getRows(){return rows;}
}
