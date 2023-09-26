package ladder.creator;

import ladder.NaturalNumber;
import ladder.Position;
import ladder.Row;

public class StaticLadderCreator implements LadderCreator {

    private final Row[] rows;

    public StaticLadderCreator(NaturalNumber numberOfRow, NaturalNumber numberOfPerson) {

        rows = new Row[numberOfRow.getNumber()];

        for (int i = 0; i < numberOfRow.getNumber(); i++) {
            rows[i] = new Row(numberOfPerson);
        }
        for (int i = 0; i < numberOfRow.getNumber()-1; i++) {
            drawLine(Position.of(i),Position.of(i+1));
        }
    }

    @Override
    public void drawLine(Position row, Position col) {
        rows[row.getValue()].drawLine(col);
    }

    @Override
    public Row[] getRows() {
        return rows;
    }
}
