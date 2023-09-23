package ladder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

    @Test
    void 사다리_생성_확인() {
        //given
        NaturalNumber numberOfRow = NaturalNumber.of(3);
        NaturalNumber numberOfPerson = NaturalNumber.of(5);

        //when
        Ladder ladder = new Ladder(numberOfRow, numberOfPerson);

        //then
        assertNotNull(ladder);
    }


    @Test
    void 사다리_결과_확인(){
        //given
        NaturalNumber numberOfRow = NaturalNumber.of(3);
        NaturalNumber numberOfPerson = NaturalNumber.of(5);

        //when
        Ladder ladder = new Ladder(numberOfRow, numberOfPerson);
        ladder.drawLine(Position.of(1), Position.of(1)); //시작 사다리, 높이(위쪽이 1, 아래로 갈수록 증가)
        ladder.drawLine(Position.of(2), Position.of(2));
        int result = ladder.run(Position.of(1));

        //then
        assertEquals(result, 3);
        assertEquals(ladder.run(Position.of(2)), 1);
        assertEquals(ladder.run(Position.of(3)), 2);
    }

    @Test
    void drawLine_입력_오류() {
        //given
        NaturalNumber numberOfRow = NaturalNumber.of(3);
        NaturalNumber numberOfPerson = NaturalNumber.of(5);

        //when
        Ladder ladder = new Ladder(numberOfRow, numberOfPerson);

        //then
        assertThrows(Exception.class, ()->ladder.drawLine(Position.of(5), Position.of(1)));
    }

    @Test
    void run_입력_오류() {
        //given
        NaturalNumber numberOfRow = NaturalNumber.of(3);
        NaturalNumber numberOfPerson = NaturalNumber.of(5);

        //when
        Ladder ladder = new Ladder(numberOfRow, numberOfPerson);

        //then
        assertThrows(Exception.class, ()->ladder.run(Position.of(6)));
    }

}