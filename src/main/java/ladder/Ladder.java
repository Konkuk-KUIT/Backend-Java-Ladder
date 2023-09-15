package ladder;

public class Ladder {

    private final int[][] rows;
    private final int numberOfRow;
    private final int numberOfPerson;

    public Ladder(int numberOfRow, int numberOfPerson) {
        validateNumberOfPerson(numberOfPerson);
        this.numberOfRow = numberOfRow;
        this.numberOfPerson = numberOfPerson;
        rows = new int[numberOfRow][numberOfPerson];
    }

    public int getRowsValue(int x, int y) {
        return rows[x][y];
    }

    public void drawLine(int x, int y) {
        validatePosition(x,y);
        //(x,y)에서 오른쪽으로 한 줄 추가
        rows[x-1][y-1] = 1;
        rows[x-1][y] = -1;
    }

    public int run(int number) {
        int curr= number-1;
        for (int i = 0; i < numberOfRow; i++) {
            if (rows[i][curr] == 1) {
                curr+=1;
            }
            else if(rows[i][curr] == -1){
                curr-=1;
            }
        }
        return curr+1;
    }

    private void validateNumberOfPerson(int numberOfPerson) {
        if (numberOfPerson < 1) {
            throw new RuntimeException();
        }
    }

    private void validatePosition(int x, int y) {
        if (x <= 0 || y <= 0 || x > numberOfRow || y > numberOfPerson-1) {
            throw new RuntimeException();
        } //배열에 맞지 않은 값 (y: 마지막 사람 라인에서 오른쪽으로 라인을 그을 수 없음)
        if (getRowsValue(x-1,y-1) ==1 || getRowsValue(x-1,y-1) ==-1) {
            throw new RuntimeException();
        } //이미 해당 좌표에 라인이 있을 때
    }
}
