package ladder;

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
            throw new IllegalArgumentException();
        }
    }

    private void validatePosition(int position) {
        if (position >= row.length || position < 0) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDrawLinePosition(int startPosition) {
        if (isInvalidPosition(startPosition)
            || isLineAtPosition(startPosition)
            || isLineAtNextPosition(startPosition)
            || isLineAtPrevPosition(startPosition)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isInvalidPosition(int position) {
        return position >= row.length - 1 || position < 0;
    }

    private boolean isLineAtPosition(int position) {
        return row[position] == Direction.RIGHT.getValue() || row[position + 1] == Direction.LEFT.getValue();
    }

    private boolean isLineAtNextPosition(int position) {
        return row[position + 1] == Direction.RIGHT.getValue();
    }

    private boolean isLineAtPrevPosition(int position) {
        return row[position] == Direction.LEFT.getValue();
    }
}