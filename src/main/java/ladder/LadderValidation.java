package ladder;

public class LadderValidation extends Ladder {
    /* 선택 행,열 유효성 검사 */
    public LadderValidation(int numberOfRows, int numberOfColumns) {
        super(numberOfRows, numberOfColumns);
    }
    public static void isValidRow(int row, int column){
        if (!(row >0 && row <=Ladder.ladder.length && column >0 &&column <=ladder[0].length)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_DRAW_POSITION.getMessage());
        }
    }
    /* 선택 열 유효성 검사 */
    public static void isValidClumn(int column){
        if (!(column >0 && column <= ladder[0].length)){
            throw new IllegalArgumentException(ExceptionMessage.INVALID_RUN_POSITION.getMessage());
        }
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
