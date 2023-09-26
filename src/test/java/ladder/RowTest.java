package ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RowTest {

    @Test
    void drawLine_테스트(){
        //given
        NaturalNumber numberOfPerson =  NaturalNumber.of(2);

        Row row = new Row(numberOfPerson);

        //when
        row.drawLine(Position.of(1));

        //then
        assertThat(row.nextPosition(Position.of(1)).getValue()).isEqualTo(2);
        assertThat(row.nextPosition(Position.of(2)).getValue()).isEqualTo(1);

    }

    @Test
    void 한_칸_사다리_이동() {
        //when
        NaturalNumber numberOfPerson = NaturalNumber.of(1);
        Row row = new Row(numberOfPerson);

        //given
        int nthOfPerson = 1;
        Position position = Position.of(nthOfPerson);

        //then
        assertEquals(1, row.nextPosition(position).getValue());
    }

    @Test
    void 두_칸_사다리_선_이동() {
        //when
        NaturalNumber numberOfPerson = NaturalNumber.of(2);
        Row row = new Row(numberOfPerson);
        row.drawLine(Position.of(1));

        //given
        int nthOfPerson = 1;
        Position position = Position.of(nthOfPerson);

        //then
        assertEquals(2, row.nextPosition(position).getValue());

        //given
        nthOfPerson = 2;
        position = Position.of(nthOfPerson);

        //then
        assertEquals(1, row.nextPosition(position).getValue());
    }

    @Test
    void 세_칸_사다리_선_이동() {
        //when
        NaturalNumber numberOfPerson = NaturalNumber.of(3);
        Row row = new Row(numberOfPerson);
        row.drawLine(Position.of(1));

        //given
        int nthOfPerson = 1;
        Position position = Position.of(nthOfPerson);

        //then
        assertEquals(2, row.nextPosition(position).getValue());

        //given
        nthOfPerson = 2;
        position = Position.of(nthOfPerson);

        //then
        assertEquals(1, row.nextPosition(position).getValue());

        //given
        nthOfPerson = 3;
        position = Position.of(nthOfPerson);

        //then
        assertEquals(3, row.nextPosition(position).getValue());
    }

    @Test
    void 사다리_사람수_예외_처리() {
        assertThrows(IllegalArgumentException.class, () -> new Row(NaturalNumber.of(0)));
    }

    @Test
    void 사다리_최대_사람수_초과_예외() {
        //when
        NaturalNumber numberOfPerson = NaturalNumber.of(3);
        Row row = new Row(numberOfPerson);

        //given
        int nthOfPerson = 4;
        Position position = Position.of(nthOfPerson);

        //then
        assertThrows(IllegalArgumentException.class, () -> row.nextPosition(position));
    }

    @Test
    void 사다리_최소_사람수_미만_예외() {
        //when
        NaturalNumber numberOfPerson = NaturalNumber.of(3);
        Row row = new Row(numberOfPerson);

        //given
        int position = -1;

        //then
        assertThrows(IllegalArgumentException.class, () -> row.nextPosition(Position.of(position)));
    }

    @Test
    void 사다리_그리기_위치_초과_예외() {
        //when
        NaturalNumber numberOfPerson = NaturalNumber.of(3);
        Row row = new Row(numberOfPerson);

        //given
        int position = 3;

        //then
        assertThrows(IllegalArgumentException.class, () -> row.drawLine(Position.of(position)));
    }

    @Test
    void 사다리_그리기_위치_미만_예외() {
        //when
        NaturalNumber numberOfPerson = NaturalNumber.of(3);
        Row row = new Row(numberOfPerson);

        //given
        int position = -1;

        //then
        assertThrows(IllegalArgumentException.class, () -> row.drawLine(Position.of(position)));
    }

    @Test
    void 사다리_그리기_좌측_선_중복_예외() {
        //when
        NaturalNumber numberOfPerson = NaturalNumber.of(3);
        Row row = new Row(numberOfPerson);
        row.drawLine(Position.of(1));

        //then
        assertThrows(IllegalArgumentException.class, () -> row.drawLine(Position.of(2)));
    }

    @Test
    void 사다리_그리기_우측_선_중복_예외() {
        //when
        NaturalNumber numberOfPerson = NaturalNumber.of(3);
        Row row = new Row(numberOfPerson);
        row.drawLine(Position.of(1));

        //then
        assertThrows(IllegalArgumentException.class, () -> row.drawLine(Position.of(0)));
    }

    @Test
    void 사다리_그리기_선_중복_예외() {
        //when
        NaturalNumber numberOfPerson = NaturalNumber.of(3);
        Row row = new Row(numberOfPerson);
        row.drawLine(Position.of(1));

        //then
        assertThrows(IllegalArgumentException.class, () -> row.drawLine(Position.of(1)));
    }
}
