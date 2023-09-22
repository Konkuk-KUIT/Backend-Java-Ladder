package ladder;

import ladder.creator.LadderCreator;
import ladder.creator.LadderSize;
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
    void 사다리_자동_생성_라인_수_확인() {
        NaturalNumber numberOfRow = NaturalNumber.of(3);
        NaturalNumber numberOfPerson = NaturalNumber.of(4);

        LadderSize ladderSize = new LadderSize(numberOfRow, numberOfPerson);

        assertEquals(NaturalNumber.of(3*4*0.3).getNumber(),ladderSize.getNumberOfLine().getNumber());
    }

    @Test
    void 사다리_가로줄_자동_랜덤_생성_확인() {
        NaturalNumber numberOfRow = NaturalNumber.of(3);
        NaturalNumber numberOfPerson = NaturalNumber.of(4);
        LadderCreator ladderCreator = new LadderCreator(numberOfRow, numberOfPerson);
    }

    @Test
    void 사다리_타기() {
        int numberOfRow = 4;
        int numberOfPerson = 5;
        LadderCreator ladderCreator = new LadderCreator(NaturalNumber.of(numberOfRow),NaturalNumber.of(numberOfPerson));

        ladderCreator.drawLine(NaturalNumber.of(1), Position.of(2),Direction.RIGHT);
        ladderCreator.drawLine(NaturalNumber.of(2), Position.of(5),Direction.LEFT);
        ladderCreator.drawLine(NaturalNumber.of(4), Position.of(3),Direction.RIGHT);
        ladderCreator.drawLine(NaturalNumber.of(2), Position.of(2),Direction.LEFT);
        ladderCreator.drawLine(NaturalNumber.of(3), Position.of(3),Direction.LEFT);

        LadderGame ladderGame = new LadderGame(ladderCreator);

        //assertEquals(4,ladderGame.run(Position.of(1)).getValue());
        //assertEquals(2,ladderGame.run(Position.of(2)).getValue());
        assertEquals(1,ladderGame.run(Position.of(3)).getValue());
        //assertEquals(5,ladderGame.run(Position.of(4)).getValue());
        //assertEquals(3,ladderGame.run(Position.of(5)).getValue());
    }
}