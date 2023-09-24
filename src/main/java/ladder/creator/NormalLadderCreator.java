package ladder.creator;

import ladder.position.LadderPosition;
import ladder.core.LadderSize;
import ladder.NaturalNumber;
import ladder.core.Row;

public class NormalLadderCreator implements LadderCreator{
    private final Row[] rows;

    public NormalLadderCreator(LadderSize ladderSize) {
        rows = new Row[ladderSize.getNumberOfRow()];
        for (int i = 0; i < ladderSize.getNumberOfRow(); i++) {
            rows[i] = new Row(NaturalNumber.of(ladderSize.getNumberOfPerson()));
        }
    }

    @Override
    public void drawLine(LadderPosition ladderPosition) {
        rows[ladderPosition.getCurrentRow()].drawLine(ladderPosition.getCurrentColumn());
    }
    @Override
    public Row[] getRows() {
        return rows;
    }
}
