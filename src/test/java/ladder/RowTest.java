package ladder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RowTest {
    @Test
    void 열_생성_확인() {
        int numOfPerson = 4;
        Row row = new Row(numOfPerson);

        assertNotNull(row);
    }
    /*@Test
    void 줄_그리기_확인() {
        //when
        int numOfPerson = 4;
        Row row = new Row(numOfPerson);
        //given
        Direction direction = Direction.RIGHT;
        Position position = Position.of(1);
        row.drawLine(position, direction);
        //then
        assertEquals(direction.getValue(),
                row.row[position.getValue()-1].getDirection().getValue());
        assertEquals(direction.getOppositeDirection().getValue(),
                row.row[row.nextPosition(position).getValue()-1].getDirection().getValue());
    }*/
    @Test
    void 줄_밖으로_그리기_금지() {
        //when
        int numOfPerson = 4;
        Row row = new Row(numOfPerson);
        //
        assertThrows(IllegalArgumentException.class, () -> row.drawLine(Position.of(numOfPerson), Direction.RIGHT));
        assertThrows(IllegalArgumentException.class, () -> row.drawLine(Position.of(1), Direction.LEFT));
    }
    @Test
    void 줄_겹치게_그리기_금지() {
        //when
        int numOfPerson = 4;
        Row row = new Row(numOfPerson);
        row.drawLine(Position.of(2),Direction.RIGHT);
        //
        assertThrows(IllegalArgumentException.class, () -> row.drawLine(Position.of(1), Direction.RIGHT));
        assertThrows(IllegalArgumentException.class, () -> row.drawLine(Position.of(3), Direction.LEFT));
        assertThrows(IllegalArgumentException.class, () -> row.drawLine(Position.of(4), Direction.LEFT));
    }
    @Test
    void 다음_줄_반환_확인() {
        int numOfPerson = 4;
        Row row = new Row(numOfPerson);
        row.drawLine(Position.of(2),Direction.RIGHT);

        assertEquals(Position.of(2).getValue(), row.nextPosition((Position.of(3))).getValue());
    }
}