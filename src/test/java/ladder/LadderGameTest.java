package ladder;

import ladder.creator.LadderCreator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LadderGameTest {

    @Test
    void 사다리_생성_확인() {
        //given
        int numberOfRow = 3;
        int numberOfPerson = 5;

        //when
        LadderCreator ladderCreator = new LadderCreator(NaturalNumber.of(numberOfPerson),NaturalNumber.of(numberOfPerson));

        //then
        assertNotNull(ladderCreator);
    }

    @Test
    void 사다리_타기() {
        int numberOfRow = 4;
        int numberOfPerson = 5;
        LadderCreator ladderCreator = new LadderCreator(NaturalNumber.of(numberOfRow),NaturalNumber.of(numberOfPerson));

        ladderCreator.drawLine(1,Position.of(2),Direction.RIGHT);
        ladderCreator.drawLine(2,Position.of(5),Direction.LEFT);
        ladderCreator.drawLine(4,Position.of(3),Direction.RIGHT);
        ladderCreator.drawLine(2,Position.of(2),Direction.LEFT);
        ladderCreator.drawLine(3,Position.of(3),Direction.LEFT);

        LadderGame ladderGame = new LadderGame(ladderCreator);

        assertEquals(4,ladderGame.run(Position.of(1)).getValue());
        assertEquals(2,ladderGame.run(Position.of(2)).getValue());
        assertEquals(1,ladderGame.run(Position.of(3)).getValue());
        assertEquals(5,ladderGame.run(Position.of(4)).getValue());
        assertEquals(3,ladderGame.run(Position.of(5)).getValue());
    }
}