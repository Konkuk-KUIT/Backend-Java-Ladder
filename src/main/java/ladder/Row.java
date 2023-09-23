package ladder;

import static ladder.ExceptionMessage.*;

public class Row {
    private final int[] row;

    public Row(int numberOfPerson) {
        this.row = new int[numberOfPerson];
    }

    public int nextLevel(int i) { // 사다리타고 내려가기
        checkColRange(i);
        return i + row[i-1]; // 내려간뒤의 사다리 번호
    }

    private void checkColRange(int i) { //범위 체크
        if (i -1 > row.length-1) {
            throw new RuntimeException();
        }
    }

    public void drawLine(int startColumn) {
        checkDrawable(startColumn);
        row[startColumn-1] = Direction.RIGHT.getValue();
        row[startColumn] = Direction.LEFT.getValue();
    }

    private void checkDrawable(int startColumn) { //선을 그릴 수 있는 상황인지 체크
        if (row[startColumn-1]!=0 || row[startColumn]!=0){
            throw new IllegalArgumentException(INVALID_DRAW_POSITION.getMessage());
        }
    }
}
