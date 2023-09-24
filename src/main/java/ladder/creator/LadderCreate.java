package ladder.creator;

import ladder.*;
public class LadderCreate implements LadderCreator{
    private final Row[] rows;

    public LadderCreate(NaturalNumber numberOfRow, NaturalNumber numberOfPerson) {
        rows = new Row[numberOfRow.getNumber()];
        for (int i = 0; i < numberOfRow.getNumber(); i++) {
            rows[i] = new Row(numberOfPerson);
        }
    }

    public void drawLine(Position row, Position col) {
        rows[row.getValue()].drawLine(col);
    }

    public Row[] getRows() {
        return rows;
    }

}