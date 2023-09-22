package ladder;

public class LadderRunner {
    private final Row[] rows;
    private final LadderPrint ladderPrint;

    public LadderRunner(Row[] rows) {
        this.rows = rows;
        this.ladderPrint = new LadderPrint(rows);
    }

    public Position run(Position position) {
        for (int row = 0; row < this.rows.length; row++) {
            System.out.println("Before");
            ladderPrint.printLadder(NaturalNumber.of(row + 1), position);

            position = this.rows[row].nextPosition(position);

            System.out.println("After");
            ladderPrint.printLadder(NaturalNumber.of(row + 1), position);
        }
        return position;
    }
}
