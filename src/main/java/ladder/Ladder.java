package ladder;

public class Ladder {
    public static void main(String[] args) {
        Ladder ladder = new Ladder(5, 4);  // 5 rows, 4 columns
        ladder.drawLine(0, 0);
        ladder.drawLine(2, 1);
        System.out.println(ladder.run(0));
    }

    private final int[][] rows;

    public Ladder(int numberOfRows, int numberOfColumns) {
        this.rows = new int[numberOfRows][numberOfColumns - 1];
    }

    public boolean canDrawLine(int row, int col) {
        if (isIncorrectPosition(row, col)) return false;

        // 현재 위치 확인
        if (rows[row][col] == 1) return false;

        // 왼쪽 확인
        if (col - 1 >= 0 && rows[row][col - 1] == 1) return false;

        // 오른쪽 확인
        if (col + 1 < rows[row].length && rows[row][col + 1] == 1) return false;

        return true;
    }

    public boolean isIncorrectPosition(int row, int col) {
        return row < 0 || row >= rows.length || col < 0 || col >= rows[row].length;
    }

    public void drawLine(int row, int col) {
        if (!canDrawLine(row, col)) {
            throw new IllegalArgumentException("Cannot draw line here.");
        }
        rows[row][col] = 1;
    }

    public int run(int startPosition) {
        int position = startPosition;
        for (int i = 0; i < rows.length; i++) {
            // 왼쪽에 존재하는지 확인
            if (position > 0 && rows[i][position - 1] == 1) {
                position--;
                continue;
            }
            // 오른쪽에 존재하는지 확인
            if (position < rows[i].length && rows[i][position] == 1) {
                position++;
            }
        }
        return position;
    }
    public int[][] getRows() {
        return this.rows;
    }
}
