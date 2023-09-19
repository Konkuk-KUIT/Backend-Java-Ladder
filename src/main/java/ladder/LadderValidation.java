package ladder;

public class LadderValidation extends Ladder {

    public LadderValidation(int numberOfRows, int numberOfColumns) {
        super(numberOfRows, numberOfColumns);
    }

    /*좌표값에해당하는 배열의 값에 CREATED_COLUMN이 들어있으면 가로선 존재*/
    /* 선택 행 유효성 검사 */
    public static boolean isValidRow(int row, int column){
        return row >0 && row <=Ladder.ladder.length && column >0 &&column <=ladder[0].length;
    }
    /* 선택 열 유효성 검사 */
    public static boolean isValidClumn(int column){
        return column >0 && column <= ladder[0].length;
    }
    /* 현재 들어있는 값이 1인지를 확인*/
    static boolean canMoveRight(int row, int column){
        return column < ladder[0].length && ladder[row][column] == Direction.CREATED_COLUMN.getValue();
    }
    /* 현재 열 왼쪽에 들어있는 값이 1인지를 확인*/
    static boolean canMoveLeft(int row, int column){
        return column >0 && ladder[row][column-1] == Direction.CREATED_COLUMN.getValue();
    }
    static boolean canMove(int row, int column){
        return canMoveRight(row,column) || canMoveLeft(row,column);
    }

}
