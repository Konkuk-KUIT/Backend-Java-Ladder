package ladder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RowTest {
    @Test
    void 열_생성_확인() {
        int numOfPerson = 4;
        Row row = new Row(4);

        assertNotNull(row);
    }
    @Test
    void 줄_그리기_확인() {
        //when
        int numOfPerson = 4;
        Row row = new Row(numOfPerson);
        //given
        int selectRow = 1;
        Direction direction = Direction.RIGHT;
        row.drawLine(selectRow, direction);
        //then
        assertArrayEquals(row.row, new int[]{1,-1,0,0});
    }
    @Test
    void 줄_밖으로_그리기_금지() {
        //when
        int numOfPerson = 4;
        Row row = new Row(numOfPerson);
        //
        assertThrows(IllegalArgumentException.class, () -> row.drawLine(numOfPerson, Direction.RIGHT));
        assertThrows(IllegalArgumentException.class, () -> row.drawLine(1, Direction.LEFT));
    }
    @Test
    void 줄_겹치게_그리기_금지() {
        //when
        int numOfPerson = 4;
        Row row = new Row(numOfPerson);
        row.drawLine(2,Direction.RIGHT);
        //
        assertThrows(IllegalArgumentException.class, () -> row.drawLine(1, Direction.RIGHT));
        assertThrows(IllegalArgumentException.class, () -> row.drawLine(3, Direction.LEFT));
        assertThrows(IllegalArgumentException.class, () -> row.drawLine(4, Direction.LEFT));
    }
}