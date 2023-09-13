package ladder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class LadderTest {

    @Test
    void 사다리_생성_확인() {
        //given
        int numberOfRow = 4;
        int numberOfPerson = 4;

        //when
        Ladder ladder = new Ladder(numberOfRow, numberOfPerson);
        ladder.drawLine(1,1);
        ladder.drawLine(2,2);
        ladder.drawLine(3,1);
        ladder.drawLine(3,3);

        //then
        assertEquals(4,ladder.run(1));
    }

}