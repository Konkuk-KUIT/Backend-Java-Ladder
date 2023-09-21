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

    @Test
    void 사다리_실행_확인() {
        //given
        NaturalNumber numberOfRow = NaturalNumber.of(3);
        NaturalNumber numberOfPerson = NaturalNumber.of(4);

        //when
        Ladder ladder = new Ladder(numberOfRow, numberOfPerson);

        ladder.drawLine(Position.of(0),Position.of(0));
        ladder.drawLine(Position.of(1),Position.of(2));
        ladder.drawLine(Position.of(2),Position.of(1));

        //then
        assertEquals(2, ladder.run(Position.of(0)).getPosition());
        assertEquals(0, ladder.run(Position.of(1)).getPosition());
        assertEquals(3, ladder.run(Position.of(2)).getPosition());
        assertEquals(1, ladder.run(Position.of(3)).getPosition());
    }

}