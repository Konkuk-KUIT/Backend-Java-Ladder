package ladder;

public class LadderPosition {

    private Position x;
    private Position y;

    LadderPosition(Position x, Position y){
        this.x = x;
        this.y = y;
    }

    public static boolean PositionisEquall(LadderPosition a, LadderPosition b){
        return (a.x.getValue() == b.x.getValue()) && (a.y.getValue() == b.y.getValue());
    }
}
