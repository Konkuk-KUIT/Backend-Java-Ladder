package ladder;

import static ladder.ExceptionMessage.*;

public class Ladder {

    //private final int[][] rows;
    private final Row[] rows;

    public Ladder(NaturalNumber numberOfRow, NaturalNumber numberOfPerson) {
        rows = new Row[numberOfRow.getNumber()];
        for(int i=0; i<numberOfRow.getNumber(); i++) {
            rows[i] = new Row(numberOfPerson.getNumber());
        }
    }

    public void drawLine(int row, int col) {
        this.rows[row].drawLine(col);
    }

//    public int run(int idx) {
//        for (int i=0; i<rows.length; i++) {
//            idx = moveLine(i, idx);
//        }
//        return idx;
//    }

}