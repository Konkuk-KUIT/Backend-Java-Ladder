package ladder;

public class Ladder {

    private final int[][] rows;
    private int numberOfRow;
    private int numberOfPerson;

    public Ladder(int numberOfRow, int numberOfPerson) {
        rows = new int[numberOfRow][numberOfPerson];
        this.numberOfRow = numberOfRow;
        this.numberOfPerson = numberOfPerson;
    }

    public int[][] getRows() {
        return rows;
    }

    public void drawLine(int x, int y) {
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

}
