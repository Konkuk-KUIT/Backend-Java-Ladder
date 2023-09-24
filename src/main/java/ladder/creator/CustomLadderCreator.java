package ladder.creator;

import ladder.position.LadderPosition;
import ladder.core.LadderSize;
import ladder.utils.NaturalNumber;
import ladder.core.Row;

public class CustomLadderCreator implements LadderCreator {

    private final Row[] rows;
    private final LadderSize ladderSize;

    public CustomLadderCreator(LadderSize ladderSize) {
        this.ladderSize = ladderSize;
        rows = new Row[ladderSize.getHeight()];
        for (int i = 0; i < ladderSize.getHeight(); i++) {
            rows[i] = new Row(NaturalNumber.of(ladderSize.getWidth()));
        }
    }

    public LadderSize getLadderSize() {
        return ladderSize;
    }

    @Override
    public void drawLine(LadderPosition ladderPosition) {
        rows[ladderPosition.getRowPosition()].drawLine(ladderPosition.getCol());
    }

    @Override
    public Row[] getRows() {
        return rows;
    }
}
