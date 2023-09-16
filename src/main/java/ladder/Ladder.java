package Ladder;

public class Ladder {
    private final Row[] rows;

    public Ladder(int numberOfRow, int numberOfPerson){

        rows = new Row[numberOfRow];
        for (int i=0;i<numberOfRow;i++){
            rows[i] = new Row(numberOfPerson);
        }
    }
    public void drawLine(int positionX, int positionY){
        rows[positionX].newRow(positionY);
    }
    public int run(int rowNumber){
        for (int i=0; i<rows.length; i++){
            rowNumber = rows[i].destination(rowNumber);
        }
        return rowNumber;
    }
}
