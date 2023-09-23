package ladder.creator;

import ladder.NaturalNumber;
import ladder.Position;
import ladder.Row;

public class DefaultLadderCreator implements LadderCreator{

    private final Row[] rows;

    public DefaultLadderCreator(NaturalNumber numberOfRow, NaturalNumber numberOfPerson) {
        rows = new Row[numberOfRow.getNumber()];
        for (int i = 0; i < numberOfRow.getNumber(); i++) {
            rows[i] = new Row(numberOfPerson);
        }
    }

    @Override
    public void drawLine() {

    }

    @Override
    public void drawLine(Position row, Position col) {
        rows[row.getValue()].drawLine(col);
    }

    public Row[] getRows() {
        return rows;
    }

}
