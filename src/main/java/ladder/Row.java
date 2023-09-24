package ladder;

import static ladder.ExceptionMessage.*;

public class Row {

    int[] row;

    public Row(int numberOfPerson) {
        validateNumberOfPerson(numberOfPerson);
        row = new int[numberOfPerson];
    }

    public void drawLine(int col) {
//        validateDrawLine(col);
        validateDrawLinePosition(col);
        row[col] = Direction.RIGHT.getValue(); //오른쪽
        row[col + 1] = Direction.LEFT.getValue(); //왼쪽
    }

    public int nextPosition(int position) {
        validatePosition(position);

        if (row[position] == Direction.RIGHT.getValue()) {
            return position + 1;
        }
        if (row[position] == Direction.LEFT.getValue()) {
            return position - 1;
        }
        return position;
    }

    private void validateNumberOfPerson(int numberOfPerson) {
        if (numberOfPerson <= 0) {
            throw new IllegalArgumentException(INVALID_NUMBER_OF_PERSON.getMessage());
        }
    }


    private void validateDrawLinePosition(int startPosition) {
        if (startPosition >= row.length - 1 || startPosition < 0 || row[startPosition] == Direction.LEFT.getValue() || row[startPosition + 1] == Direction.RIGHT.getValue()) {
            throw new IllegalArgumentException(INVALID_DRAWLINE.getMessage());
        }
    }
    private void validatePosition(int position) {
        if (position < 0 || position >= row.length) {
            throw new IllegalArgumentException(INVALID_POSITION.getMessage());
        }
    }

}
