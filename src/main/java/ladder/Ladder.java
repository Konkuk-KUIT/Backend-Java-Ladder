package ladder;

public class Ladder {


    private final Row[] rows;


    public Ladder(NaturalNumber numberOfRow, NaturalNumber numberOfPerson) {
        rows = new Row[numberOfRow.getNumber()];
        for (int i = 0; i < numberOfRow.getNumber(); i++) {
            rows[i] = new Row(numberOfPerson);
        }
    }

    public void drawLine(Position row, Position col) {
        rows[row.getValue()].drawLine(col);
    }

    public int run(Position position) {
        for (int i = 0; i < rows.length; i++) {
            position = rows[i].nextPosition(position);
        }
        return position.getValue();
    }
}
