package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

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

    @DisplayName("사다리 라인 생성 확인 ")
    @Test
    public void testValidDrawLine() {
        Ladder ladder = new Ladder(4, 4);

        ladder.drawLine(1, 1);
        ladder.drawLine(1, 3);
        ladder.drawLine(2, 1);
        ladder.drawLine(3, 2);
        ladder.drawLine(4, 3);
    }

    @DisplayName("사다리 라인 범위 오류 확인")
    @Test
    public void testInvalidDrawLine(){
        Ladder ladder = new Ladder(4,4);
        assertThrows(IllegalArgumentException.class, () -> ladder.drawLine(0, 2));
        assertThrows(IllegalArgumentException.class, () -> ladder.drawLine(1, 6));
    }
    @DisplayName("run 결과 확인")
    @Test
    public void testRun(){
        Ladder ladder = new Ladder(4,4);

        ladder.drawLine(1, 1);
        ladder.drawLine(1, 3);
        ladder.drawLine(2, 1);
        ladder.drawLine(3, 2);
        ladder.drawLine(4, 3);

        assertEquals(1, ladder.run(1));
        assertEquals(4, ladder.run(2));
        assertEquals(3, ladder.run(3));
        assertEquals(2, ladder.run(4));
    }

}