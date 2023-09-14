package ladder;

public class Ladder {

    private final int[][] rows;

    public Ladder(int numberOfRow, int numberOfPerson) {
        rows = new int[numberOfRow][numberOfPerson];
    }

    public int[][] getRows() {
        return rows;
    }

    public void drawLine(int row, int col) {
        validateIndex(row, col);
        validateLineDuplication(row, col);
        this.rows[row][col] = 1;
        this.rows[row][col + 1] = -1;
    }

    public int run(int idx) {
        for (int i=0; i<rows.length; i++) {
            idx = moveLine(i, idx);
        }
        return idx;
    }

    private int moveLine(int row, int col) {
        if(rows[row][col] == 1) return col+1;
        if(rows[row][col] == -1) return col-1;
        return col;
    }

    private void validateIndex(int row, int col) {
        if(row < 0 || col < 0 || row >= rows.length || col >= rows[0].length - 1) {
            throw new IllegalArgumentException();
        }
    }

    private void validateLineDuplication(int row, int col) {
        if(rows[row][col] != 0 || rows[row][col + 1] != 0) {
            throw new IllegalArgumentException();
        }
    }
}
