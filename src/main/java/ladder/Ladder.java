package ladder;

public class Ladder {

    private final int[][] rows;  //using wrapper class in <java.lang>
    private final Integer numberOfRow;
    private final Integer numberOfPerson;

    public Ladder(int numberOfRow, int numberOfPerson) {
        rows = new int[numberOfRow][numberOfPerson];
        this.numberOfRow = numberOfRow;
        this.numberOfPerson = numberOfPerson;
    }

    private void checkOutOfBound(int row, int col1, int col2){
        // row outOfBound 확인
        if(row-1 >= this.numberOfRow || row-1 < 0){
            throw new ArrayIndexOutOfBoundsException();
        }

        // col1, col2 outOfBound 확인
        if(col1-1 >= this.numberOfPerson || col1-1 < 0){
            throw new ArrayIndexOutOfBoundsException();
        }
        if(col2-1 >= this.numberOfPerson || col2-1 < 0){
            throw new ArrayIndexOutOfBoundsException();
        }

        //사다리 index 입력을 col1 + 1 == col2 만 허용
        if(col1+1 != col2){
            throw new IllegalArgumentException();
        }
    }

    public void drawLine(int row, int col1, int col2){
        checkOutOfBound(row, col1, col2);
        this.rows[row-1][col1-1]++;
        this.rows[row-1][col2-1]--;
    }

    public boolean existLine(int row, int col1, int col2){
        checkOutOfBound(row, col1, col2);
        if(this.rows[row-1][col1-1] != 0 && this.rows[row-1][col2-1] != 0){
            return true;
        }
        return false;
    }

    public int run(int col){
        int current_col = col-1;
        for(int i =0;i<this.numberOfRow;i++){
            current_col = move_ladder(i,current_col);
        }
        return current_col+1;
    }

    private int move_ladder(int row, int col){
        if(this.rows[row][col] == 0){
            return col;
        }
        int next_col =  col + this.rows[row][col];
        while(this.rows[row][next_col] == 0){
            next_col = next_col + this.rows[row][col];
        }
        return next_col;
    }
}
