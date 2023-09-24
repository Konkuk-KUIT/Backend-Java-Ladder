package ladder.creator;

import ladder.Random;
import ladder.position.LadderPosition;
import ladder.core.LadderSize;
import ladder.NaturalNumber;
import ladder.core.Row;

public class RandomLadderCreator implements LadderCreator{

    private final Row[] rows;
    public RandomLadderCreator(LadderSize ladderSize) {
        rows = new Row[ladderSize.getNumberOfRow()];
        for (int i = 0; i < ladderSize.getNumberOfRow(); i++) {
            rows[i] = new Row(NaturalNumber.of(ladderSize.getNumberOfPerson()));
        }
        drawLines(ladderSize);
    }

    @Override
    public void drawLine(LadderPosition ladderPosition) {
        rows[ladderPosition.getCurrentRow()].drawLine(ladderPosition.getCurrentColumn());
    }
    @Override
    public Row[] getRows() {
        return rows;
    }

    private void drawLines(LadderSize ladderSize) {
        Random random = new Random(ladderSize);
        for (int i = 0; i < random.lineCount(ladderSize); i++) {
            try {
                drawLine(random.randomPosition(ladderSize));
            } catch (IllegalArgumentException e) {
                i--;
            }
        }
    }
}
