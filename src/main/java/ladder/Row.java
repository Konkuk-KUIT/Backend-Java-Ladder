package ladder;

import static ladder.Direction.*;
import static ladder.ExceptionMessage.INVALID_POSITION;
import static ladder.ExceptionMessage.LINE_DUPLICATION;

public class Row {

    private final int[] row;

    public Row(NaturalNumber numberOfPerson) {
        this.row = new int[numberOfPerson.getNumber()];
    }

    public int[] getRow() {
        return row;
    }

    public void drawLine(Position position) {
        validateIndex(position);
        validateLineDuplication(position);
        setDirectionAtPosition(position, RIGHT);
        setDirectionAtPosition(position.next(), LEFT);
    }

    private void setDirectionAtPosition(Position position, Direction direction) {
        row[position.getPosition()] = direction.getValue();
    }

    public Position moveLine(Position currentPosition) {
        validateIndex(currentPosition);
        if (isRight(currentPosition)) return currentPosition.next();
        if (isLeft(currentPosition)) return currentPosition.prev();
        return currentPosition;
    }

    private boolean isLeft(Position position) {
        return row[position.getPosition()] == LEFT.getValue();
    }

    private boolean isRight(Position position) {
        return row[position.getPosition()] == RIGHT.getValue();
    }

    private void validateIndex(Position position) {
        if (position.getPosition() >= row.length) {
            throw new IllegalArgumentException(INVALID_POSITION.getMessage());
        }
    }

    private void validateLineDuplication(Position position) {
        if (row[position.getPosition()] != 0 || row[position.getPosition() + 1] != 0) {
            throw new IllegalArgumentException(LINE_DUPLICATION.getMessage());
        }
    }
}
