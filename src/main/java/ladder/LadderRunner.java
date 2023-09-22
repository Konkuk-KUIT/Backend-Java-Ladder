package ladder;

public class LadderRunner {

    private final Row[] rows;

    public LadderRunner(Row[] rows) {
        this.rows = rows;
    }

    public void printLadder(LadderPosition ladderPosition) {
        for (int i = 0; i < rows.length; i++) {
            rows[i].selectPrintRow(ladderPosition, i);
        }
    }

    public int run(Position position) {
        LadderPosition ladderPosition;
        for (int i = 0; i < rows.length; i++) {
            ladderPosition = new LadderPosition(i, position);
            System.out.println("Before");

            printLadder(ladderPosition);

            position = rows[i].nextPosition(position);

            ladderPosition = new LadderPosition(i, position);
            System.out.println("After");
            printLadder(ladderPosition);
        }
        return position.getPosition();
    }
}
