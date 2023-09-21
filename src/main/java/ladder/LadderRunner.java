package ladder;

public class LadderRunner {

    private final Row[] rows;

    public LadderRunner(Row[] rows) {
        this.rows = rows;
    }

    public int run(Position position) {
        for (int i = 0; i < rows.length; i++) {
            position = rows[i].nextPosition(position);
        }
        return position.getValue();
    }

    public int runWithLog(Position position) {

        for (int i = 0; i < rows.length; i++) {
            rows[i].printRow(LadderPosition.of(Position.of(i), position));
            position = rows[i].nextPosition(position);
        }

        return position.getValue();
    }

    public void printCurLadder(Position position) {
        for (int i = 0; i < rows.length; i++) {
            rows[i].printRow(LadderPosition.of(Position.of(i), position));
        }
    }
}
