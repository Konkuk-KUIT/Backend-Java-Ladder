package ladder;

public class Ladder {

    private final int[][] rows;

    public Ladder(int numberOfRow, int numberOfPerson) {
        rows = new int[numberOfRow][numberOfPerson];
    }

    public void drawLine(int row, int col){
        checkDraw(row, col); //선을 그을 수 있는 지 확인
        rows[row][col] = 1;
        rows[row][col+1] = -1;
    }

    public void checkDraw(int row, int col) {
        if(col<0 || col>=rows[0].length-1) // 움직이려는 사다리의 위치에서 줄을 그을 수 없음
            throw new IllegalStateException();
        if(row<0 || row >= rows.length) // 그리려는 사다리의 높이의 위치가 생성되어 있는 사다리 높이보다 높을
            throw new IllegalStateException();
        if(this.rows[row][col] != 0) // 현재 위치가 이미 줄이 어디론가 그어져 있음
            throw new IllegalStateException();
        if(this.rows[row][col+1]==1) // 오른쪽 사다리에 줄이 그어져 있음
            throw new IllegalStateException();
    }

    public int run(int start){
        for(int i = 0; i < rows.length; i++){
            start = start + rows[i][start];
        }
        return start;
    }

}
