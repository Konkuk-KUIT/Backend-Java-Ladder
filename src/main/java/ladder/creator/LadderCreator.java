package ladder.creator;

import ladder.*;

import java.util.HashSet;

public class LadderCreator implements Draw {

    private final Row[] rows;
    private LadderSize ladderSize;
    //private HashSet<>

    public LadderCreator(NaturalNumber numberOfRow, NaturalNumber numberOfPerson) {
        ladderSize = LadderSize.of(numberOfRow, numberOfPerson);
        rows = new Row[numberOfRow.getNumber()];
        for (int i = 0; i < numberOfRow.getNumber(); i++) {
            rows[i] = new Row(numberOfPerson);
        }
    }


    public void drawLine(Position row, Position col) {
//        System.out.println(row.getValue());
//        System.out.println(col.getValue());
        rows[row.getValue()].drawLine(col);
    }

    public Row[] getRows() {
        return rows;
    }
}
