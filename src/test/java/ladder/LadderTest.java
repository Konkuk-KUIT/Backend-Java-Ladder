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
    void 선그리기_입력범위초과_에러확인(){
        //given
        int numberOfRow = 3;
        int numberOfPerson = 5;

        //when
        Ladder ladder = new Ladder(numberOfRow, numberOfPerson);

        assertThrows(Exception.class, () -> ladder.drawLine(4,1,3));
        assertThrows(Exception.class, () -> ladder.drawLine(2,0,3));
        assertThrows(Exception.class, () -> ladder.drawLine(2,3,1));
    }

    @Test
    void  선그리기_라인생성_확인(){
        //given
        int numberOfRow = 3;
        int numberOfPerson = 5;

        //when
        Ladder ladder = new Ladder(numberOfRow, numberOfPerson);
        ladder.drawLine(2,1,2);
        assertEquals(true,ladder.existLine(2,1,2));
    }

    @Test
    void 사다리찾기_확인(){
        int numberOfRow = 3;
        int numberOfPerson = 5;

        //when
        Ladder ladder = new Ladder(numberOfRow, numberOfPerson);
        ladder.drawLine(3,1,2);
        ladder.drawLine(2,2,3);
        ladder.drawLine(1,3,4);
        ladder.drawLine(3,3,4);
        ladder.drawLine(1,4,5);

        assertEquals(2, ladder.run(1));
        assertEquals(4, ladder.run(2));
        assertEquals(5, ladder.run(3));
        assertEquals(3, ladder.run(4));
        assertEquals(1, ladder.run(5));
    }
}