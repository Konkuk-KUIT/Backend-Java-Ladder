package ladder;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class Row {
    public int[] row;

    public Row(int height){

        checkHeight(height);
        row = new int[height];
        initializeRow(row);
    }

    private void checkHeight(int height) {
        if(height < 0)
            throw new RuntimeException();
    }

    private void initializeRow(int @NotNull [] line) {
        for(int i=0; i<line.length; i++){
            line[i] = 0;
        }
    }

    public void drawLine(int position) {
        validateDrawLinePosition(position);
        row[position] = 1;
        row[position + 1] = -1;
    }

    private void validateDrawLinePosition(int position) {
        if(position >= row.length -1 || position < 0 || row[position] == -1 || row[position + 1] == 1){
            throw new IllegalArgumentException("사다리를 그릴 수 없는 위치힙니다.");
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

    private boolean isRight(int position) { return row[position] == 1; }

    private boolean isLeft(int position) { return row[position] == -1; }


//    public void printRow() {
//        for(int i=0; i<row.length; i++){
//            System.out.println(row[i]+" ");
//        }
//    }
}
