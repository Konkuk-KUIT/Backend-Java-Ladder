package ladder;

public class Ladder {
    private final int[][] rows;
    public Ladder(int numberOfRow, int numberOfPerson) {
        rows = new int[numberOfRow][numberOfPerson];
    }

    public int[][] getRows() {
        return rows;
    }

    public int getRowL() {
        return rows[0].length;
    }

    public int getColumnL() {
        return rows.length;
    }

    public void drawLine(int posY, int posX) {
        // 1.X나 Y가 범위 밖일 경우
        if (posY >= rows.length || posX >= rows[0].length - 1) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_DRAW_POSITION_OUT.getMessage());
        }
        // 2. 이미 있는 경우
        if (rows[posY][posX] == 1 && rows[posY][posX + 1] == 1) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_DRAW_POSITION_EXIST.getMessage());
        }
        // 3. 2개 이상의 다리를 연결할 경우
        if (rows[posY][posX] == 1) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_DRAW_POSITION_OVERLAP.getMessage());
        }
        rows[posY][posX] = 1;
        rows[posY][posX+1] = 1;
    }
}