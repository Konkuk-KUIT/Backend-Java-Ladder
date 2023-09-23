package ladder;

public class LadderRunner {

    private final Row[] rows;
    private LadderPrinter ladderPrinter;

    public LadderRunner(Row[] rows) {
        this.rows = rows;
    }

    public Position run(Position position) {
        this.ladderPrinter = new LadderPrinter(rows);
        for(int i=0; i<rows.length; i++) {
            ladderPrinter.printBefore();
            ladderPrinter.printLadder(Position.of(i), position);
            position = rows[i].moveLine(position);
            ladderPrinter.printAfter();
            ladderPrinter.printLadder(Position.of(i), position);
        }
        return position;
    }
}
