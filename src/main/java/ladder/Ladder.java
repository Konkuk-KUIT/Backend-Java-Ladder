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

    public void drawLine(int row, int col) {
        rows[row].drawLine(col);
    }

    public int run(int col) {
        for(int i=0; i<rows.length; i++) {
            col = rows[i].moveLine(col);
        }
        return col;
    }

}