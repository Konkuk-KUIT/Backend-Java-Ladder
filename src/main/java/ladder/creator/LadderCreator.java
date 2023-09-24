package ladder.creator;

import ladder.position.LadderPosition;
import ladder.core.Row;

public interface LadderCreator {

    void drawLine(LadderPosition ladderPosition);

    Row[] getRows();
}

//    private final Row[] rows;
//
//    public NormalLadderCreator(NaturalNumber numberOfRow, NaturalNumber numberOfPerson) {
//        rows = new Row[numberOfRow.getNumber()];
//        for (int i = 0; i < numberOfRow.getNumber(); i++) {
//            rows[i] = new Row(numberOfPerson);
//        }
//    }
//
//    public void drawLine(Position row, Position col) {
//        rows[row.getPosition()].drawLine(col);
//    }
//
//    public Row[] getRows() {
//        return rows;
//    }

