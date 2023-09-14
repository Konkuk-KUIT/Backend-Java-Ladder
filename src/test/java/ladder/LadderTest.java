package ladder;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class LadderTest {

    @Test
    void 사다리_생성_확인() {
        //given
        int numberOfRow = 3; //사다리 높이
        int numberOfPerson = 5; //사다리 줄 개수

        //when
        Ladder ladder = new Ladder(numberOfRow, numberOfPerson);

        //then
        assertNotNull(ladder);
    }

    @Test
    void 사다리_라인_생성_확인() {
        //given
        int numberOfRow = 3;
        int numberOfPerson = 4;

        //when
        Ladder ladder = new Ladder(numberOfRow, numberOfPerson);
        ladder.drawLine(0,0);

        //then
        assertEquals(1, ladder.getRows()[0][0]);
        assertEquals(-1, ladder.getRows()[0][1]);
    }

    @Test
    void 사다리_라인_생성_인덱스_오류() {

        //given
        int numberOfRow = 3;
        int numberOfPerson = 4;

        //when
        Ladder ladder = new Ladder(numberOfRow, numberOfPerson);

        //then
        assertThrows(Exception.class, () -> ladder.drawLine(-1,0));
        assertThrows(Exception.class, () -> ladder.drawLine(3,2));
        assertThrows(Exception.class, () -> ladder.drawLine(0,-1));
        assertThrows(Exception.class, () -> ladder.drawLine(2,4));
    }

    @Test
    void 사다리_라인_생성_중복_오류() {

        //given
        int numberOfRow = 3;
        int numberOfPerson = 4;

        //when
        Ladder ladder = new Ladder(numberOfRow, numberOfPerson);
        ladder.drawLine(1,1);

        //then
        assertThrows(Exception.class, () -> ladder.drawLine(1,1));
        assertThrows(Exception.class, () -> ladder.drawLine(1,2));
        assertThrows(Exception.class, () -> ladder.drawLine(1,0));
    }

    @Test
    void 사다리_실행_확인() {
        //given
        int numberOfRow = 3;
        int numberOfPerson = 4;

        //when
        Ladder ladder = new Ladder(numberOfRow, numberOfPerson);
        ladder.drawLine(0,0);
        ladder.drawLine(1,2);
        ladder.drawLine(2,1);

        //then
        assertEquals(2, ladder.run(0));
        assertEquals(0, ladder.run(1));
        assertEquals(3, ladder.run(2));
        assertEquals(1, ladder.run(3));
    }

    @Test
    void 사다리_실행_확인2() {
        //given
        int numberOfRow = 0;
        int numberOfPerson = 2;

        //when
        Ladder ladder = new Ladder(numberOfRow, numberOfPerson);

        //then
        assertEquals(1, ladder.run(1));
    }
}