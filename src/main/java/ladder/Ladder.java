package ladder;

public class Ladder {

    private final int[][] rows;

    public Ladder(int numberOfRow, int numberOfPerson) {
        rows = new int[numberOfRow][numberOfPerson];
    }

    public void drawLine(int row, int col) {
        rows[row][col] = 1; //오른쪽
        rows[row][col + 1] = -1; //왼쪽
        //ㅜㅜ
    }

    public int run(int position) {
        for (int i = 0; i < rows.length; i++) {
            position = nextPosition(position, i);
        }
        return position;
    }

    private int nextPosition(int position, int row) {
        if (rows[row][position] == 1) {
            return position + 1;
        }
        if (rows[row][position] == -1) {
            return position - 1;
        }
        return position;
    }

}