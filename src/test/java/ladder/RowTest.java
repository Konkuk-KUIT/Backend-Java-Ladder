package Ladder;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RowTest {
    @Test
    void 칸_참여자_수_부재_예외처리확인(){
        assertThrows(IllegalArgumentException.class, () -> new Row(0));
    }
    @Test
    void 사다리_그리기_시작점_미만_예외처리확인(){
        Row row = new Row(3);
        assertThrows(IllegalArgumentException.class, () -> row.newRow(-2));
    }

    @Test
    void 사다리_그리기_시작점_초과_예외처리확인(){
        Row row = new Row(3);
        assertThrows(IllegalArgumentException.class, () -> row.newRow(3));
    }

    @Test
    void 사다리_그리기_중복_왼쪽_예외처리확인(){
        Row row = new Row(3);
        row.newRow(0);
        assertThrows(IllegalArgumentException.class, () -> row.newRow(1));
    }

    @Test
    void 사다리_그리기_중복_오른쪽_예외처리확인(){
        Row row = new Row(3);
        row.newRow(1);
        assertThrows(IllegalArgumentException.class, () -> row.newRow(0));
    }
    @Test
    void 사다리_참여자_수_미만_예외처리확인(){
        Row row = new Row(3);
        assertThrows(IllegalArgumentException.class, () -> row.destination(-1));
    }

    @Test
    void 사다리_참여자_수_초과_예외처리확인(){
        Row row = new Row(3);
        assertThrows(IllegalArgumentException.class, () -> row.destination(3));
    }

    @Test
    void 사다리_타기_1회(){
        Row row = new Row(3);
        assertEquals(0, row.destination(0));
    }

    @Test
    void 사다리_타기_2회(){
        Row row = new Row(3);
        row.newRow(0);
        assertEquals(1, row.destination(0));
        assertEquals(0, row.destination(1));
    }
}
