package ladder;

import ladder.creator.LadderCreator;
import ladder.creator.LadderNormalCreator;
import ladder.creator.LadderRandomCreator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LadderGameTest {

    @Test
    void 사다리_생성_확인() {
        //given
        NaturalNumber numberOfRow = NaturalNumber.of(3);
        NaturalNumber numberOfPerson = NaturalNumber.of(5);

        //when
        LadderNormalCreator ladderCreator = new LadderNormalCreator(numberOfRow, numberOfPerson);
        //LadderCreator ladderCreator = new Ladd

        //then
        assertNotNull(ladderCreator);
    }

    @Test
    void 사다리_사람_예외_처리_확인() {
        //when
        NaturalNumber numberOfRow = NaturalNumber.of(1);
        NaturalNumber numberOfPerson = NaturalNumber.of(3);
        LadderNormalCreator ladderCreator = new LadderNormalCreator(numberOfRow, numberOfPerson);
        LadderGame ladderGame = new LadderGame(ladderCreator);

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
        LadderNormalCreator ladderCreator = new LadderNormalCreator(numberOfRow, numberOfPerson);

        LadderGame ladderGame = new LadderGame(ladderCreator);

        ladderCreator.drawLine(Position.of(0),Position.of(0));
        ladderCreator.drawLine(Position.of(1),Position.of(1));
        ladderCreator.drawLine(Position.of(2),Position.of(0));

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

    ////
    @Test
    void 사다리_그리기() {
        //given
        NaturalNumber numberOfRow = NaturalNumber.of(3);
        NaturalNumber numberOfPerson = NaturalNumber.of(4);

        LadderCreator ladderCreator = new LadderNormalCreator(numberOfRow, numberOfPerson);

        LadderGame ladderGame = new LadderGame(ladderCreator);

        ladderCreator.drawLine(Position.of(0),Position.of(0));
        ladderCreator.drawLine(Position.of(1),Position.of(1));
        ladderCreator.drawLine(Position.of(2),Position.of(0));

        //when
        int nthOfPerson = 0;
        Position position = Position.of(nthOfPerson);

        ladderGame.run(position);

        //then
        assertEquals(2, ladderGame.run(position));

    }

    @Test
    void 랜덤_사다리_생성() {
        //given
        NaturalNumber numberOfRow = NaturalNumber.of(3);
        NaturalNumber numberOfPerson = NaturalNumber.of(4);

        LadderCreator ladderCreator = new LadderRandomCreator(numberOfRow, numberOfPerson);

        LadderGame ladderGame = new LadderGame(ladderCreator);

        //when
        int nthOfPerson = 0;
        Position position = Position.of(nthOfPerson);
        ladderGame.run(position);

    }

    @Test
    void 정적_메서드() {


        //given
        NaturalNumber numberOfRow = NaturalNumber.of(3);
        NaturalNumber numberOfPerson = NaturalNumber.of(4);

        //LadderGame ladderGame = LadderGameFactory.createRandomLadderGame(numberOfRow, numberOfPerson);
        LadderGame ladderGame = LadderGameFactory.createNormalLadderGame(numberOfRow, numberOfPerson);

        //when
        int nthOfPerson = 0;
        Position position = Position.of(nthOfPerson);
        ladderGame.run(position);

        //then


    }




}