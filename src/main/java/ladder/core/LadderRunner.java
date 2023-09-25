package ladder.core;

import ladder.Ladder;
import ladder.LadderPosition;
import ladder.Node;

public class LadderRunner {

    private final Ladder ladder;
    private final int height;
    private final int width;

    private LadderRunner(Ladder ladder){
        this.ladder = ladder;
        this.height = ladder.getHeight();
        this.width = ladder.getWidth();
    }

    public static LadderRunner of(Ladder ladder){
        return new LadderRunner(ladder);
    }
    /*
    시작점의 x좌표를 입력받고 y좌표는 0부터 시작
    y좌표가 사다리의 가장 아래에 도달하면 도착한 것으로 구현
     */
    public int run(int start_point){
        System.out.println("-------- 사다리 게임 시작 ---------");
        LadderPosition position = LadderPosition.of(0, start_point);
        print_ladder_status(position);
        while(position.getY() < height){
            Node cur_node = ladder.getNodeByPosition(position);
            if(cur_node.move(position)){    // 왼오 이동 혹은 아무것도 이동안하기 (이동하면 true 이동 안하면 false)
                print_ladder_status(position);
            }
            position.move_down();   // 한칸 내려가기
            print_ladder_status(position);
        }
        return position.getX();
    }

    private void print_ladder_status(LadderPosition position){
        for (int i = 0; i < height; i++){
            print_ladder_row(i, position);
        }
        System.out.println();
    }

    private void print_ladder_row(int y, LadderPosition position){
        for (int i = 0; i < width; i++){
            print_node(i, y);
            print_separator(i, y, position);
        }
    }

    private void print_node(int x, int y){
        LadderPosition position = LadderPosition.of(y, x);
        Node node = ladder.getNodeByPosition(position);
        node.print_Node();
    }

    private void print_separator(int x, int y, LadderPosition position){
        if (x == width - 1) {
            System.out.println();
            return;
        }
        if (x == position.getX() && y == position.getY()) {
            System.out.print("* ");
            return;
        }
        System.out.print("  ");
    }
}
