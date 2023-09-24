package ladder;
import org.junit.jupiter.api.Test;

import javax.swing.text.Position;

import static org.junit.jupiter.api.Assertions.*;

public class LadderTest {
    @Test
    void 사다리_생성_확인(){


        NaturalNumber numberOfPerson = NaturalNumber.of(5);
        NaturalNumber numberOfRow = NaturalNumber.of(3);

        Ladder ladder = new Ladder(numberOfRow, numberOfPerson);

        assertNotNull(ladder);
    }

    @Test
    void 사다리_참여자_수_예외처리확인(){

        NaturalNumber numberOfPerson = NaturalNumber.of(2);
        NaturalNumber numberOfRow = NaturalNumber.of(1);
        Ladder ladder = new Ladder(numberOfRow, numberOfPerson);

        int rowNumber = 5;
        position Position = position.of(rowNumber);

        assertThrows(IllegalArgumentException.class, () -> ladder.run(Position));
    }

    @Test
    void 사다리_run_결과확인(){

        NaturalNumber numberOfPerson = NaturalNumber.of(5);
        NaturalNumber numberOfRow = NaturalNumber.of(5);
        Ladder ladder = new Ladder(numberOfRow, numberOfPerson);

        position PositionX = position.of(0);
        position PositionY = position.of(0);
        ladder.drawLine(PositionX, PositionY);

        PositionX = position.of(1);
        PositionY = position.of(2);
        ladder.drawLine(PositionX, PositionY);

        PositionX = position.of(2);
        PositionY = position.of(1);
        ladder.drawLine(PositionX, PositionY);

        PositionX = position.of(3);
        PositionY = position.of(3);
        ladder.drawLine(PositionX, PositionY);


        position rowNumber = position.of(1);
        assertEquals(0, ladder.run(rowNumber));

        rowNumber = position.of(0);
        assertEquals(2, ladder.run(rowNumber));

        rowNumber = position.of(2);
        assertEquals(4, ladder.run(rowNumber));

        rowNumber = position.of(4);
        assertEquals(3, ladder.run(rowNumber));

        rowNumber = position.of(3);
        assertEquals(1, ladder.run(rowNumber));

    }
}
