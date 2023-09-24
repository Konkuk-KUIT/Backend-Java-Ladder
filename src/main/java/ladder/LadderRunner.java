package ladder;

public class LadderRunner {

    private final Row[] rows;

    public LadderRunner(Row[] rows) {
        this.rows = rows;
    }

    public int run(Position position) {
        for (int i = 0; i < rows.length; i++) {
            printLadder(Position.of(i), position, "Before");
            position = rows[i].nextPosition(position);
            printLadder(Position.of(i), position, "After");
        }
        return position.getValue();
    }

    public String generate(Position currentRow, Position currentCol) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rows.length; i++) {
            rows[i].generateRow(sb, Position.of(i), currentRow, currentCol);
        }
        return sb.toString();
    }

    public void printLadder(Position currentRow, Position currentCol, String label) {
        System.out.println(label);
        String ladder = generate(currentRow, currentCol);
        System.out.println(ladder);
    }
}
