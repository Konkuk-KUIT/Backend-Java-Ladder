package ladder;

import org.junit.jupiter.api.Test;

import static ladder.Position.setPosition;
import static org.junit.jupiter.api.Assertions.*;

class RowTest {

    @Test
    void 한_칸_사다리_이동() {
        //when
        int numberOfPerson = 1;
        Row row = new Row(numberOfPerson);

        //given
        Position position = setPosition(0);
        row.nextPosition(position);
        //then
        assertEquals(0, position.getPosition());
    }

    @Test
    void 두_칸_사다리_선_이동() {
        //when
        int numberOfPerson = 2;
        Row row = new Row(numberOfPerson);
        row.drawLine(setPosition(0));

        //given
        Position position = setPosition(0);
        row.nextPosition(position);
        //then
        assertEquals(1, position.getPosition());

        //given
        position = setPosition(1);
        row.nextPosition(position);
        //then

        assertEquals(0, position.getPosition());
    }

    @Test
    void 세_칸_사다리_선_이동() {
        //when
        int numberOfPerson = 3;
        Row row = new Row(numberOfPerson);
        row.drawLine(setPosition(0));

        //given
        Position position = setPosition(0);
        row.nextPosition(position);

        //then
        assertEquals(1, position.getPosition());

        //given
        position = setPosition(1);
        row.nextPosition(position);

        //then
        assertEquals(0, position.getPosition());

        //given
        position = setPosition(2);
        row.nextPosition(position);

        assertEquals(2, position.getPosition());
    }

    @Test
    void 사다리_사람수_예외_처리() {
        assertThrows(IllegalArgumentException.class, () -> new Row(0));
    }

    @Test
    void 사다리_최대_사람수_초과_예외() {
        //when
        int numberOfPerson = 3;
        Row row = new Row(numberOfPerson);

        //given
        Position position = setPosition(3);

        //then
        assertThrows(IllegalArgumentException.class, () -> row.nextPosition(position));
    }
}