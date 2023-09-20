package ladder;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

    // =================================== 2주차 ===================================
    // test code 를 먼저 작성하고 test를 통과하기 위한 구현을 한다.

    @DisplayName("생성자 테스트")
    @Test
    void 사다리_객체생성_확인(){
        Ladder ladder = new Ladder(3,5);
        assertNotNull(ladder);
    }

    @DisplayName("drawLine 메서드 테스트")
    @Test
    void 사다리_다리생성_확인(){
        Ladder ladder= new Ladder(3,5);

        // 다리가 하나만 일 때
        ladder.drawLine(1, 3,4);
        assertEquals(true, ladder.isExist(1,3,1));
        assertEquals(true, ladder.isExist(1,4,-1));

        //다리가 연속으로 존재할 때
        ladder.drawLine(1,4,5);
        assertEquals(true, ladder.isExist(1,3,1));
        assertEquals(true, ladder.isExist(1,4,0));
        assertEquals(true, ladder.isExist(1,5,-1));
    }

    @DisplayName("run 메소드 테스트")
    @Test
    void 사다리_작동_확인(){
        Ladder ladder= new Ladder(3,5);

        ladder.drawLine(1,1,2);
        ladder.drawLine(1,3,4);
        ladder.drawLine(2,2,3);
        ladder.drawLine(2,3,4);
        ladder.drawLine(3,1,2);
        ladder.drawLine(3,4,5);

        assertEquals(5, ladder.run(1));
        assertEquals(2, ladder.run(2));
        assertEquals(1, ladder.run(3));
        assertEquals(3, ladder.run(4));
        assertEquals(4, ladder.run(5));
    }

    @DisplayName("outOfBound_creater 메소드 확인")
    @Test
    void 사다리_객체_인자값_범위확인(){
        // numberOfRow 1 이상인지
        assertThrows(Exception.class, () -> {Ladder ladder = new Ladder(0,5);});

        //numberOfPerson 1 이상인지
        assertThrows(Exception.class, () -> {Ladder ladder = new Ladder(5,0);});

        // upper bound 정의
        assertThrows(Exception.class, () -> {Ladder ladder = new Ladder(11,5);});
        assertThrows(Exception.class, () -> {Ladder ladder = new Ladder(5,11);});
    }

    @DisplayName("outOfBound_drawLine 메소드 확인")
    @Test
    void 사다리_다리생성_인자값_범위확인(){
        Ladder ladder = new Ladder(3,5);

        //row 범위
        assertThrows(Exception.class, () -> ladder.drawLine(0,1,2));
        assertThrows(Exception.class, () -> ladder.drawLine(4,1, 2));

        //col 범위
        assertThrows(Exception.class, () -> ladder.drawLine(1,0,1));
        assertThrows(Exception.class, () -> ladder.drawLine(1,2,1));
        assertThrows(Exception.class, () -> ladder.drawLine(1,1,6));
    }

    @DisplayName("outOfBound_run 메소드 확인")
    @Test
    void 사다리_작동_인자값_범위확인(){
        Ladder ladder =new Ladder(3,5);

        assertThrows(Exception.class, () -> ladder.run(0));
        assertThrows(Exception.class, () -> ladder.run(6));
    }
}