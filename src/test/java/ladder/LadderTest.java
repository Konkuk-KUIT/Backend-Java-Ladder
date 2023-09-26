package ladder;

import creator.CustomLadderCreator;
import creator.LadderCreator;
import creator.RandomLadderCreator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LadderGameTest {

    @Test
    void 사다리_생성_확인() {
        //given
        NaturalNumber numberOfRow = NaturalNumber.of(3);
        NaturalNumber numberOfPerson = NaturalNumber.of(5);

        //when
        LadderCreator ladderCreator = new CustomLadderCreator(numberOfRow, numberOfPerson);

        //then
        assertNotNull(ladderCreator);
    }


/*    @Test
    void 사다리_결과_확인(){
        //given
        NaturalNumber numberOfRow = NaturalNumber.of(3);
        NaturalNumber numberOfPerson = NaturalNumber.of(5);

        //when
        LadderCreator ladderCreator = new LadderCreator(numberOfRow, numberOfPerson);
        ladderCreator.drawLine(Position.of(1), Position.of(1)); //시작 사다리, 높이(위쪽이 1, 아래로 갈수록 증가)
        ladderCreator.drawLine(Position.of(2), Position.of(2));

        LadderGame ladderGame = new LadderGame(ladderCreator);
        int result = ladderGame.run(Position.of(1));

        //then
        assertEquals(3, result);
        assertEquals(ladderGame.run(Position.of(2)), 1);
        assertEquals(ladderGame.run(Position.of(3)), 2);
    }*/


    @Test
    void 랜덤_사다리_결과_확인(){
        //given
        NaturalNumber numberOfRow = NaturalNumber.of(3);
        NaturalNumber numberOfPerson = NaturalNumber.of(5);

        //when
        LadderCreator ladderCreator = new RandomLadderCreator(numberOfRow, numberOfPerson);

        //팩토리 메소드가 이게 맞나..?
        LadderGame ladderGame1 = LadderGameFactory.createRandomLadderGame((RandomLadderCreator) ladderCreator);
        LadderGame ladderGame2 = new LadderGame(ladderCreator);
        int result = ladderGame1.run(Position.of(1));

        //then

    }

    @Test
    void drawLine_입력_오류() {
        //given
        NaturalNumber numberOfRow = NaturalNumber.of(3);
        NaturalNumber numberOfPerson = NaturalNumber.of(5);

        //when
        LadderCreator ladderCreator = new CustomLadderCreator(numberOfRow, numberOfPerson);

        //then
        assertThrows(Exception.class, ()-> ladderCreator.drawLine(Position.of(5), Position.of(1)));
    }

    @Test
    void run_입력_오류() {
        //given
        NaturalNumber numberOfRow = NaturalNumber.of(3);
        NaturalNumber numberOfPerson = NaturalNumber.of(5);

        //when
        LadderCreator ladderCreator = new RandomLadderCreator(numberOfRow, numberOfPerson);
        LadderGame ladderGame = new LadderGame(ladderCreator);
        //then
        assertThrows(Exception.class, ()->ladderGame.run(Position.of(6)));
    }

}

class LadderRunnerTest {
    @Test
    void printLadder_test() {
        //given
        NaturalNumber numberOfRow = NaturalNumber.of(3);
        NaturalNumber numberOfPerson = NaturalNumber.of(5);
        CustomLadderCreator customLadderCreator = new CustomLadderCreator(numberOfRow, numberOfPerson);

        LadderRunner ladderRunner = new LadderRunner(customLadderCreator.getRows());

        //when
        ladderRunner.run(Position.of(1));

        //then
        //콘솔창

    }
}