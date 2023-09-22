package ladder.creator;

import ladder.Direction;
import ladder.NaturalNumber;
import ladder.Position;
import ladder.Row;

public class LadderCreator {
    private final Row[] rows;

    public LadderCreator(NaturalNumber numberOfRow, NaturalNumber numberOfPerson) {
        rows = new Row[numberOfRow.getNumber()];
        for (int i = 0; i < numberOfRow.getNumber(); i++) {
            rows[i] = new Row(numberOfPerson.getNumber());
        }
    }

    public void drawLine(NaturalNumber row, Position position, Direction direction) {
        rows[row.getNumber() - 1].drawLine(position, direction);
    }

    public Row[] getRow() {
        return this.rows;
    }
}
