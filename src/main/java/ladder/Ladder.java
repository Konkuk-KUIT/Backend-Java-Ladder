package ladder;

public class Ladder {

    private final Row[] rows;

    public Ladder(NaturalNumber numberOfRow, NaturalNumber numberOfPerson) {
        rows = new Row[numberOfRow.getNumber()];
        for (int i = 0; i < numberOfRow.getNumber(); i++) {
            rows[i] = new Row(numberOfPerson.getNumber());
        }
    }

    public void drawLine(int row, int position, Direction direction) {
        rows[row- 1].drawLine(position, direction);
    }

    public int run(int position) {
        for (int row = 0; row < rows.length; row++) {
            position = rows[row].nextPosition(position);
        }
        return position;
    }
}
