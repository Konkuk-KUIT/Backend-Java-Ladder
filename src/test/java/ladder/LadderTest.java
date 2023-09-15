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
    void 사다리_사람_예외_처리_확인() {
        //when
        int numberOfPerson = 3;
        Ladder ladder = new Ladder(1, numberOfPerson);

        //given
        int nthOfPerson = 4;
        Position position = Position.of(nthOfPerson);

        //then
        assertThrows(IllegalArgumentException.class, ()->ladder.run(position));
    }

    @Test
    void 사다리_결과_확인() {
        //when
        int numberOfPerson = 4;
        int row = 3;
        Ladder ladder = new Ladder(row, numberOfPerson);

        ladder.drawLine(Position.of(0),Position.of(0));
        ladder.drawLine(Position.of(1),Position.of(1));
        ladder.drawLine(Position.of(2),Position.of(0));

        //given
        int nthOfPerson = 0;
        Position position = Position.of(nthOfPerson);

        //then
        assertEquals(2, ladder.run(position));

        //given
        nthOfPerson = 1;
        position = Position.of(nthOfPerson);

        //then
        assertEquals(1, ladder.run(position));

        //given
        nthOfPerson = 2;
        position = Position.of(nthOfPerson);

        //then
        assertEquals(0, ladder.run(position));
    }

}