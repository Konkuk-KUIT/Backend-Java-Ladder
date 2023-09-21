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
        Ladder ladder = new Ladder(NaturalNumber.of(numberOfRow), NaturalNumber.of(numberOfPerson));

        //then
        assertNotNull(ladder);
    }

    @Test
    void 사다리_타기() {
        int numberOfRow = 4;
        int numberOfPerson = 5;
        Ladder ladder = new Ladder(NaturalNumber.of(numberOfRow), NaturalNumber.of(numberOfPerson));

        ladder.drawLine(1,2,Direction.RIGHT);
        ladder.drawLine(2,5,Direction.LEFT);
        ladder.drawLine(4,3,Direction.RIGHT);
        ladder.drawLine(2,2,Direction.LEFT);
        ladder.drawLine(3,3,Direction.LEFT);

        assertEquals(4,ladder.run(1));
        assertEquals(2,ladder.run(2));
        assertEquals(1,ladder.run(3));
        assertEquals(5,ladder.run(4));
        assertEquals(3,ladder.run(5));
    }
}