package ladder;

import java.util.Objects;

public class LadderPosition {
    private final Position row;
    private final Position col;

    private LadderPosition(Position row, Position col) {
        this.row = row;
        this.col = col;
    }

    public Position getRow() {
        return row;
    }

    public Position getCol() {
        return col;
    }

    public int getRowPosition() {
        return row.getValue();
    }

    public int getColPosition() {
        return col.getValue();
    }

    static LadderPosition of(Position row, Position col) {
        return new LadderPosition(row, col);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LadderPosition that = (LadderPosition) o;

        return Objects.equals(getRow(), that.getRow()) && Objects.equals(getCol(), that.getCol());
    }
}

