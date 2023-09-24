package ladder;


import static ladder.ExceptionMessage.*;

public class Row {
    int[] row;

    public Row(int numberOfPerson) {
        validateNumberOfPerson(numberOfPerson);
        row = new int[numberOfPerson];
    }

    public void drawLine(int startPosition) {
        validateDrawLinePosition(startPosition);
        row[startPosition] = Direction.RIGHT.getValue();
        row[startPosition + 1] = Direction.LEFT.getValue();
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

    private void validateNumberOfPerson(int numberOfPerson) {
        if (numberOfPerson < 1) {
            throw new IllegalArgumentException(INVALID_NUMBER_OF_PERSON.getMessage());
        }
    }

    private void validatePosition(int position) {
        if (position >= row.length || position < 0) {
            throw new IllegalArgumentException(INVALID_POSITION.getMessage());
        }
    }

    private void validateDrawLinePosition(int startPosition) {
        if (startPosition >= row.length - 1 || startPosition < 0 || row[startPosition] == Direction.LEFT.getValue() || row[startPosition + 1] == Direction.RIGHT.getValue()) {
            throw new IllegalArgumentException(INVALID_DRAW_POSITION.getMessage());
        }
    }
}