package ladder;

public class Ladder {
    private final Row[] rows;

    public Ladder(int numberOfRow, int numberOfPerson) {
        validateNumber(numberOfRow);
        validateNumber(numberOfPerson);

        rows = new Row[numberOfRow];

        for (int i = 0; i < numberOfRow; i++) {
            rows[i] = new Row(numberOfPerson);
        }
    }

    public void drawLine(Position rowPos, Position colPos) {
        rows[rowPos.getPosition()].drawLine(colPos);
    }

    public Row[] getRows() {
        return rows;
    }

    public int run(Position position) {
        for (int i = 0; i < rows.length; i++) {
            rows[i].nextPosition(position);
        }
        return position.getPosition();
    }

    private void validateNumber(int number){
        if (number < 0) throw new IllegalArgumentException();
    }
}