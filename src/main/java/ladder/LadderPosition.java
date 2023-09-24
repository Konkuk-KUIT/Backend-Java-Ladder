package ladder;

public class LadderPosition {

    private Position row;
    private Position col;

    LadderPosition(Position row, Position col){
        this.row = row;
        this.col = col;
    }

    public static LadderPosition of(Position row, Position col){
        return new LadderPosition(row, col);
    }

    public Position getRow() {
        return row;
    }

    public Position getCol() {
        return col;
    }
}
