package ladder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

    @Test
    void 사다리_생성_확인() {
        //given
        int numberOfRow = 3;
        int numberOfPerson = 5;

        //when
        Ladder ladder = new Ladder(numberOfRow, numberOfPerson);

        //then
        assertNotNull(ladder);
    }

    @Test
    void 사다리_가로_줄_긋기_확인() {
        int numberOfRow = 3;
        int numberOfPerson = 5;
        Ladder ladder = new Ladder(numberOfRow,numberOfPerson);
        int selectRow = 1;
        int selectCol = 2;
        int direction = 1;

        //when
        ladder.drawLine(selectRow, selectCol, direction);

        int[] testCol = new int[numberOfPerson];
        testCol[selectCol - 1] = direction;
        testCol[selectCol -1 + direction] = direction * (-1);

        assertEquals(direction, ladder.getDirection(selectRow, selectCol));
        assertEquals(direction * (-1), ladder.getDirection(selectRow, selectCol + direction));
    }

    @Test
    void 인덱스_검사() {
        int numberOfRow = 3;
        int numberOfPerson = 5;
        Ladder ladder = new Ladder(numberOfRow,numberOfPerson);

        assertThrows(Exception.class, () -> ladder.drawLine(1,0,1));
        assertThrows(Exception.class, () -> ladder.drawLine(0,1,1));
        assertThrows(Exception.class, () -> ladder.drawLine(1,6,1));
        assertThrows(Exception.class, () -> ladder.drawLine(4,1,1));
    }

    @Test
    void 방향값_유효성_검사() {
        int numberOfRow = 3;
        int numberOfPerson = 5;
        Ladder ladder = new Ladder(numberOfRow,numberOfPerson);

        assertThrows(Exception.class, () -> ladder.drawLine(1,2,2));
        assertThrows(Exception.class, () -> ladder.drawLine(1,2,0));
    }

    @Test
    void 사다리_밖으로_긋기_불가() {
        int numberOfRow = 3;
        int numberOfPerson = 5;
        Ladder ladder = new Ladder(numberOfRow,numberOfPerson);

        assertThrows(Exception.class, () -> ladder.drawLine(2,5,1));
        assertThrows(Exception.class, () -> ladder.drawLine(2,1,-1));
    }

    @Test
    void 줄_가로로_이어서_긋기_불가() {
        int numberOfRow = 3;
        int numberOfPerson = 5;
        Ladder ladder = new Ladder(numberOfRow,numberOfPerson);

        ladder.drawLine(1,2,1);

        assertThrows(Exception.class, () -> ladder.drawLine(1,4,-1));
        assertThrows(Exception.class, () -> ladder.drawLine(1,2,1));
    }

    @Test
    void 사다리_타기() {
        int numberOfRow = 4;
        int numberOfPerson = 5;
        Ladder ladder = new Ladder(numberOfRow,numberOfPerson);

        ladder.drawLine(1,2,1);
        ladder.drawLine(2,5,-1);
        ladder.drawLine(4,3,1);
        ladder.drawLine(2,2,-1);
        ladder.drawLine(3,3,-1);

        assertEquals(4,ladder.run(1));
        assertEquals(2,ladder.run(2));
        assertEquals(1,ladder.run(3));
        assertEquals(5,ladder.run(4));
        assertEquals(3,ladder.run(5));
    }
}