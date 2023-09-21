package ladder;

public class Ladder {

    /* 좌표값으로 나타내기위해 이차원 배열 */
    protected static Integer[][] ladder;
    /*인스턴스 생성, 좌표값에해당하는 배열의 값에 CREATED_COLUMN이 들어있으면 가로선 존재 */
    public Ladder(int numberOfRows, int numberOfColumns) {
        initLadder(numberOfRows,numberOfColumns);
    }

    private void initLadder(int numberOfRows, int numberOfColumns){
        ladder = new Integer[numberOfRows][numberOfColumns];
        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                ladder[i][j] = Direction.EMPTY_COLUMN.getValue();
            }
        }
    }

    /*가로선 그리는 함수, 가로선은 오른쪽으로만 그려짐 (draw에서 왼쪽오른쪽 선택해서 그리게 하면 코드 구조가 복잡해진다고 생각)*/
    public void drawLine(int row, int column){
        /*범위 벗어나면 예외 발생*/
        LadderValidation.isValidRow(row,column);
        ladder[row - 1][column - 1] = Direction.CREATED_COLUMN.getValue();
    }

    /*사다리게임 진행 메서드,*/
    public int run(int selectedColumn) {
        LadderValidation.isValidClumn(selectedColumn);
        int currentColumn = selectedColumn - 1;
        int currentRow = 0; // 초기 행 설정
        while (currentRow < ladder.length) {
            currentColumn= LadderMove.moveColumn(currentRow,currentColumn);
            currentRow= LadderMove.moveRow(currentRow,currentColumn);
        }
        /* 리턴값은 1을 더한 값을 반환하여 실제 게임 상의 열을 반환*/
        return currentColumn + 1;
    }

    /*사다리 전체 출력*/
    public void printLadder(){
        for(Integer[] row : ladder){
            for(Integer value : row){
                System.out.print(value);
            }
            System.out.println("");
        }
        System.out.println("");
    }

    public void printPlayer(int selectedColumn) {
        LadderValidation.isValidClumn(selectedColumn);

        //-1을 현재 위치로 대체할거라 초기화
        Integer[][] clonedLadder = new Integer[ladder.length][];
        for (int i = 0; i < ladder.length; i++) {
            clonedLadder[i] = ladder[i].clone();
        }

        int currentColumn = selectedColumn - 1;
        int currentRow = 0;

        while (currentRow < ladder.length) {
            // 현재 위치를 반복해서 초기화 켜줌
            clonedLadder[currentRow][currentColumn] = Direction.PLAYER_COLUMN.getValue();

            for(Integer[] row : clonedLadder){
                for(Integer value : row){
                    if (value == Direction.PLAYER_COLUMN.getValue()) {
                        System.out.print("*"+value); // 현재 플레이어 위치 표시
                    } else {
                        System.out.print(value); // 빈 단계 표시
                    }
                }
                System.out.println("");
            }
            System.out.println();
            // 사다리 지나가면 복구
            clonedLadder[currentRow][currentColumn] = ladder[currentRow][currentColumn];
            //사다리 이동
            currentColumn = LadderMove.moveColumn(currentRow, currentColumn);
            currentRow = LadderMove.moveRow(currentRow, currentColumn);
        }

        System.out.println("");
    }

}
