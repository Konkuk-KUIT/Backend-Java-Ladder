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
    public int run(int selectedColumn){
        //범위 벗어나면 예외 발생
        if (selectedColumn < 1 || selectedColumn > ladder.length) {
            throw new IllegalArgumentException("Invalid selected row");
        }
        //인덱스는 0부터 시작이라 1빼기
        int currentCulumn = selectedColumn-1;
        //아래로 이동하면서 사다리게임 진행
        //보통 사다리 게임에서 왼쪽먼저 확인 하므로 조건문으로 왼쪽먼저 확인
        //왜 row냐 면 row의 길이가 즉 사다리 높이임
        for(int row = 0 ; row < ladder.length; row++){
            //왼쪽으로 갈수있는 선(1로 표시)이 있다면 currentCulmn을 1줄여서 이동합니다.
            if(currentCulumn > 0 && ladder[row][currentCulumn-1]==1){
                currentCulumn--;
            }
            //왼쪽으로 갈수있는 선(1로 표시)이 있다면 currentCulmn을 1증가시켜서 이동합니다.
            if(currentCulumn< ladder[0].length-1 && ladder[row][currentCulumn]==1){
                currentCulumn++;
            }
        }
        //리턴값은 1증가시켜서 반환함으로써 실제 게임상의 열을 반환
        return currentCulumn + 1;
    }

    //가로선 그리는 함수
    public void drawLine(int row, int column){
        //범위 벗어나면 예외 발생
        if (row < 1 || row > ladder.length || column < 1 || column > ladder[0].length) {
            throw new IllegalArgumentException("Invalid row or position");
        }
        ladder[row - 1][column - 1] = 1;
    }
}
