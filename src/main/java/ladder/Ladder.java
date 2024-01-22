package ladder;

public class Ladder {

    private final Row[] rows;

    public Ladder(int numberOfRow, int numberOfPerson) {
        rows = new Row[numberOfRow];
        for (int i = 0; i < rows.length; i++) {
            rows[i] = new Row(numberOfPerson);
        }
    }

    public void drawLine(int column, int row) {
        rows[row].drawLine(column);
    }

    public int getLine(int column, int row) {
        return rows[row].getLine(column);
    }

    public int run(int pick) {
        int currentPosition = pick;
        for (int i = 0; i < rows.length; i++) {
            currentPosition += getLine(currentPosition, i);
        }
        return currentPosition;
    }
}
