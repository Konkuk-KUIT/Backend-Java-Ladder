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
    void 사다리_결과_확인() {
        //when
        int numberOfPerson = 4;
        int row = 3;
        Ladder ladder = new Ladder(row, numberOfPerson);

        ladder.drawLine(0,0);
        ladder.drawLine(1,1);
        ladder.drawLine(2,0);

        //given
        int nthOfPerson = 0;

        //then
        assertEquals(2, ladder.run(nthOfPerson));

        //given
        nthOfPerson = 1;

        //then
        assertEquals(1, ladder.run(nthOfPerson));

        //given
        nthOfPerson = 2;

        //then
        assertEquals(0, ladder.run(nthOfPerson));
    }

}