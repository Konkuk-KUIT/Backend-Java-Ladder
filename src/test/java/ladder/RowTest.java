package ladder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RowTest {

    @Test
    void checkDrawable_이어서_그릴_경우() {

        //given
        int numberOfRow = 3;
        int numberOfPerson = 5;

        //when
        Ladder ladder = new Ladder(numberOfRow, numberOfPerson);
        ladder.drawLine(1, 1);

        //then
        assertThrows(Exception.class, ()->ladder.drawLine(2, 1));
    }

    @Test
    void checkDrawable_중복으로_그릴_경우() {

        //given
        int numberOfRow = 3;
        int numberOfPerson = 5;

        //when
        Ladder ladder = new Ladder(numberOfRow, numberOfPerson);
        ladder.drawLine(1, 1);

        //then
        assertThrows(Exception.class, ()->ladder.drawLine(1, 1));
    }

}