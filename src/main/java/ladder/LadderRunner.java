package ladder;

public class LadderRunner {

    private final Row[] rows;

    public LadderRunner(Row[] rows) {
        this.rows = rows;
    }

    public Position run(Position position) {
        for(int i=0; i<rows.length; i++) {
            position = rows[i].moveLine(position);
        }
        return position;
    }
}
