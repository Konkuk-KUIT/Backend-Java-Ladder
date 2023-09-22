package ladder;

public class LadderPosition {
    private final int currentRow;
    private final Position currnetColumn;
    public LadderPosition(int i, Position currentColumn) {
        this.currentRow = i;
        this.currnetColumn = currentColumn;
    }
    public int getCurrentRow() {
        return currentRow;
    }

    public Position getCurrnetColumn() {
        return currnetColumn;
    }
}
