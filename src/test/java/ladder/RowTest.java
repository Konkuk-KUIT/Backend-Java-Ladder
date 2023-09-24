package ladder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RowTest {

    @Test
    void 사람_수_오류_확인() { // validateNumberOfPerson
        // Then
        assertThrows(IllegalArgumentException.class, () -> new Row(0));
    }

    @Test
    void 위치_오류_확인() { // validatePosition
        // Given
        int numberOfPerson = 3;
        Row row = new Row(numberOfPerson);

        // When
        int position = 4;

        // Then
        assertThrows(IllegalArgumentException.class, () -> row.nextPosition(position));
    }

    // validateDrawLinePosition
    @Test
    void 사다리_그리기_위치_초과_예외() {
        //when
        int numberOfPerson = 3;
        Row row = new Row(numberOfPerson);

        //given
        int position = 3;

        //then
        assertThrows(IllegalArgumentException.class, () -> row.drawLine(position));
    }

    @Test
    void 사다리_그리기_위치_미만_예외() {
        //when
        int numberOfPerson = 3;
        Row row = new Row(numberOfPerson);

        //given
        int position = -1;

        //then
        assertThrows(IllegalArgumentException.class, () -> row.drawLine(position));
    }

    @Test
    void 사다리_그리기_좌측_선_중복_예외() {
        //when
        int numberOfPerson = 3;
        Row row = new Row(numberOfPerson);
        row.drawLine(0);

        //then
        assertThrows(IllegalArgumentException.class, () -> row.drawLine(1));
    }

    @Test
    void 사다리_그리기_우측_선_중복_예외() {
        //when
        int numberOfPerson = 3;
        Row row = new Row(numberOfPerson);
        row.drawLine(1);

        //then
        assertThrows(IllegalArgumentException.class, () -> row.drawLine(0));
    }

}
