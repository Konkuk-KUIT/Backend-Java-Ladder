package ladder;

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
    void go_down() {
        //given
        int pos_X = 2;
        //when
        Ladder ladder = new Ladder(4, 4);
        //then
        assertEquals(3, ladder.go_down(pos_X));
    }

    @Test
    void go_right() {
        //given
        int pos_Y = 2;
        //when
        Ladder ladder = new Ladder(4, 4);
        //then
        assertEquals(3, ladder.go_right(pos_Y));
    }

    @Test
    void go_left() {
        //given
        int pos_Y = 2;
        //when
        Ladder ladder = new Ladder(4, 4);
        //then
        assertEquals(1, ladder.go_left(pos_Y));
    }
    @Test
    void 사다리_결과_확인() {
        //given
        int numberOfRow = 4;
        int numberOfPerson = 4;

        //when
        Ladder ladder = new Ladder(numberOfRow, numberOfPerson);
        ladder.drawLine(1,0);
        ladder.drawLine(2,1);
        ladder.drawLine(3,2);


        //then
        assertEquals(4, ladder.run(1));
        assertEquals(1, ladder.run(2));
        assertEquals(2, ladder.run(3));
        assertEquals(3, ladder.run(4));
    }

}