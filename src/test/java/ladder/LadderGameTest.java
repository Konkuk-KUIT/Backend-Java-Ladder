package ladder;

import ladder.creator.LadderCreator;
import ladder.creator.LadderGameFactory;
import ladder.creator.LadderManualCreator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LadderGameTest {

    @Test
    void 사다리_생성_확인() {
        //given
        NaturalNumber numberOfRow = NaturalNumber.of(3);
        NaturalNumber numberOfPerson = NaturalNumber.of(5);
        LadderSize ladderSize = new LadderSize(numberOfRow,numberOfPerson);
        //when
        LadderManualCreator ladderManualCreator = new LadderManualCreator(ladderSize);

        //then
        assertNotNull(ladderManualCreator);
    }

    @Test
    void 사다리_사람_예외_처리_확인() {
        //when
        NaturalNumber numberOfRow = NaturalNumber.of(1);
        NaturalNumber numberOfPerson = NaturalNumber.of(3);
        LadderSize ladderSize = new LadderSize(numberOfRow,numberOfPerson);
        LadderManualCreator ladderManualCreator = new LadderManualCreator(ladderSize);
        LadderGame ladderGame = new LadderGame(ladderManualCreator);

        //given
        int nthOfPerson = 4;
        Position position = Position.of(nthOfPerson);

        //then
        assertThrows(IllegalArgumentException.class, ()->ladderGame.run(position));
    }

    @Test
    void 사다리_결과_확인() {
        //when
        NaturalNumber numberOfRow = NaturalNumber.of(3);
        NaturalNumber numberOfPerson = NaturalNumber.of(4);
        LadderSize ladderSize = new LadderSize(numberOfRow,numberOfPerson);
        LadderManualCreator ladderManualCreator = new LadderManualCreator(ladderSize);

        LadderGame ladderGame = new LadderGame(ladderManualCreator);

        ladderManualCreator.drawLine(Position.of(0),Position.of(0));
        ladderManualCreator.drawLine(Position.of(1),Position.of(1));
        ladderManualCreator.drawLine(Position.of(2),Position.of(0));

        //given
        int nthOfPerson = 0;
        Position position = Position.of(nthOfPerson);

        //then
        assertEquals(2, ladderGame.run(position));

        //given
        nthOfPerson = 1;
        position = Position.of(nthOfPerson);

        //then
        assertEquals(1, ladderGame.run(position));

        //given
        nthOfPerson = 2;
        position = Position.of(nthOfPerson);

        //then
        assertEquals(0, ladderGame.run(position));
    }

    @Test
    void 랜덤_사다리_결과_확인(){
        NaturalNumber numberOfRow = NaturalNumber.of(3);
        NaturalNumber numberOfPerson = NaturalNumber.of(5);

        LadderSize ladderSize = new LadderSize(numberOfRow, numberOfPerson);

        LadderGame ladderRandomGame = LadderGameFactory.getLadderRandomGame(ladderSize);
        ladderRandomGame.run(Position.of(1));
    }
}