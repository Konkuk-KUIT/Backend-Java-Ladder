package ladder;

public class Row {
    private int[] row;

    public Row(int numberOfPerson) {
        validateNumberOfPerson(numberOfPerson);
        row = new int[numberOfPerson];
    }

    public void drawLine(Position startPosition) {
        validateDrawLinePosition(startPosition);
        setDirectionAtPosition(startPosition, Direction.RIGHT);
        setDirectionAtPosition(startPosition.next(), Direction.LEFT);
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

    private void setDirectionAtPosition(Position startPosition, Direction direction) {
        row[startPosition.getValue()] = direction.getValue();
    }

    private boolean isLeft(Position position) {
        return row[position.getValue()] == Direction.LEFT.getValue();
    }

    private boolean isRight(Position position) {
        return row[position.getValue()] == Direction.RIGHT.getValue();
    }

    private void validateNumberOfPerson(int numberOfPerson) {
        if (numberOfPerson < 1) {
            throw new IllegalArgumentException("인원 수는 1명 이하일 수 없습니다.");
        }
    }

    private void validatePosition(Position position) {
        if (position.isBiggerThan(row.length - 1) || position.isSmallerThan(0)) {
            throw new IllegalArgumentException("유효하지 않은 위치입니다.");
        }
    }

    private void validateDrawLinePosition(Position startPosition) {
        if (isInvalidDrawPosition(startPosition)
                || isRight(startPosition)
                || isRight(startPosition.next())
                || isLeft(startPosition)) {
            throw new IllegalArgumentException("Invalid draw line position");
        }
    }

    private boolean isInvalidDrawPosition(Position position) {
        return position.isBiggerThan(row.length - 1) || position.isSmallerThan(0);
    }
}