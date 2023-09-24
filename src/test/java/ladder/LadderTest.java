package ladder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

    @Test
    void 사다리_생성_확인() {
        //given
        NaturalNumber numberOfRow = NaturalNumber.of(3);
        NaturalNumber numberOfPerson = NaturalNumber.of(5);

        //when
        Ladder ladder = new Ladder(numberOfRow, numberOfPerson);

        //then
        assertNotNull(ladder);
    }

    @Test
    void 결과_확인() {
        //given
        NaturalNumber numberOfRow = NaturalNumber.of(3);
        NaturalNumber numberOfPerson = NaturalNumber.of(2);

        //when
        Ladder ladder = new Ladder(numberOfRow, numberOfPerson);
        ladder.drawLine(1, 0);
//        ladder.drawLine(1, 1); // validateDrawLine 체크


        //then
        assertEquals(1, ladder.run(0));
        assertEquals(0, ladder.run(1));
    }


}