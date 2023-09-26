package creator;

import ladder.NaturalNumber;
import ladder.Position;
import ladder.Row;

import static ladder.ExceptionMessage.INVALID_POSITION;

public class CustomLadderCreator implements LadderCreator {

    private final Row[] rows;

    public CustomLadderCreator(NaturalNumber numberOfRow, NaturalNumber numberOfPerson) {
        rows = new Row[numberOfRow.getNumber()];
        for (int i=0; i< numberOfRow.getNumber(); i++){
            rows[i] = new Row(numberOfPerson);
        }
    }

    public void drawLine(Position row, Position startColumn) {
        checkRowRange(row.getValue());
        rows[row.getValue()-1].drawLine(startColumn);
    }

    private void checkRowRange(int row) {
        if (row-1 >= rows.length || row-1 < 0) { //범위 체크
            throw new IllegalArgumentException(INVALID_POSITION.getMessage());
        }
    }

    public Row[] getRows() {
        return rows;
    }
}
