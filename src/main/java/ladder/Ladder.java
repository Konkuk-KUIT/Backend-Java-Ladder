package ladder;

import static ladder.ExceptionMessage.*;

public class Ladder {

    private final Row[] rows;

    public Ladder(int numberOfRow, int numberOfPerson) {
        if (numberOfPerson<=0) { //범위 체크
            throw new IllegalArgumentException(INVALID_NUMBER_OF_PERSION.getMessage());
        }
        rows = new Row[numberOfRow];
        for (int i=0; i< numberOfRow; i++){
            rows[i] = new Row(numberOfPerson);
        }
    }

    public int run(int i) {
        for (int level=0; level< rows.length; level++){
            i = rows[level].nextLevel(i);
        }
        return i;
    }

    public void drawLine(int startColumn, int row) {
        checkRowRange(row);
        rows[row-1].drawLine(startColumn);
    }

    private void checkRowRange(int row) {
        if (row-1 >= rows.length || row-1 < 0) { //범위 체크
            throw new IllegalArgumentException(INVALID_POSITION.getMessage());
        }
    }
}
