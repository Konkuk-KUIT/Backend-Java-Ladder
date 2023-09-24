package ladder;

public class LadderRunner {

    private final Row[] rows;

    public LadderRunner(Row[] rows) {
        this.rows = rows;
    }

    public int run(Position position) {
        for (int level=0; level< rows.length; level++){
            position = rows[level].nextLevel(position);
            System.out.println("position = " + position);
        }
        return position.getValue();
    }
}
