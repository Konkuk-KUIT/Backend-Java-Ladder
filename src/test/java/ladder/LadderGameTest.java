package ladder;

import ladder.creator.DefaultLadderCreator;
import ladder.creator.RandomLadderCreator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LadderGameTest {

    @Test
    void 사다리_생성_확인() {
        //given
        NaturalNumber numberOfRow = NaturalNumber.of(3);
        NaturalNumber numberOfPerson = NaturalNumber.of(5);

        //when
        DefaultLadderCreator ladderCreator = new DefaultLadderCreator(numberOfRow, numberOfPerson);

        //then
        assertNotNull(ladderCreator);
    }

    @Test
    void 사다리_사람_예외_처리_확인() {
        //when
        NaturalNumber numberOfRow = NaturalNumber.of(1);
        NaturalNumber numberOfPerson = NaturalNumber.of(3);
        DefaultLadderCreator ladderCreator = new DefaultLadderCreator(numberOfRow, numberOfPerson);
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
        DefaultLadderCreator ladderCreator = new DefaultLadderCreator(numberOfRow, numberOfPerson);

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

    @Test
    void 사다리_출력_확인() {
        //when
        NaturalNumber numberOfRow = NaturalNumber.of(3);
        NaturalNumber numberOfPerson = NaturalNumber.of(4);
        DefaultLadderCreator ladderCreator = new DefaultLadderCreator(numberOfRow, numberOfPerson);

        LadderGame ladderGame = new LadderGame(ladderCreator);

        ladderCreator.drawLine(Position.of(0),Position.of(0));
        ladderCreator.drawLine(Position.of(1),Position.of(1));
        ladderCreator.drawLine(Position.of(2),Position.of(0));

        //given
        int nthOfPerson = 0;
        Position position = Position.of(nthOfPerson);

        //then
        assertEquals(2, ladderGame.printLadder(position));

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
    void 사다리_랜덤_생성_확인() {
        NaturalNumber numberOfRow = NaturalNumber.of(3);
        NaturalNumber numberOfPerson = NaturalNumber.of(4);

        LadderSize ladderSize = new LadderSize(numberOfRow, numberOfPerson);

        //when
        RandomLadderCreator randomLadderCreator = new RandomLadderCreator(ladderSize);

        //then
        assertNotNull(randomLadderCreator);
    }

    @Test
    void 랜덤_사다리_결과_확인() {
        //when
        NaturalNumber numberOfRow = NaturalNumber.of(5);
        NaturalNumber numberOfPerson = NaturalNumber.of(4);

        LadderSize ladderSize = new LadderSize(numberOfRow, numberOfPerson);

        LadderGame ladderGame = LadderGameFactory.createRandomLadderGame(ladderSize);

        int nthOfPerson = 0;
        Position position = Position.of(nthOfPerson);

        //then
        ladderGame.printLadder(position);

        nthOfPerson = 1;
        position = Position.of(nthOfPerson);


        ladderGame.printLadder(position);

        nthOfPerson = 2;
        position = Position.of(nthOfPerson);


        ladderGame.printLadder(position);

        nthOfPerson = 3;
        position = Position.of(nthOfPerson);


        ladderGame.printLadder(position);
    }

}