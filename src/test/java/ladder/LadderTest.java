package ladder;

import ladder.creator.LadderCreator;
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
        //Ladder ladder = new Ladder(numberOfRow, numberOfPerson);
        LadderCreator ladder = new LadderCreator(numberOfRow, numberOfPerson);

        //then
        assertNotNull(ladder);
    }

    @Test
    void 사다리_실행_확인() {
        //given
        NaturalNumber numberOfRow = NaturalNumber.of(3);
        NaturalNumber numberOfPerson = NaturalNumber.of(4);

        //when
        //Ladder ladder = new Ladder(numberOfRow, numberOfPerson);
        LadderCreator ladder = new LadderCreator(numberOfRow, numberOfPerson);
        LadderGame ladderGame = new LadderGame(ladder);

        ladder.drawLine(Position.of(0),Position.of(0));
        ladder.drawLine(Position.of(1),Position.of(2));
        ladder.drawLine(Position.of(2),Position.of(1));

        //then
        assertEquals(2, ladderGame.run(Position.of(0)));
        assertEquals(0, ladderGame.run(Position.of(1)));
        assertEquals(3, ladderGame.run(Position.of(2)));
        assertEquals(1, ladderGame.run(Position.of(3)));
    }

}