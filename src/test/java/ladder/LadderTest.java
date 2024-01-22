package ladder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
    void 사다리_그리기_확인() {
        //given
        int numberOfRow = 3;
        int numberOfPerson = 5;

        //when
        Ladder ladder = new Ladder(numberOfRow, numberOfPerson);
        ladder.drawLine(0, 0);
        ladder.drawLine(1, 1);
        ladder.drawLine(4, 2);

        //then
        assertEquals(1, ladder.getLine(0,0));
        assertEquals(-1, ladder.getLine(1,0));
        assertEquals(1, ladder.getLine(1, 1));
        assertEquals(-1, ladder.getLine(2, 1));
        assertEquals(0, ladder.getLine(4, 2));
    }

    @Test
    void 사다리_실행() {
        //given
        int numberOfRow = 3;
        int numberOfPerson = 5;

        //when
        Ladder ladder = new Ladder(numberOfRow, numberOfPerson);
        ladder.drawLine(0, 0);
        ladder.drawLine(1, 1);
        ladder.drawLine(4, 2);

        //then
        assertEquals(2, ladder.run(0));
    }

}