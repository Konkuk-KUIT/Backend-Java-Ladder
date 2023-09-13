package ladder;

public class Ladder {

    private final int[][] rows;
    private int numberOfRow = 0;
    private int numberOfPerson = 0;

    public Ladder(int numberOfRow, int numberOfPerson) {
        this.numberOfRow = numberOfRow;
        this.numberOfPerson = numberOfPerson;
        rows = new int[numberOfRow][numberOfPerson];

        for(int i=0; i<numberOfRow; i++){
            initrows(i, numberOfPerson);
        }
    }
    
    public void initrows(int col, int numberOfPerson){
        for(int i=0; i<numberOfPerson; i++){
            rows[col][i] = 0;
        }
    }

    public void drawLine(int x, int y){
        x = x - 1;
        y = y - 1;
        if(x >= 0 && x < numberOfPerson - 1 && y >= 0 && y < numberOfRow) {
            rows[y][x] = 1;
            rows[y][x + 1] = -1;
        }
    }

    public int run(int row){

        if(row < 1 || row > numberOfPerson){ // 유효하지 않은 행일 때
            return 0;
        }
        row -= 1;
        int col = 0;
        while(col < numberOfRow){
            if(rows[col][row] != 0) {
                row += rows[col][row];
            }
            col++;
        }
        return row+1;
    }
}
