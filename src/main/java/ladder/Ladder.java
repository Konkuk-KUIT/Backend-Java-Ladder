package ladder;

import java.awt.*;

public class Ladder {

    private final Node[][] ladder;

    public Ladder(int numberOfRow, int numberOfPerson) {
        ladder = new Node[numberOfRow][numberOfPerson];
        for (int y=0; y<numberOfRow; y++){
            for (int x=0; x<numberOfPerson; x++){
                ladder[y][x] = Node.of(Direction.NONE);
            }
        }
    }


    public void drawLine(Point position, Direction direction) {
        Point crossed_point = new Point(position.x + direction.getDirection(), position.y);
        if (is_validate_position(position, crossed_point)) {
            this.ladder[position.y][position.x] = Node.of(direction);
            this.ladder[crossed_point.y][crossed_point.x] = Node.of(direction.reverse());
        }
    }

    /*
    입력받은 legPoint의 각 좌표값이 유효한 좌표값인지 판단하는 코드
    x좌표의 경우 0 ~ width 안에 들어오면 통과
    y좌표의 경우 가장 아래쪽은 도착지점이므로 사다리를 연결할 수 없다. 따라서 0 ~ height-1 안에 들어와야 통과
     */
    private boolean is_validate_position(Point position, Point crossed_point){
        return check_boundary(position, crossed_point) && check_overlapping(position, crossed_point);
    }

    // 다리가 연결될 양쪽 노드가 유효한 범위안에 있는지 체크
    private boolean check_boundary(Point position, Point crossed_point){
        if (0 <= position.x && position.x < ladder[0].length
                && 0 <= position.y && position.y < ladder.length
                && 0 <= crossed_point.y && crossed_point.y < ladder.length
                && 0 <= crossed_point.x & crossed_point.x < ladder[0].length){
            return true;
        }
        throw new ArrayIndexOutOfBoundsException("사다리 범위 밖으로는 다리를 그릴 수 없습니다.");
    }

    // 다리가 연결될 양쪽 노드 중 하나라도 겹치는 부분이 있는지 체크
    private boolean check_overlapping(Point position, Point crossed_point){
        if (this.ladder[position.y][position.x].is_NONE() && this.ladder[crossed_point.y][crossed_point.x].is_NONE()){
            return true;
        }
        throw new IllegalArgumentException("해당 지점에는 이미 사다리가 존재합니다.");
    }

    /*
    시작점의 x좌표를 입력받고 y좌표는 0부터 시작
    y좌표가 사다리의 가장 아래에 도달하면 도착한 것으로 구현
     */
    public int run(int start_point){
        int y = 0;
        int x = start_point;
        while(y < ladder.length){
            Node cur_position = ladder[y][x];
            Point dir = cur_position.move();    // 다음으로 이동할 방향 (y, x) 형태로 반환
            // 이동방향에 따라 좌표 업데이트
            y += dir.y;
            x += dir.x;
            // 서로서로를 가리켜서 무한루프에 빠지기 때문에 좌우 이동인 경우 다음 위치를 바로 한칸 내려주어야 한다. 따라서 y좌표에서 1을 더해줌
            if (!cur_position.is_NONE()){
                y += 1;
            }
        }
        return x;
    }
}
