package ladder;

public class LadderRunner {

    private final Row[] rows;

    public LadderRunner(Row[] rows) {
        this.rows = rows;
    }

    public int run(Position position) {
        for (int i = 0; i < rows.length; i++) {
            LadderPosition ladderPosition = new LadderPosition(position.getValue(), i);
            printLadder(ladderPosition, "Before");
            position = rows[i].nextPosition(position);
            ladderPosition = new LadderPosition(position.getValue(), i);
            printLadder(ladderPosition, "After");
        }
        return position.getValue();
    }


    private void printLadder(LadderPosition position, String stage) {
        System.out.println(stage);
        for (int i = 0; i < rows.length; i++) {
            for (int j = 0; j < rows[i].getNodesLength(); j++) {
                String value = String.format("%2s", rows[i].getNodeValue(j));
                if (position.getX() == j && position.getY() == i) {
                    System.out.print(value + "* ");
                } else {
                    System.out.print(value + "  ");
                }
            }
            System.out.println();
        }
    }
}