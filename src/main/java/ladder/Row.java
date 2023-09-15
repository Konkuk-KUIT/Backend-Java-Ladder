package ladder;

public class Row {
    int[] row;

    public Row(int numberOfPerson) {
        row = new int[numberOfPerson];
    }

    public void drawLine(int startPosition) {
        row[startPosition] = 1;
        row[startPosition + 1] = -1;
    }

    public int nextPosition(int position) {

        if (isRight(position)) {
            return position + 1;
        }
        if (isLeft(position)) {
            return position - 1;
        }
        return position;
    }

    private boolean isLeft(int position) {
        return row[position] == -1;
    }

    private boolean isRight(int position) {
        return row[position] == 1;
    }
}