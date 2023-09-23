package ladder;

import java.util.Objects;

public class PositionSize {
    private Position row;
    private Position col;


    public PositionSize(Position row, Position col) {
        this.row = row;
        this.col = col;
    }

    public Position getRow() {
        return row;
    }

    public Position getCol() {
        return col;
    }

    public void updatePositions(Position row, Position col){
        this.row = row;
        this.col = col;
    }

}
