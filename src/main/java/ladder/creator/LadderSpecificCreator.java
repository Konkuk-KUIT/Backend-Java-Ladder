package ladder.creator;

import ladder.Direction;
import ladder.NaturalNumber;
import ladder.Position;
import ladder.Row;

import java.util.Random;

public class LadderSpecificCreator implements LadderCreator {
    private final Row[] rows;
    private final LadderSize ladderSize;

    public LadderSpecificCreator(NaturalNumber numberOfRow, NaturalNumber numberOfPerson) {
        this.ladderSize = new LadderSize(numberOfRow, numberOfPerson);
        rows = new Row[numberOfRow.getNumber()];
        for (int i = 0; i < numberOfRow.getNumber(); i++) {
            rows[i] = new Row(numberOfPerson.getNumber());
        }
    }

    @Override
    public void drawLine(NaturalNumber row, Position position, Direction direction) {
        rows[row.getNumber() - 1].drawLine(position, direction);
    }
    @Override
    public void drawLine() {}

    @Override
    public Row[] getRow() {
        return this.rows;
    }
}
