package ladder;

public class LadderLine {
    protected final int firstLine;
    protected final int secondLine;
    protected final int firstLineRow;
    protected final int secondLineRow;

    public LadderLine(int firstLine, int secondLine, int firstLineRow, int secondLineRow) {
        this.firstLine = firstLine;
        this.secondLine = secondLine;
        this.firstLineRow = firstLineRow;
        this.secondLineRow = secondLineRow;
    }

    public boolean isLineConnected(Position curPos) {

        if((curPos.xPos == firstLine && curPos.yPos == firstLineRow) || (curPos.xPos == secondLine && curPos.yPos == secondLineRow)) {
            return true;
        }

        return false;
    }

}
