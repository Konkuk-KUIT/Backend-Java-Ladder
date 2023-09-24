package ladder;

import ladder.Exception.ErrorCode;
import ladder.Exception.ErrorMessage;
import ladder.Exception.LadderPositionOutOfBoundsException;

public class LadderPosition {
    private int y;
    private int x;

    // 초기화될 때에는 가장 위부터 초기화되므로 y좌표 0 고정
    private LadderPosition(int y, int x){
        this.y = y;
        this.x = x;
    }

    public static LadderPosition of(int y, int x){
        try {
            initialize_validation(y, x);
        } catch (LadderPositionOutOfBoundsException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return new LadderPosition(y, x);
    }

    public void move_down(){
        this.y += 1;
    }

    public void move_right(){
        this.x += 1;
    }

    public void move_left(){
        this.x -= 1;
    }

    private static void initialize_validation(int y, int x) throws LadderPositionOutOfBoundsException{
        if (x < 0 || y < 0){
            throw new LadderPositionOutOfBoundsException(ErrorCode.LADDER_ZERO_OUT_OF_BOUND_EXCEPTION, ErrorMessage.LADDER_ZERO_OUT_OF_BOUND_EXCEPTION);
        }
    }

    public int getY(){
        return this.y;
    }

    public int getX(){
        return this.x;
    }
}
