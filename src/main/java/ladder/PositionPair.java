package ladder;

public class PositionPair {
    private Position row;
    private Position col;
    public PositionPair(Position row, Position col){
        this.row=row;
        this.col=col;
    }
    public Position getPositionRow(){return row;}
    public Position getPositionCol(){return col;}
}
