package ladder;

import static ladder.ExceptionMessage.*;

public class Row {

    private final int[] row;

    public Row(int numberOfPerson) {
        validateNumberOfPerson(numberOfPerson);
        row = new int[numberOfPerson+1];
    }

    public void drawLine(int startPosition) {
        validateDrawLinePosition(startPosition);
        row[startPosition] = 1;
        row[startPosition + 1] = -1;
    }

    public int nextPosition(int position) {
        validatePosition(position);

        if (isRight(position)) {
            return position + 1;
        }
        if (isLeft(position)) {
            return position - 1;
        }
        return position;
    }

    private boolean isLeft(int position) {
        return row[position] == Direction.LEFT.getValue();
    }

    private boolean isRight(int position) {
        return row[position] == Direction.RIGHT.getValue();
    }

    private void validateDrawLinePosition(int startPosition) {
        if (startPosition > row.length -1 || startPosition < 1 || row[startPosition] == Direction.LEFT.getValue() || row[startPosition + 1] == Direction.RIGHT.getValue()) {
            throw new IllegalArgumentException(INVALID_DRAW_POSITION.getMessage());
        }
    }

    private void validatePosition(int position) {
        if (position >= row.length || position < 0) {
            throw new IllegalArgumentException(INVALID_POSITION.getMessage());
        }
    }

    private void validateNumberOfPerson(int numberOfPerson) {
        if (numberOfPerson < 1) {
            throw new RuntimeException(INVALID_NUMBER_OF_PERSON.getMessage());
        }
    }
}
