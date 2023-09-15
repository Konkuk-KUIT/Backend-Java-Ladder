package ladder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RowTest {

    @Test
    void 한_칸_사다리_이동() {
        //when
        int numberOfPerson = 1;
        Row row = new Row(numberOfPerson);

        //given
        int position = 0;

        //then
        assertEquals(0, row.nextPosition(position));
    }

    @Test
    void 두_칸_사다리_선_이동() {
        //when
        int numberOfPerson = 2;
        Row row = new Row(numberOfPerson);
        row.drawLine(0);

        //given
        int position = 0;

        //then
        assertEquals(1, row.nextPosition(position));

        //given
        position = 1;

        //then
        assertEquals(0, row.nextPosition(position));
    }

    @Test
    void 세_칸_사다리_선_이동() {
        //when
        int numberOfPerson = 3;
        Row row = new Row(numberOfPerson);
        row.drawLine(0);

        //given
        int position = 0;

        //then
        assertEquals(1, row.nextPosition(position));

        //given
        position = 1;

        //then
        assertEquals(0, row.nextPosition(position));

        //given
        position = 2;

        //then
        assertEquals(2, row.nextPosition(position));
    }
}