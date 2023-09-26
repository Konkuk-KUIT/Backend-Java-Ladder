package ladder;

import ladder.creator.LadderCreator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LadderGameTest {

    @Test
    void 사다리_생성_확인() {
        //given
        NaturalNumber numberOfRow = NaturalNumber.of(3);
        NaturalNumber numberOfPerson = NaturalNumber.of(5);

        //when
        LadderCreator ladderCreator = new LadderCreator(numberOfRow, numberOfPerson);

        //then
        assertNotNull(ladderCreator);
    }

    @Test
    void 결과_확인() {
        //given
        NaturalNumber numberOfRow = NaturalNumber.of(3);
        NaturalNumber numberOfPerson = NaturalNumber.of(4);
        LadderCreator ladderCreator = new LadderCreator(numberOfRow, numberOfPerson);

        LadderGame ladderGame = new LadderGame(ladderCreator);

        //when
        ladderCreator.drawLine(Position.of(0), Position.of(0));
        ladderCreator.drawLine(Position.of(1), Position.of(1));
        ladderCreator.drawLine(Position.of(2), Position.of(0));


        //then
        assertEquals(2, ladderGame.run(Position.of(0)));
//        assertEquals(0, ladderGame.run(Position.of(1)));
    }


}