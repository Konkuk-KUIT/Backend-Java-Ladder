package ladder;

import java.awt.*;

public class LadderCreator {

    private final Node[][] ladder;

    public LadderCreator(int numberOfRow, int numberOfPerson) {
        ladder = new Node[numberOfRow][numberOfPerson];
        for (int y=0; y<numberOfRow; y++){
            for (int x=0; x<numberOfPerson; x++){
                ladder[y][x] = Node.of(Direction.NONE);
            }
        }
    }

    public Node[][] getLadder(){
        return this.ladder;
    }


    public void drawLine(LadderPosition position, Direction direction) {
        LadderPosition crossed_position = LadderPosition.of(position.getY(), position.getX() + direction.getDirection());
        is_validate_position(position, crossed_position);
        this.ladder[position.getY()][position.getX()] = Node.of(direction);
        this.ladder[crossed_position.getY()][crossed_position.getX()] = Node.of(direction.reverse());
    }

    /*
    입력받은 legPoint의 각 좌표값이 유효한 좌표값인지 판단하는 코드
    x좌표의 경우 0 ~ width 안에 들어오면 통과
    y좌표의 경우 가장 아래쪽은 도착지점이므로 사다리를 연결할 수 없다. 따라서 0 ~ height-1 안에 들어와야 통과
     */
    private boolean is_validate_position(LadderPosition position, LadderPosition crossed_point){
        return check_boundary(position, crossed_point) && check_overlapping(position, crossed_point);
    }

    // 다리가 연결될 양쪽 노드가 유효한 범위안에 있는지 체크
    private boolean check_boundary(LadderPosition position, LadderPosition crossed_position){
        if (position.is_smaller_than_height(ladder.length)
                && position.is_smaller_than_width(ladder[0].length)
                && crossed_position.is_smaller_than_width(ladder[0].length)
                && crossed_position.is_smaller_than_height(ladder.length)){
            return true;
        }
        throw new ArrayIndexOutOfBoundsException("사다리 범위 밖으로는 다리를 그릴 수 없습니다.");
    }

    // 다리가 연결될 양쪽 노드 중 하나라도 겹치는 부분이 있는지 체크
    private boolean check_overlapping(LadderPosition position, LadderPosition crossed_point){
        if (this.ladder[position.getY()][position.getX()].is_NONE() && this.ladder[crossed_point.getY()][crossed_point.getX()].is_NONE()){
            return true;
        }
        throw new IllegalArgumentException("해당 지점에는 이미 사다리가 존재합니다.");
    }
}
