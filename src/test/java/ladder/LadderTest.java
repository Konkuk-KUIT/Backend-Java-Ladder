package ladder;

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

    @Test
    void 라인_생성_확인() {
        //given
        int row = 3;
        int col = 3;

        //when
        Ladder ladder = new Ladder(row, col);
        ladder.drawLine(1, 1);

        //then
        assertNotNull(ladder.getRows());
        assertEquals(1, ladder.getRows()[1][1]);
    }

    @Test
    void 게임_작동_확인() {
        //given
        int row = 3;
        int col = 3;

        //when
        Ladder ladder = new Ladder(row, col);
        ladder.drawLine(1, 1);

        //then
        assertEquals(2, ladder.run(1));
    }

    @Test
    void canDrawLine_범위_밖_확인() {
        Ladder ladder = new Ladder(3, 4);
        assertFalse(ladder.canDrawLine(5, 2));
    }

    @Test
    void canDrawLine_현재_위치_확인() {
        Ladder ladder = new Ladder(3, 4);
        ladder.drawLine(1, 1);
        assertFalse(ladder.canDrawLine(1, 1));
    }

    @Test
    void canDrawLine_왼쪽_오른쪽_확인() {
        Ladder ladder = new Ladder(3, 4);
        ladder.drawLine(1, 1);
        assertFalse(ladder.canDrawLine(1, 0));
        assertFalse(ladder.canDrawLine(1, 2));
    }

    @Test
    void isIncorrectPosition_범위_밖_확인() {
        Ladder ladder = new Ladder(3, 4);
        assertTrue(ladder.isIncorrectPosition(5, 2));
        assertTrue(ladder.isIncorrectPosition(1, 4));
    }
}