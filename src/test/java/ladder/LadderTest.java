package ladder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

    @DisplayName("사다리 생성")
    @Test
    void 사다리_생성_확인() {
        //given
        int numberOfRow = 3;
        int numberOfPerson = 5;

        //when
        Ladder ladder = new Ladder(numberOfRow, numberOfPerson);

        //then
        assertNotNull(ladder);
    }

    @DisplayName("drawLine 예외 확인")
    @Test
    void 사다리_줄그리기_예외(){
        //given
        Ladder ladder = new Ladder(3, 5);

        //when
        ladder.drawLine(1,1);
        ladder.drawLine(1,3);

        //줄을 그으려고 하는 사다리 오른쪽에 이미 줄이 그어졌을 때
        assertThrows(Exception.class, ()->ladder.drawLine(1,2));

        // 사다리 높이가 생성된 사다리 높이보다 높을 때
        assertThrows(Exception.class, ()->ladder.drawLine(4,2));

        // 이미 줄이 그어진 곳에 줄을 그리려고 할 때
        assertThrows(Exception.class, ()->ladder.drawLine(1,1));

        // 줄을 그을 수 없는 사다리를 선택했을 때때
        assertThrows(Exception.class, ()->ladder.drawLine(4,1));
    }

    @DisplayName("run 확인")
    @Test
    public void run_확인(){
        //given
        Ladder ladder = new Ladder(3, 5);

        //when
        ladder.drawLine(0,0);
        ladder.drawLine(0,2);
        ladder.drawLine(1,1);
        ladder.drawLine(2,3);

        //then
        int answer = ladder.run(1); //사다리는 0~4까지 있음 (5명이 하기 때문에)
        assertEquals(answer,0);

    }

}