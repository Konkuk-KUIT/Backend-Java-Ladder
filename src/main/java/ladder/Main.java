package ladder;

public class Main {

    public static void main(String[] args) {
        Row[] rows = new Row[3];
        rows[0] = new Row(NaturalNumber.of(3));
        rows[1] = new Row(NaturalNumber.of(3));
        rows[2] = new Row(NaturalNumber.of(3));

        rows[0].drawLine(Position.of(0));
        rows[1].drawLine(Position.of(1));

        LadderRunner ladderRunner = new LadderRunner(rows);

        int result = ladderRunner.run(Position.of(0));

        System.out.println("Final Position: " + result);
    }
}
