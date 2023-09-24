package ladder;

import ladder.core.LadderGame;
import ladder.core.LadderGameFactory;
import ladder.core.LadderSize;
import ladder.creator.CustomLadderCreator;
import ladder.creator.LadderCreator;
import ladder.position.LadderPosition;
import ladder.position.Position;
import ladder.utils.NaturalNumber;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LadderGameTest {

    @Test
    void 사다리_생성_확인() {
        //given
        NaturalNumber numberOfRow = NaturalNumber.of(3);
        NaturalNumber numberOfPerson = NaturalNumber.of(5);
        LadderSize ladderSize = LadderSize.of(numberOfRow, numberOfPerson);

        //when
        LadderCreator ladderCreator = new CustomLadderCreator(ladderSize);

        //then
        assertNotNull(ladderCreator);
    }

    @Test
    void 사다리_사람_예외_처리_확인() {
        //when
        NaturalNumber numberOfRow = NaturalNumber.of(1);
        NaturalNumber numberOfPerson = NaturalNumber.of(3);
        LadderSize ladderSize = LadderSize.of(numberOfRow, numberOfPerson);
        LadderCreator ladderCreator = new CustomLadderCreator(ladderSize);
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
        LadderSize ladderSize = LadderSize.of(numberOfRow, numberOfPerson);
        LadderCreator ladderCreator = new CustomLadderCreator(ladderSize);

        LadderGame ladderGame = new LadderGame(ladderCreator);

        ladderCreator.drawLine(LadderPosition.of(Position.of(0),Position.of(0)));
        ladderCreator.drawLine(LadderPosition.of(Position.of(1),Position.of(1)));
        ladderCreator.drawLine(LadderPosition.of(Position.of(2),Position.of(0)));

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
    void 랜덤_사다리_생성_확인() {
        // Given
        NaturalNumber numberOfRow = NaturalNumber.of(5);
        NaturalNumber numberOfPerson = NaturalNumber.of(30);
        LadderSize ladderSize = LadderSize.of(numberOfRow, numberOfPerson);

        // When
        LadderGame ladderGame = LadderGameFactory.randomLadderGame(ladderSize);

        // Then
        assertNotNull(ladderGame);
    }

    @Test
    void 랜덤_사다리_라인_생성_비율_확인() {
        // Given
        NaturalNumber numberOfRow = NaturalNumber.of(5);
        NaturalNumber numberOfPerson = NaturalNumber.of(30);
        LadderSize ladderSize = LadderSize.of(numberOfRow, numberOfPerson);
        LadderGame ladderGame = LadderGameFactory.randomLadderGame(ladderSize);
        int totalLines = numberOfRow.getNumber() * numberOfPerson.getNumber();
        int expectedLines = (int) (totalLines * 0.3);
        int actualLines = 0;

        for (int i = 0; i < numberOfRow.getNumber(); i++) {
            for (int j = 0; j < numberOfPerson.getNumber(); j++) {
                if (ladderGame.isLineDrawn(i, j)) {
                    actualLines++;
                }
            }
        }

        // When & Then
        assertEquals(expectedLines, actualLines);
    }
}