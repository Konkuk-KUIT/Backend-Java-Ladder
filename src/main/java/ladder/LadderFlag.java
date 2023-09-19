package ladder;

public class LadderFlag extends Ladder {
    /*이동후 비활성화 메서드*/

    public LadderFlag(int numberOfRows, int numberOfColumns) {
        super(numberOfRows, numberOfColumns);
    }
    public static void movedFlag(int row, int column){
        ladder[row][column]=Direction.FLAGED_COLUMN.getValue();
    }
    public static boolean leftFlag(int row, int column) {
        return column >0 &&ladder[row][column-1]==Direction.FLAGED_COLUMN.getValue();
    }
    public static boolean rightFlag(int row, int column){
        return  column < ladder[0].length && ladder[row][column]==Direction.FLAGED_COLUMN.getValue();
    }
}
