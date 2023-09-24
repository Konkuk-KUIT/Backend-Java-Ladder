package ladder;

public class LadderRunner {
    private final Row[] rows;

    public LadderRunner(Row[] rows) {
        this.rows = rows;
    }

    public int run(Position input) {


        System.out.println("Current Ladder Number: " + input.getValue());
        System.out.println("=============Ladder Start=============");

        for (int i = 0; i < rows.length; i++) {
            System.out.println(printCurrentLadder("Before", LadderPosition.of(Position.of(i), input)));
            input = rows[i].nextPosition(input);
            System.out.println(printCurrentLadder("After", LadderPosition.of(Position.of(i), input)));
        }

        System.out.println("=============Ladder End=============\n");

        return input.getValue();
    }

    public String printCurrentLadder(String msg, LadderPosition ladderPosition) {
        StringBuilder sb = new StringBuilder();
        sb.append(msg);
        sb.append("\n");

        for (int i = 0; i < rows.length; i++) {
            String curRow = rows[i].printOneRow(ladderPosition, Position.of(i));
            sb.append(curRow);
            sb.append("\n");
        }

        return sb.toString();
    }
}
