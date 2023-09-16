package ladder;

public class Ladder {

    private final Row[] rows;

    public Ladder(int numberOfRow, int numberOfPerson) {
        rows = new Row[numberOfRow];
        for (int i=0; i< numberOfRow; i++){
            rows[i] = new Row(numberOfPerson);
        }
    }

    public int run(int i) {
        for (int level=0; level< rows.length; level++){
            i = rows[level].nextLevel(i);
        }
        return i;
    }

    public void drawLine(int startColumn, int row) {
        checkRowRange(row);
        rows[row].drawLine(startColumn);
    }

    private void checkRowRange(int row) {
        if (row >= rows.length) { //범위 체크
            throw new RuntimeException();
        }
    }
}
