package ladder;

public class Ladder {

    private final int[][] rows;

    public Ladder(int numberOfRow, int numberOfPerson) {
        rows = new int[numberOfRow][numberOfPerson];
    }

    public void drawLine(int row, int col, int direction) {
        // index 검사
        if (row > this.rows.length || row < 1 || col > this.rows[0].length || col < 1) {
            throw new RuntimeException();
        }
        // 방향값 유효성 검사
        if (direction != 1 && direction != -1) {
            throw new RuntimeException();
        }
        // 사다리 밖으로 긋는지 검사
        if ((col == 1 && direction == -1) || (col == rows[0].length && direction == 1)) {
            throw new RuntimeException();
        }
        //사다리 이어서 긋는지 검사
        if (this.rows[row - 1][col - 1] != 0 || this.rows[row - 1][col - 1 + direction] != 0) {
            throw new RuntimeException();
        }

        //줄 긋기
        this.rows[row - 1][col - 1] = direction;
        this.rows[row - 1][col - 1 + direction] = direction * (-1);
    }

    public int getDirection(int row, int col) {
        return rows[row - 1][col - 1];
    }

    public int run(int startPos) {
        int col = startPos - 1;
        for (int row = 0; row < rows.length; row++) {
            col += rows[row][col];
        }
        return col + 1;
    }
}
