package ladder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

    @Test
    void 사다리_생성_확인() {
        //given
        int numberOfRow = 3;
        int numberOfPerson = 5;

        //when
        Ladder ladder = new Ladder(numberOfRow, numberOfPerson);

        //then
        assertNotNull(ladder);
    }

    @Test
    void runTest() {
        //given
        int numberOfRow = 3;
        int numberOfPerson = 5;

        //when
        Ladder ladder = new Ladder(numberOfRow, numberOfPerson);
        int result = ladder.run(1);

        //then
        assertEquals(result, 1);
    }


    @Test
    void drawLineTest() {
        //given
        int numberOfRow = 3;
        int numberOfPerson = 5;

        //when
        Ladder ladder = new Ladder(numberOfRow, numberOfPerson);
        ladder.drawLine(1, 1); //시작 사다리, 높이(위쪽이 1, 아래로 갈수록 증가)
        int result = ladder.run(1);

        //then
        assertEquals(result, 2);
    }

    @Test
    void drawLine_입력_오류() {
        //given
        int numberOfRow = 3;
        int numberOfPerson = 5;

        //when
        Ladder ladder = new Ladder(numberOfRow, numberOfPerson);

        //then
        assertThrows(Exception.class, ()->ladder.drawLine(4, 1));
    }

}