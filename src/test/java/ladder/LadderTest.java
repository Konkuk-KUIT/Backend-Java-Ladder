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
    void 선_그리기_확인(){
//        사다리 생성
        int numberOfRow = 5;
        int numberOfPerson = 3;
        Ladder ladder = new Ladder(numberOfRow, numberOfPerson);

        //given -> 규칙이 있다.
        int row = 4;
        int col = 2;

        ladder.drawLine(row,col);

        assertEquals(1, ladder.rowsCheck(row, col));
        assertEquals(1, ladder.rowsCheck(row, col+1));

//        중복된 선을 긋는 경우 -> RuntimeException발생
        assertThrows(Exception.class, ()->ladder.drawLine(row,col+1));
    }

    @Test
    void 사다리_결과_확인(){
//        사다리 생성
        int numberOfRow = 5;
        int numberOfPerson = 3;
        Ladder ladder = new Ladder(numberOfRow, numberOfPerson);
//        사라리 선 긋기
//        1. 아무 선도 안그어 졌을때
        assertEquals(2, ladder.run(2));
//        2. 여러 선을 그어졌을 때
        ladder.drawLine(1,1);
        ladder.drawLine(3,1);
        ladder.drawLine(5,1);
        ladder.drawLine(4,2);

        assertEquals(2, ladder.run(1));
    }
}