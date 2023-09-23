package ladder;

import static ladder.ExceptionMessage.*;

public class Row {
    private final int[] row;

    public Row(NaturalNumber numberOfPerson) {
        this.row = new int[numberOfPerson.getNumber()];
    }

    public Position nextLevel(Position currentPosition) { // 사다리타고 내려가기
        checkColRange(currentPosition);
        if(isRight(currentPosition)){
            return currentPosition.next();
        }
        if(isLeft(currentPosition)){
            return currentPosition.prev();
        }
        return currentPosition;
    }

    private boolean isLeft(Position position) {
        return row[position.getValue()-1] == Direction.LEFT.getValue();
    }

    private boolean isRight(Position position) {
        return row[position.getValue()-1] == Direction.RIGHT.getValue();
    }

    private void checkColRange(Position position) { //범위 체크
        if (position.isBiggerThan(row.length-1) || position.isSmallerThan(0)) {
            throw new IllegalArgumentException(INVALID_DRAW_POSITION.getMessage());
        }
    }

    public void drawLine(Position startColumn) {
        checkDrawable(startColumn);
        row[startColumn.getValue()-1] = Direction.RIGHT.getValue();
        row[startColumn.getValue()] = Direction.LEFT.getValue();
    }

    private void checkDrawable(Position startColumn) { //선을 그릴 수 있는 상황인지 체크
        if (row[startColumn.getValue()-1]!=0 || row[startColumn.getValue()]!=0){
            throw new IllegalArgumentException(INVALID_DRAW_POSITION.getMessage());
        }
    }
}
