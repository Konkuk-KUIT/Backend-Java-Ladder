package ladder;


public class LadderMove extends Ladder{

    /*좌표값으로 나타내기위해 이차원 배열
    캡슐화, 외부에서 접근 못하게 private로 선언
    매직 넘버 사용으로 불분명한 숫자 의미 확실하게*/
    private static final int CREATED_COLUMN = 1;
    private static final int FLAGED_COLUMN = 0;

    public LadderMove(int numberOfRows, int numberOfColumns) {
        super(numberOfRows, numberOfColumns);
    }
    /*인스턴스 생성
    좌표값에해당하는 배열의 값에 CREATED_COLUMN이 들어있으면 가로선 존재*/

    public int getLadder(int row,int column){
        return ladder[row][column];
    }
    /* 선택 행 유효성 검사 */
    public static boolean isValidRow(int row, int column){
        return row >0 && row <=Ladder.ladder.length && column >0 &&column <=ladder[0].length;
    }
    /* 선택 열 유효성 검사 */
    public static boolean isValidColumn(int column) {
        return column >0 && column <= ladder[0].length;
    }
    /* 현재 들어있는 값이 1인지를 확인*/
    private static boolean canMoveRight(int row, int column){
        return column < ladder[0].length && ladder[row][column] == CREATED_COLUMN;
    }
    /* 현재 열 왼쪽에 들어있는 값이 1인지를 확인*/
    private static boolean canMoveLeft(int row, int column){
        return column >0 && ladder[row][column-1] == CREATED_COLUMN;
    }
    private static boolean canMove(int row, int column){
        return canMoveRight(row,column) || canMoveLeft(row,column);
    }
    /*이동한 가로선 비활성*/
    public static void movedFlag(int row, int column){
        ladder[row][column]=FLAGED_COLUMN;
    }
    public static boolean leftFlag(int row, int column) {
        return column >0 &&ladder[row][column-1]==FLAGED_COLUMN;
    }
    public static boolean rightFlag(int row, int column){
        return  column < ladder[0].length && ladder[row][column]==FLAGED_COLUMN;
    }

    public static int moveColumn(int row,int column){

        /* 오른쪽으로 갈 수 있는 선(1로 표시)이 있다면 오른쪽 열로 이동*/
        if (canMoveRight(row, column)) {
            movedFlag(row,column);
            column++;
        }
        /* 왼쪽으로 갈 수 있는 선(1로 표시)이 있다면 왼쪽 열로 이동*/
        if(canMoveLeft(row,column)) {
            movedFlag(row, column - 1);
            column--;
        }
        return column;
    }
    /*세로 이동 메서드*/
    public static int moveRow(int row,int column){
        /* 오른쪽, 왼쪽 모두 이동할 수 없으면 세로로 이동*/
        if(!canMove(row,column)){
            if(leftFlag(row,column)){
                ladder[row][column-1]=CREATED_COLUMN;
            }
            if(rightFlag(row,column)){
                ladder[row][column]=CREATED_COLUMN;
            }
            row++;
        }
        return row;
    }

}
