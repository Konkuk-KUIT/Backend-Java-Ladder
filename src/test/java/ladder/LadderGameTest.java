package ladder;

import ladder.creator.LadderCreator;
import ladder.creator.LadderCreate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LadderGameTest {

    @Test
    void 사다리_생성_확인() {
        //given
        NaturalNumber numberOfRow = NaturalNumber.of(3);
        NaturalNumber numberOfPerson = NaturalNumber.of(5);

        //when
        LadderCreator ladderCreator = new LadderCreate(numberOfRow, numberOfPerson);

        //then
        assertNotNull(ladderCreator);
    }

    @Test
    void 사다리_사람_예외_처리_확인() {
        //given
        NaturalNumber numberOfRow = NaturalNumber.of(1);
        NaturalNumber numberOfPerson = NaturalNumber.of(3);
        LadderCreator ladderCreator = new LadderCreate(numberOfRow, numberOfPerson);
        LadderGame ladderGame = new LadderGame(ladderCreator);

        //when
        int nthOfPerson = 4;
        Position position = Position.of(nthOfPerson);

        //then
        assertThrows(IllegalArgumentException.class, () -> ladderGame.run(position));
    }

    @Test
    void 사다리_결과_확인() {
        // 사다리 출력까지 한번에 테스트
        //given
        NaturalNumber numberOfRow = NaturalNumber.of(3);
        NaturalNumber numberOfPerson = NaturalNumber.of(4);

        LadderCreator ladderCreator = new LadderCreate(numberOfRow, numberOfPerson);

        LadderGame ladderGame = new LadderGame(ladderCreator);

        ladderCreator.drawLine(Position.of(0), Position.of(0));
        ladderCreator.drawLine(Position.of(1), Position.of(1));
        ladderCreator.drawLine(Position.of(2), Position.of(0));


        //when
        int nthOfPerson = 0;
        Position position = Position.of(nthOfPerson);

        //then
        System.out.println("첫번째 test");
        assertEquals(2, ladderGame.run(position));
        System.out.println();

        //when
        nthOfPerson = 1;
        position = Position.of(nthOfPerson);

        //then
        System.out.println("두번째 test");
        assertEquals(1, ladderGame.run(position));
        System.out.println();

        //when
        nthOfPerson = 2;
        position = Position.of(nthOfPerson);

        //then
        System.out.println("세번째 test");
        assertEquals(0, ladderGame.run(position));
        System.out.println();
    }

    @Test
    void 사다리_랜덤_결과_확인() {
        // 사다리 출력까지 한번에 테스트
        // given
        NaturalNumber numberOfRow = NaturalNumber.of(3);
        NaturalNumber numberOfPerson = NaturalNumber.of(4);

        LadderGame ladderGame = LadderGameFactory.createRandomLadderGame(numberOfRow, numberOfPerson);

        // when
        int nthOfPerson = 0;
        Position position = Position.of(nthOfPerson);

        //then
        ladderGame.run(position);

    }

}
