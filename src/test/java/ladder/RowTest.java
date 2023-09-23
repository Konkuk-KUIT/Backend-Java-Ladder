package ladder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RowTest {

    @Test
    void checkDrawable_이어서_그릴_경우() {

        //given
        NaturalNumber numberOfRow = NaturalNumber.of(3);
        NaturalNumber numberOfPerson = NaturalNumber.of(5);

        //when
        Ladder ladder = new Ladder(numberOfRow, numberOfPerson);
        ladder.drawLine(Position.of(1), Position.of(1));

        //then
        assertThrows(Exception.class, ()->ladder.drawLine(Position.of(2), Position.of(1)));
    }

    @Test
    void checkDrawable_중복으로_그릴_경우() {

        //given
        NaturalNumber numberOfRow = NaturalNumber.of(3);
        NaturalNumber numberOfPerson = NaturalNumber.of(5);

        //when
        Ladder ladder = new Ladder(numberOfRow, numberOfPerson);
        ladder.drawLine(Position.of(1), Position.of(1));

        //then
        assertThrows(Exception.class, ()->ladder.drawLine(Position.of(1), Position.of(1)));
    }

}