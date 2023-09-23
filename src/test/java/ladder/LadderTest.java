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
        NormalLadderCreator normalLadderCreator = new NormalLadderCreator(numberOfRow, numberOfPerson);
        //then
        assertNotNull(normalLadderCreator);
    }

    @Test
    @DisplayName("사다리 크기 초과 입력")
    void PeopleOverLadderSize() {
        //given
        NaturalNumber numberOfRow = NaturalNumber.of(1);
        NaturalNumber numberOfPerson = NaturalNumber.of(3);
        NormalLadderCreator normalLadderCreator = new NormalLadderCreator(numberOfRow, numberOfPerson);
        NormalLadderGame normalLadderGame = new NormalLadderGame(normalLadderCreator);
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
        NormalLadderCreator normalLadderCreator = new NormalLadderCreator(numberOfRow, numberOfPerson);

        NormalLadderGame normalLadderGame = new NormalLadderGame(normalLadderCreator);

        normalLadderCreator.drawLine(Position.of(0), Position.of(0));
        normalLadderCreator.drawLine(Position.of(1), Position.of(1));
        normalLadderCreator.drawLine(Position.of(2), Position.of(0));
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
