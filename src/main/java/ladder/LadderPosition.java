package ladder;

// 러너의 현재 좌표값을 저장하고 있는 객체
public class LadderPosition {

    private final Position X;
    private final int Y;

    public LadderPosition(Position x, int y){
        this.X = x;
        this.Y = y;
    }

    public Position getX(){
        return X;
    }

    public int getY(){
        return Y;
    }

}
