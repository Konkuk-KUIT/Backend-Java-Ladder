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

    public void PrintLadderGameResult() {
        for (int i = 1; i <rows[0].size(); i++) {
            System.out.println(i + "번째 사람의 결과 -> " + run(Position.of(i)));
        }
    }
}
