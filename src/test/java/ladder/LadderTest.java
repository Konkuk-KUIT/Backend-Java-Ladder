package Ladder;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LadderTest {
    @Test
    void 사다리_생성_확인(){
        int numberOfRow = 3;
        int numberOfPerson = 5;

        Ladder ladder = new Ladder(numberOfRow, numberOfPerson);

        assertNotNull(ladder);
    }

    @Test
    void 사다리_참여자_수_예외처리확인(){
        int numberOfPerson = 2;
        Ladder ladder = new Ladder(1, numberOfPerson);

        int rowNumber = 5;

        assertThrows(IllegalArgumentException.class, () -> ladder.run(rowNumber));
    }

    @Test
    void 사다리_run_결과확인(){
        int numberOfPerson = 5;
        int numberOfRow = 5;
        Ladder ladder = new Ladder(numberOfRow, numberOfPerson);

        ladder.drawLine(0, 0);
        ladder.drawLine(1, 2);
        ladder.drawLine(2, 1);
        ladder.drawLine(3, 3);

        int rowNumber = 1;
        assertEquals(0, ladder.run(rowNumber));

        rowNumber = 0;
        assertEquals(2, ladder.run(rowNumber));

        rowNumber = 2;
        assertEquals(4, ladder.run(rowNumber));

        rowNumber = 4;
        assertEquals(3, ladder.run(rowNumber));

        rowNumber = 3;
        assertEquals(1, ladder.run(rowNumber));

    }
}
