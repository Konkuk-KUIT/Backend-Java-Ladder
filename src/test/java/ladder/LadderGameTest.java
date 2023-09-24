package ladder;

import ladder.creator.LadderRandomCreator;
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
        LadderRandomCreator ladderCreator = new LadderRandomCreator(NaturalNumber.of(numberOfPerson),NaturalNumber.of(numberOfPerson));

        //then
        assertNotNull(ladderCreator);
    }

    @Test
    void 사다리_자동_생성_라인_수_확인() {
        NaturalNumber numberOfRow = NaturalNumber.of(3);
        NaturalNumber numberOfPerson = NaturalNumber.of(5);

        LadderSize ladderSize = new LadderSize(numberOfRow, numberOfPerson);

        assertEquals(NaturalNumber.of(numberOfRow.getNumber()*numberOfPerson.getNumber()*0.3).getNumber(),
                ladderSize.getNumberOfLineToDraw().getNumber());
    }

    @Test
    void 사다리_줄_생성_테스트_AND_RUN() {
        NaturalNumber numberOfRow = NaturalNumber.of(6);
        NaturalNumber numberOfPerson = NaturalNumber.of(6);
        LadderRandomCreator ladderCreator = new LadderRandomCreator(numberOfRow, numberOfPerson);

        ladderCreator.drawLine(NaturalNumber.of(1), Position.of(1), Direction.NONE);

        LadderGame ladderGame = new LadderGame(ladderCreator);

        ladderGame.run(Position.of(3));
    }
}