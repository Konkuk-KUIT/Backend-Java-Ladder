package ladder;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class LadderTest {

    @Test
    void 사다리_생성_확인() {
        //given
        NaturalNumber numberOfRow = NaturalNumber.of(3);
        NaturalNumber numberOfPerson = NaturalNumber.of(4);

        //when
        Ladder ladder = new Ladder(numberOfRow, numberOfPerson);

        //then
        assertNotNull(ladder);
    }

//    @Test
//    void 사다리_실행_확인() {
//        //given
//        int numberOfRow = 3;
//        int numberOfPerson = 4;
//
//        //when
//        Ladder ladder = new Ladder(numberOfRow, numberOfPerson);
//        ladder.drawLine(0,0);
//        ladder.drawLine(1,2);
//        ladder.drawLine(2,1);
//
//        //then
//        assertEquals(2, ladder.run(0));
//        assertEquals(0, ladder.run(1));
//        assertEquals(3, ladder.run(2));
//        assertEquals(1, ladder.run(3));
//    }
//
//    @Test
//    void 사다리_실행_확인2() {
//        //given
//        int numberOfRow = 0;
//        int numberOfPerson = 2;
//
//        //when
//        Ladder ladder = new Ladder(numberOfRow, numberOfPerson);
//
//        //then
//        assertEquals(1, ladder.run(1));
//    }
}