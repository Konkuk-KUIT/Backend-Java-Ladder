package ladder;

import static ladder.ExceptionMessage.*;

public class Ladder {

    //private final int[][] rows;
    private final Row[] rows;

    public Ladder(NaturalNumber numberOfRow, NaturalNumber numberOfPerson) {
        rows = new Row[numberOfRow.getNumber()];
        for(int i=0; i<numberOfRow.getNumber(); i++) {
            rows[i] = new Row(numberOfPerson);
        }
    }

    public void drawLine(Position row, Position col) {
        rows[row.getPosition()].drawLine(col);
    }

    public Position run(Position position) {
        for(int i=0; i<rows.length; i++) {
            position = rows[i].moveLine(position);
        }
        return position;
    }

}