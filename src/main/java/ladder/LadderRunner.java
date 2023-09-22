package ladder;

public class LadderRunner {
    private final Row[] rows;

    public LadderRunner(Row[] rows) {
        this.rows = rows;
    }

    public Position run(Position position) {
        for (int row = 0; row < rows.length; row++) {
            position = rows[row].nextPosition(position);
        }
        return position;
    }
}
