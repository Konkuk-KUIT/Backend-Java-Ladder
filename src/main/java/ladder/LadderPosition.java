package ladder;

public class LadderPosition {
    private Position rowPosition;
    private Position colPosition;

    private LadderPosition(Position rowPosition, Position colPosition) {
        this.rowPosition = rowPosition;
        this.colPosition = colPosition;
    }

    public static LadderPosition of(Position rowPosition, Position colPosition) {
        return new LadderPosition(rowPosition, colPosition);
    }

    public boolean isColPositionSame(Position colPosition) {
        return this.colPosition.isSame(colPosition);
    }


    public boolean isReachEnd(int numberOfRow) {
        return (rowPosition.getValue() == numberOfRow);
    }
}
