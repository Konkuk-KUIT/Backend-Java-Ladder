package ladder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
    void 사다리라인_생성_확인() {
        //given
        int numberOfRow = 4;
        int numberOfPerson = 2;
        Ladder ladder = new Ladder(numberOfRow, numberOfPerson);

        //when
        LadderLine ladderLine = new LadderLine(0,1,1,2);
        ladder.drawLine(ladderLine);

        int startLineIndex = 0;
        int startLineIndex_2 = 1;

        //then
        assertEquals(1, ladder.run(startLineIndex));
        assertEquals(0, ladder.run(startLineIndex_2));
    }

    @Test
    void 사다리라인_생성_확인_2() {
        //given
        int numberOfRow = 4;
        int numberOfPerson = 2;
        Ladder ladder = new Ladder(numberOfRow, numberOfPerson);

        //when
        LadderLine ladderLine = new LadderLine(1,0,2,1);
        ladder.drawLine(ladderLine);

        int startLineIndex = 0;
        int startLineIndex_2 = 1;

        //then
        assertEquals(1, ladder.run(startLineIndex));
        assertEquals(0, ladder.run(startLineIndex_2));
    }

    @Test
    void 사다리_실행_확인() {
        //given
        int numberOfRow = 5;
        int numberOfPerson = 4;
        Ladder ladder = new Ladder(numberOfRow, numberOfPerson);

        //when

        ladder.drawLine(new LadderLine(0,1,1,1));
        ladder.drawLine(new LadderLine(1,2,2,2));
        ladder.drawLine(new LadderLine(2,3,1,2));
        ladder.drawLine(new LadderLine(2,3,3,3));


        int startLineIndex = 0;
        int startLineIndex_2 = 1;
        int startLineIndex_3 = 2;
        int startLineIndex_4 = 3;


        //then
        assertEquals(3, ladder.run(startLineIndex));
        assertEquals(0, ladder.run(startLineIndex_2));
        assertEquals(2, ladder.run(startLineIndex_3));
        assertEquals(1, ladder.run(startLineIndex_4));

    }

}