package ladder;

public class LadderRunner {

    private final Row[] rows;

    public LadderRunner(Row[] rows) {
        this.rows = rows;
    }

    public int run(Position position) {
        for (int level=0; level< rows.length; level++){
            printLadder(level, position);
            position = rows[level].nextLevel(position);
        }
        return position.getValue();
    }

    private void printLadder(int level, Position position) {

        for (int i=0; i<rows.length; i++){
            //level이 같은 row만 *을 position에 찍어줘야해
            //* 찍을지 말지 결정
            boolean printStar = false;
            if (level == i){
                printStar = true;
            }

            rows[i].printRow(printStar, position);
        }
        System.out.println();
    }
}
