package ladder;

import static ladder.ExceptionMessage.*;

public class Row {

    private final int[] row;

    public Row(NaturalNumber numberOfPerson) {
        row = new int[numberOfPerson.getNumber()+1];
    }

    public void drawLine(Position startPosition) {
        validateDrawLinePosition(startPosition);
        row[startPosition.getValue()] = 1;
        row[startPosition.getValue() + 1] = -1;
    }

    public Position nextPosition(Position currentPosition) {
        validatePosition(currentPosition);

        if (isRight(currentPosition)) {
            return currentPosition.next();
        }
        if (isLeft(currentPosition)) {
            return currentPosition.prev();
        }
        return currentPosition;
    }

    private boolean isLeft(Position position) {
        return row[position.getValue()] == Direction.LEFT.getValue();
    }

    private boolean isRight(Position position) {
        return row[position.getValue()] == Direction.RIGHT.getValue();
    }

    private void validateDrawLinePosition(Position startPosition) {
        if (startPosition.getValue() > row.length -1 || startPosition.getValue() < 1 || row[startPosition.getValue()] == Direction.LEFT.getValue() || row[startPosition.getValue() + 1] == Direction.RIGHT.getValue()) {
            throw new IllegalArgumentException(INVALID_DRAW_POSITION.getMessage());
        }
    }

    private void validatePosition(Position position) {
        if (position.isBiggerThan(row.length) || position.isSmallerThan(1)) {
            throw new IllegalArgumentException(INVALID_POSITION.getMessage());
        }
    }

}
