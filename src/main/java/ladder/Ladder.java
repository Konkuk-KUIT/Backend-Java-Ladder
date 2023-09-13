package ladder;

public class Ladder {

    //좌표값으로 나타내기위해 이차원 배열
    private final int[][] ladder;

    //인스턴스 생성
    //좌표값에해당하는 배열의 값에 1이 들어있으면 가로선 존재
    public Ladder(int numberOfRows, int numberOfColumnsPerRow) {
        ladder = new int[numberOfRows][numberOfColumnsPerRow];
    }

    //사다리게임 진행 메서드
    public int run(int selectedColumn) {
        // 범위 벗어나면 예외 발생
        if (selectedColumn < 1 || selectedColumn > ladder[0].length) {
            throw new IllegalArgumentException("Invalid selected column");
        }

        int currentColumn = selectedColumn - 1;
        int currentRow = 0; // 초기 행 설정
        //for문 대신 while문 사용
        while (currentRow < ladder.length) {
            // 오른쪽으로 갈 수 있는 선(1로 표시)이 있다면 오른쪽 열로 이동
            if (currentColumn < ladder[0].length - 1 && ladder[currentRow][currentColumn] == 1) {
                currentColumn++;
            }
            // 왼쪽으로 갈 수 있는 선(1로 표시)이 있다면 왼쪽 열로 이동
            if (currentColumn > 0 && ladder[currentRow][currentColumn - 1] == 1) {
                currentColumn--;
            }
            // 다음 행으로 이동
            currentRow++;
        }

        // 리턴값은 1을 더한 값을 반환하여 실제 게임 상의 열을 반환
        return currentColumn + 1;
    }

    //가로선 그리는 함수
    //가로선은 왼쪽으로만 그려짐..오른쪽 선은 어떻게 구현허지..?
    public void drawLine(int row, int column){
        //범위 벗어나면 예외 발생
        if (row < 1 || row > ladder.length || column < 1 || column > ladder[0].length) {
            throw new IllegalArgumentException("Invalid row or position");
        }
        ladder[row - 1][column - 1] = 1;
    }
}
