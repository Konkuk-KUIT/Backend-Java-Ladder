package ladder;

public class Ladder {

    private final int[][] rows;

    public Ladder(int numberOfRow, int numberOfPerson) {
        rows = new int[numberOfRow][numberOfPerson];
    }

    public int run(int i) {
        if (i >= rows[0].length) { //범위 체크
            throw new RuntimeException();
        }

        for (int level=0; level< rows.length; level++){
            i += rows[level][i-1];
        }
        return i;
    }

    public void drawLine(int startColumn, int row) {
        if (startColumn >= rows[0].length-1 || row >= rows.length) { //범위 체크
            throw new RuntimeException();
        }

        rows[startColumn-1][row-1] = 1;
        rows[startColumn][row-1] = -1;
    }
}
