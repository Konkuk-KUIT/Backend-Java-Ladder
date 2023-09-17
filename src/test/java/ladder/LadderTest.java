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
    void 결과_확인() {
        //given
        int numberOfRow = 3;
        int numberOfPerson = 2;

        //when
        Ladder ladder = new Ladder(numberOfRow, numberOfPerson);
        ladder.drawLine(1, 0);


        //then
        assertEquals(1, ladder.run(0));
        assertEquals(0, ladder.run(1));
    }

    @Test
    void 범위_오류_확인() {
        //
    }


}