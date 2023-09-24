package ladder;

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
            throw new IllegalArgumentException("사다리를 그릴 수 없는 위치입니다.");
        }
    }

    private void validatePosition(int position) {
        if (position >= row.length || position < 0) {
            throw new IllegalArgumentException("유효하지 않은 위치입니다.");
        }
    }

    private void validateNumberOfPerson(int numberOfPerson) {
        if (numberOfPerson < 1) {
            throw new RuntimeException("사람 수는 1명 이상이여야 합니다.");
        }
    }
}
