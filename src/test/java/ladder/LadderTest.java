package ladder;

import ladder.core.LadderGame;
import ladder.core.LadderSize;
import ladder.creator.NormalLadderCreator;
import ladder.position.LadderPosition;
import ladder.position.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LadderTest {
    @Test
    @DisplayName("사다리 생성")
    void LadderCreate() {
        //given
        NaturalNumber numberOfRow = NaturalNumber.of(3);
        NaturalNumber numberOfPerson = NaturalNumber.of(5);
        LadderSize ladderSize = new LadderSize(numberOfRow, numberOfPerson);
        //when
        NormalLadderCreator normalLadderCreator = new NormalLadderCreator(ladderSize);
        //then
        assertNotNull(normalLadderCreator);
    }

    @Test
    @DisplayName("사다리 크기 초과 입력")
    void PeopleOverLadderSize() {
        //given
        NaturalNumber numberOfRow = NaturalNumber.of(1);
        NaturalNumber numberOfPerson = NaturalNumber.of(3);
        LadderSize ladderSize = new LadderSize(numberOfRow, numberOfPerson);
        NormalLadderCreator normalLadderCreator = new NormalLadderCreator(ladderSize);
        LadderGame normalLadderGame = new LadderGame(normalLadderCreator);
        //when
        int nthOfPerson = 4;
        Position position = Position.of(nthOfPerson);
        //then
        assertThrows(IllegalArgumentException.class, () -> normalLadderGame.run(position));
    }

    @Test
    @DisplayName("사다리 실행 결과")
    void LadderRun() {
        //given
        NaturalNumber numberOfRow = NaturalNumber.of(3);
        NaturalNumber numberOfPerson = NaturalNumber.of(4);
        LadderSize ladderSize = new LadderSize(numberOfRow, numberOfPerson);
        NormalLadderCreator normalLadderCreator = new NormalLadderCreator(ladderSize);

        LadderGame normalLadderGame = new LadderGame(normalLadderCreator);

        LadderPosition ladderPosition1 = new LadderPosition(0, Position.of(0));
        LadderPosition ladderPosition2 = new LadderPosition(1, Position.of(1));
        LadderPosition ladderPosition3 = new LadderPosition(2, Position.of(0));

        normalLadderCreator.drawLine(ladderPosition1);
        normalLadderCreator.drawLine(ladderPosition2);
        normalLadderCreator.drawLine(ladderPosition3);
        //when
        int nthOfPerson = 0;
        Position position = Position.of(nthOfPerson);
        //then
        assertEquals(2, normalLadderGame.run(position));
//
//        //when
//        nthOfPerson = 1;
//        position = Position.of(nthOfPerson);
//        //then
//        assertEquals(1, normalLadderGame.run(position));
//
//        //when
//        nthOfPerson = 2;
//        position = Position.of(nthOfPerson);
//        //then
//        assertEquals(0, normalLadderGame.run(position));
    }
}
