package ladder;

import java.awt.*;

public class LadderRunner {

    private Node[][] ladder;

    public LadderRunner(Node[][] ladder){
        this.ladder = ladder;
    }
    /*
    시작점의 x좌표를 입력받고 y좌표는 0부터 시작
    y좌표가 사다리의 가장 아래에 도달하면 도착한 것으로 구현
     */
    public int run(int start_point){
        LadderPosition position = LadderPosition.of(0, start_point);
        while(position.getY() < ladder.length){
            Node cur_position = ladder[position.getY()][position.getX()];
            cur_position.move(position);    // 왼오 이동 혹은 아무것도 이동안하기
            position.move_down();   // 한칸 내려가기
        }
        return position.getX();
    }
}
