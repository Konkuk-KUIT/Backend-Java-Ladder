package ladder;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RowTest {

    @Test
    void 라인_생성_확인() {
        //given
        NaturalNumber numberOfPerson = NaturalNumber.of(3);
        //when
        Row row = new Row(numberOfPerson);
        row.drawLine(0);

        //then
        assertEquals(1, row.getRow()[0]);
        assertEquals(-1, row.getRow()[1]);
    }

    @Test
    void 라인_생성_인덱스_오류() {

        //given
        NaturalNumber numberOfPerson = NaturalNumber.of(3);

        //when
        Row row = new Row(numberOfPerson);

        //then
        assertThrows(Exception.class, () -> row.drawLine(2));
        assertThrows(Exception.class, () -> row.drawLine(4));
    }

    @Test
    void 라인_생성_중복_오류() {

        //given
        NaturalNumber numberOfPerson = NaturalNumber.of(4);

        //when
        Row row = new Row(numberOfPerson);
        row.drawLine(1);

        //then
        assertThrows(Exception.class, () -> row.drawLine(1));
        assertThrows(Exception.class, () -> row.drawLine(2));
    }

    @Test
    public void 라인_이동() {
        //given
        NaturalNumber numberOfPerson = NaturalNumber.of(4);
        //when
        Row row = new Row(numberOfPerson);
        row.drawLine(1);

        //then
        assertEquals(2, row.moveLine(1));
        assertEquals(1, row.moveLine(2));
        assertEquals(0, row.moveLine(0));
    }
}
