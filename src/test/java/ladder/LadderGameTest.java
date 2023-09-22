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
        NaturalNumber numberOfPerson = NaturalNumber.of(5);

        LadderSize ladderSize = new LadderSize(numberOfRow, numberOfPerson);

        assertEquals(NaturalNumber.of(numberOfRow.getNumber()*numberOfPerson.getNumber()*0.3).getNumber(),
                ladderSize.getNumberOfLineToDraw().getNumber());
    }

    @Test
    void 사다리_줄_생성_테스트_AND_RUN() {
        NaturalNumber numberOfRow = NaturalNumber.of(10);
        NaturalNumber numberOfPerson = NaturalNumber.of(10);
        LadderCreator ladderCreator = new LadderCreator(numberOfRow, numberOfPerson);

        ladderCreator.autoDrawLine();

        LadderGame ladderGame = new LadderGame(ladderCreator);

        ladderGame.run(Position.of(3));
    }
}