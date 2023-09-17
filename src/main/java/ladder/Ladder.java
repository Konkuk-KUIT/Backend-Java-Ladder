package ladder;

public class Ladder {
    private final int[][] rows;

    public Ladder(int numberOfRow, int numberOfPerson) {
        if (numberOfRow <= 0 || numberOfPerson <= 0) {
            throw new IllegalArgumentException("행과 열은 1 이상이어야 합니다.");
        }
        rows = new int[numberOfRow][numberOfPerson];
    }

    public void drawLine(int row, int col) {
        if (row < 1 || row > rows.length || col < 1 || col > rows[0].length) {
            throw new IllegalArgumentException("잘못된 행 또는 열입니다.");
        }
        rows[row - 1][col - 1] = 1;
    }

    public int run(int selectedCol) {
        if (selectedCol < 1 || selectedCol > rows[0].length) {
            throw new IllegalArgumentException("선택한 열이 범위를 벗어났습니다.");
        }

        int currentRow = 0;
        int currentCol = selectedCol - 1;

        while (currentRow < rows.length) {
            // 사다리가 그려져 있으면 왼쪽으로 이동
            if (currentCol > 0 && rows[currentRow][currentCol - 1] == 1) {
                rows[currentRow][currentCol - 1] = 2;
                currentCol--;
            }
            //오른쪽으로 이동
            if (currentCol < rows[0].length - 1 && rows[currentRow][currentCol] == 1) {
                rows[currentRow][currentCol] = 2;
                currentCol++;
            }
            //왼쪽 오른쪽 둘다 이동할 수 없는 경우 내려가기
            if(!(currentCol < rows[0].length-1 && rows[currentRow][currentCol]==1) && !(currentCol > 0 && rows[currentRow][currentCol - 1] == 1)){
                //오른쪽으로 이동한 경우 왼쪽 확인
                if (currentCol > 0 && rows[currentRow][currentCol - 1] == 2) {
                    rows[currentRow][currentCol-1] = 1;
                }
                //왼쪽으로 이동한 경우 오른쪽 확인
                if(currentCol < rows[0].length - 1 && rows[currentRow][currentCol] == 2){
                    rows[currentRow][currentCol] = 1;
                }
                currentRow++;
            }
        }
        // 1을 더해 선택한 열 번호를 반환
        return currentCol + 1;
    }
}
