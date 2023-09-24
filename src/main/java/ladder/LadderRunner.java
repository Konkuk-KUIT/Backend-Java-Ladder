package ladder;

public class LadderRunner {
    private final Row[] rows;

    public LadderRunner(Row[] rows) {
        this.rows = rows;
    }

    public Position run(Position position) {
        for (int row = 0; row < this.rows.length; row++) {
            System.out.println("Before");
            printLadder(position, row);

            position = this.rows[row].nextPosition(position);

            System.out.println("After");
            printLadder(position, row);
        }
        return position;
    }
    public void printLadder(Position currentPosition, int currentRow) {
        for (int row = 0; row < this.rows.length; row++) {
            rows[row].printRow(currentPosition, currentRow == row);
        }
    }
}
