package ladder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LadderTest {
    Ladder ladder;
    LadderRunner ladderRun;

    @BeforeEach
    void beforeEach() {
        ladder = new Ladder(6, 5);
        ladder.drawLine(0, 0);
        ladder.drawLine(1, 1);
        ladder.drawLine(2, 3);
        ladder.drawLine(4, 0);
        ladder.drawLine(5, 1);
        ladder.drawLine(4, 3);
        ladderRun = new LadderRunner(ladder);
    }

    @Test
    @DisplayName("사다리 생성 확인")
    void Ladder() {
        //given
        int numberOfRow = 3;
        int numberOfPerson = 5;
        //when
        Ladder ladderr = new Ladder(numberOfRow, numberOfPerson);
        //then
        assertEquals(3, ladderr.getColumnL());
        assertEquals(5, ladderr.getRowL());
    }

    @Test
    @DisplayName("다리 생성 확인")
    void drawLine() {
        //given
        int posYE = 6;
        int posX = 3;
        int posY = 2;
        //when

        //then
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> ladder.drawLine(posYE, posX));
        assertThrows(RuntimeException.class, () -> ladder.drawLine(posY, posX));
    }
    @Test
    @DisplayName("사다리 이용 확인")
    void run() {
        //given
        int cur0 = 0;
        int cur1 = 1;
        int cur2 = 2;
        int cur3 = 3;
        int cur4 = 4;
        //when
        cur0 = ladderRun.run(cur0);
        cur1 = ladderRun.run(cur1);
        cur2 = ladderRun.run(cur2);
        cur3 = ladderRun.run(cur3);
        cur4 = ladderRun.run(cur4);
        //then
        assertEquals(1, cur0);
        assertEquals(2, cur1);
        assertEquals(0, cur2);
        assertEquals(3, cur3);
        assertEquals(4, cur4);

    }
}