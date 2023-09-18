package ladder;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

    @Test
    void 사다리_생성() {
        //given
        int numberOfRow = 3;
        int numberOfPerson = 5;

        //when
        Ladder ladder = new Ladder(numberOfRow, numberOfPerson);

        //then
        assertNotNull(ladder);
        ladder.printResultLadder();
    }

    @Test
    void 사다리_라인_생성(){
        //given
        int numberOfRow = 3;
        int numberOfPerson = 5;

        //when
        Ladder ladder = new Ladder(numberOfRow, numberOfPerson);
        ladder.drawLine(new Position(1,1));
        ladder.drawLine(new Position(2,4));
        ladder.drawLine(new Position(2,1));

        //then
        assertEquals(1, ladder.getValueOfLadder(1,1));
        assertEquals(-1, ladder.getValueOfLadder(1,2));

        assertEquals(1, ladder.getValueOfLadder(2,4));
        assertEquals(-1, ladder.getValueOfLadder(2,5));

        assertEquals(1, ladder.getValueOfLadder(2,1));
        assertEquals(-1, ladder.getValueOfLadder(2,2));

        ladder.printResultLadder();
    }

    @Test
    void 사다리_라인_오류(){
        //given
        int numberOfRow = 3;
        int numberOfPerson = 5;

        //when
        Ladder ladder = new Ladder(numberOfRow, numberOfPerson);
        ladder.drawLine(new Position(1,1));

        //then
        // Case 1 : 사다리의 끝(5)에서 라인 생성
        assertThrows(Exception.class, () -> ladder.drawLine(new Position(1, 5)));

        // Case 2 : 범위 벗어난 Position
        assertThrows(Exception.class, () -> ladder.drawLine(new Position(4,3)));
        assertThrows(Exception.class, () -> ladder.drawLine(new Position(2,6)));

        // Case 3 : 이미 그려진 row
        assertThrows(Exception.class, () -> ladder.drawLine(new Position(1,1)));
    }

    @Test
    void 사다리_동작_비어있는경우(){
        //given
        int numberOfRow = 3;
        int numberOfPerson = 5;

        //when
        Ladder ladder = new Ladder(numberOfRow, numberOfPerson);

        //then
        assertEquals(1, ladder.run(1));
        assertEquals(2, ladder.run(2));
        assertEquals(3, ladder.run(3));
    }

    @Test
    void 사다리_동작_비어있지않은경우(){
        //given
        int numberOfRow = 3;
        int numberOfPerson = 5;

        //when
        Ladder ladder = new Ladder(numberOfRow, numberOfPerson);
        ladder.drawLine(new Position(1,1));
        ladder.drawLine(new Position(1,3));
        ladder.drawLine(new Position(2,2));
        ladder.drawLine(new Position(3,1));
        ladder.drawLine(new Position(3,4));

        //then
        assertEquals(3, ladder.run(1));
        assertEquals(2, ladder.run(2));
        assertEquals(5, ladder.run(3));
        assertEquals(1, ladder.run(4));
        assertEquals(4, ladder.run(5));
    }
}