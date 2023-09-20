package ladder;

public class Ladder {

    private final int[][] ladder;  //using wrapper class in <java.lang>
    private final int numberOfRow;
    private final int numberOfPerson;

    public Ladder(int numberOfRow, int numberOfPerson) {
        outOfBound_creator(numberOfRow,numberOfPerson);
        ladder = new int[numberOfRow][numberOfPerson];
        this.numberOfRow = numberOfRow;
        this.numberOfPerson = numberOfPerson;
    }

    public void drawLine(int row, int col1, int col2){
        outOfBound_drawLine(row, col1, col2);
        this.ladder[row-1][col1-1] += 1;
        this.ladder[row-1][col2-1] += -1;
    }

    public int run(int current_col){
        outOfBound_run(current_col);
        current_col--;
        for(int i =0;i<this.numberOfRow;i++){
            current_col = move_col(i,current_col);
        }
        return current_col+1;
    }

    public boolean isExist(int row, int col, int value){
        if(this.ladder[row-1][col-1] == value){
            return true;
        }
        return false;
    }

    private int move_col(int row, int col){
        if(this.ladder[row][col] ==0){
            return col;
        }
        int next_col = col + this.ladder[row][col];
        while(this.ladder[row][next_col] ==0){
            next_col += this.ladder[row][col];
        }
        return next_col;
    }

    private void outOfBound_creator(int numberOfRow, int numberOfPerson){
        if(numberOfRow <= 0 || numberOfPerson <= 0){
            throw new ArrayIndexOutOfBoundsException();
        }
        if(numberOfRow > 10 || numberOfPerson > 10){
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    private void outOfBound_drawLine(int row, int col1, int col2){
        if(row <= 0 || row > this.numberOfRow){
            throw new ArrayIndexOutOfBoundsException();
        }
        if(col1 <= 0 || col1 >= col2 || col2 > this.numberOfPerson){
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    private void outOfBound_run(int current_col){
        if(current_col < 1 || current_col > this.numberOfPerson) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }
}
