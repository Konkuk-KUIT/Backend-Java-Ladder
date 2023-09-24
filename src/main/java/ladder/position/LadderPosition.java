package ladder.position;

public class LadderPosition {
    private final int currentRow;
    private final Position currentColumn;
    public LadderPosition(int i, Position currentColumn) {
        this.currentRow = i;
        this.currentColumn = currentColumn;
    }
    public int getCurrentRow() {
        return currentRow;
    }

    public Position getCurrentColumn() {
        return currentColumn;
    }
}
