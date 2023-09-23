package ladder;

import static ladder.ExceptionMessage.*;

public class Ladder {

    private final Row[] rows;

    public Ladder(NaturalNumber numberOfRow, NaturalNumber numberOfPerson) {
        rows = new Row[numberOfRow.getNumber()];
        for (int i=0; i< numberOfRow.getNumber(); i++){
            rows[i] = new Row(numberOfPerson);
        }
    }

    public int run(Position position) {
        for (int level=0; level< rows.length; level++){
            position = rows[level].nextLevel(position);
        }
        return position.getValue();
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
}
