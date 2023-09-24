package ladder;

import static ladder.ExceptionMessage.*;

public class Row {

    int[] row;

    public Row(NaturalNumber numberOfPerson) {
        row = new int[numberOfPerson.getNumber()];
    }

    public void drawLine(Position col) {
        validateDrawLinePosition(col);
        row[col.getPosition()] = Direction.RIGHT.getValue(); //오른쪽
        row[col.getPosition() + 1] = Direction.LEFT.getValue(); //왼쪽
    }

    public Position nextPosition(Position position) {
        validatePosition(position);

        if (row[position.getPosition()] == Direction.RIGHT.getValue()) {
            return position.next();
        }
        if (row[position.getPosition()] == Direction.LEFT.getValue()) {
            return position.prev();
        }
        return position;
    }

    private void validateDrawLinePosition(Position startPosition) {
        if (startPosition.isBiggerThan(row.length - 2) || startPosition.isSmallerThan(0) || row[startPosition.getPosition()] == Direction.LEFT.getValue() || row[startPosition.getPosition() + 1] == Direction.RIGHT.getValue()) {
            throw new IllegalArgumentException(INVALID_DRAWLINE.getMessage());
        }
    }
    private void validatePosition(Position position) {
        if (position.isSmallerThan(0) || position.isBiggerThan(row.length-1)) {
            throw new IllegalArgumentException(INVALID_POSITION.getMessage());
        }
    }

}
