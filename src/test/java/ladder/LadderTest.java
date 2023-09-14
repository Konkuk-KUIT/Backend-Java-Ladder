package ladder;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

    private Ladder ladder;

    @BeforeEach
    void setup_ladder(){
        ladder = new Ladder(5, 5);
    }

    @Test
    @DisplayName("빈 사다리 생성")
    void create_empty_ladder() {
        //given
        int numberOfRow = 3;
        int numberOfPerson = 5;

        //when
        Ladder new_ladder = new Ladder(numberOfRow, numberOfPerson);

        //then
        assertNotNull(new_ladder);
    }

    @Test
    @DisplayName("사다리에 다리 생성")
    void draw_ladder_leg() {
        Ladder.LegPoint legPoint_1 = new Ladder.LegPoint(3, 1, 0, 4);
        Ladder.LegPoint legPoint_2 = new Ladder.LegPoint(2, 4, 1, 3);
        Ladder.LegPoint legPoint_fail = new Ladder.LegPoint(0, 3, 6, 4);

        // 0은 연결 안된 다리
        // 0 이상의 숫자는 현재 위치에서 연결된 타겟의 포지션 (y*width + x + 1)
        int[][] target_ladder =
                {{0, 0, 0, 0, 17},
                {0, 0, 0, 15, 0},
                {0, 0, 0, 0, 9},
                {0, 5, 0, 0, 0},
                {0, 0, 0, 0, 0}};

        ladder.drawLine(legPoint_1);
        ladder.drawLine(legPoint_2);
        Throwable exception = assertThrows(RuntimeException.class, () -> {
            ladder.drawLine(legPoint_fail);
        });

        assertEquals("사다리를 그릴 수 없는 좌표를 설정하였습니다.", exception.getMessage());
        assertArrayEquals(ladder.getLadder(), target_ladder);
    }

    @Test
    @DisplayName("사다리 도착지점")
    void run_ladder(){
        // draw_ladder_leg() 함수에서 작성한 사다리와 동일
        Ladder.LegPoint legPoint_1 = new Ladder.LegPoint(3, 1, 0, 4);
        Ladder.LegPoint legPoint_2 = new Ladder.LegPoint(2, 4, 1, 3);

        ladder.drawLine(legPoint_1);
        ladder.drawLine(legPoint_2);
        int dest_1 = ladder.run(0);
        int dest_2 = ladder.run(1);

        assertEquals(dest_1, 0);
        assertEquals(dest_2, 3);
    }
}