package ladder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RowTest {

    @Test
    public void Row_초기화_테스트(){
        //given
        NaturalNumber height = NaturalNumber.of(5);

        //when
        Row row1 = new Row(height);

        //then
        assertEquals(0,row1.row[0]);
        assertEquals(0,row1.row[1]);
        assertEquals(0,row1.row[2]);
        assertEquals(0,row1.row[3]);
        assertEquals(0,row1.row[4]);
    }



}