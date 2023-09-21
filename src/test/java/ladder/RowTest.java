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
        row.drawLine(Position.of(0));

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
        assertThrows(Exception.class, () -> row.drawLine(Position.of(2)));
        assertThrows(Exception.class, () -> row.drawLine(Position.of(4)));
    }

    @Test
    void 라인_생성_중복_오류() {

        //given
        NaturalNumber numberOfPerson = NaturalNumber.of(4);

        //when
        Row row = new Row(numberOfPerson);
        row.drawLine(Position.of(1));

        //then
        assertThrows(Exception.class, () -> row.drawLine(Position.of(1)));
        assertThrows(Exception.class, () -> row.drawLine(Position.of(2)));
    }

    @Test
    public void 라인_이동() {
        //given
        NaturalNumber numberOfPerson = NaturalNumber.of(4);
        //when
        Row row = new Row(numberOfPerson);
        row.drawLine(Position.of(1));

        //then
        assertEquals(2, row.moveLine(Position.of(1)).getPosition());
        assertEquals(1, row.moveLine(Position.of(2)).getPosition());
        assertEquals(0, row.moveLine(Position.of(0)).getPosition());
    }
}
