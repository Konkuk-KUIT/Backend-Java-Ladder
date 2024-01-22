package ladder;

public class Row {

    private int[] row;

    public Row(int size) {
        this.row = new int[size];
    }

    public void drawLine(int index) {
        if(row[index] != 0)
            return;
        if(index < row.length-1)
            row[index] = 1;
        if(index + 1 <= row.length-1)
            row[index+1] = -1;
    }

    public int getLine(int index) {
        return row[index];
    }


}
