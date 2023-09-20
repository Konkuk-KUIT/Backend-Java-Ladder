package ladder;

import static ladder.Direction.*;
import static ladder.ExceptionMessage.INVALID_POSITION;
import static ladder.ExceptionMessage.LINE_DUPLICATION;

public class Row {

    private final int[] row;

    public Row(int numberOfPerson) {
        this.row = new int[numberOfPerson];
    }

    public int[] getRow() {
        return row;
    }

    public void drawLine(int col) {
        validateIndex(col);
        validateLineDuplication(col);
        row[col] = RIGHT.getValue();
        row[col + 1] = LEFT.getValue();
    }

    public int moveLine(int col) {
        if (row[col] == RIGHT.getValue()) return col + RIGHT.getValue();
        if (row[col] == LEFT.getValue()) return col + LEFT.getValue();
        return col;
    }

    private void validateIndex(int col) {
        if (col < 0 || col >= row.length - 1) {
            throw new IllegalArgumentException(INVALID_POSITION.getMessage());
        }
    }

    private void validateLineDuplication(int col) {
        if (row[col] != 0 || row[col + 1] != 0) {
            throw new IllegalArgumentException(LINE_DUPLICATION.getMessage());
        }
    }
}
