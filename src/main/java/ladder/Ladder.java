package ladder;

public class Ladder {

    public static class LegPoint{
        private final int fromRow;
        private final int fromColumn;
        private final int toRow;
        private final int toColumn;

        public LegPoint(int fromRow, int fromColumn, int toRow, int toColumn){
            this.fromRow = fromRow;
            this.fromColumn = fromColumn;
            this.toRow = toRow;
            this.toColumn = toColumn;
        }
    }

    private final int[][] rows;

    public int[][] getLadder(){
        return rows;
    }

    public Ladder(int numberOfRow, int numberOfPerson) {
        rows = new int[numberOfRow][numberOfPerson];
    }

    public void drawLine(LegPoint legPoint){
        int from = legPoint.fromRow * rows[0].length + legPoint.fromColumn + 1;
        int to = legPoint.toRow * rows[0].length + legPoint.toColumn + 1;

        if (!validate_legPoints(legPoint)){
            throw new RuntimeException("사다리를 그릴 수 없는 좌표를 설정하였습니다.");
        }

        rows[legPoint.fromRow][legPoint.fromColumn] = to;
        rows[legPoint.toRow][legPoint.toColumn] = from;
    }

    private boolean validate_legPoints(LegPoint legPoint){
        return 0 <= legPoint.toRow && legPoint.toRow < rows.length - 1
                && 0 <= legPoint.fromRow && legPoint.fromRow < rows.length - 1
                && 0 <= legPoint.toColumn && legPoint.toColumn < rows[0].length
                && 0 <= legPoint.fromColumn && legPoint.fromColumn < rows[0].length;
    }
}
