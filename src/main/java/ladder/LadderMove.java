package ladder;


public class LadderMove extends Ladder{
    public LadderMove(int numberOfRows, int numberOfColumns) {
        super(numberOfRows, numberOfColumns);
    }

    /*가로 이동 메서드*/
    public static int moveColumn(int row,int column){
        /* 오른쪽으로 갈 수 있는 선(1로 표시)이 있다면 오른쪽 열로 이동*/
        if (LadderValidation.canMoveRight(row, column)) {
            LadderFlag.movedFlag(row,column);
            column++;
        }
        /* 왼쪽으로 갈 수 있는 선(1로 표시)이 있다면 왼쪽 열로 이동*/
        if(LadderValidation.canMoveLeft(row,column)) {
            LadderFlag.movedFlag(row, column - 1);
            column--;
        }
        return column;
    }

    /*세로 이동 메서드*/
    public static int moveRow(int row,int column){
        /* 오른쪽, 왼쪽 모두 이동할 수 없으면 세로로 이동*/
        if(!LadderValidation.canMove(row,column)){
            if(LadderFlag.leftFlag(row,column)){
                ladder[row][column-1]=Direction.CREATED_COLUMN.getValue();
            }
            if(LadderFlag.rightFlag(row,column)){
                ladder[row][column]=Direction.CREATED_COLUMN.getValue();
            }
            row++;
        }
        return row;
    }
}
