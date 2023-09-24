package ladder;

import ladder.core.Row;
import ladder.position.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RowTest {

    @Test
    @DisplayName("한 칸 이동")
    void moveOneBlock() {
        //given
        NaturalNumber numberOfPerson = NaturalNumber.of(1);
        Row row = new Row(numberOfPerson);
        //when
        int nthOfPerson = 0;
        Position position = Position.of(nthOfPerson);
        //then
        assertEquals(0, row.nextPosition(position).getPosition());
    }

    @Test
    @DisplayName("두 칸 이동")
    void moveTwoBlock() {
        //given
        NaturalNumber numberOfPerson = NaturalNumber.of(2);
        Row row = new Row(numberOfPerson);
        row.drawLine(Position.of(0));
        //when
        int nthOfPerson = 0;
        Position position = Position.of(nthOfPerson);
        //then
        assertEquals(1, row.nextPosition(position).getPosition());
        //when
        nthOfPerson = 1;
        position = Position.of(nthOfPerson);
        //then
        assertEquals(0, row.nextPosition(position).getPosition());
    }

    @Test
    @DisplayName("세 칸 이동")
    void moveThreeBlock() {
        //given
        NaturalNumber numberOfPerson = NaturalNumber.of(3);
        Row row = new Row(numberOfPerson);
        row.drawLine(Position.of(0));
        //when
        int nthOfPerson = 0;
        Position position = Position.of(nthOfPerson);
        //then
        assertEquals(1, row.nextPosition(position).getPosition());

        //when
        nthOfPerson = 1;
        position = Position.of(nthOfPerson);
        //then
        assertEquals(0, row.nextPosition(position).getPosition());

        //when
        nthOfPerson = 2;
        position = Position.of(nthOfPerson);
        //then
        assertEquals(2, row.nextPosition(position).getPosition());
    }

    @Test
    @DisplayName("사다리 최대 사람 수 확인")
    void OverPersonException() {
        //given
        NaturalNumber numberOfPerson = NaturalNumber.of(3);
        Row row = new Row(numberOfPerson);
        //when
        int nthOfPerson = 3;
        Position position = Position.of(nthOfPerson);
        //then
        assertThrows(IllegalArgumentException.class, () -> row.nextPosition(position));
    }

    @Test
    @DisplayName("사다리 최소 사람 수 확인")
    void UnderPersonException() {
        //given
        NaturalNumber numberOfPerson = NaturalNumber.of(3);
        Row row = new Row(numberOfPerson);
        //when
        int position = -1;
        //then
        assertThrows(IllegalArgumentException.class, () -> row.nextPosition(Position.of(position)));
    }

    @Test
    @DisplayName("사다리 생성 사람 수 확인")
    void CreateLadderPersonException() {
        //given
        //when
        //then
        assertThrows(IllegalArgumentException.class, () -> new Row(NaturalNumber.of(0)));
    }

    @Test
    @DisplayName("사다리 우측 밖으로 다리 생성")
    void drawLineOverPosition() {
        //given
        NaturalNumber numberOfPerson = NaturalNumber.of(3);
        Row row = new Row(numberOfPerson);
        //when
        int position = 3;
        //then
        assertThrows(IllegalArgumentException.class, () -> row.drawLine(Position.of(position)));
    }

    @Test
    @DisplayName("사다리 좌측 밖으로 다리 생성")
    void drawLineUnderPosition() {
        //given
        NaturalNumber numberOfPerson = NaturalNumber.of(3);
        Row row = new Row(numberOfPerson);
        //when
        int position = -1;
        //then
        assertThrows(IllegalArgumentException.class, () -> row.drawLine(Position.of(position)));
    }

    @Test
    @DisplayName("우측에 다리 잇기")
    void LeftLineOverlap() {
        //given
        NaturalNumber numberOfPerson = NaturalNumber.of(3);
        Row row = new Row(numberOfPerson);
        row.drawLine(Position.of(0));
        //when
        //then
        assertThrows(IllegalArgumentException.class, () -> row.drawLine(Position.of(1)));
    }

    @Test
    @DisplayName("좌측에 다리 잇기")
    void RightLineOverlap() {
        //given
        NaturalNumber numberOfPerson = NaturalNumber.of(3);
        Row row = new Row(numberOfPerson);
        row.drawLine(Position.of(1));
        //when
        //then
        assertThrows(IllegalArgumentException.class, () -> row.drawLine(Position.of(0)));
    }

    @Test
    @DisplayName("다리 겹치기")
    void LineOverlap() {
        //given
        NaturalNumber numberOfPerson = NaturalNumber.of(3);
        Row row = new Row(numberOfPerson);
        row.drawLine(Position.of(0));
        //when
        //then
        assertThrows(IllegalArgumentException.class, () -> row.drawLine(Position.of(0)));
    }
}
