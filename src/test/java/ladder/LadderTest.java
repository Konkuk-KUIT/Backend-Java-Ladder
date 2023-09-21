package ladder;

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
        //when
        LadderCreator ladderCreator = new LadderCreator(numberOfRow, numberOfPerson);
        //then
        assertNotNull(ladderCreator);
    }

    @Test
    @DisplayName("사다리 크기 초과 입력")
    void PeopleOverLadderSize() {
        //given
        NaturalNumber numberOfRow = NaturalNumber.of(1);
        NaturalNumber numberOfPerson = NaturalNumber.of(3);
        LadderCreator ladderCreator = new LadderCreator(numberOfRow, numberOfPerson);
        LadderGame ladderGame = new LadderGame(ladderCreator);
        //when
        int nthOfPerson = 4;
        Position position = Position.of(nthOfPerson);
        //then
        assertThrows(IllegalArgumentException.class, () -> ladderGame.run(position));
    }

    @Test
    @DisplayName("사다리 실행 결과")
    void LadderRun() {
        //given
        NaturalNumber numberOfRow = NaturalNumber.of(3);
        NaturalNumber numberOfPerson = NaturalNumber.of(4);
        LadderCreator ladderCreator = new LadderCreator(numberOfRow, numberOfPerson);

        LadderGame ladderGame = new LadderGame(ladderCreator);

        ladderCreator.drawLine(Position.of(0), Position.of(0));
        ladderCreator.drawLine(Position.of(1), Position.of(1));
        ladderCreator.drawLine(Position.of(2), Position.of(0));
        //when
        int nthOfPerson = 0;
        Position position = Position.of(nthOfPerson);
        //then
        assertEquals(2, ladderGame.run(position));

        //when
        nthOfPerson = 1;
        position = Position.of(nthOfPerson);
        //then
        assertEquals(1, ladderGame.run(position));

        //when
        nthOfPerson = 2;
        position = Position.of(nthOfPerson);
        //then
        assertEquals(0, ladderGame.run(position));
    }
}
