package ladder;

import static ladder.Direction.*;
import static ladder.Ladder.rows;
import static ladder.ExceptionMessage.*;

public class LadderPlayerPrint {
    public static int leftMove(int currentRow, int currentCol){
        rows[currentRow][currentCol - 1] = PASSED_SPACE.getValue();
        currentCol--;
        return currentCol;
    }

    public static int rightMove(int currentRow, int currentCol){
        rows[currentRow][currentCol] = PASSED_SPACE.getValue();
        currentCol++;
        return currentCol;
    }
    public static boolean leftcheck(int currentRow, int currentCol, int num){
        return currentCol > 0 && rows[currentRow][currentCol - 1] == num;
    }

    public static boolean rightcheck(int currentRow,int currentCol,int num){
        return currentCol < rows[0].length - 1 && rows[currentRow][currentCol] == num;
    }

    public static void showPlayer(int currentRow, int currentCol){
        for(int i =0;i<rows.length; i++)
        {
            for(int j= 0; j<rows[0].length;j++){
                if(i==currentRow && j ==currentCol){
                    System.out.print(rows[i][j]+"*");
                }
                else {
                    System.out.print(rows[i][j]+" ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void printRun(int selectedCol) {
        if (selectedCol < 1 || selectedCol > rows[0].length) {
            throw new IllegalArgumentException(INVALID_RUN_POSITION.getMessage());
        }

        int currentRow = 0;
        int currentCol = selectedCol - 1;


        showPlayer(currentRow,currentCol);
        while (currentRow < rows.length) {

            if (leftcheck(currentRow,currentCol,1)) {
                currentCol=leftMove(currentRow,currentCol);
                showPlayer(currentRow,currentCol);
            }

            if (rightcheck(currentRow,currentCol, 1)) {
                currentCol=rightMove(currentRow,currentCol);
                showPlayer(currentRow,currentCol);
            }

            if(!leftcheck(currentRow,currentCol,1) && !rightcheck(currentRow,currentCol, 1)){
                if (leftcheck(currentRow,currentCol,2)) {
                    rows[currentRow][currentCol-1] = CREATED_LINE_SPACE.getValue();
                }
                if(rightcheck(currentRow,currentCol, 2)){
                    rows[currentRow][currentCol] = CREATED_LINE_SPACE.getValue();
                }
                currentRow++;
                showPlayer(currentRow,currentCol);
            }
        }
    }
}
