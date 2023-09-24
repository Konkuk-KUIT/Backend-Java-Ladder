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

    public void runAndPrint(Position position) {
        for (int i = 0; i < rows.length; i++) {
            System.out.println("Before");
            print(i, position);
            position = rows[i].nextPosition(position);
            System.out.println("After");
            print(i, position);
        }
    }

    private void print(int row, Position col) {
        for (int i =0; i< rows.length; i++) {
            if (i == row) {
                rows[i].printWithStar(col);
                continue;
            }
            rows[i].print();
        }
        System.out.println();
    }
}
