package ladder;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

import static ladder.ExceptionMessage.*;

public class Row {
    public int[] row;

    public Row(NaturalNumber height){

        row = new int[height.getNumber()];
        initializeRow(row);
    }


    private void initializeRow(int @NotNull [] line) {
        for(int i=0; i<line.length; i++){
            line[i] = 0;
        }
    }

    public void drawLine(int position) {
        validateDrawLinePosition(position);
        row[position] = Direction.RIGHT.getValue();
        row[position + 1] = Direction.LEFT.getValue();
    }

    private void validateDrawLinePosition(int position) {
        if(position >= row.length -1 || position < 0 || row[position] == Direction.LEFT.getValue() || row[position + 1] == Direction.RIGHT.getValue()){
            throw new IllegalArgumentException(INVALID_DRAW_POSITION.getMessage());
        }
    }

    public int nextPosition(int position) {
        validatePosition(position);
        
        if(isRight(position)){
            return position + 1;
        }
        if(isLeft(position)){
            return position - 1;
        }
        return position;
    }

    private void validatePosition(int position) {
        if(position >= row.length || position < 0){
            throw new IllegalArgumentException("");
        }
    }

    private boolean isRight(int position) { return row[position] == Direction.RIGHT.getValue(); }

    private boolean isLeft(int position) { return row[position] == Direction.LEFT.getValue(); }


//    public void printRow() {
//        for(int i=0; i<row.length; i++){
//            System.out.println(row[i]+" ");
//        }
//    }
}
