package Ladder;

public class Row {
    public int[] row;

    public Row(int numberOfPerson){
        if (numberOfPerson < 1) {
            throw new IllegalArgumentException();
        }
        row = new int[numberOfPerson];
    }

    public void newRow(int positionY){
       if (positionY >= row.length -1 || positionY <0 || row[positionY] == -1 || row[positionY + 1] == 1){
           throw new IllegalArgumentException();
       }
        row[positionY] = 1;
        row[positionY + 1] = -1;
    }

    public int destination(int rowNumber){
        if (rowNumber >= row.length || rowNumber < 0){
            throw new IllegalArgumentException();
        }
        if (row[rowNumber] == 1){
            return rowNumber + 1;
        }
        if (row[rowNumber] == -1){
            return rowNumber - 1;
        }
        return rowNumber;
    }

}

